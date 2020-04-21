package net.evrem.service.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.CacheModel;

import net.evrem.service.model.GridItem;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing GridItem in entity cache.
 *
 * @author Zdenek Vecek
 * @see GridItem
 * @generated
 */
public class GridItemCacheModel implements CacheModel<GridItem>, Externalizable {
    public long gridItemId;
    public long noteId;
    public int w;
    public int h;
    public int x;
    public int y;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(13);

        sb.append("{gridItemId=");
        sb.append(gridItemId);
        sb.append(", noteId=");
        sb.append(noteId);
        sb.append(", w=");
        sb.append(w);
        sb.append(", h=");
        sb.append(h);
        sb.append(", x=");
        sb.append(x);
        sb.append(", y=");
        sb.append(y);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public GridItem toEntityModel() {
        GridItemImpl gridItemImpl = new GridItemImpl();

        gridItemImpl.setGridItemId(gridItemId);
        gridItemImpl.setNoteId(noteId);
        gridItemImpl.setW(w);
        gridItemImpl.setH(h);
        gridItemImpl.setX(x);
        gridItemImpl.setY(y);

        gridItemImpl.resetOriginalValues();

        return gridItemImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        gridItemId = objectInput.readLong();
        noteId = objectInput.readLong();
        w = objectInput.readInt();
        h = objectInput.readInt();
        x = objectInput.readInt();
        y = objectInput.readInt();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(gridItemId);
        objectOutput.writeLong(noteId);
        objectOutput.writeInt(w);
        objectOutput.writeInt(h);
        objectOutput.writeInt(x);
        objectOutput.writeInt(y);
    }
}
