package net.evrem.service.converter;

import net.evrem.dtos.form.GridItemForm;
import net.evrem.service.model.GridItem;

public class GridItemFormToGridItemConverter {

	public GridItem convertToGridItem(GridItemForm form, GridItem gridItem) {
		if (form == null || form.getX() == null || form.getY() == null || form.getW() == null || form.getH() == null) {
			return gridItem;
		}
		gridItem.setW(form.getW());
		gridItem.setH(form.getH());
		gridItem.setX(form.getX());
		gridItem.setY(form.getY());
		return gridItem;
	}

	public GridItemForm convertToForm(GridItem gridItem, GridItemForm form) {
		if (form == null) {
			form = new GridItemForm();
		}

		form.setGridItemId(gridItem.getGridItemId());
		form.setW(gridItem.getW());
		form.setH(gridItem.getH());
		form.setX(gridItem.getX());
		form.setY(gridItem.getY());
		return form;
	}

}
