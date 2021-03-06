package net.evrem.service.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import net.evrem.service.model.UserDetail;
import net.evrem.service.service.UserDetailLocalServiceUtil;

/**
 * The extended model base implementation for the UserDetail service. Represents a row in the &quot;user_detail&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link UserDetailImpl}.
 * </p>
 *
 * @author Zdenek Vecek
 * @see UserDetailImpl
 * @see net.evrem.service.model.UserDetail
 * @generated
 */
public abstract class UserDetailBaseImpl extends UserDetailModelImpl
    implements UserDetail {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a user detail model instance should use the {@link UserDetail} interface instead.
     */
    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            UserDetailLocalServiceUtil.addUserDetail(this);
        } else {
            UserDetailLocalServiceUtil.updateUserDetail(this);
        }
    }
}
