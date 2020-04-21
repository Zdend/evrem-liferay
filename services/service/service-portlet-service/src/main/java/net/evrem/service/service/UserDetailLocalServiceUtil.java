package net.evrem.service.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for UserDetail. This utility wraps
 * {@link net.evrem.service.service.impl.UserDetailLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Zdenek Vecek
 * @see UserDetailLocalService
 * @see net.evrem.service.service.base.UserDetailLocalServiceBaseImpl
 * @see net.evrem.service.service.impl.UserDetailLocalServiceImpl
 * @generated
 */
public class UserDetailLocalServiceUtil {
    private static UserDetailLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link net.evrem.service.service.impl.UserDetailLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the user detail to the database. Also notifies the appropriate model listeners.
    *
    * @param userDetail the user detail
    * @return the user detail that was added
    * @throws SystemException if a system exception occurred
    */
    public static net.evrem.service.model.UserDetail addUserDetail(
        net.evrem.service.model.UserDetail userDetail)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addUserDetail(userDetail);
    }

    /**
    * Creates a new user detail with the primary key. Does not add the user detail to the database.
    *
    * @param userDetailId the primary key for the new user detail
    * @return the new user detail
    */
    public static net.evrem.service.model.UserDetail createUserDetail(
        long userDetailId) {
        return getService().createUserDetail(userDetailId);
    }

    /**
    * Deletes the user detail with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param userDetailId the primary key of the user detail
    * @return the user detail that was removed
    * @throws PortalException if a user detail with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.evrem.service.model.UserDetail deleteUserDetail(
        long userDetailId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteUserDetail(userDetailId);
    }

    /**
    * Deletes the user detail from the database. Also notifies the appropriate model listeners.
    *
    * @param userDetail the user detail
    * @return the user detail that was removed
    * @throws SystemException if a system exception occurred
    */
    public static net.evrem.service.model.UserDetail deleteUserDetail(
        net.evrem.service.model.UserDetail userDetail)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteUserDetail(userDetail);
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.evrem.service.model.impl.UserDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.evrem.service.model.impl.UserDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

    public static net.evrem.service.model.UserDetail fetchUserDetail(
        long userDetailId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchUserDetail(userDetailId);
    }

    /**
    * Returns the user detail with the primary key.
    *
    * @param userDetailId the primary key of the user detail
    * @return the user detail
    * @throws PortalException if a user detail with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.evrem.service.model.UserDetail getUserDetail(
        long userDetailId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getUserDetail(userDetailId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
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
    public static java.util.List<net.evrem.service.model.UserDetail> getUserDetails(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getUserDetails(start, end);
    }

    /**
    * Returns the number of user details.
    *
    * @return the number of user details
    * @throws SystemException if a system exception occurred
    */
    public static int getUserDetailsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getUserDetailsCount();
    }

    /**
    * Updates the user detail in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param userDetail the user detail
    * @return the user detail that was updated
    * @throws SystemException if a system exception occurred
    */
    public static net.evrem.service.model.UserDetail updateUserDetail(
        net.evrem.service.model.UserDetail userDetail)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateUserDetail(userDetail);
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

    public static net.evrem.service.model.UserDetail createUserDetails(
        java.lang.Long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().createUserDetails(userId);
    }

    public static void saveUserDetail(
        net.evrem.dtos.form.UserForm userDetailForm) throws java.lang.Exception {
        getService().saveUserDetail(userDetailForm);
    }

    public static void clearService() {
        _service = null;
    }

    public static UserDetailLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    UserDetailLocalService.class.getName());

            if (invokableLocalService instanceof UserDetailLocalService) {
                _service = (UserDetailLocalService) invokableLocalService;
            } else {
                _service = new UserDetailLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(UserDetailLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(UserDetailLocalService service) {
    }
}
