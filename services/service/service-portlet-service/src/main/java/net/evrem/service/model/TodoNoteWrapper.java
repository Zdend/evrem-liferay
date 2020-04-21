package net.evrem.service.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link TodoNote}.
 * </p>
 *
 * @author Zdenek Vecek
 * @see TodoNote
 * @generated
 */
public class TodoNoteWrapper implements TodoNote, ModelWrapper<TodoNote> {
    private TodoNote _todoNote;

    public TodoNoteWrapper(TodoNote todoNote) {
        _todoNote = todoNote;
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

    /**
    * Returns the primary key of this todo note.
    *
    * @return the primary key of this todo note
    */
    @Override
    public long getPrimaryKey() {
        return _todoNote.getPrimaryKey();
    }

    /**
    * Sets the primary key of this todo note.
    *
    * @param primaryKey the primary key of this todo note
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _todoNote.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the todo note ID of this todo note.
    *
    * @return the todo note ID of this todo note
    */
    @Override
    public long getTodoNoteId() {
        return _todoNote.getTodoNoteId();
    }

    /**
    * Sets the todo note ID of this todo note.
    *
    * @param todoNoteId the todo note ID of this todo note
    */
    @Override
    public void setTodoNoteId(long todoNoteId) {
        _todoNote.setTodoNoteId(todoNoteId);
    }

    /**
    * Returns the note ID of this todo note.
    *
    * @return the note ID of this todo note
    */
    @Override
    public long getNoteId() {
        return _todoNote.getNoteId();
    }

    /**
    * Sets the note ID of this todo note.
    *
    * @param noteId the note ID of this todo note
    */
    @Override
    public void setNoteId(long noteId) {
        _todoNote.setNoteId(noteId);
    }

    /**
    * Returns the is done of this todo note.
    *
    * @return the is done of this todo note
    */
    @Override
    public boolean getIsDone() {
        return _todoNote.getIsDone();
    }

    /**
    * Returns <code>true</code> if this todo note is is done.
    *
    * @return <code>true</code> if this todo note is is done; <code>false</code> otherwise
    */
    @Override
    public boolean isIsDone() {
        return _todoNote.isIsDone();
    }

    /**
    * Sets whether this todo note is is done.
    *
    * @param isDone the is done of this todo note
    */
    @Override
    public void setIsDone(boolean isDone) {
        _todoNote.setIsDone(isDone);
    }

    /**
    * Returns the text of this todo note.
    *
    * @return the text of this todo note
    */
    @Override
    public java.lang.String getText() {
        return _todoNote.getText();
    }

    /**
    * Sets the text of this todo note.
    *
    * @param text the text of this todo note
    */
    @Override
    public void setText(java.lang.String text) {
        _todoNote.setText(text);
    }

    /**
    * Returns the sort no of this todo note.
    *
    * @return the sort no of this todo note
    */
    @Override
    public int getSortNo() {
        return _todoNote.getSortNo();
    }

    /**
    * Sets the sort no of this todo note.
    *
    * @param sortNo the sort no of this todo note
    */
    @Override
    public void setSortNo(int sortNo) {
        _todoNote.setSortNo(sortNo);
    }

    /**
    * Returns the modified date of this todo note.
    *
    * @return the modified date of this todo note
    */
    @Override
    public java.util.Date getModifiedDate() {
        return _todoNote.getModifiedDate();
    }

    /**
    * Sets the modified date of this todo note.
    *
    * @param modifiedDate the modified date of this todo note
    */
    @Override
    public void setModifiedDate(java.util.Date modifiedDate) {
        _todoNote.setModifiedDate(modifiedDate);
    }

    @Override
    public boolean isNew() {
        return _todoNote.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _todoNote.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _todoNote.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _todoNote.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _todoNote.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _todoNote.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _todoNote.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _todoNote.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _todoNote.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _todoNote.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _todoNote.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new TodoNoteWrapper((TodoNote) _todoNote.clone());
    }

    @Override
    public int compareTo(net.evrem.service.model.TodoNote todoNote) {
        return _todoNote.compareTo(todoNote);
    }

    @Override
    public int hashCode() {
        return _todoNote.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<net.evrem.service.model.TodoNote> toCacheModel() {
        return _todoNote.toCacheModel();
    }

    @Override
    public net.evrem.service.model.TodoNote toEscapedModel() {
        return new TodoNoteWrapper(_todoNote.toEscapedModel());
    }

    @Override
    public net.evrem.service.model.TodoNote toUnescapedModel() {
        return new TodoNoteWrapper(_todoNote.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _todoNote.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _todoNote.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _todoNote.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof TodoNoteWrapper)) {
            return false;
        }

        TodoNoteWrapper todoNoteWrapper = (TodoNoteWrapper) obj;

        if (Validator.equals(_todoNote, todoNoteWrapper._todoNote)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public TodoNote getWrappedTodoNote() {
        return _todoNote;
    }

    @Override
    public TodoNote getWrappedModel() {
        return _todoNote;
    }

    @Override
    public void resetOriginalValues() {
        _todoNote.resetOriginalValues();
    }
}
