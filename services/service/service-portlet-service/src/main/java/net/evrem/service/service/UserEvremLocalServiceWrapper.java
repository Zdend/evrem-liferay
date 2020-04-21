package net.evrem.service.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link UserEvremLocalService}.
 *
 * @author Zdenek Vecek
 * @see UserEvremLocalService
 * @generated
 */
public class UserEvremLocalServiceWrapper implements UserEvremLocalService,
    ServiceWrapper<UserEvremLocalService> {
    private UserEvremLocalService _userEvremLocalService;

    public UserEvremLocalServiceWrapper(
        UserEvremLocalService userEvremLocalService) {
        _userEvremLocalService = userEvremLocalService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _userEvremLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _userEvremLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _userEvremLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public net.evrem.dtos.form.UserForm getUserForm(java.lang.Long userId)
        throws java.lang.Exception {
        return _userEvremLocalService.getUserForm(userId);
    }

    @Override
    public void saveUser(net.evrem.dtos.form.UserForm userForm,
        java.lang.Long userId) throws java.lang.Exception {
        _userEvremLocalService.saveUser(userForm, userId);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public UserEvremLocalService getWrappedUserEvremLocalService() {
        return _userEvremLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedUserEvremLocalService(
        UserEvremLocalService userEvremLocalService) {
        _userEvremLocalService = userEvremLocalService;
    }

    @Override
    public UserEvremLocalService getWrappedService() {
        return _userEvremLocalService;
    }

    @Override
    public void setWrappedService(UserEvremLocalService userEvremLocalService) {
        _userEvremLocalService = userEvremLocalService;
    }
}
