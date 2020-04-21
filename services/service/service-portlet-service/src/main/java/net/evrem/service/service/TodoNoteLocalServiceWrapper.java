package net.evrem.service.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TodoNoteLocalService}.
 *
 * @author Zdenek Vecek
 * @see TodoNoteLocalService
 * @generated
 */
public class TodoNoteLocalServiceWrapper implements TodoNoteLocalService,
    ServiceWrapper<TodoNoteLocalService> {
    private TodoNoteLocalService _todoNoteLocalService;

    public TodoNoteLocalServiceWrapper(
        TodoNoteLocalService todoNoteLocalService) {
        _todoNoteLocalService = todoNoteLocalService;
    }

    /**
    * Adds the todo note to the database. Also notifies the appropriate model listeners.
    *
    * @param todoNote the todo note
    * @return the todo note that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public net.evrem.service.model.TodoNote addTodoNote(
        net.evrem.service.model.TodoNote todoNote)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _todoNoteLocalService.addTodoNote(todoNote);
    }

    /**
    * Creates a new todo note with the primary key. Does not add the todo note to the database.
    *
    * @param todoNoteId the primary key for the new todo note
    * @return the new todo note
    */
    @Override
    public net.evrem.service.model.TodoNote createTodoNote(long todoNoteId) {
        return _todoNoteLocalService.createTodoNote(todoNoteId);
    }

    /**
    * Deletes the todo note with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param todoNoteId the primary key of the todo note
    * @return the todo note that was removed
    * @throws PortalException if a todo note with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public net.evrem.service.model.TodoNote deleteTodoNote(long todoNoteId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _todoNoteLocalService.deleteTodoNote(todoNoteId);
    }

    /**
    * Deletes the todo note from the database. Also notifies the appropriate model listeners.
    *
    * @param todoNote the todo note
    * @return the todo note that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public net.evrem.service.model.TodoNote deleteTodoNote(
        net.evrem.service.model.TodoNote todoNote)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _todoNoteLocalService.deleteTodoNote(todoNote);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _todoNoteLocalService.dynamicQuery();
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
        return _todoNoteLocalService.dynamicQuery(dynamicQuery);
    }

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
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _todoNoteLocalService.dynamicQuery(dynamicQuery, start, end);
    }

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
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _todoNoteLocalService.dynamicQuery(dynamicQuery, start, end,
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
        return _todoNoteLocalService.dynamicQueryCount(dynamicQuery);
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
        return _todoNoteLocalService.dynamicQueryCount(dynamicQuery, projection);
    }

    @Override
    public net.evrem.service.model.TodoNote fetchTodoNote(long todoNoteId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _todoNoteLocalService.fetchTodoNote(todoNoteId);
    }

    /**
    * Returns the todo note with the primary key.
    *
    * @param todoNoteId the primary key of the todo note
    * @return the todo note
    * @throws PortalException if a todo note with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public net.evrem.service.model.TodoNote getTodoNote(long todoNoteId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _todoNoteLocalService.getTodoNote(todoNoteId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _todoNoteLocalService.getPersistedModel(primaryKeyObj);
    }

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
    @Override
    public java.util.List<net.evrem.service.model.TodoNote> getTodoNotes(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _todoNoteLocalService.getTodoNotes(start, end);
    }

    /**
    * Returns the number of todo notes.
    *
    * @return the number of todo notes
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getTodoNotesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _todoNoteLocalService.getTodoNotesCount();
    }

    /**
    * Updates the todo note in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param todoNote the todo note
    * @return the todo note that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public net.evrem.service.model.TodoNote updateTodoNote(
        net.evrem.service.model.TodoNote todoNote)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _todoNoteLocalService.updateTodoNote(todoNote);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _todoNoteLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _todoNoteLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _todoNoteLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public net.evrem.service.model.TodoNote createTodoNote()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _todoNoteLocalService.createTodoNote();
    }

    @Override
    public void saveTodoNotes(java.lang.String text, java.lang.Long noteId,
        java.lang.Boolean updateNotes, java.lang.Boolean checkState)
        throws java.lang.Exception {
        _todoNoteLocalService.saveTodoNotes(text, noteId, updateNotes,
            checkState);
    }

    @Override
    public void saveTodoNotes(
        java.util.List<net.evrem.dtos.form.TodoNoteForm> forms,
        java.lang.Long noteId) throws java.lang.Exception {
        _todoNoteLocalService.saveTodoNotes(forms, noteId);
    }

    @Override
    public void saveTodoNote(net.evrem.dtos.form.TodoNoteForm form,
        java.lang.Long noteId) throws java.lang.Exception {
        _todoNoteLocalService.saveTodoNote(form, noteId);
    }

    @Override
    public net.evrem.dtos.form.TodoNoteForm getTodoNoteByNoteIdAndSortNo(
        java.lang.Long noteId, java.lang.Integer sortNo)
        throws java.lang.Exception {
        return _todoNoteLocalService.getTodoNoteByNoteIdAndSortNo(noteId, sortNo);
    }

    @Override
    public java.util.List<net.evrem.dtos.form.TodoNoteForm> getTodoNotesByNoteId(
        java.lang.Long noteId) throws java.lang.Exception {
        return _todoNoteLocalService.getTodoNotesByNoteId(noteId);
    }

    @Override
    public void deleteByNoteId(java.lang.Long noteId)
        throws java.lang.Exception {
        _todoNoteLocalService.deleteByNoteId(noteId);
    }

    @Override
    public void checkTodoNote(java.lang.Long noteId, java.lang.Long todoNoteId)
        throws java.lang.Exception {
        _todoNoteLocalService.checkTodoNote(noteId, todoNoteId);
    }

    @Override
    public void checkAllTodoNotes(java.lang.Long noteId,
        java.lang.Boolean checkState) throws java.lang.Exception {
        _todoNoteLocalService.checkAllTodoNotes(noteId, checkState);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public TodoNoteLocalService getWrappedTodoNoteLocalService() {
        return _todoNoteLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedTodoNoteLocalService(
        TodoNoteLocalService todoNoteLocalService) {
        _todoNoteLocalService = todoNoteLocalService;
    }

    @Override
    public TodoNoteLocalService getWrappedService() {
        return _todoNoteLocalService;
    }

    @Override
    public void setWrappedService(TodoNoteLocalService todoNoteLocalService) {
        _todoNoteLocalService = todoNoteLocalService;
    }
}
