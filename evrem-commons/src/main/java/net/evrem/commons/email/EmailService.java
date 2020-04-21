package net.evrem.commons.email;

import net.evrem.dtos.dto.EventNotificationDto;

public interface EmailService {

	public void sendUserCreated(String email, String timezone) throws Exception;

	public void sendEventNotification(String email, EventNotificationDto note) throws Exception;
}
