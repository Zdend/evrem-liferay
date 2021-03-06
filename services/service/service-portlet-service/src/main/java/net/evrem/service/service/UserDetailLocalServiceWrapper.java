package net.evrem.service.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link UserDetailLocalService}.
 *
 * @author Zdenek Vecek
 * @see UserDetailLocalService
 * @generated
 */
public class UserDetailLocalServiceWrapper implements UserDetailLocalService,
    ServiceWrapper<UserDetailLocalService> {
    private UserDetailLocalService _userDetailLocalService;

    public UserDetailLocalServiceWrapper(
        UserDetailLocalService userDetailLocalService) {
        _userDetailLocalService = userDetailLocalService;
    }

    /**
    * Adds the user detail to the database. Also notifies the appropriate model listeners.
    *
    * @param userDetail the user detail
    * @return the user detail that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public net.evrem.service.model.UserDetail addUserDetail(
        net.evrem.service.model.UserDetail userDetail)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _userDetailLocalService.addUserDetail(userDetail);
    }

    /**
    * Creates a new user detail with the primary key. Does not add the user detail to the database.
    *
    * @param userDetailId the primary key for the new user detail
    * @return the new user detail
    */
    @Override
    public net.evrem.service.model.UserDetail createUserDetail(
        long userDetailId) {
        return _userDetailLocalService.createUserDetail(userDetailId);
    }

    /**
    * Deletes the user detail with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param userDetailId the primary key of the user detail
    * @return the user detail that was removed
    * @throws PortalException if a user detail with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public net.evrem.service.model.UserDetail deleteUserDetail(
        long userDetailId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _userDetailLocalService.deleteUserDetail(userDetailId);
    }

    /**
    * Deletes the user detail from the database. Also notifies the appropriate model listeners.
    *
    * @param userDetail the user detail
    * @return the user detail that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public net.evrem.service.model.UserDetail deleteUserDetail(
        net.evrem.service.model.UserDetail userDetail)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _userDetailLocalService.deleteUserDetail(userDetail);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _userDetailLocalService.dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _userDetailLocalService.dynamicQuery(dynamicQuery);
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
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _userDetailLocalService.dynamicQuery(dynamicQuery, start, end);
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
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _userDetailLocalService.dynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _userDetailLocalService.dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _userDetailLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public net.evrem.service.model.UserDetail fetchUserDetail(long userDetailId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _userDetailLocalService.fetchUserDetail(userDetailId);
    }

    /**
    * Returns the user detail with the primary key.
    *
    * @param userDetailId the primary key of the user detail
    * @return the user detail
    * @throws PortalException if a user detail with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public net.evrem.service.model.UserDetail getUserDetail(long userDetailId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _userDetailLocalService.getUserDetail(userDetailId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _userDetailLocalService.getPersistedModel(primaryKeyObj);
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
    @Override
    public java.util.List<net.evrem.service.model.UserDetail> getUserDetails(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _userDetailLocalService.getUserDetails(start, end);
    }

    /**
    * Returns the number of user details.
    *
    * @return the number of user details
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getUserDetailsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _userDetailLocalService.getUserDetailsCount();
    }

    /**
    * Updates the user detail in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param userDetail the user detail
    * @return the user detail that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public net.evrem.service.model.UserDetail updateUserDetail(
        net.evrem.service.model.UserDetail userDetail)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _userDetailLocalService.updateUserDetail(userDetail);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _userDetailLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _userDetailLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _userDetailLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public net.evrem.service.model.UserDetail createUserDetails(
        java.lang.Long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _userDetailLocalService.createUserDetails(userId);
    }

    @Override
    public void saveUserDetail(net.evrem.dtos.form.UserForm userDetailForm)
        throws java.lang.Exception {
        _userDetailLocalService.saveUserDetail(userDetailForm);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public UserDetailLocalService getWrappedUserDetailLocalService() {
        return _userDetailLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedUserDetailLocalService(
        UserDetailLocalService userDetailLocalService) {
        _userDetailLocalService = userDetailLocalService;
    }

    @Override
    public UserDetailLocalService getWrappedService() {
        return _userDetailLocalService;
    }

    @Override
    public void setWrappedService(UserDetailLocalService userDetailLocalService) {
        _userDetailLocalService = userDetailLocalService;
    }
}
