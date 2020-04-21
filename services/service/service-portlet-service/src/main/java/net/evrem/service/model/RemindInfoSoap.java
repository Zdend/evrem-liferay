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
public class RemindInfoSoap implements Serializable {
    private long _remindInfoId;
    private long _noteId;
    private Date _remindDate;
    private String _remindSubject;
    private String _recipientEmails;
    private Date _lastRemindTime;

    public RemindInfoSoap() {
    }

    public static RemindInfoSoap toSoapModel(RemindInfo model) {
        RemindInfoSoap soapModel = new RemindInfoSoap();

        soapModel.setRemindInfoId(model.getRemindInfoId());
        soapModel.setNoteId(model.getNoteId());
        soapModel.setRemindDate(model.getRemindDate());
        soapModel.setRemindSubject(model.getRemindSubject());
        soapModel.setRecipientEmails(model.getRecipientEmails());
        soapModel.setLastRemindTime(model.getLastRemindTime());

        return soapModel;
    }

    public static RemindInfoSoap[] toSoapModels(RemindInfo[] models) {
        RemindInfoSoap[] soapModels = new RemindInfoSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static RemindInfoSoap[][] toSoapModels(RemindInfo[][] models) {
        RemindInfoSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new RemindInfoSoap[models.length][models[0].length];
        } else {
            soapModels = new RemindInfoSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static RemindInfoSoap[] toSoapModels(List<RemindInfo> models) {
        List<RemindInfoSoap> soapModels = new ArrayList<RemindInfoSoap>(models.size());

        for (RemindInfo model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new RemindInfoSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _remindInfoId;
    }

    public void setPrimaryKey(long pk) {
        setRemindInfoId(pk);
    }

    public long getRemindInfoId() {
        return _remindInfoId;
    }

    public void setRemindInfoId(long remindInfoId) {
        _remindInfoId = remindInfoId;
    }

    public long getNoteId() {
        return _noteId;
    }

    public void setNoteId(long noteId) {
        _noteId = noteId;
    }

    public Date getRemindDate() {
        return _remindDate;
    }

    public void setRemindDate(Date remindDate) {
        _remindDate = remindDate;
    }

    public String getRemindSubject() {
        return _remindSubject;
    }

    public void setRemindSubject(String remindSubject) {
        _remindSubject = remindSubject;
    }

    public String getRecipientEmails() {
        return _recipientEmails;
    }

    public void setRecipientEmails(String recipientEmails) {
        _recipientEmails = recipientEmails;
    }

    public Date getLastRemindTime() {
        return _lastRemindTime;
    }

    public void setLastRemindTime(Date lastRemindTime) {
        _lastRemindTime = lastRemindTime;
    }
}
