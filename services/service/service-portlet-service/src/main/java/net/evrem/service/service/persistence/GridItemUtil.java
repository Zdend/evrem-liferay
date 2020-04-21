package net.evrem.service.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import net.evrem.service.model.GridItem;

import java.util.List;

/**
 * The persistence utility for the grid item service. This utility wraps {@link GridItemPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Zdenek Vecek
 * @see GridItemPersistence
 * @see GridItemPersistenceImpl
 * @generated
 */
public class GridItemUtil {
    private static GridItemPersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(GridItem gridItem) {
        getPersistence().clearCache(gridItem);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<GridItem> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<GridItem> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<GridItem> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static GridItem update(GridItem gridItem) throws SystemException {
        return getPersistence().update(gridItem);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static GridItem update(GridItem gridItem,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(gridItem, serviceContext);
    }

    /**
    * Returns the grid item where noteId = &#63; or throws a {@link net.evrem.service.NoSuchGridItemException} if it could not be found.
    *
    * @param noteId the note ID
    * @return the matching grid item
    * @throws net.evrem.service.NoSuchGridItemException if a matching grid item could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.evrem.service.model.GridItem findByNoteId(long noteId)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchGridItemException {
        return getPersistence().findByNoteId(noteId);
    }

    /**
    * Returns the grid item where noteId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param noteId the note ID
    * @return the matching grid item, or <code>null</code> if a matching grid item could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.evrem.service.model.GridItem fetchByNoteId(long noteId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByNoteId(noteId);
    }

    /**
    * Returns the grid item where noteId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param noteId the note ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching grid item, or <code>null</code> if a matching grid item could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.evrem.service.model.GridItem fetchByNoteId(long noteId,
        boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByNoteId(noteId, retrieveFromCache);
    }

    /**
    * Removes the grid item where noteId = &#63; from the database.
    *
    * @param noteId the note ID
    * @return the grid item that was removed
    * @throws SystemException if a system exception occurred
    */
    public static net.evrem.service.model.GridItem removeByNoteId(long noteId)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchGridItemException {
        return getPersistence().removeByNoteId(noteId);
    }

    /**
    * Returns the number of grid items where noteId = &#63;.
    *
    * @param noteId the note ID
    * @return the number of matching grid items
    * @throws SystemException if a system exception occurred
    */
    public static int countByNoteId(long noteId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByNoteId(noteId);
    }

    /**
    * Caches the grid item in the entity cache if it is enabled.
    *
    * @param gridItem the grid item
    */
    public static void cacheResult(net.evrem.service.model.GridItem gridItem) {
        getPersistence().cacheResult(gridItem);
    }

    /**
    * Caches the grid items in the entity cache if it is enabled.
    *
    * @param gridItems the grid items
    */
    public static void cacheResult(
        java.util.List<net.evrem.service.model.GridItem> gridItems) {
        getPersistence().cacheResult(gridItems);
    }

    /**
    * Creates a new grid item with the primary key. Does not add the grid item to the database.
    *
    * @param gridItemId the primary key for the new grid item
    * @return the new grid item
    */
    public static net.evrem.service.model.GridItem create(long gridItemId) {
        return getPersistence().create(gridItemId);
    }

    /**
    * Removes the grid item with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param gridItemId the primary key of the grid item
    * @return the grid item that was removed
    * @throws net.evrem.service.NoSuchGridItemException if a grid item with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.evrem.service.model.GridItem remove(long gridItemId)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchGridItemException {
        return getPersistence().remove(gridItemId);
    }

    public static net.evrem.service.model.GridItem updateImpl(
        net.evrem.service.model.GridItem gridItem)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(gridItem);
    }

    /**
    * Returns the grid item with the primary key or throws a {@link net.evrem.service.NoSuchGridItemException} if it could not be found.
    *
    * @param gridItemId the primary key of the grid item
    * @return the grid item
    * @throws net.evrem.service.NoSuchGridItemException if a grid item with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.evrem.service.model.GridItem findByPrimaryKey(
        long gridItemId)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchGridItemException {
        return getPersistence().findByPrimaryKey(gridItemId);
    }

    /**
    * Returns the grid item with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param gridItemId the primary key of the grid item
    * @return the grid item, or <code>null</code> if a grid item with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.evrem.service.model.GridItem fetchByPrimaryKey(
        long gridItemId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(gridItemId);
    }

    /**
    * Returns all the grid items.
    *
    * @return the grid items
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<net.evrem.service.model.GridItem> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<net.evrem.service.model.GridItem> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the grid items.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.evrem.service.model.impl.GridItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of grid items
    * @param end the upper bound of the range of grid items (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of grid items
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<net.evrem.service.model.GridItem> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the grid items from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of grid items.
    *
    * @return the number of grid items
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static GridItemPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (GridItemPersistence) PortletBeanLocatorUtil.locate(net.evrem.service.service.ClpSerializer.getServletContextName(),
                    GridItemPersistence.class.getName());

            ReferenceRegistry.registerReference(GridItemUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(GridItemPersistence persistence) {
    }
}
