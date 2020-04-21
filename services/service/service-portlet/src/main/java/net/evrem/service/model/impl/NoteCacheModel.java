package net.evrem.service.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import net.evrem.service.model.Note;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Note in entity cache.
 *
 * @author Zdenek Vecek
 * @see Note
 * @generated
 */
public class NoteCacheModel implements CacheModel<Note>, Externalizable {
    public long noteId;
    public long userId;
    public boolean hasCheck;
    public boolean hasTime;
    public boolean hasReminder;
    public boolean hasTodo;
    public boolean hasRepeat;
    public boolean hasColor;
    public boolean hasWall;
    public String text;
    public boolean isDone;
    public long eventTime;
    public String period;
    public String color;
    public long createdDate;
    public long modifiedDate;
    public boolean isDeleted;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(35);

        sb.append("{noteId=");
        sb.append(noteId);
        sb.append(", userId=");
        sb.append(userId);
        sb.append(", hasCheck=");
        sb.append(hasCheck);
        sb.append(", hasTime=");
        sb.append(hasTime);
        sb.append(", hasReminder=");
        sb.append(hasReminder);
        sb.append(", hasTodo=");
        sb.append(hasTodo);
        sb.append(", hasRepeat=");
        sb.append(hasRepeat);
        sb.append(", hasColor=");
        sb.append(hasColor);
        sb.append(", hasWall=");
        sb.append(hasWall);
        sb.append(", text=");
        sb.append(text);
        sb.append(", isDone=");
        sb.append(isDone);
        sb.append(", eventTime=");
        sb.append(eventTime);
        sb.append(", period=");
        sb.append(period);
        sb.append(", color=");
        sb.append(color);
        sb.append(", createdDate=");
        sb.append(createdDate);
        sb.append(", modifiedDate=");
        sb.append(modifiedDate);
        sb.append(", isDeleted=");
        sb.append(isDeleted);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Note toEntityModel() {
        NoteImpl noteImpl = new NoteImpl();

        noteImpl.setNoteId(noteId);
        noteImpl.setUserId(userId);
        noteImpl.setHasCheck(hasCheck);
        noteImpl.setHasTime(hasTime);
        noteImpl.setHasReminder(hasReminder);
        noteImpl.setHasTodo(hasTodo);
        noteImpl.setHasRepeat(hasRepeat);
        noteImpl.setHasColor(hasColor);
        noteImpl.setHasWall(hasWall);

        if (text == null) {
            noteImpl.setText(StringPool.BLANK);
        } else {
            noteImpl.setText(text);
        }

        noteImpl.setIsDone(isDone);

        if (eventTime == Long.MIN_VALUE) {
            noteImpl.setEventTime(null);
        } else {
            noteImpl.setEventTime(new Date(eventTime));
        }

        if (period == null) {
            noteImpl.setPeriod(StringPool.BLANK);
        } else {
            noteImpl.setPeriod(period);
        }

        if (color == null) {
            noteImpl.setColor(StringPool.BLANK);
        } else {
            noteImpl.setColor(color);
        }

        if (createdDate == Long.MIN_VALUE) {
            noteImpl.setCreatedDate(null);
        } else {
            noteImpl.setCreatedDate(new Date(createdDate));
        }

        if (modifiedDate == Long.MIN_VALUE) {
            noteImpl.setModifiedDate(null);
        } else {
            noteImpl.setModifiedDate(new Date(modifiedDate));
        }

        noteImpl.setIsDeleted(isDeleted);

        noteImpl.resetOriginalValues();

        return noteImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        noteId = objectInput.readLong();
        userId = objectInput.readLong();
        hasCheck = objectInput.readBoolean();
        hasTime = objectInput.readBoolean();
        hasReminder = objectInput.readBoolean();
        hasTodo = objectInput.readBoolean();
        hasRepeat = objectInput.readBoolean();
        hasColor = objectInput.readBoolean();
        hasWall = objectInput.readBoolean();
        text = objectInput.readUTF();
        isDone = objectInput.readBoolean();
        eventTime = objectInput.readLong();
        period = objectInput.readUTF();
        color = objectInput.readUTF();
        createdDate = objectInput.readLong();
        modifiedDate = objectInput.readLong();
        isDeleted = objectInput.readBoolean();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(noteId);
        objectOutput.writeLong(userId);
        objectOutput.writeBoolean(hasCheck);
        objectOutput.writeBoolean(hasTime);
        objectOutput.writeBoolean(hasReminder);
        objectOutput.writeBoolean(hasTodo);
        objectOutput.writeBoolean(hasRepeat);
        objectOutput.writeBoolean(hasColor);
        objectOutput.writeBoolean(hasWall);

        if (text == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(text);
        }

        objectOutput.writeBoolean(isDone);
        objectOutput.writeLong(eventTime);

        if (period == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(period);
        }

        if (color == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(color);
        }

        objectOutput.writeLong(createdDate);
        objectOutput.writeLong(modifiedDate);
        objectOutput.writeBoolean(isDeleted);
    }
}
