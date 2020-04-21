package net.evrem.service.service.base;

import net.evrem.service.service.UserEvremLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Zdenek Vecek
 * @generated
 */
public class UserEvremLocalServiceClpInvoker {
    private String _methodName34;
    private String[] _methodParameterTypes34;
    private String _methodName35;
    private String[] _methodParameterTypes35;
    private String _methodName38;
    private String[] _methodParameterTypes38;
    private String _methodName39;
    private String[] _methodParameterTypes39;

    public UserEvremLocalServiceClpInvoker() {
        _methodName34 = "getBeanIdentifier";

        _methodParameterTypes34 = new String[] {  };

        _methodName35 = "setBeanIdentifier";

        _methodParameterTypes35 = new String[] { "java.lang.String" };

        _methodName38 = "getUserForm";

        _methodParameterTypes38 = new String[] { "java.lang.Long" };

        _methodName39 = "saveUser";

        _methodParameterTypes39 = new String[] {
                "net.evrem.dtos.form.UserForm", "java.lang.Long"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName34.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes34, parameterTypes)) {
            return UserEvremLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName35.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes35, parameterTypes)) {
            UserEvremLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName38.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes38, parameterTypes)) {
            return UserEvremLocalServiceUtil.getUserForm((java.lang.Long) arguments[0]);
        }

        if (_methodName39.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes39, parameterTypes)) {
            UserEvremLocalServiceUtil.saveUser((net.evrem.dtos.form.UserForm) arguments[0],
                (java.lang.Long) arguments[1]);

            return null;
        }

        throw new UnsupportedOperationException();
    }
}
