package net.evrem.service.service.base;

import net.evrem.service.service.TodoNoteLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Zdenek Vecek
 * @generated
 */
public class TodoNoteLocalServiceClpInvoker {
    private String _methodName0;
    private String[] _methodParameterTypes0;
    private String _methodName1;
    private String[] _methodParameterTypes1;
    private String _methodName2;
    private String[] _methodParameterTypes2;
    private String _methodName3;
    private String[] _methodParameterTypes3;
    private String _methodName4;
    private String[] _methodParameterTypes4;
    private String _methodName5;
    private String[] _methodParameterTypes5;
    private String _methodName6;
    private String[] _methodParameterTypes6;
    private String _methodName7;
    private String[] _methodParameterTypes7;
    private String _methodName8;
    private String[] _methodParameterTypes8;
    private String _methodName9;
    private String[] _methodParameterTypes9;
    private String _methodName10;
    private String[] _methodParameterTypes10;
    private String _methodName11;
    private String[] _methodParameterTypes11;
    private String _methodName12;
    private String[] _methodParameterTypes12;
    private String _methodName13;
    private String[] _methodParameterTypes13;
    private String _methodName14;
    private String[] _methodParameterTypes14;
    private String _methodName15;
    private String[] _methodParameterTypes15;
    private String _methodName50;
    private String[] _methodParameterTypes50;
    private String _methodName51;
    private String[] _methodParameterTypes51;
    private String _methodName56;
    private String[] _methodParameterTypes56;
    private String _methodName57;
    private String[] _methodParameterTypes57;
    private String _methodName58;
    private String[] _methodParameterTypes58;
    private String _methodName59;
    private String[] _methodParameterTypes59;
    private String _methodName60;
    private String[] _methodParameterTypes60;
    private String _methodName61;
    private String[] _methodParameterTypes61;
    private String _methodName62;
    private String[] _methodParameterTypes62;
    private String _methodName63;
    private String[] _methodParameterTypes63;
    private String _methodName64;
    private String[] _methodParameterTypes64;

    public TodoNoteLocalServiceClpInvoker() {
        _methodName0 = "addTodoNote";

        _methodParameterTypes0 = new String[] { "net.evrem.service.model.TodoNote" };

        _methodName1 = "createTodoNote";

        _methodParameterTypes1 = new String[] { "long" };

        _methodName2 = "deleteTodoNote";

        _methodParameterTypes2 = new String[] { "long" };

        _methodName3 = "deleteTodoNote";

        _methodParameterTypes3 = new String[] { "net.evrem.service.model.TodoNote" };

        _methodName4 = "dynamicQuery";

        _methodParameterTypes4 = new String[] {  };

        _methodName5 = "dynamicQuery";

        _methodParameterTypes5 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery"
            };

        _methodName6 = "dynamicQuery";

        _methodParameterTypes6 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
            };

        _methodName7 = "dynamicQuery";

        _methodParameterTypes7 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };

        _methodName8 = "dynamicQueryCount";

        _methodParameterTypes8 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery"
            };

        _methodName9 = "dynamicQueryCount";

        _methodParameterTypes9 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery",
                "com.liferay.portal.kernel.dao.orm.Projection"
            };

        _methodName10 = "fetchTodoNote";

        _methodParameterTypes10 = new String[] { "long" };

        _methodName11 = "getTodoNote";

        _methodParameterTypes11 = new String[] { "long" };

        _methodName12 = "getPersistedModel";

        _methodParameterTypes12 = new String[] { "java.io.Serializable" };

        _methodName13 = "getTodoNotes";

        _methodParameterTypes13 = new String[] { "int", "int" };

        _methodName14 = "getTodoNotesCount";

        _methodParameterTypes14 = new String[] {  };

        _methodName15 = "updateTodoNote";

        _methodParameterTypes15 = new String[] {
                "net.evrem.service.model.TodoNote"
            };

        _methodName50 = "getBeanIdentifier";

        _methodParameterTypes50 = new String[] {  };

        _methodName51 = "setBeanIdentifier";

        _methodParameterTypes51 = new String[] { "java.lang.String" };

        _methodName56 = "createTodoNote";

        _methodParameterTypes56 = new String[] {  };

        _methodName57 = "saveTodoNotes";

        _methodParameterTypes57 = new String[] {
                "java.lang.String", "java.lang.Long", "java.lang.Boolean",
                "java.lang.Boolean"
            };

        _methodName58 = "saveTodoNotes";

        _methodParameterTypes58 = new String[] {
                "java.util.List", "java.lang.Long"
            };

        _methodName59 = "saveTodoNote";

        _methodParameterTypes59 = new String[] {
                "net.evrem.dtos.form.TodoNoteForm", "java.lang.Long"
            };

        _methodName60 = "getTodoNoteByNoteIdAndSortNo";

        _methodParameterTypes60 = new String[] {
                "java.lang.Long", "java.lang.Integer"
            };

        _methodName61 = "getTodoNotesByNoteId";

        _methodParameterTypes61 = new String[] { "java.lang.Long" };

        _methodName62 = "deleteByNoteId";

        _methodParameterTypes62 = new String[] { "java.lang.Long" };

        _methodName63 = "checkTodoNote";

        _methodParameterTypes63 = new String[] {
                "java.lang.Long", "java.lang.Long"
            };

        _methodName64 = "checkAllTodoNotes";

        _methodParameterTypes64 = new String[] {
                "java.lang.Long", "java.lang.Boolean"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return TodoNoteLocalServiceUtil.addTodoNote((net.evrem.service.model.TodoNote) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return TodoNoteLocalServiceUtil.createTodoNote(((Long) arguments[0]).longValue());
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return TodoNoteLocalServiceUtil.deleteTodoNote(((Long) arguments[0]).longValue());
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return TodoNoteLocalServiceUtil.deleteTodoNote((net.evrem.service.model.TodoNote) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return TodoNoteLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return TodoNoteLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return TodoNoteLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return TodoNoteLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return TodoNoteLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return TodoNoteLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                (com.liferay.portal.kernel.dao.orm.Projection) arguments[1]);
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return TodoNoteLocalServiceUtil.fetchTodoNote(((Long) arguments[0]).longValue());
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return TodoNoteLocalServiceUtil.getTodoNote(((Long) arguments[0]).longValue());
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return TodoNoteLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return TodoNoteLocalServiceUtil.getTodoNotes(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return TodoNoteLocalServiceUtil.getTodoNotesCount();
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return TodoNoteLocalServiceUtil.updateTodoNote((net.evrem.service.model.TodoNote) arguments[0]);
        }

        if (_methodName50.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes50, parameterTypes)) {
            return TodoNoteLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName51.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes51, parameterTypes)) {
            TodoNoteLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName56.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes56, parameterTypes)) {
            return TodoNoteLocalServiceUtil.createTodoNote();
        }

        if (_methodName57.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes57, parameterTypes)) {
            TodoNoteLocalServiceUtil.saveTodoNotes((java.lang.String) arguments[0],
                (java.lang.Long) arguments[1],
                (java.lang.Boolean) arguments[2],
                (java.lang.Boolean) arguments[3]);

            return null;
        }

        if (_methodName58.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes58, parameterTypes)) {
            TodoNoteLocalServiceUtil.saveTodoNotes((java.util.List<net.evrem.dtos.form.TodoNoteForm>) arguments[0],
                (java.lang.Long) arguments[1]);

            return null;
        }

        if (_methodName59.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes59, parameterTypes)) {
            TodoNoteLocalServiceUtil.saveTodoNote((net.evrem.dtos.form.TodoNoteForm) arguments[0],
                (java.lang.Long) arguments[1]);

            return null;
        }

        if (_methodName60.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes60, parameterTypes)) {
            return TodoNoteLocalServiceUtil.getTodoNoteByNoteIdAndSortNo((java.lang.Long) arguments[0],
                (java.lang.Integer) arguments[1]);
        }

        if (_methodName61.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes61, parameterTypes)) {
            return TodoNoteLocalServiceUtil.getTodoNotesByNoteId((java.lang.Long) arguments[0]);
        }

        if (_methodName62.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes62, parameterTypes)) {
            TodoNoteLocalServiceUtil.deleteByNoteId((java.lang.Long) arguments[0]);

            return null;
        }

        if (_methodName63.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes63, parameterTypes)) {
            TodoNoteLocalServiceUtil.checkTodoNote((java.lang.Long) arguments[0],
                (java.lang.Long) arguments[1]);

            return null;
        }

        if (_methodName64.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes64, parameterTypes)) {
            TodoNoteLocalServiceUtil.checkAllTodoNotes((java.lang.Long) arguments[0],
                (java.lang.Boolean) arguments[1]);

            return null;
        }

        throw new UnsupportedOperationException();
    }
}
