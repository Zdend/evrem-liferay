package net.evrem.portlet.support.controller;

import javax.portlet.RenderRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import net.evrem.commons.ajax.AjaxResponse;
import net.evrem.commons.json.JsonSerializer;
import net.evrem.commons.util.TimeZoneUtil;
import net.evrem.dtos.form.UserForm;
import net.evrem.service.service.UserEvremLocalServiceUtil;

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
public class ProfileController {

	private final Log log = LogFactoryUtil.getLog(getClass());

	@RenderMapping
	public String view(RenderRequest request, ModelMap map) {
		UserForm userForm = null;

		try {
			userForm = UserEvremLocalServiceUtil.getUserForm(PortalUtil.getUserId(request));

		} catch (Exception e) {
			log.error("Error during fetching user.", e);
		}

		map.addAttribute("user", JsonSerializer.toJson(userForm));
		map.addAttribute("timeZones", JsonSerializer.toJson(TimeZoneUtil.getTimeZonesList()));

		return "view";
	}

	@ResourceMapping("saveUser")
	public void saveUser(@RequestParam("jsonUser") String jsonUser, ResourceRequest req, ResourceResponse res) {
		UserForm userForm = null;
		try {
			userForm = JsonSerializer.getInstance().readValue(jsonUser, UserForm.class);
		} catch (Exception e) {
			log.error("Error during deserialization User", e);
		}
		Long userId = PortalUtil.getUserId(req);

		try {
			UserEvremLocalServiceUtil.saveUser(userForm, userId);
		} catch (Exception e1) {
			log.error("Error during saving user", e1);
		}

		AjaxResponse<UserForm> response = new AjaxResponse<UserForm>();
		response.setPayload(userForm);
		try {
			res.getWriter().write(response.toJson());
		} catch (Exception e) {
			log.error("Error during writing JSON to response.", e);
		}
	}

}
