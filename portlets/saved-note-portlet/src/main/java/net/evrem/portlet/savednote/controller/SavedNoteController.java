package net.evrem.portlet.savednote.controller;

import java.util.List;

import javax.portlet.RenderRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import net.evrem.commons.ajax.AjaxResponse;
import net.evrem.commons.json.JsonSerializer;
import net.evrem.dtos.dto.CoordinatesDto;
import net.evrem.dtos.form.NoteFormModel;
import net.evrem.service.service.GridItemLocalServiceUtil;
import net.evrem.service.service.NoteLocalServiceUtil;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.util.PortalUtil;

@Controller
@RequestMapping(value = "VIEW")
public class SavedNoteController {

	private final Log log = LogFactoryUtil.getLog(getClass());

	@RenderMapping
	public String view(RenderRequest request, ModelMap map) {
		List<NoteFormModel> noteForms = null;

		Long userId = PortalUtil.getUserId(request);

		try {
			noteForms = NoteLocalServiceUtil.getNotesByUserId(userId);
		} catch (Exception e) {
			log.error("Error during fetching notes for userId: " + userId, e);
		}
		map.addAttribute("notesJSON", JsonSerializer.toJson(noteForms));

		return "view";
	}

	@ResourceMapping("saveCoordinates")
	public void saveCoordinates(@RequestParam("jsonCoordinates") String jsonCoordinates, ResourceRequest req, ResourceResponse res) {
		CoordinatesDto coordinates = convertToCoordinates(jsonCoordinates);

		Long userId;
		try {
			userId = PortalUtil.getUserId(req);
		} catch (Exception e) {
			log.error("Error during getting user from request.");
			return;
		}

		try {
			GridItemLocalServiceUtil.saveCoordinates(coordinates, userId);
		} catch (Exception e1) {
			log.error("Error during updating coordinates.", e1);
		}

		AjaxResponse<Object> response = new AjaxResponse<Object>();
		try {
			res.getWriter().write(response.toJson());
		} catch (Exception e) {
			log.error("Error during writing JSON to response.", e);
		}

		System.out.println("Coordinates has been successfully saved.");
	}

	private CoordinatesDto convertToCoordinates(String jsonCoordinates) {
		CoordinatesDto coordinates = null;
		try {
			coordinates = JsonSerializer.getInstance().readValue(jsonCoordinates, CoordinatesDto.class);
		} catch (Exception e) {
			log.error("Error during deserialization to Coordinates", e);
		}
		System.out.println(JsonSerializer.toJson(coordinates));
		return coordinates;
	}

}
