package net.evrem.portlet.upcoming.controller;

import java.util.List;

import javax.portlet.RenderRequest;

import net.evrem.commons.json.JsonSerializer;
import net.evrem.dtos.form.NoteFormModel;
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
public class UpcomingController {

	private final Log log = LogFactoryUtil.getLog(getClass());

	@RenderMapping
	public String view(RenderRequest request, ModelMap map) {
		List<NoteFormModel> noteForms = null;

		Long userId = PortalUtil.getUserId(request);

		try {
			noteForms = NoteLocalServiceUtil.getNotesEventByUserId(userId, false);
		} catch (Exception e) {
			log.error("Error during fetching notes for userId: " + userId, e);
		}
		map.addAttribute("notesJSON", JsonSerializer.toJson(noteForms));

		return "view";
	}

}
