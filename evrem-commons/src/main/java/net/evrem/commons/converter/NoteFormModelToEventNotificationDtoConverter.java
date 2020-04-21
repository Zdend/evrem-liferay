package net.evrem.commons.converter;

import java.text.SimpleDateFormat;

import net.evrem.commons.global.GlobalConstants;
import net.evrem.dtos.dto.EventNotificationDto;
import net.evrem.dtos.form.NoteFormModel;

public class NoteFormModelToEventNotificationDtoConverter {

	public EventNotificationDto convertToEventNotification(NoteFormModel form, EventNotificationDto dto) {
		if (dto == null) {
			dto = new EventNotificationDto();
		}
		SimpleDateFormat format = new SimpleDateFormat(GlobalConstants.DATE_TIME_FORMAT);
		dto.setText(form.getText());
		if (form.getCreatedDate() != null) {
			dto.setCreatedDate(format.format(form.getCreatedDate()));
		}
		if (form.getRemindInfo() != null) {
			if (form.getRemindInfo().getRemindDate() != null) {
				dto.setRemindTime(format.format(form.getRemindInfo().getRemindDate()));
			}
			dto.setSubject(form.getRemindInfo().getRemindSubject());
		}
		if (form.getEventTime() != null) {
			dto.setEventTime(format.format(form.getEventTime()));
		}
		dto.setColor(form.getColor().getColorWithHash());
		dto.setTodos(form.getTodos());

		return dto;
	}

}
