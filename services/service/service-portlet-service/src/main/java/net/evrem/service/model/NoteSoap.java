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
public class NoteSoap implements Serializable {
    private long _noteId;
    private long _userId;
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

    public NoteSoap() {
    }

    public static NoteSoap toSoapModel(Note model) {
        NoteSoap soapModel = new NoteSoap();

        soapModel.setNoteId(model.getNoteId());
        soapModel.setUserId(model.getUserId());
        soapModel.setHasCheck(model.getHasCheck());
        soapModel.setHasTime(model.getHasTime());
        soapModel.setHasReminder(model.getHasReminder());
        soapModel.setHasTodo(model.getHasTodo());
        soapModel.setHasRepeat(model.getHasRepeat());
        soapModel.setHasColor(model.getHasColor());
        soapModel.setHasWall(model.getHasWall());
        soapModel.setText(model.getText());
        soapModel.setIsDone(model.getIsDone());
        soapModel.setEventTime(model.getEventTime());
        soapModel.setPeriod(model.getPeriod());
        soapModel.setColor(model.getColor());
        soapModel.setCreatedDate(model.getCreatedDate());
        soapModel.setModifiedDate(model.getModifiedDate());
        soapModel.setIsDeleted(model.getIsDeleted());

        return soapModel;
    }

    public static NoteSoap[] toSoapModels(Note[] models) {
        NoteSoap[] soapModels = new NoteSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static NoteSoap[][] toSoapModels(Note[][] models) {
        NoteSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new NoteSoap[models.length][models[0].length];
        } else {
            soapModels = new NoteSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static NoteSoap[] toSoapModels(List<Note> models) {
        List<NoteSoap> soapModels = new ArrayList<NoteSoap>(models.size());

        for (Note model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new NoteSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _noteId;
    }

    public void setPrimaryKey(long pk) {
        setNoteId(pk);
    }

    public long getNoteId() {
        return _noteId;
    }

    public void setNoteId(long noteId) {
        _noteId = noteId;
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }

    public boolean getHasCheck() {
        return _hasCheck;
    }

    public boolean isHasCheck() {
        return _hasCheck;
    }

    public void setHasCheck(boolean hasCheck) {
        _hasCheck = hasCheck;
    }

    public boolean getHasTime() {
        return _hasTime;
    }

    public boolean isHasTime() {
        return _hasTime;
    }

    public void setHasTime(boolean hasTime) {
        _hasTime = hasTime;
    }

    public boolean getHasReminder() {
        return _hasReminder;
    }

    public boolean isHasReminder() {
        return _hasReminder;
    }

    public void setHasReminder(boolean hasReminder) {
        _hasReminder = hasReminder;
    }

    public boolean getHasTodo() {
        return _hasTodo;
    }

    public boolean isHasTodo() {
        return _hasTodo;
    }

    public void setHasTodo(boolean hasTodo) {
        _hasTodo = hasTodo;
    }

    public boolean getHasRepeat() {
        return _hasRepeat;
    }

    public boolean isHasRepeat() {
        return _hasRepeat;
    }

    public void setHasRepeat(boolean hasRepeat) {
        _hasRepeat = hasRepeat;
    }

    public boolean getHasColor() {
        return _hasColor;
    }

    public boolean isHasColor() {
        return _hasColor;
    }

    public void setHasColor(boolean hasColor) {
        _hasColor = hasColor;
    }

    public boolean getHasWall() {
        return _hasWall;
    }

    public boolean isHasWall() {
        return _hasWall;
    }

    public void setHasWall(boolean hasWall) {
        _hasWall = hasWall;
    }

    public String getText() {
        return _text;
    }

    public void setText(String text) {
        _text = text;
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

    public Date getEventTime() {
        return _eventTime;
    }

    public void setEventTime(Date eventTime) {
        _eventTime = eventTime;
    }

    public String getPeriod() {
        return _period;
    }

    public void setPeriod(String period) {
        _period = period;
    }

    public String getColor() {
        return _color;
    }

    public void setColor(String color) {
        _color = color;
    }

    public Date getCreatedDate() {
        return _createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        _createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return _modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;
    }

    public boolean getIsDeleted() {
        return _isDeleted;
    }

    public boolean isIsDeleted() {
        return _isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        _isDeleted = isDeleted;
    }
}
