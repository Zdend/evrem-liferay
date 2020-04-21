package net.evrem.service.converter;

import java.util.Date;

import net.evrem.dtos.form.TodoNoteForm;
import net.evrem.service.model.TodoNote;

public class TodoNoteFormToTodoNoteConverter {

	public TodoNote convertToTodoNote(TodoNoteForm form, TodoNote todoNote) {
		todoNote.setIsDone(form.getIsTodoDone());
		todoNote.setModifiedDate(new Date());
		todoNote.setText(form.getTodoText());
		todoNote.setSortNo(form.getSortNo());

		return todoNote;
	}

	public TodoNoteForm convertToForm(TodoNote todoNote, TodoNoteForm form) {
		if (form == null) {
			form = new TodoNoteForm();
		}

		form.setIsTodoDone(todoNote.getIsDone());
		form.setTodoModifiedDate(todoNote.getModifiedDate());
		form.setTodoNoteId(todoNote.getTodoNoteId());
		form.setTodoText(todoNote.getText());
		form.setSortNo(todoNote.getSortNo());

		return form;
	}

}
