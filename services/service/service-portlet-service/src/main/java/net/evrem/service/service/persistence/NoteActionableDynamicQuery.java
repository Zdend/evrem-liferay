package net.evrem.service.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import net.evrem.service.model.Note;
import net.evrem.service.service.NoteLocalServiceUtil;

/**
 * @author Zdenek Vecek
 * @generated
 */
public abstract class NoteActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public NoteActionableDynamicQuery() throws SystemException {
        setBaseLocalService(NoteLocalServiceUtil.getService());
        setClass(Note.class);

        setClassLoader(net.evrem.service.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("noteId");
    }
}
