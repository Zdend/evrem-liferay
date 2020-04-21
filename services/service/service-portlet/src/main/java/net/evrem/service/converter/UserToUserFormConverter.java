package net.evrem.service.converter;

import net.evrem.dtos.form.UserForm;

import com.liferay.portal.model.User;

public class UserToUserFormConverter {

	public UserForm convertToUserForm(User user, UserForm form) {
		if (form == null) {
			form = new UserForm();
		}

		form.setUserId(user.getUserId());
		form.setTimeZoneId(user.getTimeZoneId());
		form.setEmail(user.getEmailAddress());

		return form;
	}

}
