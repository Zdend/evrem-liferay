package net.evrem.service.converter;

import java.text.SimpleDateFormat;

import net.evrem.dtos.dto.EventDto;
import net.evrem.dtos.enums.Color;
import net.evrem.service.model.Note;

public class NoteToEventDtoConverter {

	public EventDto convertToDto(Note note, EventDto dto) {
		if (dto == null) {
			dto = new EventDto();
		}
		dto.setId(note.getNoteId());

		Color colorEnum = Color.valueOf(note.getColor());
		dto.setColor(colorEnum.getColorWithHash());

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		dto.setStart(format.format(note.getEventTime()));

		dto.setTitle(note.getText());

		return dto;
	}

}
