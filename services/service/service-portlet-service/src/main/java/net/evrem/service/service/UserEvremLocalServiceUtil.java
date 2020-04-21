package net.evrem.service.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for UserEvrem. This utility wraps
 * {@link net.evrem.service.service.impl.UserEvremLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Zdenek Vecek
 * @see UserEvremLocalService
 * @see net.evrem.service.service.base.UserEvremLocalServiceBaseImpl
 * @see net.evrem.service.service.impl.UserEvremLocalServiceImpl
 * @generated
 */
public class UserEvremLocalServiceUtil {
    private static UserEvremLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link net.evrem.service.service.impl.UserEvremLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

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

    public static net.evrem.dtos.form.UserForm getUserForm(
        java.lang.Long userId) throws java.lang.Exception {
        return getService().getUserForm(userId);
    }

    public static void saveUser(net.evrem.dtos.form.UserForm userForm,
        java.lang.Long userId) throws java.lang.Exception {
        getService().saveUser(userForm, userId);
    }

    public static void clearService() {
        _service = null;
    }

    public static UserEvremLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    UserEvremLocalService.class.getName());

            if (invokableLocalService instanceof UserEvremLocalService) {
                _service = (UserEvremLocalService) invokableLocalService;
            } else {
                _service = new UserEvremLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(UserEvremLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(UserEvremLocalService service) {
    }
}
