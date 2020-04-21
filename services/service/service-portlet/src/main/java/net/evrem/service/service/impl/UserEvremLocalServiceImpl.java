package net.evrem.service.service.impl;

import net.evrem.dtos.form.UserForm;
import net.evrem.service.converter.UserToUserFormConverter;
import net.evrem.service.service.base.UserEvremLocalServiceBaseImpl;

import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;

/**
 * The implementation of the user evrem local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link net.evrem.service.service.UserEvremLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author Zdenek Vecek
 * @see net.evrem.service.service.base.UserEvremLocalServiceBaseImpl
 * @see net.evrem.service.service.UserEvremLocalServiceUtil
 */
public class UserEvremLocalServiceImpl extends UserEvremLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * net.evrem.service.service.UserEvremLocalServiceUtil} to access the user
	 * evrem local service.
	 */

	public UserForm getUserForm(Long userId) throws Exception {
		User user = UserLocalServiceUtil.getUser(userId);
		UserToUserFormConverter converter = new UserToUserFormConverter();

		UserForm form = converter.convertToUserForm(user, null);

		return form;
	}

	public void saveUser(UserForm userForm, Long userId) throws Exception {
		User user = UserLocalServiceUtil.getUser(userId);

		user.setTimeZoneId(userForm.getTimeZoneId());
		UserLocalServiceUtil.updateUser(user);
	}
}
