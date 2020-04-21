package net.evrem.service.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Zdenek Vecek
 * @generated
 */
public class TodoNoteSoap implements Serializable {
    private long _todoNoteId;
    private long _noteId;
    private boolean _isDone;
    private String _text;
    private int _sortNo;
    private Date _modifiedDate;

    public TodoNoteSoap() {
    }

    public static TodoNoteSoap toSoapModel(TodoNote model) {
        TodoNoteSoap soapModel = new TodoNoteSoap();

        soapModel.setTodoNoteId(model.getTodoNoteId());
        soapModel.setNoteId(model.getNoteId());
        soapModel.setIsDone(model.getIsDone());
        soapModel.setText(model.getText());
        soapModel.setSortNo(model.getSortNo());
        soapModel.setModifiedDate(model.getModifiedDate());

        return soapModel;
    }

    public static TodoNoteSoap[] toSoapModels(TodoNote[] models) {
        TodoNoteSoap[] soapModels = new TodoNoteSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static TodoNoteSoap[][] toSoapModels(TodoNote[][] models) {
        TodoNoteSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new TodoNoteSoap[models.length][models[0].length];
        } else {
            soapModels = new TodoNoteSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static TodoNoteSoap[] toSoapModels(List<TodoNote> models) {
        List<TodoNoteSoap> soapModels = new ArrayList<TodoNoteSoap>(models.size());

        for (TodoNote model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new TodoNoteSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _todoNoteId;
    }

    public void setPrimaryKey(long pk) {
        setTodoNoteId(pk);
    }

    public long getTodoNoteId() {
        return _todoNoteId;
    }

    public void setTodoNoteId(long todoNoteId) {
        _todoNoteId = todoNoteId;
    }

    public long getNoteId() {
        return _noteId;
    }

    public void setNoteId(long noteId) {
        _noteId = noteId;
    }

    public boolean getIsDone() {
        return _isDone;
    }

    public boolean isIsDone() {
        return _isDone;
    }

    public void setIsDone(boolean isDone) {
        _isDone = isDone;
    }

    public String getText() {
        return _text;
    }

    public void setText(String text) {
        _text = text;
    }

    public int getSortNo() {
        return _sortNo;
    }

    public void setSortNo(int sortNo) {
        _sortNo = sortNo;
    }

    public Date getModifiedDate() {
        return _modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;
    }
}
