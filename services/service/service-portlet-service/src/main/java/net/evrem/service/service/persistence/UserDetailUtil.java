package net.evrem.service.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import net.evrem.service.model.UserDetail;

import java.util.List;

/**
 * The persistence utility for the user detail service. This utility wraps {@link UserDetailPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Zdenek Vecek
 * @see UserDetailPersistence
 * @see UserDetailPersistenceImpl
 * @generated
 */
public class UserDetailUtil {
    private static UserDetailPersistence _persistence;

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
    public static void clearCache(UserDetail userDetail) {
        getPersistence().clearCache(userDetail);
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
    public static List<UserDetail> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<UserDetail> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<UserDetail> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static UserDetail update(UserDetail userDetail)
        throws SystemException {
        return getPersistence().update(userDetail);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static UserDetail update(UserDetail userDetail,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(userDetail, serviceContext);
    }

    /**
    * Returns the user detail where userId = &#63; or throws a {@link net.evrem.service.NoSuchUserDetailException} if it could not be found.
    *
    * @param userId the user ID
    * @return the matching user detail
    * @throws net.evrem.service.NoSuchUserDetailException if a matching user detail could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.evrem.service.model.UserDetail findByUserId(long userId)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchUserDetailException {
        return getPersistence().findByUserId(userId);
    }

    /**
    * Returns the user detail where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param userId the user ID
    * @return the matching user detail, or <code>null</code> if a matching user detail could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.evrem.service.model.UserDetail fetchByUserId(long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUserId(userId);
    }

    /**
    * Returns the user detail where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param userId the user ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching user detail, or <code>null</code> if a matching user detail could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.evrem.service.model.UserDetail fetchByUserId(
        long userId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUserId(userId, retrieveFromCache);
    }

    /**
    * Removes the user detail where userId = &#63; from the database.
    *
    * @param userId the user ID
    * @return the user detail that was removed
    * @throws SystemException if a system exception occurred
    */
    public static net.evrem.service.model.UserDetail removeByUserId(long userId)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchUserDetailException {
        return getPersistence().removeByUserId(userId);
    }

    /**
    * Returns the number of user details where userId = &#63;.
    *
    * @param userId the user ID
    * @return the number of matching user details
    * @throws SystemException if a system exception occurred
    */
    public static int countByUserId(long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUserId(userId);
    }

    /**
    * Caches the user detail in the entity cache if it is enabled.
    *
    * @param userDetail the user detail
    */
    public static void cacheResult(
        net.evrem.service.model.UserDetail userDetail) {
        getPersistence().cacheResult(userDetail);
    }

    /**
    * Caches the user details in the entity cache if it is enabled.
    *
    * @param userDetails the user details
    */
    public static void cacheResult(
        java.util.List<net.evrem.service.model.UserDetail> userDetails) {
        getPersistence().cacheResult(userDetails);
    }

    /**
    * Creates a new user detail with the primary key. Does not add the user detail to the database.
    *
    * @param userDetailId the primary key for the new user detail
    * @return the new user detail
    */
    public static net.evrem.service.model.UserDetail create(long userDetailId) {
        return getPersistence().create(userDetailId);
    }

    /**
    * Removes the user detail with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param userDetailId the primary key of the user detail
    * @return the user detail that was removed
    * @throws net.evrem.service.NoSuchUserDetailException if a user detail with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.evrem.service.model.UserDetail remove(long userDetailId)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchUserDetailException {
        return getPersistence().remove(userDetailId);
    }

    public static net.evrem.service.model.UserDetail updateImpl(
        net.evrem.service.model.UserDetail userDetail)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(userDetail);
    }

    /**
    * Returns the user detail with the primary key or throws a {@link net.evrem.service.NoSuchUserDetailException} if it could not be found.
    *
    * @param userDetailId the primary key of the user detail
    * @return the user detail
    * @throws net.evrem.service.NoSuchUserDetailException if a user detail with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.evrem.service.model.UserDetail findByPrimaryKey(
        long userDetailId)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchUserDetailException {
        return getPersistence().findByPrimaryKey(userDetailId);
    }

    /**
    * Returns the user detail with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param userDetailId the primary key of the user detail
    * @return the user detail, or <code>null</code> if a user detail with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.evrem.service.model.UserDetail fetchByPrimaryKey(
        long userDetailId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(userDetailId);
    }

    /**
    * Returns all the user details.
    *
    * @return the user details
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<net.evrem.service.model.UserDetail> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

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
    public static java.util.List<net.evrem.service.model.UserDetail> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

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
    public static java.util.List<net.evrem.service.model.UserDetail> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the user details from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of user details.
    *
    * @return the number of user details
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static UserDetailPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (UserDetailPersistence) PortletBeanLocatorUtil.locate(net.evrem.service.service.ClpSerializer.getServletContextName(),
                    UserDetailPersistence.class.getName());

            ReferenceRegistry.registerReference(UserDetailUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(UserDetailPersistence persistence) {
    }
}
