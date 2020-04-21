package net.evrem.service.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import net.evrem.service.model.GridItemClp;
import net.evrem.service.model.NoteClp;
import net.evrem.service.model.RemindInfoClp;
import net.evrem.service.model.TodoNoteClp;
import net.evrem.service.model.UserDetailClp;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;


public class ClpSerializer {
    private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
    private static String _servletContextName;
    private static boolean _useReflectionToTranslateThrowable = true;

    public static String getServletContextName() {
        if (Validator.isNotNull(_servletContextName)) {
            return _servletContextName;
        }

        synchronized (ClpSerializer.class) {
            if (Validator.isNotNull(_servletContextName)) {
                return _servletContextName;
            }

            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Class<?> portletPropsClass = classLoader.loadClass(
                        "com.liferay.util.portlet.PortletProps");

                Method getMethod = portletPropsClass.getMethod("get",
                        new Class<?>[] { String.class });

                String portletPropsServletContextName = (String) getMethod.invoke(null,
                        "service-portlet-deployment-context");

                if (Validator.isNotNull(portletPropsServletContextName)) {
                    _servletContextName = portletPropsServletContextName;
                }
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info(
                        "Unable to locate deployment context from portlet properties");
                }
            }

            if (Validator.isNull(_servletContextName)) {
                try {
                    String propsUtilServletContextName = PropsUtil.get(
                            "service-portlet-deployment-context");

                    if (Validator.isNotNull(propsUtilServletContextName)) {
                        _servletContextName = propsUtilServletContextName;
                    }
                } catch (Throwable t) {
                    if (_log.isInfoEnabled()) {
                        _log.info(
                            "Unable to locate deployment context from portal properties");
                    }
                }
            }

            if (Validator.isNull(_servletContextName)) {
                _servletContextName = "service-portlet";
            }

            return _servletContextName;
        }
    }

    public static Object translateInput(BaseModel<?> oldModel) {
        Class<?> oldModelClass = oldModel.getClass();

        String oldModelClassName = oldModelClass.getName();

        if (oldModelClassName.equals(GridItemClp.class.getName())) {
            return translateInputGridItem(oldModel);
        }

        if (oldModelClassName.equals(NoteClp.class.getName())) {
            return translateInputNote(oldModel);
        }

        if (oldModelClassName.equals(RemindInfoClp.class.getName())) {
            return translateInputRemindInfo(oldModel);
        }

        if (oldModelClassName.equals(TodoNoteClp.class.getName())) {
            return translateInputTodoNote(oldModel);
        }

        if (oldModelClassName.equals(UserDetailClp.class.getName())) {
            return translateInputUserDetail(oldModel);
        }

        return oldModel;
    }

    public static Object translateInput(List<Object> oldList) {
        List<Object> newList = new ArrayList<Object>(oldList.size());

        for (int i = 0; i < oldList.size(); i++) {
            Object curObj = oldList.get(i);

            newList.add(translateInput(curObj));
        }

        return newList;
    }

    public static Object translateInputGridItem(BaseModel<?> oldModel) {
        GridItemClp oldClpModel = (GridItemClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getGridItemRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputNote(BaseModel<?> oldModel) {
        NoteClp oldClpModel = (NoteClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getNoteRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputRemindInfo(BaseModel<?> oldModel) {
        RemindInfoClp oldClpModel = (RemindInfoClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getRemindInfoRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputTodoNote(BaseModel<?> oldModel) {
        TodoNoteClp oldClpModel = (TodoNoteClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getTodoNoteRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputUserDetail(BaseModel<?> oldModel) {
        UserDetailClp oldClpModel = (UserDetailClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getUserDetailRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInput(Object obj) {
        if (obj instanceof BaseModel<?>) {
            return translateInput((BaseModel<?>) obj);
        } else if (obj instanceof List<?>) {
            return translateInput((List<Object>) obj);
        } else {
            return obj;
        }
    }

    public static Object translateOutput(BaseModel<?> oldModel) {
        Class<?> oldModelClass = oldModel.getClass();

        String oldModelClassName = oldModelClass.getName();

        if (oldModelClassName.equals(
                    "net.evrem.service.model.impl.GridItemImpl")) {
            return translateOutputGridItem(oldModel);
        }

        if (oldModelClassName.equals("net.evrem.service.model.impl.NoteImpl")) {
            return translateOutputNote(oldModel);
        }

        if (oldModelClassName.equals(
                    "net.evrem.service.model.impl.RemindInfoImpl")) {
            return translateOutputRemindInfo(oldModel);
        }

        if (oldModelClassName.equals(
                    "net.evrem.service.model.impl.TodoNoteImpl")) {
            return translateOutputTodoNote(oldModel);
        }

        if (oldModelClassName.equals(
                    "net.evrem.service.model.impl.UserDetailImpl")) {
            return translateOutputUserDetail(oldModel);
        }

        return oldModel;
    }

    public static Object translateOutput(List<Object> oldList) {
        List<Object> newList = new ArrayList<Object>(oldList.size());

        for (int i = 0; i < oldList.size(); i++) {
            Object curObj = oldList.get(i);

            newList.add(translateOutput(curObj));
        }

        return newList;
    }

    public static Object translateOutput(Object obj) {
        if (obj instanceof BaseModel<?>) {
            return translateOutput((BaseModel<?>) obj);
        } else if (obj instanceof List<?>) {
            return translateOutput((List<Object>) obj);
        } else {
            return obj;
        }
    }

    public static Throwable translateThrowable(Throwable throwable) {
        if (_useReflectionToTranslateThrowable) {
            try {
                UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

                objectOutputStream.writeObject(throwable);

                objectOutputStream.flush();
                objectOutputStream.close();

                UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
                        0, unsyncByteArrayOutputStream.size());

                Thread currentThread = Thread.currentThread();

                ClassLoader contextClassLoader = currentThread.getContextClassLoader();

                ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
                        contextClassLoader);

                throwable = (Throwable) objectInputStream.readObject();

                objectInputStream.close();

                return throwable;
            } catch (SecurityException se) {
                if (_log.isInfoEnabled()) {
                    _log.info("Do not use reflection to translate throwable");
                }

                _useReflectionToTranslateThrowable = false;
            } catch (Throwable throwable2) {
                _log.error(throwable2, throwable2);

                return throwable2;
            }
        }

        Class<?> clazz = throwable.getClass();

        String className = clazz.getName();

        if (className.equals(PortalException.class.getName())) {
            return new PortalException();
        }

        if (className.equals(SystemException.class.getName())) {
            return new SystemException();
        }

        if (className.equals("net.evrem.service.NoSuchGridItemException")) {
            return new net.evrem.service.NoSuchGridItemException();
        }

        if (className.equals("net.evrem.service.NoSuchNoteException")) {
            return new net.evrem.service.NoSuchNoteException();
        }

        if (className.equals("net.evrem.service.NoSuchRemindInfoException")) {
            return new net.evrem.service.NoSuchRemindInfoException();
        }

        if (className.equals("net.evrem.service.NoSuchTodoNoteException")) {
            return new net.evrem.service.NoSuchTodoNoteException();
        }

        if (className.equals("net.evrem.service.NoSuchUserDetailException")) {
            return new net.evrem.service.NoSuchUserDetailException();
        }

        return throwable;
    }

    public static Object translateOutputGridItem(BaseModel<?> oldModel) {
        GridItemClp newModel = new GridItemClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setGridItemRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputNote(BaseModel<?> oldModel) {
        NoteClp newModel = new NoteClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setNoteRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputRemindInfo(BaseModel<?> oldModel) {
        RemindInfoClp newModel = new RemindInfoClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setRemindInfoRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputTodoNote(BaseModel<?> oldModel) {
        TodoNoteClp newModel = new TodoNoteClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setTodoNoteRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputUserDetail(BaseModel<?> oldModel) {
        UserDetailClp newModel = new UserDetailClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setUserDetailRemoteModel(oldModel);

        return newModel;
    }
}
