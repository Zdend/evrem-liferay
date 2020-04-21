package net.evrem.service.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Note}.
 * </p>
 *
 * @author Zdenek Vecek
 * @see Note
 * @generated
 */
public class NoteWrapper implements Note, ModelWrapper<Note> {
    private Note _note;

    public NoteWrapper(Note note) {
        _note = note;
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

    /**
    * Returns the primary key of this note.
    *
    * @return the primary key of this note
    */
    @Override
    public long getPrimaryKey() {
        return _note.getPrimaryKey();
    }

    /**
    * Sets the primary key of this note.
    *
    * @param primaryKey the primary key of this note
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _note.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the note ID of this note.
    *
    * @return the note ID of this note
    */
    @Override
    public long getNoteId() {
        return _note.getNoteId();
    }

    /**
    * Sets the note ID of this note.
    *
    * @param noteId the note ID of this note
    */
    @Override
    public void setNoteId(long noteId) {
        _note.setNoteId(noteId);
    }

    /**
    * Returns the user ID of this note.
    *
    * @return the user ID of this note
    */
    @Override
    public long getUserId() {
        return _note.getUserId();
    }

    /**
    * Sets the user ID of this note.
    *
    * @param userId the user ID of this note
    */
    @Override
    public void setUserId(long userId) {
        _note.setUserId(userId);
    }

    /**
    * Returns the user uuid of this note.
    *
    * @return the user uuid of this note
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _note.getUserUuid();
    }

    /**
    * Sets the user uuid of this note.
    *
    * @param userUuid the user uuid of this note
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _note.setUserUuid(userUuid);
    }

    /**
    * Returns the has check of this note.
    *
    * @return the has check of this note
    */
    @Override
    public boolean getHasCheck() {
        return _note.getHasCheck();
    }

    /**
    * Returns <code>true</code> if this note is has check.
    *
    * @return <code>true</code> if this note is has check; <code>false</code> otherwise
    */
    @Override
    public boolean isHasCheck() {
        return _note.isHasCheck();
    }

    /**
    * Sets whether this note is has check.
    *
    * @param hasCheck the has check of this note
    */
    @Override
    public void setHasCheck(boolean hasCheck) {
        _note.setHasCheck(hasCheck);
    }

    /**
    * Returns the has time of this note.
    *
    * @return the has time of this note
    */
    @Override
    public boolean getHasTime() {
        return _note.getHasTime();
    }

    /**
    * Returns <code>true</code> if this note is has time.
    *
    * @return <code>true</code> if this note is has time; <code>false</code> otherwise
    */
    @Override
    public boolean isHasTime() {
        return _note.isHasTime();
    }

    /**
    * Sets whether this note is has time.
    *
    * @param hasTime the has time of this note
    */
    @Override
    public void setHasTime(boolean hasTime) {
        _note.setHasTime(hasTime);
    }

    /**
    * Returns the has reminder of this note.
    *
    * @return the has reminder of this note
    */
    @Override
    public boolean getHasReminder() {
        return _note.getHasReminder();
    }

    /**
    * Returns <code>true</code> if this note is has reminder.
    *
    * @return <code>true</code> if this note is has reminder; <code>false</code> otherwise
    */
    @Override
    public boolean isHasReminder() {
        return _note.isHasReminder();
    }

    /**
    * Sets whether this note is has reminder.
    *
    * @param hasReminder the has reminder of this note
    */
    @Override
    public void setHasReminder(boolean hasReminder) {
        _note.setHasReminder(hasReminder);
    }

    /**
    * Returns the has todo of this note.
    *
    * @return the has todo of this note
    */
    @Override
    public boolean getHasTodo() {
        return _note.getHasTodo();
    }

    /**
    * Returns <code>true</code> if this note is has todo.
    *
    * @return <code>true</code> if this note is has todo; <code>false</code> otherwise
    */
    @Override
    public boolean isHasTodo() {
        return _note.isHasTodo();
    }

    /**
    * Sets whether this note is has todo.
    *
    * @param hasTodo the has todo of this note
    */
    @Override
    public void setHasTodo(boolean hasTodo) {
        _note.setHasTodo(hasTodo);
    }

    /**
    * Returns the has repeat of this note.
    *
    * @return the has repeat of this note
    */
    @Override
    public boolean getHasRepeat() {
        return _note.getHasRepeat();
    }

    /**
    * Returns <code>true</code> if this note is has repeat.
    *
    * @return <code>true</code> if this note is has repeat; <code>false</code> otherwise
    */
    @Override
    public boolean isHasRepeat() {
        return _note.isHasRepeat();
    }

    /**
    * Sets whether this note is has repeat.
    *
    * @param hasRepeat the has repeat of this note
    */
    @Override
    public void setHasRepeat(boolean hasRepeat) {
        _note.setHasRepeat(hasRepeat);
    }

    /**
    * Returns the has color of this note.
    *
    * @return the has color of this note
    */
    @Override
    public boolean getHasColor() {
        return _note.getHasColor();
    }

    /**
    * Returns <code>true</code> if this note is has color.
    *
    * @return <code>true</code> if this note is has color; <code>false</code> otherwise
    */
    @Override
    public boolean isHasColor() {
        return _note.isHasColor();
    }

    /**
    * Sets whether this note is has color.
    *
    * @param hasColor the has color of this note
    */
    @Override
    public void setHasColor(boolean hasColor) {
        _note.setHasColor(hasColor);
    }

    /**
    * Returns the has wall of this note.
    *
    * @return the has wall of this note
    */
    @Override
    public boolean getHasWall() {
        return _note.getHasWall();
    }

    /**
    * Returns <code>true</code> if this note is has wall.
    *
    * @return <code>true</code> if this note is has wall; <code>false</code> otherwise
    */
    @Override
    public boolean isHasWall() {
        return _note.isHasWall();
    }

    /**
    * Sets whether this note is has wall.
    *
    * @param hasWall the has wall of this note
    */
    @Override
    public void setHasWall(boolean hasWall) {
        _note.setHasWall(hasWall);
    }

    /**
    * Returns the text of this note.
    *
    * @return the text of this note
    */
    @Override
    public java.lang.String getText() {
        return _note.getText();
    }

    /**
    * Sets the text of this note.
    *
    * @param text the text of this note
    */
    @Override
    public void setText(java.lang.String text) {
        _note.setText(text);
    }

    /**
    * Returns the is done of this note.
    *
    * @return the is done of this note
    */
    @Override
    public boolean getIsDone() {
        return _note.getIsDone();
    }

    /**
    * Returns <code>true</code> if this note is is done.
    *
    * @return <code>true</code> if this note is is done; <code>false</code> otherwise
    */
    @Override
    public boolean isIsDone() {
        return _note.isIsDone();
    }

    /**
    * Sets whether this note is is done.
    *
    * @param isDone the is done of this note
    */
    @Override
    public void setIsDone(boolean isDone) {
        _note.setIsDone(isDone);
    }

    /**
    * Returns the event time of this note.
    *
    * @return the event time of this note
    */
    @Override
    public java.util.Date getEventTime() {
        return _note.getEventTime();
    }

    /**
    * Sets the event time of this note.
    *
    * @param eventTime the event time of this note
    */
    @Override
    public void setEventTime(java.util.Date eventTime) {
        _note.setEventTime(eventTime);
    }

    /**
    * Returns the period of this note.
    *
    * @return the period of this note
    */
    @Override
    public java.lang.String getPeriod() {
        return _note.getPeriod();
    }

    /**
    * Sets the period of this note.
    *
    * @param period the period of this note
    */
    @Override
    public void setPeriod(java.lang.String period) {
        _note.setPeriod(period);
    }

    /**
    * Returns the color of this note.
    *
    * @return the color of this note
    */
    @Override
    public java.lang.String getColor() {
        return _note.getColor();
    }

    /**
    * Sets the color of this note.
    *
    * @param color the color of this note
    */
    @Override
    public void setColor(java.lang.String color) {
        _note.setColor(color);
    }

    /**
    * Returns the created date of this note.
    *
    * @return the created date of this note
    */
    @Override
    public java.util.Date getCreatedDate() {
        return _note.getCreatedDate();
    }

    /**
    * Sets the created date of this note.
    *
    * @param createdDate the created date of this note
    */
    @Override
    public void setCreatedDate(java.util.Date createdDate) {
        _note.setCreatedDate(createdDate);
    }

    /**
    * Returns the modified date of this note.
    *
    * @return the modified date of this note
    */
    @Override
    public java.util.Date getModifiedDate() {
        return _note.getModifiedDate();
    }

    /**
    * Sets the modified date of this note.
    *
    * @param modifiedDate the modified date of this note
    */
    @Override
    public void setModifiedDate(java.util.Date modifiedDate) {
        _note.setModifiedDate(modifiedDate);
    }

    /**
    * Returns the is deleted of this note.
    *
    * @return the is deleted of this note
    */
    @Override
    public boolean getIsDeleted() {
        return _note.getIsDeleted();
    }

    /**
    * Returns <code>true</code> if this note is is deleted.
    *
    * @return <code>true</code> if this note is is deleted; <code>false</code> otherwise
    */
    @Override
    public boolean isIsDeleted() {
        return _note.isIsDeleted();
    }

    /**
    * Sets whether this note is is deleted.
    *
    * @param isDeleted the is deleted of this note
    */
    @Override
    public void setIsDeleted(boolean isDeleted) {
        _note.setIsDeleted(isDeleted);
    }

    @Override
    public boolean isNew() {
        return _note.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _note.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _note.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _note.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _note.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _note.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _note.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _note.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _note.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _note.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _note.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new NoteWrapper((Note) _note.clone());
    }

    @Override
    public int compareTo(net.evrem.service.model.Note note) {
        return _note.compareTo(note);
    }

    @Override
    public int hashCode() {
        return _note.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<net.evrem.service.model.Note> toCacheModel() {
        return _note.toCacheModel();
    }

    @Override
    public net.evrem.service.model.Note toEscapedModel() {
        return new NoteWrapper(_note.toEscapedModel());
    }

    @Override
    public net.evrem.service.model.Note toUnescapedModel() {
        return new NoteWrapper(_note.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _note.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _note.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _note.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof NoteWrapper)) {
            return false;
        }

        NoteWrapper noteWrapper = (NoteWrapper) obj;

        if (Validator.equals(_note, noteWrapper._note)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Note getWrappedNote() {
        return _note;
    }

    @Override
    public Note getWrappedModel() {
        return _note;
    }

    @Override
    public void resetOriginalValues() {
        _note.resetOriginalValues();
    }
}
