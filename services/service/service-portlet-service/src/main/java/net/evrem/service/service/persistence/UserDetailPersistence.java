package net.evrem.service.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import net.evrem.service.model.UserDetail;

/**
 * The persistence interface for the user detail service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Zdenek Vecek
 * @see UserDetailPersistenceImpl
 * @see UserDetailUtil
 * @generated
 */
public interface UserDetailPersistence extends BasePersistence<UserDetail> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link UserDetailUtil} to access the user detail persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns the user detail where userId = &#63; or throws a {@link net.evrem.service.NoSuchUserDetailException} if it could not be found.
    *
    * @param userId the user ID
    * @return the matching user detail
    * @throws net.evrem.service.NoSuchUserDetailException if a matching user detail could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.evrem.service.model.UserDetail findByUserId(long userId)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchUserDetailException;

    /**
    * Returns the user detail where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param userId the user ID
    * @return the matching user detail, or <code>null</code> if a matching user detail could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.evrem.service.model.UserDetail fetchByUserId(long userId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the user detail where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param userId the user ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching user detail, or <code>null</code> if a matching user detail could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.evrem.service.model.UserDetail fetchByUserId(long userId,
        boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the user detail where userId = &#63; from the database.
    *
    * @param userId the user ID
    * @return the user detail that was removed
    * @throws SystemException if a system exception occurred
    */
    public net.evrem.service.model.UserDetail removeByUserId(long userId)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchUserDetailException;

    /**
    * Returns the number of user details where userId = &#63;.
    *
    * @param userId the user ID
    * @return the number of matching user details
    * @throws SystemException if a system exception occurred
    */
    public int countByUserId(long userId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the user detail in the entity cache if it is enabled.
    *
    * @param userDetail the user detail
    */
    public void cacheResult(net.evrem.service.model.UserDetail userDetail);

    /**
    * Caches the user details in the entity cache if it is enabled.
    *
    * @param userDetails the user details
    */
    public void cacheResult(
        java.util.List<net.evrem.service.model.UserDetail> userDetails);

    /**
    * Creates a new user detail with the primary key. Does not add the user detail to the database.
    *
    * @param userDetailId the primary key for the new user detail
    * @return the new user detail
    */
    public net.evrem.service.model.UserDetail create(long userDetailId);

    /**
    * Removes the user detail with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param userDetailId the primary key of the user detail
    * @return the user detail that was removed
    * @throws net.evrem.service.NoSuchUserDetailException if a user detail with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.evrem.service.model.UserDetail remove(long userDetailId)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchUserDetailException;

    public net.evrem.service.model.UserDetail updateImpl(
        net.evrem.service.model.UserDetail userDetail)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the user detail with the primary key or throws a {@link net.evrem.service.NoSuchUserDetailException} if it could not be found.
    *
    * @param userDetailId the primary key of the user detail
    * @return the user detail
    * @throws net.evrem.service.NoSuchUserDetailException if a user detail with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.evrem.service.model.UserDetail findByPrimaryKey(
        long userDetailId)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchUserDetailException;

    /**
    * Returns the user detail with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param userDetailId the primary key of the user detail
    * @return the user detail, or <code>null</code> if a user detail with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.evrem.service.model.UserDetail fetchByPrimaryKey(
        long userDetailId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the user details.
    *
    * @return the user details
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<net.evrem.service.model.UserDetail> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the user details.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.evrem.service.model.impl.UserDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of user details
    * @param end the upper bound of the range of user details (not inclusive)
    * @return the range of user details
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<net.evrem.service.model.UserDetail> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the user details.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.evrem.service.model.impl.UserDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of user details
    * @param end the upper bound of the range of user details (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of user details
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<net.evrem.service.model.UserDetail> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the user details from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of user details.
    *
    * @return the number of user details
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
