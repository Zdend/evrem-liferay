package net.evrem.commons.converter;

import net.evrem.dtos.enums.Period;
import net.evrem.dtos.form.PeriodForm;

public class PeriodEnumToPeriodFormConverter implements Converter<Period, PeriodForm> {

	public PeriodForm convertFrom(Period s, PeriodForm t) {
		if (t == null) {
			t = new PeriodForm();
		}
		t.setName(s.name());
		t.setTitle(s.getTitle());
		return t;
	}

	public Period convertTo(PeriodForm t, Period s) {
		return Period.valueOf(t.getName());
	}

}
