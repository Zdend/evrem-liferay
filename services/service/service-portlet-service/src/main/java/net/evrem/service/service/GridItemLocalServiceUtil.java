package net.evrem.service.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for GridItem. This utility wraps
 * {@link net.evrem.service.service.impl.GridItemLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Zdenek Vecek
 * @see GridItemLocalService
 * @see net.evrem.service.service.base.GridItemLocalServiceBaseImpl
 * @see net.evrem.service.service.impl.GridItemLocalServiceImpl
 * @generated
 */
public class GridItemLocalServiceUtil {
    private static GridItemLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link net.evrem.service.service.impl.GridItemLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the grid item to the database. Also notifies the appropriate model listeners.
    *
    * @param gridItem the grid item
    * @return the grid item that was added
    * @throws SystemException if a system exception occurred
    */
    public static net.evrem.service.model.GridItem addGridItem(
        net.evrem.service.model.GridItem gridItem)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addGridItem(gridItem);
    }

    /**
    * Creates a new grid item with the primary key. Does not add the grid item to the database.
    *
    * @param gridItemId the primary key for the new grid item
    * @return the new grid item
    */
    public static net.evrem.service.model.GridItem createGridItem(
        long gridItemId) {
        return getService().createGridItem(gridItemId);
    }

    /**
    * Deletes the grid item with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param gridItemId the primary key of the grid item
    * @return the grid item that was removed
    * @throws PortalException if a grid item with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.evrem.service.model.GridItem deleteGridItem(
        long gridItemId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteGridItem(gridItemId);
    }

    /**
    * Deletes the grid item from the database. Also notifies the appropriate model listeners.
    *
    * @param gridItem the grid item
    * @return the grid item that was removed
    * @throws SystemException if a system exception occurred
    */
    public static net.evrem.service.model.GridItem deleteGridItem(
        net.evrem.service.model.GridItem gridItem)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteGridItem(gridItem);
    }

    public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return getService().dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.evrem.service.model.impl.GridItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.evrem.service.model.impl.GridItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery, projection);
    }

    public static net.evrem.service.model.GridItem fetchGridItem(
        long gridItemId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchGridItem(gridItemId);
    }

    /**
    * Returns the grid item with the primary key.
    *
    * @param gridItemId the primary key of the grid item
    * @return the grid item
    * @throws PortalException if a grid item with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.evrem.service.model.GridItem getGridItem(long gridItemId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getGridItem(gridItemId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the grid items.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.evrem.service.model.impl.GridItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of grid items
    * @param end the upper bound of the range of grid items (not inclusive)
    * @return the range of grid items
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<net.evrem.service.model.GridItem> getGridItems(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getGridItems(start, end);
    }

    /**
    * Returns the number of grid items.
    *
    * @return the number of grid items
    * @throws SystemException if a system exception occurred
    */
    public static int getGridItemsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getGridItemsCount();
    }

    /**
    * Updates the grid item in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param gridItem the grid item
    * @return the grid item that was updated
    * @throws SystemException if a system exception occurred
    */
    public static net.evrem.service.model.GridItem updateGridItem(
        net.evrem.service.model.GridItem gridItem)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateGridItem(gridItem);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    public static net.evrem.service.model.GridItem createGridItem()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().createGridItem();
    }

    public static void saveGridItem(net.evrem.dtos.form.GridItemForm gridForm,
        java.lang.Long noteId) throws java.lang.Exception {
        getService().saveGridItem(gridForm, noteId);
    }

    public static net.evrem.dtos.form.GridItemForm getGridItemByNoteId(
        java.lang.Long noteId) throws java.lang.Exception {
        return getService().getGridItemByNoteId(noteId);
    }

    public static void deleteByNoteId(java.lang.Long noteId)
        throws java.lang.Exception {
        getService().deleteByNoteId(noteId);
    }

    public static void saveCoordinates(
        net.evrem.dtos.dto.CoordinatesDto coordinates, java.lang.Long userId)
        throws java.lang.Exception {
        getService().saveCoordinates(coordinates, userId);
    }

    public static void clearService() {
        _service = null;
    }

    public static GridItemLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    GridItemLocalService.class.getName());

            if (invokableLocalService instanceof GridItemLocalService) {
                _service = (GridItemLocalService) invokableLocalService;
            } else {
                _service = new GridItemLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(GridItemLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(GridItemLocalService service) {
    }
}
