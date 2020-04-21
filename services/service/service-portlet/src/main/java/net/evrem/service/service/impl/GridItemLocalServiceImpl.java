package net.evrem.service.service.impl;

import net.evrem.dtos.dto.CoordinatesDto;
import net.evrem.dtos.form.GridItemForm;
import net.evrem.service.converter.GridItemFormToGridItemConverter;
import net.evrem.service.model.GridItem;
import net.evrem.service.model.Note;
import net.evrem.service.service.NoteLocalServiceUtil;
import net.evrem.service.service.base.GridItemLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * The implementation of the grid item local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link net.evrem.service.service.GridItemLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author Zdenek Vecek
 * @see net.evrem.service.service.base.GridItemLocalServiceBaseImpl
 * @see net.evrem.service.service.GridItemLocalServiceUtil
 */
public class GridItemLocalServiceImpl extends GridItemLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * net.evrem.service.service.GridItemLocalServiceUtil} to access the grid
	 * item local service.
	 */

	private final Log log = LogFactoryUtil.getLog(getClass());

	public GridItem createGridItem() throws SystemException {
		Long gridItemId = counterLocalService.increment(GridItem.class.toString());
		GridItem gridItem = super.createGridItem(gridItemId);
		setDefaultValues(gridItem);
		return gridItem;
	}

	private void setDefaultValues(GridItem gridItem) {
		gridItem.setX(1);
		gridItem.setY(1);
		gridItem.setW(2);
		gridItem.setH(1);
	}

	public void saveGridItem(GridItemForm gridForm, Long noteId) throws Exception {
		GridItem gridItem = getGridItemPersistence().fetchByNoteId(noteId);

		if (gridItem == null) {
			gridItem = createGridItem();
			gridItem.setNoteId(noteId);
		}

		GridItemFormToGridItemConverter gridItemConverter = new GridItemFormToGridItemConverter();
		gridItemConverter.convertToGridItem(gridForm, gridItem);

		updateGridItem(gridItem);
	}

	public GridItemForm getGridItemByNoteId(Long noteId) throws Exception {
		GridItem gridItem = null;

		gridItem = getGridItemPersistence().findByNoteId(noteId);

		GridItemForm form = null;
		if (gridItem != null && !Long.valueOf(gridItem.getGridItemId()).equals(0L)) {

			GridItemFormToGridItemConverter converter = new GridItemFormToGridItemConverter();
			form = converter.convertToForm(gridItem, form);
		}

		return form;
	}

	public void deleteByNoteId(Long noteId) throws Exception {
		GridItem gridItem = getGridItemPersistence().fetchByNoteId(noteId);
		if (gridItem != null) {
			deleteGridItem(gridItem);
		}
	}

	public void saveCoordinates(CoordinatesDto coordinates, Long userId) throws Exception {
		for (GridItemForm form : coordinates.getGridItems()) {
			GridItem gridItem = getGridItem(form.getGridItemId());
			Note note = NoteLocalServiceUtil.getNote(gridItem.getNoteId());

			if (!Long.valueOf(note.getUserId()).equals(userId)) {
				throw new Exception("You are trying to update note coordinates, that is not yours!! UserId: " + userId);
			}

			GridItemFormToGridItemConverter converter = new GridItemFormToGridItemConverter();
			converter.convertToGridItem(form, gridItem);
			updateGridItem(gridItem);
		}
	}

}
