package net.evrem.dtos.dto;

import java.util.HashMap;
import java.util.List;

import net.evrem.dtos.form.ColorForm;
import net.evrem.dtos.form.PeriodForm;

public class CodelistDto {

	private List<ColorForm> colors;
	private List<PeriodForm> periods;

	private HashMap<String, String> urls;

	public List<ColorForm> getColors() {
		return colors;
	}

	public void setColors(List<ColorForm> colors) {
		this.colors = colors;
	}

	public List<PeriodForm> getPeriods() {
		return periods;
	}

	public void setPeriods(List<PeriodForm> periods) {
		this.periods = periods;
	}

	public HashMap<String, String> getUrls() {
		return urls;
	}

	public void setUrls(HashMap<String, String> urls) {
		this.urls = urls;
	}

}
