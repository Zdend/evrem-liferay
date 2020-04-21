package net.evrem.portlet.calendar.controller;

import java.util.List;

import javax.portlet.RenderRequest;

import net.evrem.commons.json.JsonSerializer;
import net.evrem.dtos.dto.EventDto;
import net.evrem.service.service.NoteLocalServiceUtil;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.util.PortalUtil;

@Controller
@RequestMapping(value = "VIEW")
public class CalendarController {

	private final Log log = LogFactoryUtil.getLog(getClass());

	@RenderMapping
	public String view(RenderRequest request, ModelMap map) {
		Long userId = PortalUtil.getUserId(request);

		List<EventDto> events = null;
		try {
			events = NoteLocalServiceUtil.getEvents(userId);
		} catch (Exception e1) {
			log.error("Error during fetching events for userId: " + userId, e1);
		}

		map.addAttribute("eventsJSON", JsonSerializer.toJson(events));

		return "view";
	}

}
