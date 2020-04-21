package net.evrem.service.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * Provides the local service interface for TodoNote. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Zdenek Vecek
 * @see TodoNoteLocalServiceUtil
 * @see net.evrem.service.service.base.TodoNoteLocalServiceBaseImpl
 * @see net.evrem.service.service.impl.TodoNoteLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface TodoNoteLocalService extends BaseLocalService,
    InvokableLocalService, PersistedModelLocalService {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link TodoNoteLocalServiceUtil} to access the todo note local service. Add custom service methods to {@link net.evrem.service.service.impl.TodoNoteLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */

    /**
    * Adds the todo note to the database. Also notifies the appropriate model listeners.
    *
    * @param todoNote the todo note
    * @return the todo note that was added
    * @throws SystemException if a system exception occurred
    */
    public net.evrem.service.model.TodoNote addTodoNote(
        net.evrem.service.model.TodoNote todoNote)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Creates a new todo note with the primary key. Does not add the todo note to the database.
    *
    * @param todoNoteId the primary key for the new todo note
    * @return the new todo note
    */
    public net.evrem.service.model.TodoNote createTodoNote(long todoNoteId);

    /**
    * Deletes the todo note with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param todoNoteId the primary key of the todo note
    * @return the todo note that was removed
    * @throws PortalException if a todo note with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.evrem.service.model.TodoNote deleteTodoNote(long todoNoteId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Deletes the todo note from the database. Also notifies the appropriate model listeners.
    *
    * @param todoNote the todo note
    * @return the todo note that was removed
    * @throws SystemException if a system exception occurred
    */
    public net.evrem.service.model.TodoNote deleteTodoNote(
        net.evrem.service.model.TodoNote todoNote)
        throws com.liferay.portal.kernel.exception.SystemException;

    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery();

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.evrem.service.model.impl.TodoNoteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.evrem.service.model.impl.TodoNoteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public net.evrem.service.model.TodoNote fetchTodoNote(long todoNoteId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the todo note with the primary key.
    *
    * @param todoNoteId the primary key of the todo note
    * @return the todo note
    * @throws PortalException if a todo note with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public net.evrem.service.model.TodoNote getTodoNote(long todoNoteId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the todo notes.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.evrem.service.model.impl.TodoNoteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of todo notes
    * @param end the upper bound of the range of todo notes (not inclusive)
    * @return the range of todo notes
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<net.evrem.service.model.TodoNote> getTodoNotes(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of todo notes.
    *
    * @return the number of todo notes
    * @throws SystemException if a system exception occurred
    */
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public int getTodoNotesCount()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Updates the todo note in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param todoNote the todo note
    * @return the todo note that was updated
    * @throws SystemException if a system exception occurred
    */
    public net.evrem.service.model.TodoNote updateTodoNote(
        net.evrem.service.model.TodoNote todoNote)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier();

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier);

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable;

    public net.evrem.service.model.TodoNote createTodoNote()
        throws com.liferay.portal.kernel.exception.SystemException;

    public void saveTodoNotes(java.lang.String text, java.lang.Long noteId,
        java.lang.Boolean updateNotes, java.lang.Boolean checkState)
        throws java.lang.Exception;

    public void saveTodoNotes(
        java.util.List<net.evrem.dtos.form.TodoNoteForm> forms,
        java.lang.Long noteId) throws java.lang.Exception;

    public void saveTodoNote(net.evrem.dtos.form.TodoNoteForm form,
        java.lang.Long noteId) throws java.lang.Exception;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public net.evrem.dtos.form.TodoNoteForm getTodoNoteByNoteIdAndSortNo(
        java.lang.Long noteId, java.lang.Integer sortNo)
        throws java.lang.Exception;

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<net.evrem.dtos.form.TodoNoteForm> getTodoNotesByNoteId(
        java.lang.Long noteId) throws java.lang.Exception;

    public void deleteByNoteId(java.lang.Long noteId)
        throws java.lang.Exception;

    public void checkTodoNote(java.lang.Long noteId, java.lang.Long todoNoteId)
        throws java.lang.Exception;

    public void checkAllTodoNotes(java.lang.Long noteId,
        java.lang.Boolean checkState) throws java.lang.Exception;
}
