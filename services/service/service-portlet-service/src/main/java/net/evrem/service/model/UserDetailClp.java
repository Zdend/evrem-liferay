package net.evrem.service.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import net.evrem.service.service.ClpSerializer;
import net.evrem.service.service.UserDetailLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class UserDetailClp extends BaseModelImpl<UserDetail>
    implements UserDetail {
    private long _userDetailId;
    private long _userId;
    private String _userUuid;
    private String _timeZoneId;
    private BaseModel<?> _userDetailRemoteModel;

    public UserDetailClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return UserDetail.class;
    }

    @Override
    public String getModelClassName() {
        return UserDetail.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _userDetailId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setUserDetailId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _userDetailId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("userDetailId", getUserDetailId());
        attributes.put("userId", getUserId());
        attributes.put("timeZoneId", getTimeZoneId());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long userDetailId = (Long) attributes.get("userDetailId");

        if (userDetailId != null) {
            setUserDetailId(userDetailId);
        }

        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        String timeZoneId = (String) attributes.get("timeZoneId");

        if (timeZoneId != null) {
            setTimeZoneId(timeZoneId);
        }
    }

    @Override
    public long getUserDetailId() {
        return _userDetailId;
    }

    @Override
    public void setUserDetailId(long userDetailId) {
        _userDetailId = userDetailId;

        if (_userDetailRemoteModel != null) {
            try {
                Class<?> clazz = _userDetailRemoteModel.getClass();

                Method method = clazz.getMethod("setUserDetailId", long.class);

                method.invoke(_userDetailRemoteModel, userDetailId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getUserId() {
        return _userId;
    }

    @Override
    public void setUserId(long userId) {
        _userId = userId;

        if (_userDetailRemoteModel != null) {
            try {
                Class<?> clazz = _userDetailRemoteModel.getClass();

                Method method = clazz.getMethod("setUserId", long.class);

                method.invoke(_userDetailRemoteModel, userId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getUserUuid() throws SystemException {
        return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
    }

    @Override
    public void setUserUuid(String userUuid) {
        _userUuid = userUuid;
    }

    @Override
    public String getTimeZoneId() {
        return _timeZoneId;
    }

    @Override
    public void setTimeZoneId(String timeZoneId) {
        _timeZoneId = timeZoneId;

        if (_userDetailRemoteModel != null) {
            try {
                Class<?> clazz = _userDetailRemoteModel.getClass();

                Method method = clazz.getMethod("setTimeZoneId", String.class);

                method.invoke(_userDetailRemoteModel, timeZoneId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getUserDetailRemoteModel() {
        return _userDetailRemoteModel;
    }

    public void setUserDetailRemoteModel(BaseModel<?> userDetailRemoteModel) {
        _userDetailRemoteModel = userDetailRemoteModel;
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

        Class<?> remoteModelClass = _userDetailRemoteModel.getClass();

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

        Object returnValue = method.invoke(_userDetailRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            UserDetailLocalServiceUtil.addUserDetail(this);
        } else {
            UserDetailLocalServiceUtil.updateUserDetail(this);
        }
    }

    @Override
    public UserDetail toEscapedModel() {
        return (UserDetail) ProxyUtil.newProxyInstance(UserDetail.class.getClassLoader(),
            new Class[] { UserDetail.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        UserDetailClp clone = new UserDetailClp();

        clone.setUserDetailId(getUserDetailId());
        clone.setUserId(getUserId());
        clone.setTimeZoneId(getTimeZoneId());

        return clone;
    }

    @Override
    public int compareTo(UserDetail userDetail) {
        long primaryKey = userDetail.getPrimaryKey();

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

        if (!(obj instanceof UserDetailClp)) {
            return false;
        }

        UserDetailClp userDetail = (UserDetailClp) obj;

        long primaryKey = userDetail.getPrimaryKey();

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
        StringBundler sb = new StringBundler(7);

        sb.append("{userDetailId=");
        sb.append(getUserDetailId());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append(", timeZoneId=");
        sb.append(getTimeZoneId());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(13);

        sb.append("<model><model-name>");
        sb.append("net.evrem.service.model.UserDetail");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>userDetailId</column-name><column-value><![CDATA[");
        sb.append(getUserDetailId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>timeZoneId</column-name><column-value><![CDATA[");
        sb.append(getTimeZoneId());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
