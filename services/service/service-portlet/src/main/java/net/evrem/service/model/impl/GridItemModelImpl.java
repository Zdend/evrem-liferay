package net.evrem.service.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import net.evrem.service.model.GridItem;
import net.evrem.service.model.GridItemModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the GridItem service. Represents a row in the &quot;grid_item&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link net.evrem.service.model.GridItemModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link GridItemImpl}.
 * </p>
 *
 * @author Zdenek Vecek
 * @see GridItemImpl
 * @see net.evrem.service.model.GridItem
 * @see net.evrem.service.model.GridItemModel
 * @generated
 */
public class GridItemModelImpl extends BaseModelImpl<GridItem>
    implements GridItemModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a grid item model instance should use the {@link net.evrem.service.model.GridItem} interface instead.
     */
    public static final String TABLE_NAME = "grid_item";
    public static final Object[][] TABLE_COLUMNS = {
            { "griditem_id", Types.BIGINT },
            { "note_id", Types.BIGINT },
            { "w", Types.INTEGER },
            { "h", Types.INTEGER },
            { "x", Types.INTEGER },
            { "y", Types.INTEGER }
        };
    public static final String TABLE_SQL_CREATE = "create table grid_item (griditem_id LONG not null primary key,note_id LONG,w INTEGER,h INTEGER,x INTEGER,y INTEGER)";
    public static final String TABLE_SQL_DROP = "drop table grid_item";
    public static final String ORDER_BY_JPQL = " ORDER BY gridItem.gridItemId ASC";
    public static final String ORDER_BY_SQL = " ORDER BY grid_item.griditem_id ASC";
    public static final String DATA_SOURCE = "evremDataSource";
    public static final String SESSION_FACTORY = "evremSessionFactory";
    public static final String TX_MANAGER = "evremTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.net.evrem.service.model.GridItem"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.net.evrem.service.model.GridItem"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.net.evrem.service.model.GridItem"),
            true);
    public static long NOTEID_COLUMN_BITMASK = 1L;
    public static long GRIDITEMID_COLUMN_BITMASK = 2L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.net.evrem.service.model.GridItem"));
    private static ClassLoader _classLoader = GridItem.class.getClassLoader();
    private static Class<?>[] _escapedModelInterfaces = new Class[] {
            GridItem.class
        };
    private long _gridItemId;
    private long _noteId;
    private long _originalNoteId;
    private boolean _setOriginalNoteId;
    private int _w;
    private int _h;
    private int _x;
    private int _y;
    private long _columnBitmask;
    private GridItem _escapedModel;

    public GridItemModelImpl() {
    }

    @Override
    public long getPrimaryKey() {
        return _gridItemId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setGridItemId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _gridItemId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
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

    @Override
    public long getGridItemId() {
        return _gridItemId;
    }

    @Override
    public void setGridItemId(long gridItemId) {
        _gridItemId = gridItemId;
    }

    @Override
    public long getNoteId() {
        return _noteId;
    }

    @Override
    public void setNoteId(long noteId) {
        _columnBitmask |= NOTEID_COLUMN_BITMASK;

        if (!_setOriginalNoteId) {
            _setOriginalNoteId = true;

            _originalNoteId = _noteId;
        }

        _noteId = noteId;
    }

    public long getOriginalNoteId() {
        return _originalNoteId;
    }

    @Override
    public int getW() {
        return _w;
    }

    @Override
    public void setW(int w) {
        _w = w;
    }

    @Override
    public int getH() {
        return _h;
    }

    @Override
    public void setH(int h) {
        _h = h;
    }

    @Override
    public int getX() {
        return _x;
    }

    @Override
    public void setX(int x) {
        _x = x;
    }

    @Override
    public int getY() {
        return _y;
    }

    @Override
    public void setY(int y) {
        _y = y;
    }

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
            GridItem.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public GridItem toEscapedModel() {
        if (_escapedModel == null) {
            _escapedModel = (GridItem) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelInterfaces, new AutoEscapeBeanHandler(this));
        }

        return _escapedModel;
    }

    @Override
    public Object clone() {
        GridItemImpl gridItemImpl = new GridItemImpl();

        gridItemImpl.setGridItemId(getGridItemId());
        gridItemImpl.setNoteId(getNoteId());
        gridItemImpl.setW(getW());
        gridItemImpl.setH(getH());
        gridItemImpl.setX(getX());
        gridItemImpl.setY(getY());

        gridItemImpl.resetOriginalValues();

        return gridItemImpl;
    }

    @Override
    public int compareTo(GridItem gridItem) {
        long primaryKey = gridItem.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof GridItem)) {
            return false;
        }

        GridItem gridItem = (GridItem) obj;

        long primaryKey = gridItem.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public void resetOriginalValues() {
        GridItemModelImpl gridItemModelImpl = this;

        gridItemModelImpl._originalNoteId = gridItemModelImpl._noteId;

        gridItemModelImpl._setOriginalNoteId = false;

        gridItemModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<GridItem> toCacheModel() {
        GridItemCacheModel gridItemCacheModel = new GridItemCacheModel();

        gridItemCacheModel.gridItemId = getGridItemId();

        gridItemCacheModel.noteId = getNoteId();

        gridItemCacheModel.w = getW();

        gridItemCacheModel.h = getH();

        gridItemCacheModel.x = getX();

        gridItemCacheModel.y = getY();

        return gridItemCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(13);

        sb.append("{gridItemId=");
        sb.append(getGridItemId());
        sb.append(", noteId=");
        sb.append(getNoteId());
        sb.append(", w=");
        sb.append(getW());
        sb.append(", h=");
        sb.append(getH());
        sb.append(", x=");
        sb.append(getX());
        sb.append(", y=");
        sb.append(getY());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(22);

        sb.append("<model><model-name>");
        sb.append("net.evrem.service.model.GridItem");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>gridItemId</column-name><column-value><![CDATA[");
        sb.append(getGridItemId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>noteId</column-name><column-value><![CDATA[");
        sb.append(getNoteId());
        sb.append("]]></column-value></column>");
        sb.append("<column><column-name>w</column-name><column-value><![CDATA[");
        sb.append(getW());
        sb.append("]]></column-value></column>");
        sb.append("<column><column-name>h</column-name><column-value><![CDATA[");
        sb.append(getH());
        sb.append("]]></column-value></column>");
        sb.append("<column><column-name>x</column-name><column-value><![CDATA[");
        sb.append(getX());
        sb.append("]]></column-value></column>");
        sb.append("<column><column-name>y</column-name><column-value><![CDATA[");
        sb.append(getY());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
