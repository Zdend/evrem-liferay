package net.evrem.service.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the RemindInfo service. Represents a row in the &quot;remind_info&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link net.evrem.service.model.impl.RemindInfoModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link net.evrem.service.model.impl.RemindInfoImpl}.
 * </p>
 *
 * @author Zdenek Vecek
 * @see RemindInfo
 * @see net.evrem.service.model.impl.RemindInfoImpl
 * @see net.evrem.service.model.impl.RemindInfoModelImpl
 * @generated
 */
public interface RemindInfoModel extends BaseModel<RemindInfo> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a remind info model instance should use the {@link RemindInfo} interface instead.
     */

    /**
     * Returns the primary key of this remind info.
     *
     * @return the primary key of this remind info
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this remind info.
     *
     * @param primaryKey the primary key of this remind info
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the remind info ID of this remind info.
     *
     * @return the remind info ID of this remind info
     */
    public long getRemindInfoId();

    /**
     * Sets the remind info ID of this remind info.
     *
     * @param remindInfoId the remind info ID of this remind info
     */
    public void setRemindInfoId(long remindInfoId);

    /**
     * Returns the note ID of this remind info.
     *
     * @return the note ID of this remind info
     */
    public long getNoteId();

    /**
     * Sets the note ID of this remind info.
     *
     * @param noteId the note ID of this remind info
     */
    public void setNoteId(long noteId);

    /**
     * Returns the remind date of this remind info.
     *
     * @return the remind date of this remind info
     */
    public Date getRemindDate();

    /**
     * Sets the remind date of this remind info.
     *
     * @param remindDate the remind date of this remind info
     */
    public void setRemindDate(Date remindDate);

    /**
     * Returns the remind subject of this remind info.
     *
     * @return the remind subject of this remind info
     */
    @AutoEscape
    public String getRemindSubject();

    /**
     * Sets the remind subject of this remind info.
     *
     * @param remindSubject the remind subject of this remind info
     */
    public void setRemindSubject(String remindSubject);

    /**
     * Returns the recipient emails of this remind info.
     *
     * @return the recipient emails of this remind info
     */
    @AutoEscape
    public String getRecipientEmails();

    /**
     * Sets the recipient emails of this remind info.
     *
     * @param recipientEmails the recipient emails of this remind info
     */
    public void setRecipientEmails(String recipientEmails);

    /**
     * Returns the last remind time of this remind info.
     *
     * @return the last remind time of this remind info
     */
    public Date getLastRemindTime();

    /**
     * Sets the last remind time of this remind info.
     *
     * @param lastRemindTime the last remind time of this remind info
     */
    public void setLastRemindTime(Date lastRemindTime);

    @Override
    public boolean isNew();

    @Override
    public void setNew(boolean n);

    @Override
    public boolean isCachedModel();

    @Override
    public void setCachedModel(boolean cachedModel);

    @Override
    public boolean isEscapedModel();

    @Override
    public Serializable getPrimaryKeyObj();

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj);

    @Override
    public ExpandoBridge getExpandoBridge();

    @Override
    public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

    @Override
    public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext);

    @Override
    public Object clone();

    @Override
    public int compareTo(RemindInfo remindInfo);

    @Override
    public int hashCode();

    @Override
    public CacheModel<RemindInfo> toCacheModel();

    @Override
    public RemindInfo toEscapedModel();

    @Override
    public RemindInfo toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}
