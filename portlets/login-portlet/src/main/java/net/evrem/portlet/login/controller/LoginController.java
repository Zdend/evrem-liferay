package net.evrem.portlet.login.controller;

import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import net.evrem.commons.ajax.AjaxResponse;
import net.evrem.portlet.login.service.SignupService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.NoRedirectActionResponse;
import com.liferay.portal.kernel.struts.PortletActionInvoker;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.WebKeys;

@Controller
@RequestMapping(value = "VIEW")
public class LoginController {

	private final Log log = LogFactoryUtil.getLog(getClass());

	@Autowired
	private SignupService signupService;

	@RenderMapping
	public String view() {
		return "view";
	}

	@ActionMapping
	public void login(ActionRequest actionRequest, ActionResponse actionResponse, Map<String, String> formdata) throws Exception {
		String login = ParamUtil.getString(actionRequest, "login");
		String password = ParamUtil.getString(actionRequest, "password");
		String rememberMe = ParamUtil.getString(actionRequest, "rememberMe");

		String className = "com.liferay.portlet.login.action.LoginAction";
		PortletConfig portletConfig = (PortletConfig) actionRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		NoRedirectActionResponse noRedirectActionResponse = new NoRedirectActionResponse(actionResponse);

		try {
			PortletActionInvoker.processAction(className, portletConfig, actionRequest, noRedirectActionResponse);
		} catch (Exception e) {
			log.error(e, e);
		}

		if (Validator.isNull(noRedirectActionResponse.getRedirectLocation())) {
			actionResponse.setRenderParameter("login", login);
			actionResponse.setRenderParameter("rememberMe", rememberMe);
		} else {
			String redirect = PortalUtil.getPathMain() + "/portal/login?login=" + login + "&password=" + password + "&rememberMe=" + rememberMe;

			actionResponse.sendRedirect(redirect);
		}

		System.out.println("HURAY");

	}

	@ResourceMapping("signUp")
	public void signUp(ResourceRequest req, ResourceResponse res) {
		String email = ParamUtil.getString(req, "email");
		String password1 = ParamUtil.getString(req, "password1");
		String password2 = ParamUtil.getString(req, "password2");
		String token = ParamUtil.getString(req, "token");
		String timeZoneId = ParamUtil.getString(req, "timeZoneId");
		String remoteip = PortalUtil.getHttpServletRequest(req).getRemoteAddr();
		Boolean isVerificated = false;

		try {
			isVerificated = signupService.sendTokenToGoogle(token, remoteip);
		} catch (Exception e) {
			log.error("Error during verifying token", e);
		}

		if (isVerificated) {
			Long siteId = null;
			try {
				siteId = PortalUtil.getScopeGroupId(req);
			} catch (Exception e) {
				log.error("Error during getting site id.", e);
			}

			final ThemeDisplay themeDisplay = (ThemeDisplay) req.getAttribute(WebKeys.THEME_DISPLAY);
			System.out.println(themeDisplay.getUserId());

			if (signupService.isValidUser(email, password1, password2)) {

				try {
					signupService.createPortalUser(email, themeDisplay.getCompanyId(), themeDisplay.getUserId(), themeDisplay.getLocale(), password1,
							password2, siteId, timeZoneId);
				} catch (Exception e) {
					log.error("Portal user creation failed", e);
				}

			}

		}

		AjaxResponse<Boolean> response = new AjaxResponse<Boolean>();
		response.setPayload(isVerificated);

		try {
			res.getWriter().write(response.toJson());
		} catch (Exception e) {
			log.error("Error during writing JSON to response.", e);
		}
		System.out.println("New user has been created.");
	}

}
