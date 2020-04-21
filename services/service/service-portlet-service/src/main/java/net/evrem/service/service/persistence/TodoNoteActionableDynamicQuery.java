package net.evrem.service.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import net.evrem.service.model.TodoNote;
import net.evrem.service.service.TodoNoteLocalServiceUtil;

/**
 * @author Zdenek Vecek
 * @generated
 */
public abstract class TodoNoteActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public TodoNoteActionableDynamicQuery() throws SystemException {
        setBaseLocalService(TodoNoteLocalServiceUtil.getService());
        setClass(TodoNote.class);

        setClassLoader(net.evrem.service.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("todoNoteId");
    }
}
