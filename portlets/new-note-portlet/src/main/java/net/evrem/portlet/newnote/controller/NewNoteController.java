package net.evrem.portlet.newnote.controller;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.RenderRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import net.evrem.commons.ajax.AjaxResponse;
import net.evrem.commons.converter.ColorEnumToColorFormConverter;
import net.evrem.commons.converter.PeriodEnumToPeriodFormConverter;
import net.evrem.commons.json.JsonSerializer;
import net.evrem.commons.util.FormDataUtil;
import net.evrem.dtos.enums.Color;
import net.evrem.dtos.enums.Period;
import net.evrem.dtos.form.ColorForm;
import net.evrem.dtos.form.NoteFormModel;
import net.evrem.dtos.form.PeriodForm;
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
public class NewNoteController {

	private final Log log = LogFactoryUtil.getLog(getClass());

	@RenderMapping
	public String view(RenderRequest request, ModelMap map) {
		List<ColorForm> colors = new ArrayList<ColorForm>();
		ColorEnumToColorFormConverter colorConverter = new ColorEnumToColorFormConverter();
		for (Color color : Color.values()) {
			colors.add(colorConverter.convertFrom(color, null));
		}
		List<PeriodForm> periods = new ArrayList<PeriodForm>();
		PeriodEnumToPeriodFormConverter periodConverter = new PeriodEnumToPeriodFormConverter();
		for (Period period : Period.values()) {
			periods.add(periodConverter.convertFrom(period, null));
		}

		map.addAttribute("periods", JsonSerializer.toJson(periods));
		map.addAttribute("colors", JsonSerializer.toJson(colors));
		return "view";
	}

	@ResourceMapping("saveNote")
	public void saveNote(@RequestParam("jsonNote") String jsonNote, ResourceRequest req, ResourceResponse res) {
		NoteFormModel note = convertToFormModel(jsonNote);

		if (!validateNote(note)) {
			// TODO Add validation result to ajax response
			log.error("Error during validation note. It hasn't been saved.");
			return;
		}

		try {
			NoteLocalServiceUtil.saveNote(note, PortalUtil.getUserId(req));
		} catch (Exception e1) {
			log.error("Error during saving note", e1);
		}

		AjaxResponse<NoteFormModel> response = new AjaxResponse<NoteFormModel>();
		try {
			res.getWriter().write(response.toJson());
		} catch (Exception e) {
			log.error("Error during writing JSON to response.", e);
		}
	}

	private NoteFormModel convertToFormModel(String jsonNote) {
		NoteFormModel note = null;
		try {
			String escapedData = FormDataUtil.escape(jsonNote);
			note = JsonSerializer.getInstance().readValue(escapedData, NoteFormModel.class);
		} catch (Exception e) {
			log.error("Error during deserialization to NoteFormModel", e);
		}
		System.out.println(JsonSerializer.toJson(note));
		return note;
	}

	@ResourceMapping("deleteNote")
	public void deleteNote(@RequestParam("jsonNote") String jsonNote, ResourceRequest req, ResourceResponse res) {
		NoteFormModel note = convertToFormModel(jsonNote);

		try {
			NoteLocalServiceUtil.deleteNote(note.getNoteId(), PortalUtil.getUserId(req));
		} catch (Exception e1) {
			log.error("Error during deleting note: " + note.getNoteId(), e1);
		}

		AjaxResponse<NoteFormModel> response = new AjaxResponse<NoteFormModel>();
		try {
			res.getWriter().write(response.toJson());
		} catch (Exception e) {
			log.error("Error during writing JSON to response.", e);
		}

		System.out.println("Note " + note.getNoteId() + " has been successfully deleted.");
	}

	private Boolean validateNote(NoteFormModel note) {
		if (note.getHasTime() && note.getEventTime() == null) {
			return false;
		}
		if (note.getHasReminder() && note.getRemindInfo().getRemindDate() == null) {
			return false;
		}
		if (note.getNoteId() != null && note.getUserId() == null) {
			return false;
		}
		if (note.getText().length() > 2000) {
			return false;
		}
		return true;
	}

}
