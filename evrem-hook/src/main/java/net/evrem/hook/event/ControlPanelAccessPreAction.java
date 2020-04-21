package net.evrem.hook.event;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.kernel.events.Action;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.RoleServiceUtil;
import com.liferay.portal.service.UserServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;

/**
 * The ControlPanelAccessPreAction restricts access to Control panel of simple
 * users.
 */
public class ControlPanelAccessPreAction extends Action {

	/**
	 * Instantiates a new control panel access pre action.
	 */
	public ControlPanelAccessPreAction() {
		super();
	}

	/*
	 * @see com.liferay.portal.kernel.events.Action#run(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void run(HttpServletRequest request, HttpServletResponse response) throws ActionException {
		try {

			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			if (GroupLocalServiceUtil.getGroup(themeDisplay.getLayout().getGroupId()).isControlPanel()) {

				User currentUser = UserServiceUtil.getUserById(themeDisplay.getUserId());
				if (!RoleServiceUtil.hasUserRole(currentUser.getUserId(), currentUser.getCompanyId(), "administrator", true)) {
					throw new PrincipalException("User " + request.getRemoteUser() + " can't access the control panel.");
				}

			}
		} catch (Exception ex) {
			throw new ActionException(ex);
		}
	}
}
