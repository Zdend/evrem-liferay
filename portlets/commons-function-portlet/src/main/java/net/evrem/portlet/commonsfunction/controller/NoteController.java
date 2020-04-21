package net.evrem.portlet.commonsfunction.controller;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import net.evrem.commons.ajax.AjaxResponse;
import net.evrem.service.service.NoteLocalServiceUtil;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.util.PortalUtil;

@Controller
@RequestMapping(value = "VIEW")
public class NoteController {

	private final Log log = LogFactoryUtil.getLog(getClass());

	@RenderMapping
	public String view(RenderRequest request, RenderResponse response) {
		return "view";
	}

	@ResourceMapping("checkNote")
	public void checkNote(@RequestParam("noteId") String noteId, ResourceRequest req, ResourceResponse res) {

		Long userId;
		try {
			userId = PortalUtil.getUserId(req);
		} catch (Exception e) {
			log.error("Error during getting user from request.");
			return;
		}

		try {
			NoteLocalServiceUtil.checkNote(Long.valueOf(noteId), userId);
		} catch (Exception e1) {
			log.error("Error during checking note.", e1);
		}

		AjaxResponse<Object> response = new AjaxResponse<Object>();
		try {
			res.getWriter().write(response.toJson());
		} catch (Exception e) {
			log.error("Error during writing JSON to response.", e);
		}

		System.out.println("Note has been successfully (un)checked.");
	}

	@ResourceMapping("checkTodoNote")
	public void checkTodoNote(@RequestParam("noteId") String noteId, @RequestParam("todoNoteId") String todoNoteId, ResourceRequest req, ResourceResponse res) {

		Long userId;
		try {
			userId = PortalUtil.getUserId(req);
		} catch (Exception e) {
			log.error("Error during getting user from request.");
			return;
		}

		try {
			NoteLocalServiceUtil.checkTodoNote(Long.valueOf(noteId), Long.valueOf(todoNoteId), userId);
		} catch (Exception e1) {
			log.error("Error during checking todonote.", e1);
		}

		AjaxResponse<Object> response = new AjaxResponse<Object>();
		try {
			res.getWriter().write(response.toJson());
		} catch (Exception e) {
			log.error("Error during writing JSON to response.", e);
		}

		System.out.println("Todo note has been successfully (un)checked.");
	}

}
