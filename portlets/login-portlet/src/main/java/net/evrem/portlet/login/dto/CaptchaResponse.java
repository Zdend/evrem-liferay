package net.evrem.portlet.login.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CaptchaResponse {

	private Boolean success;

	@JsonProperty("error-codes")
	private List<String> errorcodes;

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

}
