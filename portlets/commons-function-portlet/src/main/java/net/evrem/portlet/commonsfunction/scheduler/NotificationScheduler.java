package net.evrem.portlet.commonsfunction.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import net.evrem.commons.converter.NoteFormModelToEventNotificationDtoConverter;
import net.evrem.commons.email.EmailServiceImpl;
import net.evrem.commons.global.GlobalConstants;
import net.evrem.dtos.form.NoteFormModel;
import net.evrem.service.model.RemindInfo;
import net.evrem.service.service.NoteLocalService;
import net.evrem.service.service.NoteLocalServiceUtil;
import net.evrem.service.service.RemindInfoLocalServiceUtil;

import org.joda.time.DateTimeUtils;
import org.joda.time.DateTimeZone;

import com.liferay.portal.kernel.bean.BeanLocatorException;
import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.security.permission.PermissionThreadLocal;
import com.liferay.portal.service.RoleServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.UserServiceUtil;

public class NotificationScheduler implements MessageListener {

	private final Log log = LogFactoryUtil.getLog(getClass());

	@Override
	public void receive(Message message) throws MessageListenerException {
		log.info("Start running scheduler for Event notification");

		PermissionChecker permissionChecker = null;
		try {
			User user = UserLocalServiceUtil.getUserById(Long.valueOf(PropsUtil.get("evrem.admin.userid")));
			permissionChecker = PermissionCheckerFactoryUtil.create(user);
		} catch (Exception e1) {
			log.error("Unable to log as admin in Notification Scheduler", e1);
		}

		PermissionThreadLocal.setPermissionChecker(permissionChecker);

		try {
			PortletBeanLocatorUtil.locate("service-portlet", NoteLocalService.class.getName());
		} catch (BeanLocatorException e) {
			log.warn("Service layer has not been initialized yet, probably it's because application is starting right now.");
			return;
		}

		try {
			runNotification();
		} catch (Exception e) {
			log.error("Error during event notification.", e);
		}

		log.info("Done running scheduler for Event notification");

	}

	private void runNotification() throws Exception {
		Role role = RoleServiceUtil.getRole(Long.valueOf(PropsUtil.get("evrem.company.companyid")), GlobalConstants.EVREM_USER_ROLE);

		long[] userIds;
		userIds = UserServiceUtil.getRoleUserIds(role.getRoleId());
		long currentMillis = DateTimeUtils.currentTimeMillis();
		EmailServiceImpl emailService = new EmailServiceImpl();

		for (long userId : userIds) {
			List<NoteFormModel> notes = NoteLocalServiceUtil.getNotesForReminding(userId);
			for (NoteFormModel note : notes) {
				User user = UserLocalServiceUtil.getUser(userId);
				SimpleDateFormat format = new SimpleDateFormat(GlobalConstants.DATE_TIME_FORMAT);

				DateTimeZone dateTz = DateTimeZone.forID(user.getTimeZoneId());
				long localRemindMillis = note.getRemindInfo().getRemindDate().getTime();
				System.out.println("localRemindMillis:" + format.format(new Date(localRemindMillis)));
				long utcRemindMillis = dateTz.convertLocalToUTC(localRemindMillis, false);
				System.out.println("utcRemindMillis:" + format.format(new Date(utcRemindMillis)));

				long lastRemindMillis = note.getRemindInfo().getLastRemindTime() != null ? note.getRemindInfo().getLastRemindTime().getTime() : 0l;
				System.out.println("lastRemindMillis:" + format.format(new Date(lastRemindMillis)));

				if (utcRemindMillis - currentMillis < (1000 * 60 * 5) && currentMillis - lastRemindMillis > 86400000) {

					NoteFormModelToEventNotificationDtoConverter notificationConverter = new NoteFormModelToEventNotificationDtoConverter();

					// TODO Send summarized email - only one per day ?
					emailService.sendEventNotification(user.getEmailAddress(), notificationConverter.convertToEventNotification(note, null));

					RemindInfo remindInfo = RemindInfoLocalServiceUtil.getRemindInfo(note.getRemindInfo().getRemindInfoId());
					remindInfo.setLastRemindTime(new Date());
					RemindInfoLocalServiceUtil.updateRemindInfo(remindInfo);
				}

			}

		}
	}

}
