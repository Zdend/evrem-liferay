package net.evrem.commons.email;

import java.io.StringWriter;

import javax.mail.internet.InternetAddress;

import net.evrem.dtos.dto.EventNotificationDto;

import org.apache.commons.lang.StringUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.app.event.implement.IncludeRelativePath;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.util.PropsUtil;

public class EmailServiceImpl implements EmailService {

	public void sendUserCreated(String email, String timezone) throws Exception {
		InternetAddress from = new InternetAddress(PropsUtil.get("evrem.email.from.info"), PropsUtil.get("evrem.email.from.info.name"));
		String testAddress = PropsUtil.get("evrem.email.test.address");
		InternetAddress to = null;
		if (StringUtils.isNotBlank(testAddress)) {
			to = new InternetAddress(testAddress);
		} else {
			to = new InternetAddress(email);
		}

		String subject = "Your Evrem account has been created";

		Template t = initTemplate("simple-layout");

		VelocityContext context = new VelocityContext();
		context.put("screen_content", "user-created.vm");
		context.put("login", email);
		context.put("timezone", timezone);
		context.put("subject", "Welcome to Evrem");

		StringWriter writer = new StringWriter();
		t.merge(context, writer);

		String body = writer.toString();
		System.out.println(body);

		MailMessage mailMessage = new MailMessage(from, to, subject, body, true);

		MailServiceUtil.sendEmail(mailMessage);
	}

	public void sendEventNotification(String email, EventNotificationDto note) throws Exception {
		InternetAddress from = new InternetAddress(PropsUtil.get("evrem.email.from.info"), PropsUtil.get("evrem.email.from.info.name"));
		String testAddress = PropsUtil.get("evrem.email.test.address");
		InternetAddress to = null;
		if (StringUtils.isNotBlank(testAddress)) {
			to = new InternetAddress(testAddress);
		} else {
			to = new InternetAddress(email);
		}

		String subject = StringUtils.isNotBlank(note.getSubject()) ? note.getSubject() : "Evrem notification";

		Template t = initTemplate("simple-layout");

		VelocityContext context = new VelocityContext();
		context.put("screen_content", "event-notification.vm");
		context.put("note", note);
		context.put("subject", subject);

		StringWriter writer = new StringWriter();
		t.merge(context, writer);

		String body = writer.toString();
		System.out.println(body);

		MailMessage mailMessage = new MailMessage(from, to, subject, body, true);
		MailServiceUtil.sendEmail(mailMessage);
	}

	private Template initTemplate(String templateName) {
		VelocityEngine ve = new VelocityEngine();
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		ve.setProperty(RuntimeConstants.EVENTHANDLER_INCLUDE, IncludeRelativePath.class.getName());

		ve.init();

		return ve.getTemplate("email/templates/" + templateName + ".vm", "UTF-8");
	}

}
