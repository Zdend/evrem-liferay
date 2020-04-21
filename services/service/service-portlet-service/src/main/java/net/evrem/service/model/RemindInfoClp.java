package net.evrem.service.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import net.evrem.service.service.ClpSerializer;
import net.evrem.service.service.RemindInfoLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class RemindInfoClp extends BaseModelImpl<RemindInfo>
    implements RemindInfo {
    private long _remindInfoId;
    private long _noteId;
    private Date _remindDate;
    private String _remindSubject;
    private String _recipientEmails;
    private Date _lastRemindTime;
    private BaseModel<?> _remindInfoRemoteModel;

    public RemindInfoClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return RemindInfo.class;
    }

    @Override
    public String getModelClassName() {
        return RemindInfo.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _remindInfoId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setRemindInfoId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _remindInfoId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("remindInfoId", getRemindInfoId());
        attributes.put("noteId", getNoteId());
        attributes.put("remindDate", getRemindDate());
        attributes.put("remindSubject", getRemindSubject());
        attributes.put("recipientEmails", getRecipientEmails());
        attributes.put("lastRemindTime", getLastRemindTime());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long remindInfoId = (Long) attributes.get("remindInfoId");

        if (remindInfoId != null) {
            setRemindInfoId(remindInfoId);
        }

        Long noteId = (Long) attributes.get("noteId");

        if (noteId != null) {
            setNoteId(noteId);
        }

        Date remindDate = (Date) attributes.get("remindDate");

        if (remindDate != null) {
            setRemindDate(remindDate);
        }

        String remindSubject = (String) attributes.get("remindSubject");

        if (remindSubject != null) {
            setRemindSubject(remindSubject);
        }

        String recipientEmails = (String) attributes.get("recipientEmails");

        if (recipientEmails != null) {
            setRecipientEmails(recipientEmails);
        }

        Date lastRemindTime = (Date) attributes.get("lastRemindTime");

        if (lastRemindTime != null) {
            setLastRemindTime(lastRemindTime);
        }
    }

    @Override
    public long getRemindInfoId() {
        return _remindInfoId;
    }

    @Override
    public void setRemindInfoId(long remindInfoId) {
        _remindInfoId = remindInfoId;

        if (_remindInfoRemoteModel != null) {
            try {
                Class<?> clazz = _remindInfoRemoteModel.getClass();

                Method method = clazz.getMethod("setRemindInfoId", long.class);

                method.invoke(_remindInfoRemoteModel, remindInfoId);
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

        if (_remindInfoRemoteModel != null) {
            try {
                Class<?> clazz = _remindInfoRemoteModel.getClass();

                Method method = clazz.getMethod("setNoteId", long.class);

                method.invoke(_remindInfoRemoteModel, noteId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getRemindDate() {
        return _remindDate;
    }

    @Override
    public void setRemindDate(Date remindDate) {
        _remindDate = remindDate;

        if (_remindInfoRemoteModel != null) {
            try {
                Class<?> clazz = _remindInfoRemoteModel.getClass();

                Method method = clazz.getMethod("setRemindDate", Date.class);

                method.invoke(_remindInfoRemoteModel, remindDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getRemindSubject() {
        return _remindSubject;
    }

    @Override
    public void setRemindSubject(String remindSubject) {
        _remindSubject = remindSubject;

        if (_remindInfoRemoteModel != null) {
            try {
                Class<?> clazz = _remindInfoRemoteModel.getClass();

                Method method = clazz.getMethod("setRemindSubject", String.class);

                method.invoke(_remindInfoRemoteModel, remindSubject);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getRecipientEmails() {
        return _recipientEmails;
    }

    @Override
    public void setRecipientEmails(String recipientEmails) {
        _recipientEmails = recipientEmails;

        if (_remindInfoRemoteModel != null) {
            try {
                Class<?> clazz = _remindInfoRemoteModel.getClass();

                Method method = clazz.getMethod("setRecipientEmails",
                        String.class);

                method.invoke(_remindInfoRemoteModel, recipientEmails);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getLastRemindTime() {
        return _lastRemindTime;
    }

    @Override
    public void setLastRemindTime(Date lastRemindTime) {
        _lastRemindTime = lastRemindTime;

        if (_remindInfoRemoteModel != null) {
            try {
                Class<?> clazz = _remindInfoRemoteModel.getClass();

                Method method = clazz.getMethod("setLastRemindTime", Date.class);

                method.invoke(_remindInfoRemoteModel, lastRemindTime);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getRemindInfoRemoteModel() {
        return _remindInfoRemoteModel;
    }

    public void setRemindInfoRemoteModel(BaseModel<?> remindInfoRemoteModel) {
        _remindInfoRemoteModel = remindInfoRemoteModel;
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

        Class<?> remoteModelClass = _remindInfoRemoteModel.getClass();

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

        Object returnValue = method.invoke(_remindInfoRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            RemindInfoLocalServiceUtil.addRemindInfo(this);
        } else {
            RemindInfoLocalServiceUtil.updateRemindInfo(this);
        }
    }

    @Override
    public RemindInfo toEscapedModel() {
        return (RemindInfo) ProxyUtil.newProxyInstance(RemindInfo.class.getClassLoader(),
            new Class[] { RemindInfo.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        RemindInfoClp clone = new RemindInfoClp();

        clone.setRemindInfoId(getRemindInfoId());
        clone.setNoteId(getNoteId());
        clone.setRemindDate(getRemindDate());
        clone.setRemindSubject(getRemindSubject());
        clone.setRecipientEmails(getRecipientEmails());
        clone.setLastRemindTime(getLastRemindTime());

        return clone;
    }

    @Override
    public int compareTo(RemindInfo remindInfo) {
        long primaryKey = remindInfo.getPrimaryKey();

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

        if (!(obj instanceof RemindInfoClp)) {
            return false;
        }

        RemindInfoClp remindInfo = (RemindInfoClp) obj;

        long primaryKey = remindInfo.getPrimaryKey();

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

        sb.append("{remindInfoId=");
        sb.append(getRemindInfoId());
        sb.append(", noteId=");
        sb.append(getNoteId());
        sb.append(", remindDate=");
        sb.append(getRemindDate());
        sb.append(", remindSubject=");
        sb.append(getRemindSubject());
        sb.append(", recipientEmails=");
        sb.append(getRecipientEmails());
        sb.append(", lastRemindTime=");
        sb.append(getLastRemindTime());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(22);

        sb.append("<model><model-name>");
        sb.append("net.evrem.service.model.RemindInfo");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>remindInfoId</column-name><column-value><![CDATA[");
        sb.append(getRemindInfoId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>noteId</column-name><column-value><![CDATA[");
        sb.append(getNoteId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>remindDate</column-name><column-value><![CDATA[");
        sb.append(getRemindDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>remindSubject</column-name><column-value><![CDATA[");
        sb.append(getRemindSubject());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>recipientEmails</column-name><column-value><![CDATA[");
        sb.append(getRecipientEmails());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>lastRemindTime</column-name><column-value><![CDATA[");
        sb.append(getLastRemindTime());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
