package net.evrem.service.converter;

import net.evrem.commons.util.FormDataUtil;
import net.evrem.dtos.form.RemindInfoForm;
import net.evrem.service.model.RemindInfo;

public class RemindInfoFormToRemindInfoConverter {

	public RemindInfo convertToRemindInfo(RemindInfoForm form, RemindInfo remindInfo) {
		remindInfo.setRemindDate(form.getRemindDate());
		remindInfo.setRemindSubject(FormDataUtil.escape(form.getRemindSubject()));

		return remindInfo;
	}

	public RemindInfoForm convertToForm(RemindInfo remindInfo, RemindInfoForm form) {
		if (form == null) {
			form = new RemindInfoForm();
		}
		form.setRemindDate(remindInfo.getRemindDate());
		form.setRemindSubject(remindInfo.getRemindSubject());
		form.setRemindInfoId(remindInfo.getRemindInfoId());
		form.setLastRemindTime(remindInfo.getLastRemindTime());
		// s.setRecipientEmails(t.getRecipientEmails());
		// TODO Consider to allow sending on other emails that user's

		return form;
	}

}
