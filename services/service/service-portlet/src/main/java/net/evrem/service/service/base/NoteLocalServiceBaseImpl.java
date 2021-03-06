package net.evrem.service.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import net.evrem.service.model.Note;
import net.evrem.service.service.NoteLocalService;
import net.evrem.service.service.persistence.GridItemPersistence;
import net.evrem.service.service.persistence.NotePersistence;
import net.evrem.service.service.persistence.RemindInfoPersistence;
import net.evrem.service.service.persistence.TodoNotePersistence;
import net.evrem.service.service.persistence.UserDetailPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the note local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link net.evrem.service.service.impl.NoteLocalServiceImpl}.
 * </p>
 *
 * @author Zdenek Vecek
 * @see net.evrem.service.service.impl.NoteLocalServiceImpl
 * @see net.evrem.service.service.NoteLocalServiceUtil
 * @generated
 */
public abstract class NoteLocalServiceBaseImpl extends BaseLocalServiceImpl
    implements NoteLocalService, IdentifiableBean {
    @BeanReference(type = net.evrem.service.service.GridItemLocalService.class)
    protected net.evrem.service.service.GridItemLocalService gridItemLocalService;
    @BeanReference(type = GridItemPersistence.class)
    protected GridItemPersistence gridItemPersistence;
    @BeanReference(type = net.evrem.service.service.NoteLocalService.class)
    protected net.evrem.service.service.NoteLocalService noteLocalService;
    @BeanReference(type = NotePersistence.class)
    protected NotePersistence notePersistence;
    @BeanReference(type = net.evrem.service.service.RemindInfoLocalService.class)
    protected net.evrem.service.service.RemindInfoLocalService remindInfoLocalService;
    @BeanReference(type = RemindInfoPersistence.class)
    protected RemindInfoPersistence remindInfoPersistence;
    @BeanReference(type = net.evrem.service.service.TodoNoteLocalService.class)
    protected net.evrem.service.service.TodoNoteLocalService todoNoteLocalService;
    @BeanReference(type = TodoNotePersistence.class)
    protected TodoNotePersistence todoNotePersistence;
    @BeanReference(type = net.evrem.service.service.UserDetailLocalService.class)
    protected net.evrem.service.service.UserDetailLocalService userDetailLocalService;
    @BeanReference(type = UserDetailPersistence.class)
    protected UserDetailPersistence userDetailPersistence;
    @BeanReference(type = net.evrem.service.service.UserEvremLocalService.class)
    protected net.evrem.service.service.UserEvremLocalService userEvremLocalService;
    @BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
    protected com.liferay.counter.service.CounterLocalService counterLocalService;
    @BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
    protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
    @BeanReference(type = com.liferay.portal.service.UserLocalService.class)
    protected com.liferay.portal.service.UserLocalService userLocalService;
    @BeanReference(type = com.liferay.portal.service.UserService.class)
    protected com.liferay.portal.service.UserService userService;
    @BeanReference(type = UserPersistence.class)
    protected UserPersistence userPersistence;
    private String _beanIdentifier;
    private ClassLoader _classLoader;
    private NoteLocalServiceClpInvoker _clpInvoker = new NoteLocalServiceClpInvoker();

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link net.evrem.service.service.NoteLocalServiceUtil} to access the note local service.
     */

    /**
     * Adds the note to the database. Also notifies the appropriate model listeners.
     *
     * @param note the note
     * @return the note that was added
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.REINDEX)
    @Override
    public Note addNote(Note note) throws SystemException {
        note.setNew(true);

        return notePersistence.update(note);
    }

    /**
     * Creates a new note with the primary key. Does not add the note to the database.
     *
     * @param noteId the primary key for the new note
     * @return the new note
     */
    @Override
    public Note createNote(long noteId) {
        return notePersistence.create(noteId);
    }

    /**
     * Deletes the note with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param noteId the primary key of the note
     * @return the note that was removed
     * @throws PortalException if a note with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.DELETE)
    @Override
    public Note deleteNote(long noteId) throws PortalException, SystemException {
        return notePersistence.remove(noteId);
    }

    /**
     * Deletes the note from the database. Also notifies the appropriate model listeners.
     *
     * @param note the note
     * @return the note that was removed
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.DELETE)
    @Override
    public Note deleteNote(Note note) throws SystemException {
        return notePersistence.remove(note);
    }

    @Override
    public DynamicQuery dynamicQuery() {
        Class<?> clazz = getClass();

        return DynamicQueryFactoryUtil.forClass(Note.class,
            clazz.getClassLoader());
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
    public List dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return notePersistence.findWithDynamicQuery(dynamicQuery);
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
    public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return notePersistence.findWithDynamicQuery(dynamicQuery, start, end);
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
    public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return notePersistence.findWithDynamicQuery(dynamicQuery, start, end,
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
    public long dynamicQueryCount(DynamicQuery dynamicQuery)
        throws SystemException {
        return notePersistence.countWithDynamicQuery(dynamicQuery);
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
    public long dynamicQueryCount(DynamicQuery dynamicQuery,
        Projection projection) throws SystemException {
        return notePersistence.countWithDynamicQuery(dynamicQuery, projection);
    }

    @Override
    public Note fetchNote(long noteId) throws SystemException {
        return notePersistence.fetchByPrimaryKey(noteId);
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
    public Note getNote(long noteId) throws PortalException, SystemException {
        return notePersistence.findByPrimaryKey(noteId);
    }

    @Override
    public PersistedModel getPersistedModel(Serializable primaryKeyObj)
        throws PortalException, SystemException {
        return notePersistence.findByPrimaryKey(primaryKeyObj);
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
    public List<Note> getNotes(int start, int end) throws SystemException {
        return notePersistence.findAll(start, end);
    }

    /**
     * Returns the number of notes.
     *
     * @return the number of notes
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int getNotesCount() throws SystemException {
        return notePersistence.countAll();
    }

    /**
     * Updates the note in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
     *
     * @param note the note
     * @return the note that was updated
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.REINDEX)
    @Override
    public Note updateNote(Note note) throws SystemException {
        return notePersistence.update(note);
    }

    /**
     * Returns the grid item local service.
     *
     * @return the grid item local service
     */
    public net.evrem.service.service.GridItemLocalService getGridItemLocalService() {
        return gridItemLocalService;
    }

    /**
     * Sets the grid item local service.
     *
     * @param gridItemLocalService the grid item local service
     */
    public void setGridItemLocalService(
        net.evrem.service.service.GridItemLocalService gridItemLocalService) {
        this.gridItemLocalService = gridItemLocalService;
    }

    /**
     * Returns the grid item persistence.
     *
     * @return the grid item persistence
     */
    public GridItemPersistence getGridItemPersistence() {
        return gridItemPersistence;
    }

    /**
     * Sets the grid item persistence.
     *
     * @param gridItemPersistence the grid item persistence
     */
    public void setGridItemPersistence(GridItemPersistence gridItemPersistence) {
        this.gridItemPersistence = gridItemPersistence;
    }

    /**
     * Returns the note local service.
     *
     * @return the note local service
     */
    public net.evrem.service.service.NoteLocalService getNoteLocalService() {
        return noteLocalService;
    }

    /**
     * Sets the note local service.
     *
     * @param noteLocalService the note local service
     */
    public void setNoteLocalService(
        net.evrem.service.service.NoteLocalService noteLocalService) {
        this.noteLocalService = noteLocalService;
    }

    /**
     * Returns the note persistence.
     *
     * @return the note persistence
     */
    public NotePersistence getNotePersistence() {
        return notePersistence;
    }

    /**
     * Sets the note persistence.
     *
     * @param notePersistence the note persistence
     */
    public void setNotePersistence(NotePersistence notePersistence) {
        this.notePersistence = notePersistence;
    }

    /**
     * Returns the remind info local service.
     *
     * @return the remind info local service
     */
    public net.evrem.service.service.RemindInfoLocalService getRemindInfoLocalService() {
        return remindInfoLocalService;
    }

    /**
     * Sets the remind info local service.
     *
     * @param remindInfoLocalService the remind info local service
     */
    public void setRemindInfoLocalService(
        net.evrem.service.service.RemindInfoLocalService remindInfoLocalService) {
        this.remindInfoLocalService = remindInfoLocalService;
    }

    /**
     * Returns the remind info persistence.
     *
     * @return the remind info persistence
     */
    public RemindInfoPersistence getRemindInfoPersistence() {
        return remindInfoPersistence;
    }

    /**
     * Sets the remind info persistence.
     *
     * @param remindInfoPersistence the remind info persistence
     */
    public void setRemindInfoPersistence(
        RemindInfoPersistence remindInfoPersistence) {
        this.remindInfoPersistence = remindInfoPersistence;
    }

    /**
     * Returns the todo note local service.
     *
     * @return the todo note local service
     */
    public net.evrem.service.service.TodoNoteLocalService getTodoNoteLocalService() {
        return todoNoteLocalService;
    }

    /**
     * Sets the todo note local service.
     *
     * @param todoNoteLocalService the todo note local service
     */
    public void setTodoNoteLocalService(
        net.evrem.service.service.TodoNoteLocalService todoNoteLocalService) {
        this.todoNoteLocalService = todoNoteLocalService;
    }

    /**
     * Returns the todo note persistence.
     *
     * @return the todo note persistence
     */
    public TodoNotePersistence getTodoNotePersistence() {
        return todoNotePersistence;
    }

    /**
     * Sets the todo note persistence.
     *
     * @param todoNotePersistence the todo note persistence
     */
    public void setTodoNotePersistence(TodoNotePersistence todoNotePersistence) {
        this.todoNotePersistence = todoNotePersistence;
    }

    /**
     * Returns the user detail local service.
     *
     * @return the user detail local service
     */
    public net.evrem.service.service.UserDetailLocalService getUserDetailLocalService() {
        return userDetailLocalService;
    }

    /**
     * Sets the user detail local service.
     *
     * @param userDetailLocalService the user detail local service
     */
    public void setUserDetailLocalService(
        net.evrem.service.service.UserDetailLocalService userDetailLocalService) {
        this.userDetailLocalService = userDetailLocalService;
    }

    /**
     * Returns the user detail persistence.
     *
     * @return the user detail persistence
     */
    public UserDetailPersistence getUserDetailPersistence() {
        return userDetailPersistence;
    }

    /**
     * Sets the user detail persistence.
     *
     * @param userDetailPersistence the user detail persistence
     */
    public void setUserDetailPersistence(
        UserDetailPersistence userDetailPersistence) {
        this.userDetailPersistence = userDetailPersistence;
    }

    /**
     * Returns the user evrem local service.
     *
     * @return the user evrem local service
     */
    public net.evrem.service.service.UserEvremLocalService getUserEvremLocalService() {
        return userEvremLocalService;
    }

    /**
     * Sets the user evrem local service.
     *
     * @param userEvremLocalService the user evrem local service
     */
    public void setUserEvremLocalService(
        net.evrem.service.service.UserEvremLocalService userEvremLocalService) {
        this.userEvremLocalService = userEvremLocalService;
    }

    /**
     * Returns the counter local service.
     *
     * @return the counter local service
     */
    public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
        return counterLocalService;
    }

    /**
     * Sets the counter local service.
     *
     * @param counterLocalService the counter local service
     */
    public void setCounterLocalService(
        com.liferay.counter.service.CounterLocalService counterLocalService) {
        this.counterLocalService = counterLocalService;
    }

    /**
     * Returns the resource local service.
     *
     * @return the resource local service
     */
    public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
        return resourceLocalService;
    }

    /**
     * Sets the resource local service.
     *
     * @param resourceLocalService the resource local service
     */
    public void setResourceLocalService(
        com.liferay.portal.service.ResourceLocalService resourceLocalService) {
        this.resourceLocalService = resourceLocalService;
    }

    /**
     * Returns the user local service.
     *
     * @return the user local service
     */
    public com.liferay.portal.service.UserLocalService getUserLocalService() {
        return userLocalService;
    }

    /**
     * Sets the user local service.
     *
     * @param userLocalService the user local service
     */
    public void setUserLocalService(
        com.liferay.portal.service.UserLocalService userLocalService) {
        this.userLocalService = userLocalService;
    }

    /**
     * Returns the user remote service.
     *
     * @return the user remote service
     */
    public com.liferay.portal.service.UserService getUserService() {
        return userService;
    }

    /**
     * Sets the user remote service.
     *
     * @param userService the user remote service
     */
    public void setUserService(
        com.liferay.portal.service.UserService userService) {
        this.userService = userService;
    }

    /**
     * Returns the user persistence.
     *
     * @return the user persistence
     */
    public UserPersistence getUserPersistence() {
        return userPersistence;
    }

    /**
     * Sets the user persistence.
     *
     * @param userPersistence the user persistence
     */
    public void setUserPersistence(UserPersistence userPersistence) {
        this.userPersistence = userPersistence;
    }

    public void afterPropertiesSet() {
        Class<?> clazz = getClass();

        _classLoader = clazz.getClassLoader();

        PersistedModelLocalServiceRegistryUtil.register("net.evrem.service.model.Note",
            noteLocalService);
    }

    public void destroy() {
        PersistedModelLocalServiceRegistryUtil.unregister(
            "net.evrem.service.model.Note");
    }

    /**
     * Returns the Spring bean ID for this bean.
     *
     * @return the Spring bean ID for this bean
     */
    @Override
    public String getBeanIdentifier() {
        return _beanIdentifier;
    }

    /**
     * Sets the Spring bean ID for this bean.
     *
     * @param beanIdentifier the Spring bean ID for this bean
     */
    @Override
    public void setBeanIdentifier(String beanIdentifier) {
        _beanIdentifier = beanIdentifier;
    }

    @Override
    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        Thread currentThread = Thread.currentThread();

        ClassLoader contextClassLoader = currentThread.getContextClassLoader();

        if (contextClassLoader != _classLoader) {
            currentThread.setContextClassLoader(_classLoader);
        }

        try {
            return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
        } finally {
            if (contextClassLoader != _classLoader) {
                currentThread.setContextClassLoader(contextClassLoader);
            }
        }
    }

    protected Class<?> getModelClass() {
        return Note.class;
    }

    protected String getModelClassName() {
        return Note.class.getName();
    }

    /**
     * Performs an SQL query.
     *
     * @param sql the sql query
     */
    protected void runSQL(String sql) throws SystemException {
        try {
            DataSource dataSource = notePersistence.getDataSource();

            SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
                    sql, new int[0]);

            sqlUpdate.update();
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
