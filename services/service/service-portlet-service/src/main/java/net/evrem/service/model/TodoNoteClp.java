package net.evrem.service.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import net.evrem.service.service.ClpSerializer;
import net.evrem.service.service.TodoNoteLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class TodoNoteClp extends BaseModelImpl<TodoNote> implements TodoNote {
    private long _todoNoteId;
    private long _noteId;
    private boolean _isDone;
    private String _text;
    private int _sortNo;
    private Date _modifiedDate;
    private BaseModel<?> _todoNoteRemoteModel;

    public TodoNoteClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return TodoNote.class;
    }

    @Override
    public String getModelClassName() {
        return TodoNote.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _todoNoteId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setTodoNoteId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _todoNoteId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("todoNoteId", getTodoNoteId());
        attributes.put("noteId", getNoteId());
        attributes.put("isDone", getIsDone());
        attributes.put("text", getText());
        attributes.put("sortNo", getSortNo());
        attributes.put("modifiedDate", getModifiedDate());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long todoNoteId = (Long) attributes.get("todoNoteId");

        if (todoNoteId != null) {
            setTodoNoteId(todoNoteId);
        }

        Long noteId = (Long) attributes.get("noteId");

        if (noteId != null) {
            setNoteId(noteId);
        }

        Boolean isDone = (Boolean) attributes.get("isDone");

        if (isDone != null) {
            setIsDone(isDone);
        }

        String text = (String) attributes.get("text");

        if (text != null) {
            setText(text);
        }

        Integer sortNo = (Integer) attributes.get("sortNo");

        if (sortNo != null) {
            setSortNo(sortNo);
        }

        Date modifiedDate = (Date) attributes.get("modifiedDate");

        if (modifiedDate != null) {
            setModifiedDate(modifiedDate);
        }
    }

    @Override
    public long getTodoNoteId() {
        return _todoNoteId;
    }

    @Override
    public void setTodoNoteId(long todoNoteId) {
        _todoNoteId = todoNoteId;

        if (_todoNoteRemoteModel != null) {
            try {
                Class<?> clazz = _todoNoteRemoteModel.getClass();

                Method method = clazz.getMethod("setTodoNoteId", long.class);

                method.invoke(_todoNoteRemoteModel, todoNoteId);
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

        if (_todoNoteRemoteModel != null) {
            try {
                Class<?> clazz = _todoNoteRemoteModel.getClass();

                Method method = clazz.getMethod("setNoteId", long.class);

                method.invoke(_todoNoteRemoteModel, noteId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getIsDone() {
        return _isDone;
    }

    @Override
    public boolean isIsDone() {
        return _isDone;
    }

    @Override
    public void setIsDone(boolean isDone) {
        _isDone = isDone;

        if (_todoNoteRemoteModel != null) {
            try {
                Class<?> clazz = _todoNoteRemoteModel.getClass();

                Method method = clazz.getMethod("setIsDone", boolean.class);

                method.invoke(_todoNoteRemoteModel, isDone);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getText() {
        return _text;
    }

    @Override
    public void setText(String text) {
        _text = text;

        if (_todoNoteRemoteModel != null) {
            try {
                Class<?> clazz = _todoNoteRemoteModel.getClass();

                Method method = clazz.getMethod("setText", String.class);

                method.invoke(_todoNoteRemoteModel, text);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getSortNo() {
        return _sortNo;
    }

    @Override
    public void setSortNo(int sortNo) {
        _sortNo = sortNo;

        if (_todoNoteRemoteModel != null) {
            try {
                Class<?> clazz = _todoNoteRemoteModel.getClass();

                Method method = clazz.getMethod("setSortNo", int.class);

                method.invoke(_todoNoteRemoteModel, sortNo);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getModifiedDate() {
        return _modifiedDate;
    }

    @Override
    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;

        if (_todoNoteRemoteModel != null) {
            try {
                Class<?> clazz = _todoNoteRemoteModel.getClass();

                Method method = clazz.getMethod("setModifiedDate", Date.class);

                method.invoke(_todoNoteRemoteModel, modifiedDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getTodoNoteRemoteModel() {
        return _todoNoteRemoteModel;
    }

    public void setTodoNoteRemoteModel(BaseModel<?> todoNoteRemoteModel) {
        _todoNoteRemoteModel = todoNoteRemoteModel;
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

        Class<?> remoteModelClass = _todoNoteRemoteModel.getClass();

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

        Object returnValue = method.invoke(_todoNoteRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            TodoNoteLocalServiceUtil.addTodoNote(this);
        } else {
            TodoNoteLocalServiceUtil.updateTodoNote(this);
        }
    }

    @Override
    public TodoNote toEscapedModel() {
        return (TodoNote) ProxyUtil.newProxyInstance(TodoNote.class.getClassLoader(),
            new Class[] { TodoNote.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        TodoNoteClp clone = new TodoNoteClp();

        clone.setTodoNoteId(getTodoNoteId());
        clone.setNoteId(getNoteId());
        clone.setIsDone(getIsDone());
        clone.setText(getText());
        clone.setSortNo(getSortNo());
        clone.setModifiedDate(getModifiedDate());

        return clone;
    }

    @Override
    public int compareTo(TodoNote todoNote) {
        long primaryKey = todoNote.getPrimaryKey();

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

        if (!(obj instanceof TodoNoteClp)) {
            return false;
        }

        TodoNoteClp todoNote = (TodoNoteClp) obj;

        long primaryKey = todoNote.getPrimaryKey();

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

        sb.append("{todoNoteId=");
        sb.append(getTodoNoteId());
        sb.append(", noteId=");
        sb.append(getNoteId());
        sb.append(", isDone=");
        sb.append(getIsDone());
        sb.append(", text=");
        sb.append(getText());
        sb.append(", sortNo=");
        sb.append(getSortNo());
        sb.append(", modifiedDate=");
        sb.append(getModifiedDate());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(22);

        sb.append("<model><model-name>");
        sb.append("net.evrem.service.model.TodoNote");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>todoNoteId</column-name><column-value><![CDATA[");
        sb.append(getTodoNoteId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>noteId</column-name><column-value><![CDATA[");
        sb.append(getNoteId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>isDone</column-name><column-value><![CDATA[");
        sb.append(getIsDone());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>text</column-name><column-value><![CDATA[");
        sb.append(getText());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>sortNo</column-name><column-value><![CDATA[");
        sb.append(getSortNo());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
        sb.append(getModifiedDate());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
