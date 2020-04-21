package net.evrem.service.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the UserDetail service. Represents a row in the &quot;user_detail&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link net.evrem.service.model.impl.UserDetailModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link net.evrem.service.model.impl.UserDetailImpl}.
 * </p>
 *
 * @author Zdenek Vecek
 * @see UserDetail
 * @see net.evrem.service.model.impl.UserDetailImpl
 * @see net.evrem.service.model.impl.UserDetailModelImpl
 * @generated
 */
public interface UserDetailModel extends BaseModel<UserDetail> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a user detail model instance should use the {@link UserDetail} interface instead.
     */

    /**
     * Returns the primary key of this user detail.
     *
     * @return the primary key of this user detail
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this user detail.
     *
     * @param primaryKey the primary key of this user detail
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the user detail ID of this user detail.
     *
     * @return the user detail ID of this user detail
     */
    public long getUserDetailId();

    /**
     * Sets the user detail ID of this user detail.
     *
     * @param userDetailId the user detail ID of this user detail
     */
    public void setUserDetailId(long userDetailId);

    /**
     * Returns the user ID of this user detail.
     *
     * @return the user ID of this user detail
     */
    public long getUserId();

    /**
     * Sets the user ID of this user detail.
     *
     * @param userId the user ID of this user detail
     */
    public void setUserId(long userId);

    /**
     * Returns the user uuid of this user detail.
     *
     * @return the user uuid of this user detail
     * @throws SystemException if a system exception occurred
     */
    public String getUserUuid() throws SystemException;

    /**
     * Sets the user uuid of this user detail.
     *
     * @param userUuid the user uuid of this user detail
     */
    public void setUserUuid(String userUuid);

    /**
     * Returns the time zone ID of this user detail.
     *
     * @return the time zone ID of this user detail
     */
    @AutoEscape
    public String getTimeZoneId();

    /**
     * Sets the time zone ID of this user detail.
     *
     * @param timeZoneId the time zone ID of this user detail
     */
    public void setTimeZoneId(String timeZoneId);

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
    public int compareTo(UserDetail userDetail);

    @Override
    public int hashCode();

    @Override
    public CacheModel<UserDetail> toCacheModel();

    @Override
    public UserDetail toEscapedModel();

    @Override
    public UserDetail toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}
