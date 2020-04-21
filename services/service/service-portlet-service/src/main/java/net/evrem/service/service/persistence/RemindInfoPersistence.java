package net.evrem.service.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import net.evrem.service.model.RemindInfo;

/**
 * The persistence interface for the remind info service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Zdenek Vecek
 * @see RemindInfoPersistenceImpl
 * @see RemindInfoUtil
 * @generated
 */
public interface RemindInfoPersistence extends BasePersistence<RemindInfo> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link RemindInfoUtil} to access the remind info persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns the remind info where noteId = &#63; or throws a {@link net.evrem.service.NoSuchRemindInfoException} if it could not be found.
    *
    * @param noteId the note ID
    * @return the matching remind info
    * @throws net.evrem.service.NoSuchRemindInfoException if a matching remind info could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.evrem.service.model.RemindInfo findByNoteId(long noteId)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchRemindInfoException;

    /**
    * Returns the remind info where noteId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param noteId the note ID
    * @return the matching remind info, or <code>null</code> if a matching remind info could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.evrem.service.model.RemindInfo fetchByNoteId(long noteId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the remind info where noteId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param noteId the note ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching remind info, or <code>null</code> if a matching remind info could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.evrem.service.model.RemindInfo fetchByNoteId(long noteId,
        boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the remind info where noteId = &#63; from the database.
    *
    * @param noteId the note ID
    * @return the remind info that was removed
    * @throws SystemException if a system exception occurred
    */
    public net.evrem.service.model.RemindInfo removeByNoteId(long noteId)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchRemindInfoException;

    /**
    * Returns the number of remind infos where noteId = &#63;.
    *
    * @param noteId the note ID
    * @return the number of matching remind infos
    * @throws SystemException if a system exception occurred
    */
    public int countByNoteId(long noteId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the remind info in the entity cache if it is enabled.
    *
    * @param remindInfo the remind info
    */
    public void cacheResult(net.evrem.service.model.RemindInfo remindInfo);

    /**
    * Caches the remind infos in the entity cache if it is enabled.
    *
    * @param remindInfos the remind infos
    */
    public void cacheResult(
        java.util.List<net.evrem.service.model.RemindInfo> remindInfos);

    /**
    * Creates a new remind info with the primary key. Does not add the remind info to the database.
    *
    * @param remindInfoId the primary key for the new remind info
    * @return the new remind info
    */
    public net.evrem.service.model.RemindInfo create(long remindInfoId);

    /**
    * Removes the remind info with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param remindInfoId the primary key of the remind info
    * @return the remind info that was removed
    * @throws net.evrem.service.NoSuchRemindInfoException if a remind info with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.evrem.service.model.RemindInfo remove(long remindInfoId)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchRemindInfoException;

    public net.evrem.service.model.RemindInfo updateImpl(
        net.evrem.service.model.RemindInfo remindInfo)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the remind info with the primary key or throws a {@link net.evrem.service.NoSuchRemindInfoException} if it could not be found.
    *
    * @param remindInfoId the primary key of the remind info
    * @return the remind info
    * @throws net.evrem.service.NoSuchRemindInfoException if a remind info with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.evrem.service.model.RemindInfo findByPrimaryKey(
        long remindInfoId)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchRemindInfoException;

    /**
    * Returns the remind info with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param remindInfoId the primary key of the remind info
    * @return the remind info, or <code>null</code> if a remind info with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.evrem.service.model.RemindInfo fetchByPrimaryKey(
        long remindInfoId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the remind infos.
    *
    * @return the remind infos
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<net.evrem.service.model.RemindInfo> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<net.evrem.service.model.RemindInfo> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<net.evrem.service.model.RemindInfo> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the remind infos from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of remind infos.
    *
    * @return the number of remind infos
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
