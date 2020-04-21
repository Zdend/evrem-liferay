package net.evrem.service.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import net.evrem.service.model.RemindInfo;
import net.evrem.service.model.RemindInfoModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the RemindInfo service. Represents a row in the &quot;remind_info&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link net.evrem.service.model.RemindInfoModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link RemindInfoImpl}.
 * </p>
 *
 * @author Zdenek Vecek
 * @see RemindInfoImpl
 * @see net.evrem.service.model.RemindInfo
 * @see net.evrem.service.model.RemindInfoModel
 * @generated
 */
public class RemindInfoModelImpl extends BaseModelImpl<RemindInfo>
    implements RemindInfoModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a remind info model instance should use the {@link net.evrem.service.model.RemindInfo} interface instead.
     */
    public static final String TABLE_NAME = "remind_info";
    public static final Object[][] TABLE_COLUMNS = {
            { "remindinfo_id", Types.BIGINT },
            { "note_id", Types.BIGINT },
            { "remind_date", Types.TIMESTAMP },
            { "remind_subject", Types.VARCHAR },
            { "recipient_emails", Types.VARCHAR },
            { "last_remind_time", Types.TIMESTAMP }
        };
    public static final String TABLE_SQL_CREATE = "create table remind_info (remindinfo_id LONG not null primary key,note_id LONG,remind_date DATE null,remind_subject VARCHAR(75) null,recipient_emails VARCHAR(75) null,last_remind_time DATE null)";
    public static final String TABLE_SQL_DROP = "drop table remind_info";
    public static final String ORDER_BY_JPQL = " ORDER BY remindInfo.remindInfoId ASC";
    public static final String ORDER_BY_SQL = " ORDER BY remind_info.remindinfo_id ASC";
    public static final String DATA_SOURCE = "evremDataSource";
    public static final String SESSION_FACTORY = "evremSessionFactory";
    public static final String TX_MANAGER = "evremTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.net.evrem.service.model.RemindInfo"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.net.evrem.service.model.RemindInfo"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.net.evrem.service.model.RemindInfo"),
            true);
    public static long NOTEID_COLUMN_BITMASK = 1L;
    public static long REMINDINFOID_COLUMN_BITMASK = 2L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.net.evrem.service.model.RemindInfo"));
    private static ClassLoader _classLoader = RemindInfo.class.getClassLoader();
    private static Class<?>[] _escapedModelInterfaces = new Class[] {
            RemindInfo.class
        };
    private long _remindInfoId;
    private long _noteId;
    private long _originalNoteId;
    private boolean _setOriginalNoteId;
    private Date _remindDate;
    private String _remindSubject;
    private String _recipientEmails;
    private Date _lastRemindTime;
    private long _columnBitmask;
    private RemindInfo _escapedModel;

    public RemindInfoModelImpl() {
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

    @Override
    public long getRemindInfoId() {
        return _remindInfoId;
    }

    @Override
    public void setRemindInfoId(long remindInfoId) {
        _remindInfoId = remindInfoId;
    }

    @Override
    public long getNoteId() {
        return _noteId;
    }

    @Override
    public void setNoteId(long noteId) {
        _columnBitmask |= NOTEID_COLUMN_BITMASK;

        if (!_setOriginalNoteId) {
            _setOriginalNoteId = true;

            _originalNoteId = _noteId;
        }

        _noteId = noteId;
    }

    public long getOriginalNoteId() {
        return _originalNoteId;
    }

    @Override
    public Date getRemindDate() {
        return _remindDate;
    }

    @Override
    public void setRemindDate(Date remindDate) {
        _remindDate = remindDate;
    }

    @Override
    public String getRemindSubject() {
        if (_remindSubject == null) {
            return StringPool.BLANK;
        } else {
            return _remindSubject;
        }
    }

    @Override
    public void setRemindSubject(String remindSubject) {
        _remindSubject = remindSubject;
    }

    @Override
    public String getRecipientEmails() {
        if (_recipientEmails == null) {
            return StringPool.BLANK;
        } else {
            return _recipientEmails;
        }
    }

    @Override
    public void setRecipientEmails(String recipientEmails) {
        _recipientEmails = recipientEmails;
    }

    @Override
    public Date getLastRemindTime() {
        return _lastRemindTime;
    }

    @Override
    public void setLastRemindTime(Date lastRemindTime) {
        _lastRemindTime = lastRemindTime;
    }

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
            RemindInfo.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public RemindInfo toEscapedModel() {
        if (_escapedModel == null) {
            _escapedModel = (RemindInfo) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelInterfaces, new AutoEscapeBeanHandler(this));
        }

        return _escapedModel;
    }

    @Override
    public Object clone() {
        RemindInfoImpl remindInfoImpl = new RemindInfoImpl();

        remindInfoImpl.setRemindInfoId(getRemindInfoId());
        remindInfoImpl.setNoteId(getNoteId());
        remindInfoImpl.setRemindDate(getRemindDate());
        remindInfoImpl.setRemindSubject(getRemindSubject());
        remindInfoImpl.setRecipientEmails(getRecipientEmails());
        remindInfoImpl.setLastRemindTime(getLastRemindTime());

        remindInfoImpl.resetOriginalValues();

        return remindInfoImpl;
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

        if (!(obj instanceof RemindInfo)) {
            return false;
        }

        RemindInfo remindInfo = (RemindInfo) obj;

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
    public void resetOriginalValues() {
        RemindInfoModelImpl remindInfoModelImpl = this;

        remindInfoModelImpl._originalNoteId = remindInfoModelImpl._noteId;

        remindInfoModelImpl._setOriginalNoteId = false;

        remindInfoModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<RemindInfo> toCacheModel() {
        RemindInfoCacheModel remindInfoCacheModel = new RemindInfoCacheModel();

        remindInfoCacheModel.remindInfoId = getRemindInfoId();

        remindInfoCacheModel.noteId = getNoteId();

        Date remindDate = getRemindDate();

        if (remindDate != null) {
            remindInfoCacheModel.remindDate = remindDate.getTime();
        } else {
            remindInfoCacheModel.remindDate = Long.MIN_VALUE;
        }

        remindInfoCacheModel.remindSubject = getRemindSubject();

        String remindSubject = remindInfoCacheModel.remindSubject;

        if ((remindSubject != null) && (remindSubject.length() == 0)) {
            remindInfoCacheModel.remindSubject = null;
        }

        remindInfoCacheModel.recipientEmails = getRecipientEmails();

        String recipientEmails = remindInfoCacheModel.recipientEmails;

        if ((recipientEmails != null) && (recipientEmails.length() == 0)) {
            remindInfoCacheModel.recipientEmails = null;
        }

        Date lastRemindTime = getLastRemindTime();

        if (lastRemindTime != null) {
            remindInfoCacheModel.lastRemindTime = lastRemindTime.getTime();
        } else {
            remindInfoCacheModel.lastRemindTime = Long.MIN_VALUE;
        }

        return remindInfoCacheModel;
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
