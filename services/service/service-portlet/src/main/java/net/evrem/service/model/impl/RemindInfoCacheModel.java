package net.evrem.service.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import net.evrem.service.model.RemindInfo;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing RemindInfo in entity cache.
 *
 * @author Zdenek Vecek
 * @see RemindInfo
 * @generated
 */
public class RemindInfoCacheModel implements CacheModel<RemindInfo>,
    Externalizable {
    public long remindInfoId;
    public long noteId;
    public long remindDate;
    public String remindSubject;
    public String recipientEmails;
    public long lastRemindTime;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(13);

        sb.append("{remindInfoId=");
        sb.append(remindInfoId);
        sb.append(", noteId=");
        sb.append(noteId);
        sb.append(", remindDate=");
        sb.append(remindDate);
        sb.append(", remindSubject=");
        sb.append(remindSubject);
        sb.append(", recipientEmails=");
        sb.append(recipientEmails);
        sb.append(", lastRemindTime=");
        sb.append(lastRemindTime);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public RemindInfo toEntityModel() {
        RemindInfoImpl remindInfoImpl = new RemindInfoImpl();

        remindInfoImpl.setRemindInfoId(remindInfoId);
        remindInfoImpl.setNoteId(noteId);

        if (remindDate == Long.MIN_VALUE) {
            remindInfoImpl.setRemindDate(null);
        } else {
            remindInfoImpl.setRemindDate(new Date(remindDate));
        }

        if (remindSubject == null) {
            remindInfoImpl.setRemindSubject(StringPool.BLANK);
        } else {
            remindInfoImpl.setRemindSubject(remindSubject);
        }

        if (recipientEmails == null) {
            remindInfoImpl.setRecipientEmails(StringPool.BLANK);
        } else {
            remindInfoImpl.setRecipientEmails(recipientEmails);
        }

        if (lastRemindTime == Long.MIN_VALUE) {
            remindInfoImpl.setLastRemindTime(null);
        } else {
            remindInfoImpl.setLastRemindTime(new Date(lastRemindTime));
        }

        remindInfoImpl.resetOriginalValues();

        return remindInfoImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        remindInfoId = objectInput.readLong();
        noteId = objectInput.readLong();
        remindDate = objectInput.readLong();
        remindSubject = objectInput.readUTF();
        recipientEmails = objectInput.readUTF();
        lastRemindTime = objectInput.readLong();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(remindInfoId);
        objectOutput.writeLong(noteId);
        objectOutput.writeLong(remindDate);

        if (remindSubject == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(remindSubject);
        }

        if (recipientEmails == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(recipientEmails);
        }

        objectOutput.writeLong(lastRemindTime);
    }
}
