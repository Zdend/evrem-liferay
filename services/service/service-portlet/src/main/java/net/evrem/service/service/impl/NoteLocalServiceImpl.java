package net.evrem.service.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.evrem.dtos.dto.EventDto;
import net.evrem.dtos.form.GridItemForm;
import net.evrem.dtos.form.NoteFormModel;
import net.evrem.dtos.form.RemindInfoForm;
import net.evrem.dtos.form.TodoNoteForm;
import net.evrem.service.converter.NoteFormModelToNoteConverter;
import net.evrem.service.converter.NoteToEventDtoConverter;
import net.evrem.service.model.Note;
import net.evrem.service.service.GridItemLocalServiceUtil;
import net.evrem.service.service.RemindInfoLocalServiceUtil;
import net.evrem.service.service.TodoNoteLocalServiceUtil;
import net.evrem.service.service.base.NoteLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * The implementation of the note local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link net.evrem.service.service.NoteLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author Brian Wing Shun Chan
 * @see net.evrem.service.service.base.NoteLocalServiceBaseImpl
 * @see net.evrem.service.service.NoteLocalServiceUtil
 */
public class NoteLocalServiceImpl extends NoteLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * net.evrem.service.service.NoteLocalServiceUtil} to access the note local
	 * service.
	 */

	private final Log log = LogFactoryUtil.getLog(getClass());

	public Note createNote() throws SystemException {
		Long noteId = counterLocalService.increment(Note.class.toString());
		System.out.println("Note id from create note: " + noteId);
		return super.createNote(noteId);
	}

	public void saveNote(NoteFormModel noteForm, Long userId) throws Exception {
		try {
			Note note = null;
			if (noteForm.getNoteId() != null) {
				note = getNote(noteForm.getNoteId());

				if (!userId.equals(note.getUserId())) {
					throw new Exception("You are trying to save note that is not yours. NoteId: " + note.getNoteId() + ", userId: " + userId);
				}
			} else {
				note = createNote();
				note.setUserId(userId);
			}

			NoteFormModelToNoteConverter noteConverter = new NoteFormModelToNoteConverter();

			noteConverter.convertToNote(noteForm, note);

			if (noteForm.getHasReminder()) {
				RemindInfoLocalServiceUtil.saveRemindInfo(noteForm.getRemindInfo(), note.getNoteId());
			}

			if (noteForm.getHasTodo()) {
				TodoNoteLocalServiceUtil.saveTodoNotes(noteForm.getText(), note.getNoteId(), noteForm.getNoteId() != null, noteForm.getIsDone());
			}

			if (noteForm.getHasWall()) {
				GridItemLocalServiceUtil.saveGridItem(noteForm.getGridItem(), note.getNoteId());
			}

			if (noteForm.getNoteId() == null) {
				addNote(note);
			} else {
				checkAndDeleteNoteDependentEntities(note.getNoteId());
				note.setModifiedDate(new Date());
				updateNote(note);
			}
		} catch (Exception e) {
			log.error("Error during saving or converting note.", e);
		}
	}

	public void deletePermanentlyNote(Long noteId, Long userId) throws Exception {
		Note note = getNote(noteId);
		if (!userId.equals(note.getUserId())) {
			throw new Exception("You are trying to delete permanently note that is not yours. NoteId: " + noteId + ", userId: " + userId);
		}
		checkAndDeleteNoteDependentEntities(noteId);
		deleteNote(note);
	}

	private void checkAndDeleteNoteDependentEntities(Long noteId) throws Exception {
		Note note = getNote(noteId);
		if (!note.getHasReminder()) {
			RemindInfoLocalServiceUtil.deleteByNoteId(noteId);
		}
		if (!note.getHasTodo()) {
			TodoNoteLocalServiceUtil.deleteByNoteId(noteId);
		}
		if (!note.getHasWall()) {
			GridItemLocalServiceUtil.deleteByNoteId(noteId);
		}
	}

	public void deleteNote(Long noteId, Long userId) throws Exception {
		Note note = getNote(noteId);
		if (!userId.equals(note.getUserId())) {
			throw new Exception("You are trying to delete note that is not yours. NoteId: " + noteId + ", userId: " + userId);
		}
		note.setModifiedDate(new Date());
		note.setIsDeleted(true);
		updateNote(note);
	}

	public void deleteAllDeletedNotesPermanently(Long userId) throws Exception {
		List<Note> notes = getNotePersistence().findByDeletedNotesByUserId(userId);
		for (Note note : notes) {
			deletePermanentlyNote(note.getNoteId(), userId);
		}
	}

	public List<NoteFormModel> getNotesByUserId(Long userId) throws Exception {
		List<NoteFormModel> noteForms = new ArrayList<NoteFormModel>();

		List<Note> notes = getNotePersistence().findByUserIdOnWall(userId);
		NoteFormModelToNoteConverter noteConverter = new NoteFormModelToNoteConverter();

		for (Note note : notes) {
			NoteFormModel form = new NoteFormModel();
			noteConverter.convertToForm(note, form);

			setDependentEntitiesToNote(form, note, note.getNoteId(), true);

			noteForms.add(form);
		}

		return noteForms;
	}

	private void setDependentEntitiesToNote(NoteFormModel form, Note note, Long noteId, Boolean withGrid) throws Exception {
		if (note.getHasReminder()) {
			RemindInfoForm remindInfoForm = RemindInfoLocalServiceUtil.getRemindInfoByNoteId(form.getNoteId());
			form.setRemindInfo(remindInfoForm);
		}

		if (note.getHasTodo()) {
			List<TodoNoteForm> todoForms = TodoNoteLocalServiceUtil.getTodoNotesByNoteId(note.getNoteId());
			form.setTodos(todoForms);
		}

		if (note.getHasWall() && withGrid) {
			GridItemForm gridItemForm = GridItemLocalServiceUtil.getGridItemByNoteId(note.getNoteId());
			form.setGridItem(gridItemForm);
		}
	}

	public List<NoteFormModel> getNotesEventByUserId(Long userId, Boolean withDeleted) throws Exception {
		List<NoteFormModel> noteForms = new ArrayList<NoteFormModel>();
		List<Note> notes = null;
		if (withDeleted) {
			notes = getNotePersistence().findByAllNotesByUserId(userId);
		} else {
			notes = getNotePersistence().findByUserId(userId);
		}
		NoteFormModelToNoteConverter noteConverter = new NoteFormModelToNoteConverter();

		for (Note note : notes) {
			NoteFormModel form = new NoteFormModel();
			noteConverter.convertToForm(note, form);

			setDependentEntitiesToNote(form, note, note.getNoteId(), false);

			noteForms.add(form);
		}

		return noteForms;
	}

	public List<NoteFormModel> getNotesForReminding(Long userId) throws Exception {
		List<NoteFormModel> noteForms = new ArrayList<NoteFormModel>();

		List<Note> notes = getNotePersistence().findByRemindDate(userId);
		NoteFormModelToNoteConverter noteConverter = new NoteFormModelToNoteConverter();

		for (Note note : notes) {
			NoteFormModel form = new NoteFormModel();
			noteConverter.convertToForm(note, form);

			setDependentEntitiesToNote(form, note, note.getNoteId(), false);

			noteForms.add(form);
		}

		return noteForms;
	}

	public List<EventDto> getEvents(Long userId) throws Exception {
		List<EventDto> events = new ArrayList<EventDto>();
		List<Note> notes = getNotePersistence().findByEventTime(userId);
		NoteToEventDtoConverter converter = new NoteToEventDtoConverter();

		for (Note note : notes) {
			events.add(converter.convertToDto(note, null));
		}

		return events;

	}

	public void checkNote(Long noteId, Long userId) throws Exception {
		Note note = getNote(noteId);

		if (!userId.equals(note.getUserId())) {
			throw new Exception("You are trying to check note that is not yours. NoteId: " + noteId + ", userId: " + userId);
		}

		Boolean checkState = !note.getIsDone();
		TodoNoteLocalServiceUtil.checkAllTodoNotes(noteId, checkState);

		note.setIsDone(checkState);
		updateNote(note);
	}

	public void checkTodoNote(Long noteId, Long todoNoteId, Long userId) throws Exception {
		Note note = getNote(noteId);

		if (!userId.equals(note.getUserId())) {
			throw new Exception("You are trying to check todonote that is not yours. NoteId: " + noteId + ", userId: " + userId);
		}
		TodoNoteLocalServiceUtil.checkTodoNote(noteId, todoNoteId);

		note.setModifiedDate(new Date());
		updateNote(note);
	}

}
