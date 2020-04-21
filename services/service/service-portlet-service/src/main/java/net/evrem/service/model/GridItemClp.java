package net.evrem.service.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import net.evrem.service.service.ClpSerializer;
import net.evrem.service.service.GridItemLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class GridItemClp extends BaseModelImpl<GridItem> implements GridItem {
    private long _gridItemId;
    private long _noteId;
    private int _w;
    private int _h;
    private int _x;
    private int _y;
    private BaseModel<?> _gridItemRemoteModel;

    public GridItemClp() {
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

        if (_gridItemRemoteModel != null) {
            try {
                Class<?> clazz = _gridItemRemoteModel.getClass();

                Method method = clazz.getMethod("setGridItemId", long.class);

                method.invoke(_gridItemRemoteModel, gridItemId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getNoteId() {
        return _noteId;
    }

    @Override
    public void setNoteId(long noteId) {
        _noteId = noteId;

        if (_gridItemRemoteModel != null) {
            try {
                Class<?> clazz = _gridItemRemoteModel.getClass();

                Method method = clazz.getMethod("setNoteId", long.class);

                method.invoke(_gridItemRemoteModel, noteId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getW() {
        return _w;
    }

    @Override
    public void setW(int w) {
        _w = w;

        if (_gridItemRemoteModel != null) {
            try {
                Class<?> clazz = _gridItemRemoteModel.getClass();

                Method method = clazz.getMethod("setW", int.class);

                method.invoke(_gridItemRemoteModel, w);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getH() {
        return _h;
    }

    @Override
    public void setH(int h) {
        _h = h;

        if (_gridItemRemoteModel != null) {
            try {
                Class<?> clazz = _gridItemRemoteModel.getClass();

                Method method = clazz.getMethod("setH", int.class);

                method.invoke(_gridItemRemoteModel, h);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getX() {
        return _x;
    }

    @Override
    public void setX(int x) {
        _x = x;

        if (_gridItemRemoteModel != null) {
            try {
                Class<?> clazz = _gridItemRemoteModel.getClass();

                Method method = clazz.getMethod("setX", int.class);

                method.invoke(_gridItemRemoteModel, x);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getY() {
        return _y;
    }

    @Override
    public void setY(int y) {
        _y = y;

        if (_gridItemRemoteModel != null) {
            try {
                Class<?> clazz = _gridItemRemoteModel.getClass();

                Method method = clazz.getMethod("setY", int.class);

                method.invoke(_gridItemRemoteModel, y);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getGridItemRemoteModel() {
        return _gridItemRemoteModel;
    }

    public void setGridItemRemoteModel(BaseModel<?> gridItemRemoteModel) {
        _gridItemRemoteModel = gridItemRemoteModel;
    }

    public Object invokeOnRemoteModel(String methodName,
        Class<?>[] parameterTypes, Object[] parameterValues)
        throws Exception {
        Object[] remoteParameterValues = new Object[parameterValues.length];

        for (int i = 0; i < parameterValues.length; i++) {
            if (parameterValues[i] != null) {
                remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
            }
        }

        Class<?> remoteModelClass = _gridItemRemoteModel.getClass();

        ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

        Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                remoteParameterTypes[i] = parameterTypes[i];
            } else {
                String parameterTypeName = parameterTypes[i].getName();

                remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
            }
        }

        Method method = remoteModelClass.getMethod(methodName,
                remoteParameterTypes);

        Object returnValue = method.invoke(_gridItemRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            GridItemLocalServiceUtil.addGridItem(this);
        } else {
            GridItemLocalServiceUtil.updateGridItem(this);
        }
    }

    @Override
    public GridItem toEscapedModel() {
        return (GridItem) ProxyUtil.newProxyInstance(GridItem.class.getClassLoader(),
            new Class[] { GridItem.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        GridItemClp clone = new GridItemClp();

        clone.setGridItemId(getGridItemId());
        clone.setNoteId(getNoteId());
        clone.setW(getW());
        clone.setH(getH());
        clone.setX(getX());
        clone.setY(getY());

        return clone;
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

        if (!(obj instanceof GridItemClp)) {
            return false;
        }

        GridItemClp gridItem = (GridItemClp) obj;

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
