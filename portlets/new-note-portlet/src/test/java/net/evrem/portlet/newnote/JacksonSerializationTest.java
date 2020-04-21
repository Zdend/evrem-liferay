package net.evrem.portlet.newnote;

import java.util.Arrays;
import java.util.List;

import net.evrem.commons.json.JsonSerializer;
import net.evrem.dtos.enums.Color;
import net.evrem.dtos.enums.Period;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonSerializationTest {

	@Test
	public void testSerializationOfEnum() {
		List<Color> colors = Arrays.asList(Color.values());
		List<Period> periods = Arrays.asList(Period.values());

		// List<ColorDto> colorsDto = new ArrayList<ColorDto>();
		// colorsDto.add(new ColorDto("BLUE_NAVY", "#185287"));
		// colorsDto.add(new ColorDto("BLUE_NAVY", "#185287"));
		// colorsDto.add(new ColorDto("BLUE_NAVY", "#185287"));
		// colorsDto.add(new ColorDto("BLUE_NAVY", "#185287"));
		// colorsDto.add(new ColorDto("BLUE_NAVY", "#185287"));

		System.out.println(JsonSerializer.toJson(colors));

		// System.out.println(JsonSerializer.toJson(colorsDto));

		ObjectMapper mapper = JsonSerializer.getInstance();
	}

}
