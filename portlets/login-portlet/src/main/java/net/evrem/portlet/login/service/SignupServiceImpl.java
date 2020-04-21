package net.evrem.portlet.login.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.evrem.commons.email.EmailServiceImpl;
import net.evrem.commons.global.GlobalConstants;
import net.evrem.commons.json.JsonSerializer;
import net.evrem.portlet.login.dto.CaptchaResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;

@Service("signupService")
public class SignupServiceImpl implements SignupService {

	private final Log log = LogFactoryUtil.getLog(getClass());

	public User createPortalUser(String email, final long companyId, final long userId, final Locale locale, String password1, String password2, long siteId,
			String timeZoneId) throws Exception {
		User user = null;

		Role role = RoleLocalServiceUtil.getRole(companyId, GlobalConstants.EVREM_USER_ROLE);

		long[] groups = new long[] { siteId };
		long[] roles = new long[] { role.getRoleId() };

		user = UserLocalServiceUtil.addUser(userId, companyId, false, password1, password2, true, email, email, 0L, "", locale,
				email.substring(0, email.indexOf("@")), "", email.substring(email.indexOf("@"), email.lastIndexOf(".")), 0, 0, true, 0, 1, 1970, "", groups,
				null, roles, null, false, new ServiceContext());

		user.setTimeZoneId(timeZoneId);

		UserLocalServiceUtil.updateUser(user);

		try {
			EmailServiceImpl service = new EmailServiceImpl();
			service.sendUserCreated(email, timeZoneId);
		} catch (Exception e) {
			log.error("Error during sending email about user creation for user:" + user.getUserId(), e);
		}

		return user;
	}

	public Boolean isValidUser(String email, String password1, String password2) {
		if (StringUtils.isBlank(password1) || StringUtils.isBlank(password2)) {
			return false;
		}
		if (!validateRegexp(password1, GlobalConstants.PASSWORD_PATTERN)) {
			return false;
		}
		if (!password1.equals(password2)) {
			return false;
		}
		if (!validateRegexp(email, GlobalConstants.EMAIL_PATTERN)) {
			return false;
		}

		System.out.println("Passwords or email are valid!");
		return true;
	}

	private Boolean validateRegexp(String value, String patternString) {
		Pattern pattern = Pattern.compile(patternString);
		Matcher matcher = pattern.matcher(value);
		return matcher.matches();
	}

	public Boolean sendTokenToGoogle(String token, String remoteip) throws Exception {

		String url = "https://www.google.com/recaptcha/api/siteverify?secret=" + GlobalConstants.SECRET_CAPTCHA_KEY + "&response=" + token + "&remoteip="
				+ remoteip;

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", HttpHeaders.USER_AGENT);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);

		if (responseCode != 200) {
			return false;
		}

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		CaptchaResponse captchaResponse = JsonSerializer.getInstance().readValue(in, CaptchaResponse.class);
		in.close();

		return captchaResponse.getSuccess();
	}

}
