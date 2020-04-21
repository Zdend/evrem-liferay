package net.evrem.service.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.evrem.dtos.form.TodoNoteForm;
import net.evrem.service.converter.TodoNoteFormToTodoNoteConverter;
import net.evrem.service.model.TodoNote;
import net.evrem.service.service.base.TodoNoteLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the TodoNote local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link net.evrem.service.service.TodoNoteLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author Brian Wing Shun Chan
 * @see net.evrem.service.service.base.TodoNoteLocalServiceBaseImpl
 * @see net.evrem.service.service.TodoNoteLocalServiceUtil
 */
public class TodoNoteLocalServiceImpl extends TodoNoteLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * net.evrem.service.service.TodoNoteLocalServiceUtil} to access the
	 * TodoNote local service.
	 */

	public TodoNote createTodoNote() throws SystemException {
		Long todoNoteId = counterLocalService.increment(TodoNote.class.toString());
		return super.createTodoNote(todoNoteId);
	}

	public void saveTodoNotes(String text, Long noteId, Boolean updateNotes, Boolean checkState) throws Exception {
		String[] lines = text.split("[\r\n]+");

		Boolean rowCountChange = false;
		if (updateNotes) {
			List<TodoNoteForm> forms = getTodoNotesByNoteId(noteId);
			if (forms.size() != lines.length) {
				deleteByNoteId(noteId);
				rowCountChange = true;
			}
		}

		for (int i = 0; i < lines.length; i++) {
			TodoNoteForm form = new TodoNoteForm();

			if (updateNotes && !rowCountChange) {
				form = getTodoNoteByNoteIdAndSortNo(noteId, i);
			} else {
				form.setSortNo(i);
			}
			form.setIsTodoDone(checkState != null ? checkState : false);
			form.setTodoText(lines[i]);

			saveTodoNote(form, noteId);
		}
	}

	public void saveTodoNotes(List<TodoNoteForm> forms, Long noteId) throws Exception {
		for (TodoNoteForm form : forms) {
			saveTodoNote(form, noteId);
		}
	}

	public void saveTodoNote(TodoNoteForm form, Long noteId) throws Exception {
		TodoNote todoNote = null;
		if (form != null && form.getTodoNoteId() != null) {
			todoNote = getTodoNote(form.getTodoNoteId());
		} else {
			todoNote = createTodoNote();
			todoNote.setNoteId(noteId);
		}

		TodoNoteFormToTodoNoteConverter todoNoteConverter = new TodoNoteFormToTodoNoteConverter();
		todoNoteConverter.convertToTodoNote(form, todoNote);

		updateTodoNote(todoNote);

	}

	public TodoNoteForm getTodoNoteByNoteIdAndSortNo(Long noteId, Integer sortNo) throws Exception {
		TodoNote todoNote = getTodoNotePersistence().findByNoteIdAndSortNo(noteId, sortNo);
		TodoNoteFormToTodoNoteConverter todoNoteConverter = new TodoNoteFormToTodoNoteConverter();

		return todoNoteConverter.convertToForm(todoNote, null);
	}

	public List<TodoNoteForm> getTodoNotesByNoteId(Long noteId) throws Exception {
		List<TodoNote> todoNotes = getTodoNotePersistence().findByNoteId(noteId);
		List<TodoNoteForm> todoNoteForms = new ArrayList<TodoNoteForm>();
		TodoNoteFormToTodoNoteConverter todoNoteConverter = new TodoNoteFormToTodoNoteConverter();

		for (TodoNote todoNote : todoNotes) {
			todoNoteForms.add(todoNoteConverter.convertToForm(todoNote, null));
		}

		return todoNoteForms;
	}

	public void deleteByNoteId(Long noteId) throws Exception {
		List<TodoNote> todoNotes = getTodoNotePersistence().findByNoteId(noteId);
		for (TodoNote todoNote : todoNotes) {
			deleteTodoNote(todoNote);
		}
	}

	public void checkTodoNote(Long noteId, Long todoNoteId) throws Exception {
		TodoNote todoNote = getTodoNote(todoNoteId);
		if (!Long.valueOf(todoNote.getNoteId()).equals(noteId)) {
			throw new Exception("You are trying to check todoNote that doesn't belongs to this note.");
		}
		todoNote.setIsDone(!todoNote.getIsDone());

		todoNote.setModifiedDate(new Date());
		updateTodoNote(todoNote);
	}

	public void checkAllTodoNotes(Long noteId, Boolean checkState) throws Exception {
		List<TodoNote> todos = getTodoNotePersistence().findByNoteId(noteId);
		for (TodoNote todoNote : todos) {
			todoNote.setIsDone(checkState);
			todoNote.setModifiedDate(new Date());
			updateTodoNote(todoNote);
		}
	}

}
