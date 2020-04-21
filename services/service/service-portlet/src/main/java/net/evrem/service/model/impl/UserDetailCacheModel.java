package net.evrem.service.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import net.evrem.service.model.UserDetail;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing UserDetail in entity cache.
 *
 * @author Zdenek Vecek
 * @see UserDetail
 * @generated
 */
public class UserDetailCacheModel implements CacheModel<UserDetail>,
    Externalizable {
    public long userDetailId;
    public long userId;
    public String timeZoneId;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(7);

        sb.append("{userDetailId=");
        sb.append(userDetailId);
        sb.append(", userId=");
        sb.append(userId);
        sb.append(", timeZoneId=");
        sb.append(timeZoneId);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public UserDetail toEntityModel() {
        UserDetailImpl userDetailImpl = new UserDetailImpl();

        userDetailImpl.setUserDetailId(userDetailId);
        userDetailImpl.setUserId(userId);

        if (timeZoneId == null) {
            userDetailImpl.setTimeZoneId(StringPool.BLANK);
        } else {
            userDetailImpl.setTimeZoneId(timeZoneId);
        }

        userDetailImpl.resetOriginalValues();

        return userDetailImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        userDetailId = objectInput.readLong();
        userId = objectInput.readLong();
        timeZoneId = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(userDetailId);
        objectOutput.writeLong(userId);

        if (timeZoneId == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(timeZoneId);
        }
    }
}
