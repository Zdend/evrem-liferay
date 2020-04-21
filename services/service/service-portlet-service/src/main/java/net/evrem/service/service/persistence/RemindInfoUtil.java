package net.evrem.service.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import net.evrem.service.model.RemindInfo;

import java.util.List;

/**
 * The persistence utility for the remind info service. This utility wraps {@link RemindInfoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Zdenek Vecek
 * @see RemindInfoPersistence
 * @see RemindInfoPersistenceImpl
 * @generated
 */
public class RemindInfoUtil {
    private static RemindInfoPersistence _persistence;

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
    public static void clearCache(RemindInfo remindInfo) {
        getPersistence().clearCache(remindInfo);
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
    public static List<RemindInfo> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<RemindInfo> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<RemindInfo> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static RemindInfo update(RemindInfo remindInfo)
        throws SystemException {
        return getPersistence().update(remindInfo);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static RemindInfo update(RemindInfo remindInfo,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(remindInfo, serviceContext);
    }

    /**
    * Returns the remind info where noteId = &#63; or throws a {@link net.evrem.service.NoSuchRemindInfoException} if it could not be found.
    *
    * @param noteId the note ID
    * @return the matching remind info
    * @throws net.evrem.service.NoSuchRemindInfoException if a matching remind info could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.evrem.service.model.RemindInfo findByNoteId(long noteId)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchRemindInfoException {
        return getPersistence().findByNoteId(noteId);
    }

    /**
    * Returns the remind info where noteId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param noteId the note ID
    * @return the matching remind info, or <code>null</code> if a matching remind info could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.evrem.service.model.RemindInfo fetchByNoteId(long noteId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByNoteId(noteId);
    }

    /**
    * Returns the remind info where noteId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param noteId the note ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching remind info, or <code>null</code> if a matching remind info could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.evrem.service.model.RemindInfo fetchByNoteId(
        long noteId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByNoteId(noteId, retrieveFromCache);
    }

    /**
    * Removes the remind info where noteId = &#63; from the database.
    *
    * @param noteId the note ID
    * @return the remind info that was removed
    * @throws SystemException if a system exception occurred
    */
    public static net.evrem.service.model.RemindInfo removeByNoteId(long noteId)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchRemindInfoException {
        return getPersistence().removeByNoteId(noteId);
    }

    /**
    * Returns the number of remind infos where noteId = &#63;.
    *
    * @param noteId the note ID
    * @return the number of matching remind infos
    * @throws SystemException if a system exception occurred
    */
    public static int countByNoteId(long noteId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByNoteId(noteId);
    }

    /**
    * Caches the remind info in the entity cache if it is enabled.
    *
    * @param remindInfo the remind info
    */
    public static void cacheResult(
        net.evrem.service.model.RemindInfo remindInfo) {
        getPersistence().cacheResult(remindInfo);
    }

    /**
    * Caches the remind infos in the entity cache if it is enabled.
    *
    * @param remindInfos the remind infos
    */
    public static void cacheResult(
        java.util.List<net.evrem.service.model.RemindInfo> remindInfos) {
        getPersistence().cacheResult(remindInfos);
    }

    /**
    * Creates a new remind info with the primary key. Does not add the remind info to the database.
    *
    * @param remindInfoId the primary key for the new remind info
    * @return the new remind info
    */
    public static net.evrem.service.model.RemindInfo create(long remindInfoId) {
        return getPersistence().create(remindInfoId);
    }

    /**
    * Removes the remind info with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param remindInfoId the primary key of the remind info
    * @return the remind info that was removed
    * @throws net.evrem.service.NoSuchRemindInfoException if a remind info with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.evrem.service.model.RemindInfo remove(long remindInfoId)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchRemindInfoException {
        return getPersistence().remove(remindInfoId);
    }

    public static net.evrem.service.model.RemindInfo updateImpl(
        net.evrem.service.model.RemindInfo remindInfo)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(remindInfo);
    }

    /**
    * Returns the remind info with the primary key or throws a {@link net.evrem.service.NoSuchRemindInfoException} if it could not be found.
    *
    * @param remindInfoId the primary key of the remind info
    * @return the remind info
    * @throws net.evrem.service.NoSuchRemindInfoException if a remind info with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.evrem.service.model.RemindInfo findByPrimaryKey(
        long remindInfoId)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchRemindInfoException {
        return getPersistence().findByPrimaryKey(remindInfoId);
    }

    /**
    * Returns the remind info with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param remindInfoId the primary key of the remind info
    * @return the remind info, or <code>null</code> if a remind info with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.evrem.service.model.RemindInfo fetchByPrimaryKey(
        long remindInfoId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(remindInfoId);
    }

    /**
    * Returns all the remind infos.
    *
    * @return the remind infos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<net.evrem.service.model.RemindInfo> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the remind infos.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.evrem.service.model.impl.RemindInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of remind infos
    * @param end the upper bound of the range of remind infos (not inclusive)
    * @return the range of remind infos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<net.evrem.service.model.RemindInfo> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the remind infos.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.evrem.service.model.impl.RemindInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of remind infos
    * @param end the upper bound of the range of remind infos (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of remind infos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<net.evrem.service.model.RemindInfo> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the remind infos from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of remind infos.
    *
    * @return the number of remind infos
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static RemindInfoPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (RemindInfoPersistence) PortletBeanLocatorUtil.locate(net.evrem.service.service.ClpSerializer.getServletContextName(),
                    RemindInfoPersistence.class.getName());

            ReferenceRegistry.registerReference(RemindInfoUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(RemindInfoPersistence persistence) {
    }
}
