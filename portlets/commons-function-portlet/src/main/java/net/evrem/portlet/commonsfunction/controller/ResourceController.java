package net.evrem.portlet.commonsfunction.controller;

import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import net.evrem.commons.ajax.AjaxResponse;
import net.evrem.commons.util.TimeZoneUtil;
import net.evrem.dtos.dto.TimeZoneDto;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

@Controller
@RequestMapping(value = "VIEW")
public class ResourceController {

	private final Log log = LogFactoryUtil.getLog(getClass());

	@ResourceMapping("loadTimeZones")
	public void loadTimeZones(ResourceRequest req, ResourceResponse res) {
		List<TimeZoneDto> timeZones = TimeZoneUtil.getTimeZonesList();
		AjaxResponse<List<TimeZoneDto>> response = new AjaxResponse<List<TimeZoneDto>>();
		response.setPayload(timeZones);

		try {
			res.getWriter().write(response.toJson());
		} catch (Exception e) {
			log.error("Error during writing JSON to response.", e);
		}
		System.out.println("Timezones has been loaded.");
	}

}
