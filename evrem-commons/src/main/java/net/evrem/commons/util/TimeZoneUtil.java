package net.evrem.commons.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import net.evrem.dtos.dto.TimeZoneDto;

import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class TimeZoneUtil {

	public static List<TimeZoneDto> getTimeZonesList() {
		List<TimeZoneDto> dtos = new ArrayList<TimeZoneDto>();
		Set<String> timeZoneIds = DateTimeZone.getAvailableIDs();
		DateTimeFormatter dtf = DateTimeFormat.forPattern("ZZ");
		for (String tzId : timeZoneIds) {
			DateTimeZone timeZone = DateTimeZone.forID(tzId);
			TimeZoneDto dto = null;
			if (timeZone.getID().equals(tzId)) {
				dto = new TimeZoneDto();
				dto.setTimeZoneId(timeZone.getID());
				dto.setOffsetTitle(dtf.withZone(timeZone).print(0));
				dto.setOffset(timeZone.getStandardOffset(0));
				dtos.add(dto);
			}
		}
		return dtos;
	}

}
