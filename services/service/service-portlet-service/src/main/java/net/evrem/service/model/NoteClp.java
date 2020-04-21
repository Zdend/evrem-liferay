package net.evrem.service.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import net.evrem.service.service.ClpSerializer;
import net.evrem.service.service.NoteLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class NoteClp extends BaseModelImpl<Note> implements Note {
    private long _noteId;
    private long _userId;
    private String _userUuid;
    private boolean _hasCheck;
    private boolean _hasTime;
    private boolean _hasReminder;
    private boolean _hasTodo;
    private boolean _hasRepeat;
    private boolean _hasColor;
    private boolean _hasWall;
    private String _text;
    private boolean _isDone;
    private Date _eventTime;
    private String _period;
    private String _color;
    private Date _createdDate;
    private Date _modifiedDate;
    private boolean _isDeleted;
    private BaseModel<?> _noteRemoteModel;

    public NoteClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return Note.class;
    }

    @Override
    public String getModelClassName() {
        return Note.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _noteId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setNoteId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _noteId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("noteId", getNoteId());
        attributes.put("userId", getUserId());
        attributes.put("hasCheck", getHasCheck());
        attributes.put("hasTime", getHasTime());
        attributes.put("hasReminder", getHasReminder());
        attributes.put("hasTodo", getHasTodo());
        attributes.put("hasRepeat", getHasRepeat());
        attributes.put("hasColor", getHasColor());
        attributes.put("hasWall", getHasWall());
        attributes.put("text", getText());
        attributes.put("isDone", getIsDone());
        attributes.put("eventTime", getEventTime());
        attributes.put("period", getPeriod());
        attributes.put("color", getColor());
        attributes.put("createdDate", getCreatedDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("isDeleted", getIsDeleted());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long noteId = (Long) attributes.get("noteId");

        if (noteId != null) {
            setNoteId(noteId);
        }

        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        Boolean hasCheck = (Boolean) attributes.get("hasCheck");

        if (hasCheck != null) {
            setHasCheck(hasCheck);
        }

        Boolean hasTime = (Boolean) attributes.get("hasTime");

        if (hasTime != null) {
            setHasTime(hasTime);
        }

        Boolean hasReminder = (Boolean) attributes.get("hasReminder");

        if (hasReminder != null) {
            setHasReminder(hasReminder);
        }

        Boolean hasTodo = (Boolean) attributes.get("hasTodo");

        if (hasTodo != null) {
            setHasTodo(hasTodo);
        }

        Boolean hasRepeat = (Boolean) attributes.get("hasRepeat");

        if (hasRepeat != null) {
            setHasRepeat(hasRepeat);
        }

        Boolean hasColor = (Boolean) attributes.get("hasColor");

        if (hasColor != null) {
            setHasColor(hasColor);
        }

        Boolean hasWall = (Boolean) attributes.get("hasWall");

        if (hasWall != null) {
            setHasWall(hasWall);
        }

        String text = (String) attributes.get("text");

        if (text != null) {
            setText(text);
        }

        Boolean isDone = (Boolean) attributes.get("isDone");

        if (isDone != null) {
            setIsDone(isDone);
        }

        Date eventTime = (Date) attributes.get("eventTime");

        if (eventTime != null) {
            setEventTime(eventTime);
        }

        String period = (String) attributes.get("period");

        if (period != null) {
            setPeriod(period);
        }

        String color = (String) attributes.get("color");

        if (color != null) {
            setColor(color);
        }

        Date createdDate = (Date) attributes.get("createdDate");

        if (createdDate != null) {
            setCreatedDate(createdDate);
        }

        Date modifiedDate = (Date) attributes.get("modifiedDate");

        if (modifiedDate != null) {
            setModifiedDate(modifiedDate);
        }

        Boolean isDeleted = (Boolean) attributes.get("isDeleted");

        if (isDeleted != null) {
            setIsDeleted(isDeleted);
        }
    }

    @Override
    public long getNoteId() {
        return _noteId;
    }

    @Override
    public void setNoteId(long noteId) {
        _noteId = noteId;

        if (_noteRemoteModel != null) {
            try {
                Class<?> clazz = _noteRemoteModel.getClass();

                Method method = clazz.getMethod("setNoteId", long.class);

                method.invoke(_noteRemoteModel, noteId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getUserId() {
        return _userId;
    }

    @Override
    public void setUserId(long userId) {
        _userId = userId;

        if (_noteRemoteModel != null) {
            try {
                Class<?> clazz = _noteRemoteModel.getClass();

                Method method = clazz.getMethod("setUserId", long.class);

                method.invoke(_noteRemoteModel, userId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getUserUuid() throws SystemException {
        return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
    }

    @Override
    public void setUserUuid(String userUuid) {
        _userUuid = userUuid;
    }

    @Override
    public boolean getHasCheck() {
        return _hasCheck;
    }

    @Override
    public boolean isHasCheck() {
        return _hasCheck;
    }

    @Override
    public void setHasCheck(boolean hasCheck) {
        _hasCheck = hasCheck;

        if (_noteRemoteModel != null) {
            try {
                Class<?> clazz = _noteRemoteModel.getClass();

                Method method = clazz.getMethod("setHasCheck", boolean.class);

                method.invoke(_noteRemoteModel, hasCheck);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getHasTime() {
        return _hasTime;
    }

    @Override
    public boolean isHasTime() {
        return _hasTime;
    }

    @Override
    public void setHasTime(boolean hasTime) {
        _hasTime = hasTime;

        if (_noteRemoteModel != null) {
            try {
                Class<?> clazz = _noteRemoteModel.getClass();

                Method method = clazz.getMethod("setHasTime", boolean.class);

                method.invoke(_noteRemoteModel, hasTime);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getHasReminder() {
        return _hasReminder;
    }

    @Override
    public boolean isHasReminder() {
        return _hasReminder;
    }

    @Override
    public void setHasReminder(boolean hasReminder) {
        _hasReminder = hasReminder;

        if (_noteRemoteModel != null) {
            try {
                Class<?> clazz = _noteRemoteModel.getClass();

                Method method = clazz.getMethod("setHasReminder", boolean.class);

                method.invoke(_noteRemoteModel, hasReminder);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getHasTodo() {
        return _hasTodo;
    }

    @Override
    public boolean isHasTodo() {
        return _hasTodo;
    }

    @Override
    public void setHasTodo(boolean hasTodo) {
        _hasTodo = hasTodo;

        if (_noteRemoteModel != null) {
            try {
                Class<?> clazz = _noteRemoteModel.getClass();

                Method method = clazz.getMethod("setHasTodo", boolean.class);

                method.invoke(_noteRemoteModel, hasTodo);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getHasRepeat() {
        return _hasRepeat;
    }

    @Override
    public boolean isHasRepeat() {
        return _hasRepeat;
    }

    @Override
    public void setHasRepeat(boolean hasRepeat) {
        _hasRepeat = hasRepeat;

        if (_noteRemoteModel != null) {
            try {
                Class<?> clazz = _noteRemoteModel.getClass();

                Method method = clazz.getMethod("setHasRepeat", boolean.class);

                method.invoke(_noteRemoteModel, hasRepeat);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getHasColor() {
        return _hasColor;
    }

    @Override
    public boolean isHasColor() {
        return _hasColor;
    }

    @Override
    public void setHasColor(boolean hasColor) {
        _hasColor = hasColor;

        if (_noteRemoteModel != null) {
            try {
                Class<?> clazz = _noteRemoteModel.getClass();

                Method method = clazz.getMethod("setHasColor", boolean.class);

                method.invoke(_noteRemoteModel, hasColor);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getHasWall() {
        return _hasWall;
    }

    @Override
    public boolean isHasWall() {
        return _hasWall;
    }

    @Override
    public void setHasWall(boolean hasWall) {
        _hasWall = hasWall;

        if (_noteRemoteModel != null) {
            try {
                Class<?> clazz = _noteRemoteModel.getClass();

                Method method = clazz.getMethod("setHasWall", boolean.class);

                method.invoke(_noteRemoteModel, hasWall);
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

        if (_noteRemoteModel != null) {
            try {
                Class<?> clazz = _noteRemoteModel.getClass();

                Method method = clazz.getMethod("setText", String.class);

                method.invoke(_noteRemoteModel, text);
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

        if (_noteRemoteModel != null) {
            try {
                Class<?> clazz = _noteRemoteModel.getClass();

                Method method = clazz.getMethod("setIsDone", boolean.class);

                method.invoke(_noteRemoteModel, isDone);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getEventTime() {
        return _eventTime;
    }

    @Override
    public void setEventTime(Date eventTime) {
        _eventTime = eventTime;

        if (_noteRemoteModel != null) {
            try {
                Class<?> clazz = _noteRemoteModel.getClass();

                Method method = clazz.getMethod("setEventTime", Date.class);

                method.invoke(_noteRemoteModel, eventTime);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getPeriod() {
        return _period;
    }

    @Override
    public void setPeriod(String period) {
        _period = period;

        if (_noteRemoteModel != null) {
            try {
                Class<?> clazz = _noteRemoteModel.getClass();

                Method method = clazz.getMethod("setPeriod", String.class);

                method.invoke(_noteRemoteModel, period);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getColor() {
        return _color;
    }

    @Override
    public void setColor(String color) {
        _color = color;

        if (_noteRemoteModel != null) {
            try {
                Class<?> clazz = _noteRemoteModel.getClass();

                Method method = clazz.getMethod("setColor", String.class);

                method.invoke(_noteRemoteModel, color);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getCreatedDate() {
        return _createdDate;
    }

    @Override
    public void setCreatedDate(Date createdDate) {
        _createdDate = createdDate;

        if (_noteRemoteModel != null) {
            try {
                Class<?> clazz = _noteRemoteModel.getClass();

                Method method = clazz.getMethod("setCreatedDate", Date.class);

                method.invoke(_noteRemoteModel, createdDate);
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

        if (_noteRemoteModel != null) {
            try {
                Class<?> clazz = _noteRemoteModel.getClass();

                Method method = clazz.getMethod("setModifiedDate", Date.class);

                method.invoke(_noteRemoteModel, modifiedDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getIsDeleted() {
        return _isDeleted;
    }

    @Override
    public boolean isIsDeleted() {
        return _isDeleted;
    }

    @Override
    public void setIsDeleted(boolean isDeleted) {
        _isDeleted = isDeleted;

        if (_noteRemoteModel != null) {
            try {
                Class<?> clazz = _noteRemoteModel.getClass();

                Method method = clazz.getMethod("setIsDeleted", boolean.class);

                method.invoke(_noteRemoteModel, isDeleted);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getNoteRemoteModel() {
        return _noteRemoteModel;
    }

    public void setNoteRemoteModel(BaseModel<?> noteRemoteModel) {
        _noteRemoteModel = noteRemoteModel;
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

        Class<?> remoteModelClass = _noteRemoteModel.getClass();

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

        Object returnValue = method.invoke(_noteRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            NoteLocalServiceUtil.addNote(this);
        } else {
            NoteLocalServiceUtil.updateNote(this);
        }
    }

    @Override
    public Note toEscapedModel() {
        return (Note) ProxyUtil.newProxyInstance(Note.class.getClassLoader(),
            new Class[] { Note.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        NoteClp clone = new NoteClp();

        clone.setNoteId(getNoteId());
        clone.setUserId(getUserId());
        clone.setHasCheck(getHasCheck());
        clone.setHasTime(getHasTime());
        clone.setHasReminder(getHasReminder());
        clone.setHasTodo(getHasTodo());
        clone.setHasRepeat(getHasRepeat());
        clone.setHasColor(getHasColor());
        clone.setHasWall(getHasWall());
        clone.setText(getText());
        clone.setIsDone(getIsDone());
        clone.setEventTime(getEventTime());
        clone.setPeriod(getPeriod());
        clone.setColor(getColor());
        clone.setCreatedDate(getCreatedDate());
        clone.setModifiedDate(getModifiedDate());
        clone.setIsDeleted(getIsDeleted());

        return clone;
    }

    @Override
    public int compareTo(Note note) {
        int value = 0;

        if (getNoteId() < note.getNoteId()) {
            value = -1;
        } else if (getNoteId() > note.getNoteId()) {
            value = 1;
        } else {
            value = 0;
        }

        if (value != 0) {
            return value;
        }

        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof NoteClp)) {
            return false;
        }

        NoteClp note = (NoteClp) obj;

        long primaryKey = note.getPrimaryKey();

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
        StringBundler sb = new StringBundler(35);

        sb.append("{noteId=");
        sb.append(getNoteId());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append(", hasCheck=");
        sb.append(getHasCheck());
        sb.append(", hasTime=");
        sb.append(getHasTime());
        sb.append(", hasReminder=");
        sb.append(getHasReminder());
        sb.append(", hasTodo=");
        sb.append(getHasTodo());
        sb.append(", hasRepeat=");
        sb.append(getHasRepeat());
        sb.append(", hasColor=");
        sb.append(getHasColor());
        sb.append(", hasWall=");
        sb.append(getHasWall());
        sb.append(", text=");
        sb.append(getText());
        sb.append(", isDone=");
        sb.append(getIsDone());
        sb.append(", eventTime=");
        sb.append(getEventTime());
        sb.append(", period=");
        sb.append(getPeriod());
        sb.append(", color=");
        sb.append(getColor());
        sb.append(", createdDate=");
        sb.append(getCreatedDate());
        sb.append(", modifiedDate=");
        sb.append(getModifiedDate());
        sb.append(", isDeleted=");
        sb.append(getIsDeleted());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(55);

        sb.append("<model><model-name>");
        sb.append("net.evrem.service.model.Note");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>noteId</column-name><column-value><![CDATA[");
        sb.append(getNoteId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>hasCheck</column-name><column-value><![CDATA[");
        sb.append(getHasCheck());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>hasTime</column-name><column-value><![CDATA[");
        sb.append(getHasTime());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>hasReminder</column-name><column-value><![CDATA[");
        sb.append(getHasReminder());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>hasTodo</column-name><column-value><![CDATA[");
        sb.append(getHasTodo());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>hasRepeat</column-name><column-value><![CDATA[");
        sb.append(getHasRepeat());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>hasColor</column-name><column-value><![CDATA[");
        sb.append(getHasColor());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>hasWall</column-name><column-value><![CDATA[");
        sb.append(getHasWall());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>text</column-name><column-value><![CDATA[");
        sb.append(getText());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>isDone</column-name><column-value><![CDATA[");
        sb.append(getIsDone());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>eventTime</column-name><column-value><![CDATA[");
        sb.append(getEventTime());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>period</column-name><column-value><![CDATA[");
        sb.append(getPeriod());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>color</column-name><column-value><![CDATA[");
        sb.append(getColor());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>createdDate</column-name><column-value><![CDATA[");
        sb.append(getCreatedDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
        sb.append(getModifiedDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>isDeleted</column-name><column-value><![CDATA[");
        sb.append(getIsDeleted());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
