package net.evrem.service.converter;

import java.util.Date;

import net.evrem.dtos.enums.Color;
import net.evrem.dtos.enums.Period;
import net.evrem.dtos.form.ColorForm;
import net.evrem.dtos.form.NoteFormModel;
import net.evrem.dtos.form.PeriodForm;
import net.evrem.service.model.Note;

import org.apache.commons.lang.StringUtils;

public class NoteFormModelToNoteConverter {

	public Note convertToNote(NoteFormModel form, Note note) {
		note.setCreatedDate(new Date());
		note.setIsDeleted(false);

		note.setHasCheck(form.getHasCheck());
		note.setHasReminder(form.getHasReminder());
		note.setHasRepeat(form.getHasRepeat());
		note.setHasTime(form.getHasTime());
		note.setHasTodo(form.getHasTodo());
		note.setHasColor(form.getHasColor());
		note.setHasWall(form.getHasWall());

		if (form.getHasRepeat()) {
			Period periodEnum = Period.valueOf(form.getPeriod().getName());
			note.setPeriod(periodEnum.name());
		}

		note.setEventTime(form.getEventTime());
		note.setIsDone(form.getIsDone());
		note.setColor(Color.valueOf(form.getColor().getName()).toString());

		String[] lines = form.getText().split("[\r\n]+");

		note.setText(StringUtils.join(lines, "\r\n"));

		return note;
	}

	public NoteFormModel convertToForm(Note note, NoteFormModel form) {
		if (form == null) {
			form = new NoteFormModel();
		}
		form.setUserId(note.getUserId());
		form.setNoteId(note.getNoteId());

		Color colorEnum = Color.valueOf(note.getColor());
		form.setColor(new ColorForm(colorEnum.name(), colorEnum.getColorWithHash()));
		form.setCreatedDate(note.getCreatedDate());
		form.setEventTime(note.getEventTime());
		form.setIsDone(note.getIsDone());
		form.setModifiedDate(note.getModifiedDate());

		if (note.getHasRepeat()) {
			Period periodEnum = Period.valueOf(note.getPeriod());
			form.setPeriod(new PeriodForm(periodEnum.name(), periodEnum.getTitle()));
		}

		form.setHasCheck(note.getHasCheck());
		form.setHasColor(note.getHasColor());
		form.setHasReminder(note.getHasReminder());
		form.setHasRepeat(note.getHasRepeat());
		form.setHasTime(note.getHasTime());
		form.setHasTodo(note.getHasTodo());
		form.setHasWall(note.getHasWall());

		form.setText(note.getText());
		form.setIsDeleted(note.getIsDeleted());

		return form;
	}

}
