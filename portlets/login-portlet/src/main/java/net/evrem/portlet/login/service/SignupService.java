package net.evrem.portlet.login.service;

import java.util.Locale;

import com.liferay.portal.model.User;

public interface SignupService {

	public User createPortalUser(String email, final long companyId, final long userId, final Locale locale, String password1, String password2, long siteId,
			String timeZoneId) throws Exception;

	public Boolean isValidUser(String email, String password1, String password2);

	public Boolean sendTokenToGoogle(String token, String remoteip) throws Exception;
}
