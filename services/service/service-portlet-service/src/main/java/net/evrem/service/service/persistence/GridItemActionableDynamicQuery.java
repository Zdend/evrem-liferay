package net.evrem.service.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import net.evrem.service.model.GridItem;
import net.evrem.service.service.GridItemLocalServiceUtil;

/**
 * @author Zdenek Vecek
 * @generated
 */
public abstract class GridItemActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public GridItemActionableDynamicQuery() throws SystemException {
        setBaseLocalService(GridItemLocalServiceUtil.getService());
        setClass(GridItem.class);

        setClassLoader(net.evrem.service.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("gridItemId");
    }
}
