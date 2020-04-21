package net.evrem.dtos.dto;

import java.util.List;

import net.evrem.dtos.form.GridItemForm;

public class CoordinatesDto {

	private List<GridItemForm> gridItems;

	public List<GridItemForm> getGridItems() {
		return gridItems;
	}

	public void setGridItems(List<GridItemForm> gridItems) {
		this.gridItems = gridItems;
	}

}
