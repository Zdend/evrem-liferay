package net.evrem.service.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link GridItem}.
 * </p>
 *
 * @author Zdenek Vecek
 * @see GridItem
 * @generated
 */
public class GridItemWrapper implements GridItem, ModelWrapper<GridItem> {
    private GridItem _gridItem;

    public GridItemWrapper(GridItem gridItem) {
        _gridItem = gridItem;
    }

    @Override
    public Class<?> getModelClass() {
        return GridItem.class;
    }

    @Override
    public String getModelClassName() {
        return GridItem.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("gridItemId", getGridItemId());
        attributes.put("noteId", getNoteId());
        attributes.put("w", getW());
        attributes.put("h", getH());
        attributes.put("x", getX());
        attributes.put("y", getY());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long gridItemId = (Long) attributes.get("gridItemId");

        if (gridItemId != null) {
            setGridItemId(gridItemId);
        }

        Long noteId = (Long) attributes.get("noteId");

        if (noteId != null) {
            setNoteId(noteId);
        }

        Integer w = (Integer) attributes.get("w");

        if (w != null) {
            setW(w);
        }

        Integer h = (Integer) attributes.get("h");

        if (h != null) {
            setH(h);
        }

        Integer x = (Integer) attributes.get("x");

        if (x != null) {
            setX(x);
        }

        Integer y = (Integer) attributes.get("y");

        if (y != null) {
            setY(y);
        }
    }

    /**
    * Returns the primary key of this grid item.
    *
    * @return the primary key of this grid item
    */
    @Override
    public long getPrimaryKey() {
        return _gridItem.getPrimaryKey();
    }

    /**
    * Sets the primary key of this grid item.
    *
    * @param primaryKey the primary key of this grid item
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _gridItem.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the grid item ID of this grid item.
    *
    * @return the grid item ID of this grid item
    */
    @Override
    public long getGridItemId() {
        return _gridItem.getGridItemId();
    }

    /**
    * Sets the grid item ID of this grid item.
    *
    * @param gridItemId the grid item ID of this grid item
    */
    @Override
    public void setGridItemId(long gridItemId) {
        _gridItem.setGridItemId(gridItemId);
    }

    /**
    * Returns the note ID of this grid item.
    *
    * @return the note ID of this grid item
    */
    @Override
    public long getNoteId() {
        return _gridItem.getNoteId();
    }

    /**
    * Sets the note ID of this grid item.
    *
    * @param noteId the note ID of this grid item
    */
    @Override
    public void setNoteId(long noteId) {
        _gridItem.setNoteId(noteId);
    }

    /**
    * Returns the w of this grid item.
    *
    * @return the w of this grid item
    */
    @Override
    public int getW() {
        return _gridItem.getW();
    }

    /**
    * Sets the w of this grid item.
    *
    * @param w the w of this grid item
    */
    @Override
    public void setW(int w) {
        _gridItem.setW(w);
    }

    /**
    * Returns the h of this grid item.
    *
    * @return the h of this grid item
    */
    @Override
    public int getH() {
        return _gridItem.getH();
    }

    /**
    * Sets the h of this grid item.
    *
    * @param h the h of this grid item
    */
    @Override
    public void setH(int h) {
        _gridItem.setH(h);
    }

    /**
    * Returns the x of this grid item.
    *
    * @return the x of this grid item
    */
    @Override
    public int getX() {
        return _gridItem.getX();
    }

    /**
    * Sets the x of this grid item.
    *
    * @param x the x of this grid item
    */
    @Override
    public void setX(int x) {
        _gridItem.setX(x);
    }

    /**
    * Returns the y of this grid item.
    *
    * @return the y of this grid item
    */
    @Override
    public int getY() {
        return _gridItem.getY();
    }

    /**
    * Sets the y of this grid item.
    *
    * @param y the y of this grid item
    */
    @Override
    public void setY(int y) {
        _gridItem.setY(y);
    }

    @Override
    public boolean isNew() {
        return _gridItem.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _gridItem.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _gridItem.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _gridItem.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _gridItem.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _gridItem.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _gridItem.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _gridItem.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _gridItem.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _gridItem.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _gridItem.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new GridItemWrapper((GridItem) _gridItem.clone());
    }

    @Override
    public int compareTo(net.evrem.service.model.GridItem gridItem) {
        return _gridItem.compareTo(gridItem);
    }

    @Override
    public int hashCode() {
        return _gridItem.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<net.evrem.service.model.GridItem> toCacheModel() {
        return _gridItem.toCacheModel();
    }

    @Override
    public net.evrem.service.model.GridItem toEscapedModel() {
        return new GridItemWrapper(_gridItem.toEscapedModel());
    }

    @Override
    public net.evrem.service.model.GridItem toUnescapedModel() {
        return new GridItemWrapper(_gridItem.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _gridItem.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _gridItem.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _gridItem.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof GridItemWrapper)) {
            return false;
        }

        GridItemWrapper gridItemWrapper = (GridItemWrapper) obj;

        if (Validator.equals(_gridItem, gridItemWrapper._gridItem)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public GridItem getWrappedGridItem() {
        return _gridItem;
    }

    @Override
    public GridItem getWrappedModel() {
        return _gridItem;
    }

    @Override
    public void resetOriginalValues() {
        _gridItem.resetOriginalValues();
    }
}
