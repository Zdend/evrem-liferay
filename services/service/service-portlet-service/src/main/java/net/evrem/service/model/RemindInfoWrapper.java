package net.evrem.service.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link RemindInfo}.
 * </p>
 *
 * @author Zdenek Vecek
 * @see RemindInfo
 * @generated
 */
public class RemindInfoWrapper implements RemindInfo, ModelWrapper<RemindInfo> {
    private RemindInfo _remindInfo;

    public RemindInfoWrapper(RemindInfo remindInfo) {
        _remindInfo = remindInfo;
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

    /**
    * Returns the primary key of this remind info.
    *
    * @return the primary key of this remind info
    */
    @Override
    public long getPrimaryKey() {
        return _remindInfo.getPrimaryKey();
    }

    /**
    * Sets the primary key of this remind info.
    *
    * @param primaryKey the primary key of this remind info
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _remindInfo.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the remind info ID of this remind info.
    *
    * @return the remind info ID of this remind info
    */
    @Override
    public long getRemindInfoId() {
        return _remindInfo.getRemindInfoId();
    }

    /**
    * Sets the remind info ID of this remind info.
    *
    * @param remindInfoId the remind info ID of this remind info
    */
    @Override
    public void setRemindInfoId(long remindInfoId) {
        _remindInfo.setRemindInfoId(remindInfoId);
    }

    /**
    * Returns the note ID of this remind info.
    *
    * @return the note ID of this remind info
    */
    @Override
    public long getNoteId() {
        return _remindInfo.getNoteId();
    }

    /**
    * Sets the note ID of this remind info.
    *
    * @param noteId the note ID of this remind info
    */
    @Override
    public void setNoteId(long noteId) {
        _remindInfo.setNoteId(noteId);
    }

    /**
    * Returns the remind date of this remind info.
    *
    * @return the remind date of this remind info
    */
    @Override
    public java.util.Date getRemindDate() {
        return _remindInfo.getRemindDate();
    }

    /**
    * Sets the remind date of this remind info.
    *
    * @param remindDate the remind date of this remind info
    */
    @Override
    public void setRemindDate(java.util.Date remindDate) {
        _remindInfo.setRemindDate(remindDate);
    }

    /**
    * Returns the remind subject of this remind info.
    *
    * @return the remind subject of this remind info
    */
    @Override
    public java.lang.String getRemindSubject() {
        return _remindInfo.getRemindSubject();
    }

    /**
    * Sets the remind subject of this remind info.
    *
    * @param remindSubject the remind subject of this remind info
    */
    @Override
    public void setRemindSubject(java.lang.String remindSubject) {
        _remindInfo.setRemindSubject(remindSubject);
    }

    /**
    * Returns the recipient emails of this remind info.
    *
    * @return the recipient emails of this remind info
    */
    @Override
    public java.lang.String getRecipientEmails() {
        return _remindInfo.getRecipientEmails();
    }

    /**
    * Sets the recipient emails of this remind info.
    *
    * @param recipientEmails the recipient emails of this remind info
    */
    @Override
    public void setRecipientEmails(java.lang.String recipientEmails) {
        _remindInfo.setRecipientEmails(recipientEmails);
    }

    /**
    * Returns the last remind time of this remind info.
    *
    * @return the last remind time of this remind info
    */
    @Override
    public java.util.Date getLastRemindTime() {
        return _remindInfo.getLastRemindTime();
    }

    /**
    * Sets the last remind time of this remind info.
    *
    * @param lastRemindTime the last remind time of this remind info
    */
    @Override
    public void setLastRemindTime(java.util.Date lastRemindTime) {
        _remindInfo.setLastRemindTime(lastRemindTime);
    }

    @Override
    public boolean isNew() {
        return _remindInfo.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _remindInfo.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _remindInfo.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _remindInfo.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _remindInfo.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _remindInfo.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _remindInfo.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _remindInfo.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _remindInfo.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _remindInfo.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _remindInfo.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new RemindInfoWrapper((RemindInfo) _remindInfo.clone());
    }

    @Override
    public int compareTo(net.evrem.service.model.RemindInfo remindInfo) {
        return _remindInfo.compareTo(remindInfo);
    }

    @Override
    public int hashCode() {
        return _remindInfo.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<net.evrem.service.model.RemindInfo> toCacheModel() {
        return _remindInfo.toCacheModel();
    }

    @Override
    public net.evrem.service.model.RemindInfo toEscapedModel() {
        return new RemindInfoWrapper(_remindInfo.toEscapedModel());
    }

    @Override
    public net.evrem.service.model.RemindInfo toUnescapedModel() {
        return new RemindInfoWrapper(_remindInfo.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _remindInfo.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _remindInfo.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _remindInfo.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof RemindInfoWrapper)) {
            return false;
        }

        RemindInfoWrapper remindInfoWrapper = (RemindInfoWrapper) obj;

        if (Validator.equals(_remindInfo, remindInfoWrapper._remindInfo)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public RemindInfo getWrappedRemindInfo() {
        return _remindInfo;
    }

    @Override
    public RemindInfo getWrappedModel() {
        return _remindInfo;
    }

    @Override
    public void resetOriginalValues() {
        _remindInfo.resetOriginalValues();
    }
}
