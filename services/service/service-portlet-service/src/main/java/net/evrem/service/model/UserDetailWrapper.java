package net.evrem.service.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link UserDetail}.
 * </p>
 *
 * @author Zdenek Vecek
 * @see UserDetail
 * @generated
 */
public class UserDetailWrapper implements UserDetail, ModelWrapper<UserDetail> {
    private UserDetail _userDetail;

    public UserDetailWrapper(UserDetail userDetail) {
        _userDetail = userDetail;
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

    /**
    * Returns the primary key of this user detail.
    *
    * @return the primary key of this user detail
    */
    @Override
    public long getPrimaryKey() {
        return _userDetail.getPrimaryKey();
    }

    /**
    * Sets the primary key of this user detail.
    *
    * @param primaryKey the primary key of this user detail
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _userDetail.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the user detail ID of this user detail.
    *
    * @return the user detail ID of this user detail
    */
    @Override
    public long getUserDetailId() {
        return _userDetail.getUserDetailId();
    }

    /**
    * Sets the user detail ID of this user detail.
    *
    * @param userDetailId the user detail ID of this user detail
    */
    @Override
    public void setUserDetailId(long userDetailId) {
        _userDetail.setUserDetailId(userDetailId);
    }

    /**
    * Returns the user ID of this user detail.
    *
    * @return the user ID of this user detail
    */
    @Override
    public long getUserId() {
        return _userDetail.getUserId();
    }

    /**
    * Sets the user ID of this user detail.
    *
    * @param userId the user ID of this user detail
    */
    @Override
    public void setUserId(long userId) {
        _userDetail.setUserId(userId);
    }

    /**
    * Returns the user uuid of this user detail.
    *
    * @return the user uuid of this user detail
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _userDetail.getUserUuid();
    }

    /**
    * Sets the user uuid of this user detail.
    *
    * @param userUuid the user uuid of this user detail
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _userDetail.setUserUuid(userUuid);
    }

    /**
    * Returns the time zone ID of this user detail.
    *
    * @return the time zone ID of this user detail
    */
    @Override
    public java.lang.String getTimeZoneId() {
        return _userDetail.getTimeZoneId();
    }

    /**
    * Sets the time zone ID of this user detail.
    *
    * @param timeZoneId the time zone ID of this user detail
    */
    @Override
    public void setTimeZoneId(java.lang.String timeZoneId) {
        _userDetail.setTimeZoneId(timeZoneId);
    }

    @Override
    public boolean isNew() {
        return _userDetail.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _userDetail.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _userDetail.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _userDetail.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _userDetail.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _userDetail.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _userDetail.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _userDetail.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _userDetail.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _userDetail.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _userDetail.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new UserDetailWrapper((UserDetail) _userDetail.clone());
    }

    @Override
    public int compareTo(net.evrem.service.model.UserDetail userDetail) {
        return _userDetail.compareTo(userDetail);
    }

    @Override
    public int hashCode() {
        return _userDetail.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<net.evrem.service.model.UserDetail> toCacheModel() {
        return _userDetail.toCacheModel();
    }

    @Override
    public net.evrem.service.model.UserDetail toEscapedModel() {
        return new UserDetailWrapper(_userDetail.toEscapedModel());
    }

    @Override
    public net.evrem.service.model.UserDetail toUnescapedModel() {
        return new UserDetailWrapper(_userDetail.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _userDetail.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _userDetail.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _userDetail.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof UserDetailWrapper)) {
            return false;
        }

        UserDetailWrapper userDetailWrapper = (UserDetailWrapper) obj;

        if (Validator.equals(_userDetail, userDetailWrapper._userDetail)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public UserDetail getWrappedUserDetail() {
        return _userDetail;
    }

    @Override
    public UserDetail getWrappedModel() {
        return _userDetail;
    }

    @Override
    public void resetOriginalValues() {
        _userDetail.resetOriginalValues();
    }
}
