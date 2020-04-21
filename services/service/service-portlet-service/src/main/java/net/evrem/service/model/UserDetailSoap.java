package net.evrem.service.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Zdenek Vecek
 * @generated
 */
public class UserDetailSoap implements Serializable {
    private long _userDetailId;
    private long _userId;
    private String _timeZoneId;

    public UserDetailSoap() {
    }

    public static UserDetailSoap toSoapModel(UserDetail model) {
        UserDetailSoap soapModel = new UserDetailSoap();

        soapModel.setUserDetailId(model.getUserDetailId());
        soapModel.setUserId(model.getUserId());
        soapModel.setTimeZoneId(model.getTimeZoneId());

        return soapModel;
    }

    public static UserDetailSoap[] toSoapModels(UserDetail[] models) {
        UserDetailSoap[] soapModels = new UserDetailSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static UserDetailSoap[][] toSoapModels(UserDetail[][] models) {
        UserDetailSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new UserDetailSoap[models.length][models[0].length];
        } else {
            soapModels = new UserDetailSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static UserDetailSoap[] toSoapModels(List<UserDetail> models) {
        List<UserDetailSoap> soapModels = new ArrayList<UserDetailSoap>(models.size());

        for (UserDetail model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new UserDetailSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _userDetailId;
    }

    public void setPrimaryKey(long pk) {
        setUserDetailId(pk);
    }

    public long getUserDetailId() {
        return _userDetailId;
    }

    public void setUserDetailId(long userDetailId) {
        _userDetailId = userDetailId;
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }

    public String getTimeZoneId() {
        return _timeZoneId;
    }

    public void setTimeZoneId(String timeZoneId) {
        _timeZoneId = timeZoneId;
    }
}
