package net.evrem.service.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import net.evrem.service.model.UserDetail;
import net.evrem.service.service.UserDetailLocalServiceUtil;

/**
 * @author Zdenek Vecek
 * @generated
 */
public abstract class UserDetailActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public UserDetailActionableDynamicQuery() throws SystemException {
        setBaseLocalService(UserDetailLocalServiceUtil.getService());
        setClass(UserDetail.class);

        setClassLoader(net.evrem.service.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("userDetailId");
    }
}
