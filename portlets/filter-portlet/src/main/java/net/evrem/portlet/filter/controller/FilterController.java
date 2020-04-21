package net.evrem.portlet.filter.controller;

import java.util.List;

import javax.portlet.RenderRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import net.evrem.commons.ajax.AjaxResponse;
import net.evrem.commons.export.ExportManager;
import net.evrem.commons.file.FileService;
import net.evrem.commons.file.FileServiceImpl;
import net.evrem.commons.json.JsonSerializer;
import net.evrem.dtos.form.NoteFormModel;
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
public class FilterController {

	private final Log log = LogFactoryUtil.getLog(getClass());

	private final String XLSX_MIME_TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

	@RenderMapping
	public String view(RenderRequest request, ModelMap map) {
		List<NoteFormModel> noteForms = null;

		Long userId = PortalUtil.getUserId(request);

		try {
			noteForms = NoteLocalServiceUtil.getNotesEventByUserId(userId, true);
		} catch (Exception e) {
			log.error("Error during fetching notes for userId: " + userId, e);
		}
		map.addAttribute("notesJSON", JsonSerializer.toJson(noteForms));
		return "view";
	}

	@ResourceMapping("exportAll")
	public void exportAll(ResourceRequest req, ResourceResponse res) {
		Long userId = PortalUtil.getUserId(req);
		String filePath = null;
		try {
			filePath = ExportManager.getExportAllFile(userId);
		} catch (Exception e1) {
			log.error("Error during exporting file for user: " + userId, e1);
		}

		AjaxResponse<String> response = new AjaxResponse<String>();
		response.setPayload(filePath);
		try {
			res.getWriter().write(response.toJson());
		} catch (Exception e) {
			log.error("Error during writing JSON to response.", e);
		}
	}

	@ResourceMapping("getExportAllFile")
	public void getExportAllFile(@RequestParam("fileName") String fileName, ResourceRequest req, ResourceResponse res) {
		FileService fileService = new FileServiceImpl();

		try {
			fileService.getFileFromTemp(fileName, res.getPortletOutputStream());
			res.setContentType(XLSX_MIME_TYPE);
			res.setProperty("Content-Disposition", "attachment; filename=" + fileName);
			res.flushBuffer();

			fileService.deleteFileFromTemp(fileName);
		} catch (Exception ex) {
			log.error("Error writing file to output stream. Filename was: " + fileName, ex);
		}

	}

	@ResourceMapping("emptyTrash")
	public void emptyTrash(ResourceRequest req, ResourceResponse res) {

		Long userId = PortalUtil.getUserId(req);

		try {
			NoteLocalServiceUtil.deleteAllDeletedNotesPermanently(userId);
		} catch (Exception e) {
			log.error("Error emptying trash for user: " + userId, e);
		}
		List<NoteFormModel> noteForms = null;
		try {
			noteForms = NoteLocalServiceUtil.getNotesEventByUserId(userId, true);
		} catch (Exception e) {
			log.error("Error during fetching notes for userId: " + userId, e);
		}

		AjaxResponse<List<NoteFormModel>> response = new AjaxResponse<List<NoteFormModel>>();
		response.setPayload(noteForms);
		try {
			res.getWriter().write(response.toJson());
		} catch (Exception e) {
			log.error("Error during writing JSON to response.", e);
		}
	}

}
