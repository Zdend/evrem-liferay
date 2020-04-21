package net.evrem.commons.test.email;

import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.evrem.commons.global.GlobalConstants;
import net.evrem.dtos.dto.EventNotificationDto;
import net.evrem.dtos.form.TodoNoteForm;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.app.event.implement.IncludeRelativePath;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.junit.Test;

public class MailTest {

	// @Test
	public void testNotificationEmail() {
		Template t = initTemplate("simple-layout");

		VelocityContext context = new VelocityContext();
		context.put("screen_content", "event-notification.vm");
		context.put("note", getMockNote());
		context.put("subject", getMockNote().getSubject());

		StringWriter writer = new StringWriter();
		t.merge(context, writer);

		String body = writer.toString();
		System.out.println(body);
	}

	@Test
	public void testUserCreatedEmail() {
		Template t = initTemplate("simple-layout");

		VelocityContext context = new VelocityContext();
		context.put("screen_content", "user-created.vm");
		context.put("login", "8145571+Zdend@users.noreply.github.com");
		context.put("timezone", "Europe/Prague");
		context.put("subject", "Welcome to Evrem");

		StringWriter writer = new StringWriter();
		t.merge(context, writer);

		String body = writer.toString();
		System.out.println(body);
	}

	private Template initTemplate(String templateName) {
		VelocityEngine ve = new VelocityEngine();
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		ve.setProperty(RuntimeConstants.EVENTHANDLER_INCLUDE, IncludeRelativePath.class.getName());

		ve.init();

		return ve.getTemplate("email/templates/" + templateName + ".vm", "UTF-8");
	}

	private EventNotificationDto getMockNote() {
		String actualDate = new SimpleDateFormat(GlobalConstants.DATE_TIME_FORMAT).format(new Date());
		EventNotificationDto note = new EventNotificationDto();
		note.setText("Tohle bude česká poznámka se vší diakritikou\nANother day in paradise\nTriple task");
		note.setCreatedDate(actualDate);
		note.setEventTime(actualDate);
		note.setRemindTime(actualDate);
		note.setSubject("Můj vlastní předmět");
		note.setColor("#442c66");

		List<TodoNoteForm> todos = new ArrayList<TodoNoteForm>();
		TodoNoteForm todo1 = new TodoNoteForm();
		todo1.setTodoText("Tohle bude česká poznámka se vší diakritikou");
		TodoNoteForm todo2 = new TodoNoteForm();
		todo2.setTodoText("ANother day in paradise");
		TodoNoteForm todo3 = new TodoNoteForm();
		todo3.setTodoText("Triple task");

		todos.add(todo1);
		todos.add(todo2);
		todos.add(todo3);
		note.setTodos(todos);

		return note;
	}
}
