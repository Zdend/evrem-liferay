package net.evrem.service.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Note. This utility wraps
 * {@link net.evrem.service.service.impl.NoteLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Zdenek Vecek
 * @see NoteLocalService
 * @see net.evrem.service.service.base.NoteLocalServiceBaseImpl
 * @see net.evrem.service.service.impl.NoteLocalServiceImpl
 * @generated
 */
public class NoteLocalServiceUtil {
    private static NoteLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link net.evrem.service.service.impl.NoteLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the note to the database. Also notifies the appropriate model listeners.
    *
    * @param note the note
    * @return the note that was added
    * @throws SystemException if a system exception occurred
    */
    public static net.evrem.service.model.Note addNote(
        net.evrem.service.model.Note note)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addNote(note);
    }

    /**
    * Creates a new note with the primary key. Does not add the note to the database.
    *
    * @param noteId the primary key for the new note
    * @return the new note
    */
    public static net.evrem.service.model.Note createNote(long noteId) {
        return getService().createNote(noteId);
    }

    /**
    * Deletes the note with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param noteId the primary key of the note
    * @return the note that was removed
    * @throws PortalException if a note with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.evrem.service.model.Note deleteNote(long noteId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteNote(noteId);
    }

    /**
    * Deletes the note from the database. Also notifies the appropriate model listeners.
    *
    * @param note the note
    * @return the note that was removed
    * @throws SystemException if a system exception occurred
    */
    public static net.evrem.service.model.Note deleteNote(
        net.evrem.service.model.Note note)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteNote(note);
    }

    public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return getService().dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery);
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
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
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
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery, projection);
    }

    public static net.evrem.service.model.Note fetchNote(long noteId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchNote(noteId);
    }

    /**
    * Returns the note with the primary key.
    *
    * @param noteId the primary key of the note
    * @return the note
    * @throws PortalException if a note with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.evrem.service.model.Note getNote(long noteId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getNote(noteId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
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
    public static java.util.List<net.evrem.service.model.Note> getNotes(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getNotes(start, end);
    }

    /**
    * Returns the number of notes.
    *
    * @return the number of notes
    * @throws SystemException if a system exception occurred
    */
    public static int getNotesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getNotesCount();
    }

    /**
    * Updates the note in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param note the note
    * @return the note that was updated
    * @throws SystemException if a system exception occurred
    */
    public static net.evrem.service.model.Note updateNote(
        net.evrem.service.model.Note note)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateNote(note);
    }

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

    public static net.evrem.service.model.Note createNote()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().createNote();
    }

    public static void saveNote(net.evrem.dtos.form.NoteFormModel noteForm,
        java.lang.Long userId) throws java.lang.Exception {
        getService().saveNote(noteForm, userId);
    }

    public static void deletePermanentlyNote(java.lang.Long noteId,
        java.lang.Long userId) throws java.lang.Exception {
        getService().deletePermanentlyNote(noteId, userId);
    }

    public static void deleteNote(java.lang.Long noteId, java.lang.Long userId)
        throws java.lang.Exception {
        getService().deleteNote(noteId, userId);
    }

    public static void deleteAllDeletedNotesPermanently(java.lang.Long userId)
        throws java.lang.Exception {
        getService().deleteAllDeletedNotesPermanently(userId);
    }

    public static java.util.List<net.evrem.dtos.form.NoteFormModel> getNotesByUserId(
        java.lang.Long userId) throws java.lang.Exception {
        return getService().getNotesByUserId(userId);
    }

    public static java.util.List<net.evrem.dtos.form.NoteFormModel> getNotesEventByUserId(
        java.lang.Long userId, java.lang.Boolean withDeleted)
        throws java.lang.Exception {
        return getService().getNotesEventByUserId(userId, withDeleted);
    }

    public static java.util.List<net.evrem.dtos.form.NoteFormModel> getNotesForReminding(
        java.lang.Long userId) throws java.lang.Exception {
        return getService().getNotesForReminding(userId);
    }

    public static java.util.List<net.evrem.dtos.dto.EventDto> getEvents(
        java.lang.Long userId) throws java.lang.Exception {
        return getService().getEvents(userId);
    }

    public static void checkNote(java.lang.Long noteId, java.lang.Long userId)
        throws java.lang.Exception {
        getService().checkNote(noteId, userId);
    }

    public static void checkTodoNote(java.lang.Long noteId,
        java.lang.Long todoNoteId, java.lang.Long userId)
        throws java.lang.Exception {
        getService().checkTodoNote(noteId, todoNoteId, userId);
    }

    public static void clearService() {
        _service = null;
    }

    public static NoteLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    NoteLocalService.class.getName());

            if (invokableLocalService instanceof NoteLocalService) {
                _service = (NoteLocalService) invokableLocalService;
            } else {
                _service = new NoteLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(NoteLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(NoteLocalService service) {
    }
}
