package net.evrem.service.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link NoteLocalService}.
 *
 * @author Zdenek Vecek
 * @see NoteLocalService
 * @generated
 */
public class NoteLocalServiceWrapper implements NoteLocalService,
    ServiceWrapper<NoteLocalService> {
    private NoteLocalService _noteLocalService;

    public NoteLocalServiceWrapper(NoteLocalService noteLocalService) {
        _noteLocalService = noteLocalService;
    }

    /**
    * Adds the note to the database. Also notifies the appropriate model listeners.
    *
    * @param note the note
    * @return the note that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public net.evrem.service.model.Note addNote(
        net.evrem.service.model.Note note)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _noteLocalService.addNote(note);
    }

    /**
    * Creates a new note with the primary key. Does not add the note to the database.
    *
    * @param noteId the primary key for the new note
    * @return the new note
    */
    @Override
    public net.evrem.service.model.Note createNote(long noteId) {
        return _noteLocalService.createNote(noteId);
    }

    /**
    * Deletes the note with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param noteId the primary key of the note
    * @return the note that was removed
    * @throws PortalException if a note with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public net.evrem.service.model.Note deleteNote(long noteId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _noteLocalService.deleteNote(noteId);
    }

    /**
    * Deletes the note from the database. Also notifies the appropriate model listeners.
    *
    * @param note the note
    * @return the note that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public net.evrem.service.model.Note deleteNote(
        net.evrem.service.model.Note note)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _noteLocalService.deleteNote(note);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _noteLocalService.dynamicQuery();
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
        return _noteLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.evrem.service.model.impl.NoteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _noteLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.evrem.service.model.impl.NoteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _noteLocalService.dynamicQuery(dynamicQuery, start, end,
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
        return _noteLocalService.dynamicQueryCount(dynamicQuery);
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
        return _noteLocalService.dynamicQueryCount(dynamicQuery, projection);
    }

    @Override
    public net.evrem.service.model.Note fetchNote(long noteId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _noteLocalService.fetchNote(noteId);
    }

    /**
    * Returns the note with the primary key.
    *
    * @param noteId the primary key of the note
    * @return the note
    * @throws PortalException if a note with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public net.evrem.service.model.Note getNote(long noteId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _noteLocalService.getNote(noteId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _noteLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the notes.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.evrem.service.model.impl.NoteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of notes
    * @param end the upper bound of the range of notes (not inclusive)
    * @return the range of notes
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<net.evrem.service.model.Note> getNotes(int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _noteLocalService.getNotes(start, end);
    }

    /**
    * Returns the number of notes.
    *
    * @return the number of notes
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getNotesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _noteLocalService.getNotesCount();
    }

    /**
    * Updates the note in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param note the note
    * @return the note that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public net.evrem.service.model.Note updateNote(
        net.evrem.service.model.Note note)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _noteLocalService.updateNote(note);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _noteLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _noteLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _noteLocalService.invokeMethod(name, parameterTypes, arguments);
    }

    @Override
    public net.evrem.service.model.Note createNote()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _noteLocalService.createNote();
    }

    @Override
    public void saveNote(net.evrem.dtos.form.NoteFormModel noteForm,
        java.lang.Long userId) throws java.lang.Exception {
        _noteLocalService.saveNote(noteForm, userId);
    }

    @Override
    public void deletePermanentlyNote(java.lang.Long noteId,
        java.lang.Long userId) throws java.lang.Exception {
        _noteLocalService.deletePermanentlyNote(noteId, userId);
    }

    @Override
    public void deleteNote(java.lang.Long noteId, java.lang.Long userId)
        throws java.lang.Exception {
        _noteLocalService.deleteNote(noteId, userId);
    }

    @Override
    public void deleteAllDeletedNotesPermanently(java.lang.Long userId)
        throws java.lang.Exception {
        _noteLocalService.deleteAllDeletedNotesPermanently(userId);
    }

    @Override
    public java.util.List<net.evrem.dtos.form.NoteFormModel> getNotesByUserId(
        java.lang.Long userId) throws java.lang.Exception {
        return _noteLocalService.getNotesByUserId(userId);
    }

    @Override
    public java.util.List<net.evrem.dtos.form.NoteFormModel> getNotesEventByUserId(
        java.lang.Long userId, java.lang.Boolean withDeleted)
        throws java.lang.Exception {
        return _noteLocalService.getNotesEventByUserId(userId, withDeleted);
    }

    @Override
    public java.util.List<net.evrem.dtos.form.NoteFormModel> getNotesForReminding(
        java.lang.Long userId) throws java.lang.Exception {
        return _noteLocalService.getNotesForReminding(userId);
    }

    @Override
    public java.util.List<net.evrem.dtos.dto.EventDto> getEvents(
        java.lang.Long userId) throws java.lang.Exception {
        return _noteLocalService.getEvents(userId);
    }

    @Override
    public void checkNote(java.lang.Long noteId, java.lang.Long userId)
        throws java.lang.Exception {
        _noteLocalService.checkNote(noteId, userId);
    }

    @Override
    public void checkTodoNote(java.lang.Long noteId, java.lang.Long todoNoteId,
        java.lang.Long userId) throws java.lang.Exception {
        _noteLocalService.checkTodoNote(noteId, todoNoteId, userId);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public NoteLocalService getWrappedNoteLocalService() {
        return _noteLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedNoteLocalService(NoteLocalService noteLocalService) {
        _noteLocalService = noteLocalService;
    }

    @Override
    public NoteLocalService getWrappedService() {
        return _noteLocalService;
    }

    @Override
    public void setWrappedService(NoteLocalService noteLocalService) {
        _noteLocalService = noteLocalService;
    }
}
