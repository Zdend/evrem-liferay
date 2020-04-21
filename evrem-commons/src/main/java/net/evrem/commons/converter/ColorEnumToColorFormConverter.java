package net.evrem.commons.converter;

import net.evrem.dtos.enums.Color;
import net.evrem.dtos.form.ColorForm;

public class ColorEnumToColorFormConverter implements Converter<Color, ColorForm> {

	public ColorForm convertFrom(Color s, ColorForm t) {
		if (t == null) {
			t = new ColorForm();
		}
		t.setName(s.name());
		t.setColorWithHash(s.getColorWithHash());
		return t;
	}

	public Color convertTo(ColorForm t, Color s) {
		return Color.valueOf(s.name());
	}

}
