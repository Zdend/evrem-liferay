package net.evrem.portlet.commonsfunction.controller;

import java.util.List;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import net.evrem.commons.converter.NoteFormModelToEventNotificationDtoConverter;
import net.evrem.commons.email.EmailServiceImpl;
import net.evrem.dtos.form.NoteFormModel;
import net.evrem.service.service.NoteLocalServiceUtil;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.util.PortalUtil;

@Controller
@RequestMapping(value = "VIEW")
public class TestController {

	private final Log log = LogFactoryUtil.getLog(getClass());

	@RenderMapping
	public String view(RenderRequest request, RenderResponse response) {
		return "view";
	}

	@ResourceMapping("getHello")
	public void getHello(ResourceRequest request, ResourceResponse response) {
		try {
			EmailServiceImpl service = new EmailServiceImpl();
			List<NoteFormModel> forms = NoteLocalServiceUtil.getNotesByUserId(PortalUtil.getUserId(request));
			User user = PortalUtil.getUser(request);
			for (NoteFormModel form : forms) {
				if (form.getNoteId().equals(2401L)) {
					NoteFormModelToEventNotificationDtoConverter notificationConverter = new NoteFormModelToEventNotificationDtoConverter();
					service.sendEventNotification(user.getEmailAddress(), notificationConverter.convertToEventNotification(form, null));
				}
			}

			response.getWriter().write("HUAAAAAAAAAAAAAA");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@ResourceMapping("sendUserCreated")
	public void sendUserCreated(ResourceResponse response) {
		EmailServiceImpl service = new EmailServiceImpl();

		try {
			service.sendUserCreated("8145571+Zdend@users.noreply.github.com", "Europe/Prague");

			response.getWriter().write("HUAAAAAAAAAAAAAA");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
