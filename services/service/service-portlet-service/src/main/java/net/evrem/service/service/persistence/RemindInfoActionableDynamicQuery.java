package net.evrem.service.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import net.evrem.service.model.RemindInfo;
import net.evrem.service.service.RemindInfoLocalServiceUtil;

/**
 * @author Zdenek Vecek
 * @generated
 */
public abstract class RemindInfoActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public RemindInfoActionableDynamicQuery() throws SystemException {
        setBaseLocalService(RemindInfoLocalServiceUtil.getService());
        setClass(RemindInfo.class);

        setClassLoader(net.evrem.service.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("remindInfoId");
    }
}
