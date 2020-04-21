package net.evrem.service.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import net.evrem.service.model.TodoNote;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TodoNote in entity cache.
 *
 * @author Zdenek Vecek
 * @see TodoNote
 * @generated
 */
public class TodoNoteCacheModel implements CacheModel<TodoNote>, Externalizable {
    public long todoNoteId;
    public long noteId;
    public boolean isDone;
    public String text;
    public int sortNo;
    public long modifiedDate;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(13);

        sb.append("{todoNoteId=");
        sb.append(todoNoteId);
        sb.append(", noteId=");
        sb.append(noteId);
        sb.append(", isDone=");
        sb.append(isDone);
        sb.append(", text=");
        sb.append(text);
        sb.append(", sortNo=");
        sb.append(sortNo);
        sb.append(", modifiedDate=");
        sb.append(modifiedDate);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public TodoNote toEntityModel() {
        TodoNoteImpl todoNoteImpl = new TodoNoteImpl();

        todoNoteImpl.setTodoNoteId(todoNoteId);
        todoNoteImpl.setNoteId(noteId);
        todoNoteImpl.setIsDone(isDone);

        if (text == null) {
            todoNoteImpl.setText(StringPool.BLANK);
        } else {
            todoNoteImpl.setText(text);
        }

        todoNoteImpl.setSortNo(sortNo);

        if (modifiedDate == Long.MIN_VALUE) {
            todoNoteImpl.setModifiedDate(null);
        } else {
            todoNoteImpl.setModifiedDate(new Date(modifiedDate));
        }

        todoNoteImpl.resetOriginalValues();

        return todoNoteImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        todoNoteId = objectInput.readLong();
        noteId = objectInput.readLong();
        isDone = objectInput.readBoolean();
        text = objectInput.readUTF();
        sortNo = objectInput.readInt();
        modifiedDate = objectInput.readLong();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(todoNoteId);
        objectOutput.writeLong(noteId);
        objectOutput.writeBoolean(isDone);

        if (text == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(text);
        }

        objectOutput.writeInt(sortNo);
        objectOutput.writeLong(modifiedDate);
    }
}
