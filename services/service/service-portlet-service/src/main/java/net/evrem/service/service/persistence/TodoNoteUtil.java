package net.evrem.service.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import net.evrem.service.model.TodoNote;

import java.util.List;

/**
 * The persistence utility for the todo note service. This utility wraps {@link TodoNotePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Zdenek Vecek
 * @see TodoNotePersistence
 * @see TodoNotePersistenceImpl
 * @generated
 */
public class TodoNoteUtil {
    private static TodoNotePersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(TodoNote todoNote) {
        getPersistence().clearCache(todoNote);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<TodoNote> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<TodoNote> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<TodoNote> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static TodoNote update(TodoNote todoNote) throws SystemException {
        return getPersistence().update(todoNote);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static TodoNote update(TodoNote todoNote,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(todoNote, serviceContext);
    }

    /**
    * Returns all the todo notes where noteId = &#63;.
    *
    * @param noteId the note ID
    * @return the matching todo notes
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<net.evrem.service.model.TodoNote> findByNoteId(
        long noteId) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByNoteId(noteId);
    }

    /**
    * Returns a range of all the todo notes where noteId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.evrem.service.model.impl.TodoNoteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param noteId the note ID
    * @param start the lower bound of the range of todo notes
    * @param end the upper bound of the range of todo notes (not inclusive)
    * @return the range of matching todo notes
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<net.evrem.service.model.TodoNote> findByNoteId(
        long noteId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByNoteId(noteId, start, end);
    }

    /**
    * Returns an ordered range of all the todo notes where noteId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.evrem.service.model.impl.TodoNoteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param noteId the note ID
    * @param start the lower bound of the range of todo notes
    * @param end the upper bound of the range of todo notes (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching todo notes
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<net.evrem.service.model.TodoNote> findByNoteId(
        long noteId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByNoteId(noteId, start, end, orderByComparator);
    }

    /**
    * Returns the first todo note in the ordered set where noteId = &#63;.
    *
    * @param noteId the note ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching todo note
    * @throws net.evrem.service.NoSuchTodoNoteException if a matching todo note could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.evrem.service.model.TodoNote findByNoteId_First(
        long noteId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchTodoNoteException {
        return getPersistence().findByNoteId_First(noteId, orderByComparator);
    }

    /**
    * Returns the first todo note in the ordered set where noteId = &#63;.
    *
    * @param noteId the note ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching todo note, or <code>null</code> if a matching todo note could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.evrem.service.model.TodoNote fetchByNoteId_First(
        long noteId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByNoteId_First(noteId, orderByComparator);
    }

    /**
    * Returns the last todo note in the ordered set where noteId = &#63;.
    *
    * @param noteId the note ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching todo note
    * @throws net.evrem.service.NoSuchTodoNoteException if a matching todo note could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.evrem.service.model.TodoNote findByNoteId_Last(
        long noteId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchTodoNoteException {
        return getPersistence().findByNoteId_Last(noteId, orderByComparator);
    }

    /**
    * Returns the last todo note in the ordered set where noteId = &#63;.
    *
    * @param noteId the note ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching todo note, or <code>null</code> if a matching todo note could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.evrem.service.model.TodoNote fetchByNoteId_Last(
        long noteId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByNoteId_Last(noteId, orderByComparator);
    }

    /**
    * Returns the todo notes before and after the current todo note in the ordered set where noteId = &#63;.
    *
    * @param todoNoteId the primary key of the current todo note
    * @param noteId the note ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next todo note
    * @throws net.evrem.service.NoSuchTodoNoteException if a todo note with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.evrem.service.model.TodoNote[] findByNoteId_PrevAndNext(
        long todoNoteId, long noteId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchTodoNoteException {
        return getPersistence()
                   .findByNoteId_PrevAndNext(todoNoteId, noteId,
            orderByComparator);
    }

    /**
    * Removes all the todo notes where noteId = &#63; from the database.
    *
    * @param noteId the note ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByNoteId(long noteId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByNoteId(noteId);
    }

    /**
    * Returns the number of todo notes where noteId = &#63;.
    *
    * @param noteId the note ID
    * @return the number of matching todo notes
    * @throws SystemException if a system exception occurred
    */
    public static int countByNoteId(long noteId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByNoteId(noteId);
    }

    /**
    * Returns the todo note where noteId = &#63; and sortNo = &#63; or throws a {@link net.evrem.service.NoSuchTodoNoteException} if it could not be found.
    *
    * @param noteId the note ID
    * @param sortNo the sort no
    * @return the matching todo note
    * @throws net.evrem.service.NoSuchTodoNoteException if a matching todo note could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.evrem.service.model.TodoNote findByNoteIdAndSortNo(
        long noteId, int sortNo)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchTodoNoteException {
        return getPersistence().findByNoteIdAndSortNo(noteId, sortNo);
    }

    /**
    * Returns the todo note where noteId = &#63; and sortNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param noteId the note ID
    * @param sortNo the sort no
    * @return the matching todo note, or <code>null</code> if a matching todo note could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.evrem.service.model.TodoNote fetchByNoteIdAndSortNo(
        long noteId, int sortNo)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByNoteIdAndSortNo(noteId, sortNo);
    }

    /**
    * Returns the todo note where noteId = &#63; and sortNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param noteId the note ID
    * @param sortNo the sort no
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching todo note, or <code>null</code> if a matching todo note could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.evrem.service.model.TodoNote fetchByNoteIdAndSortNo(
        long noteId, int sortNo, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByNoteIdAndSortNo(noteId, sortNo, retrieveFromCache);
    }

    /**
    * Removes the todo note where noteId = &#63; and sortNo = &#63; from the database.
    *
    * @param noteId the note ID
    * @param sortNo the sort no
    * @return the todo note that was removed
    * @throws SystemException if a system exception occurred
    */
    public static net.evrem.service.model.TodoNote removeByNoteIdAndSortNo(
        long noteId, int sortNo)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchTodoNoteException {
        return getPersistence().removeByNoteIdAndSortNo(noteId, sortNo);
    }

    /**
    * Returns the number of todo notes where noteId = &#63; and sortNo = &#63;.
    *
    * @param noteId the note ID
    * @param sortNo the sort no
    * @return the number of matching todo notes
    * @throws SystemException if a system exception occurred
    */
    public static int countByNoteIdAndSortNo(long noteId, int sortNo)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByNoteIdAndSortNo(noteId, sortNo);
    }

    /**
    * Caches the todo note in the entity cache if it is enabled.
    *
    * @param todoNote the todo note
    */
    public static void cacheResult(net.evrem.service.model.TodoNote todoNote) {
        getPersistence().cacheResult(todoNote);
    }

    /**
    * Caches the todo notes in the entity cache if it is enabled.
    *
    * @param todoNotes the todo notes
    */
    public static void cacheResult(
        java.util.List<net.evrem.service.model.TodoNote> todoNotes) {
        getPersistence().cacheResult(todoNotes);
    }

    /**
    * Creates a new todo note with the primary key. Does not add the todo note to the database.
    *
    * @param todoNoteId the primary key for the new todo note
    * @return the new todo note
    */
    public static net.evrem.service.model.TodoNote create(long todoNoteId) {
        return getPersistence().create(todoNoteId);
    }

    /**
    * Removes the todo note with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param todoNoteId the primary key of the todo note
    * @return the todo note that was removed
    * @throws net.evrem.service.NoSuchTodoNoteException if a todo note with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.evrem.service.model.TodoNote remove(long todoNoteId)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchTodoNoteException {
        return getPersistence().remove(todoNoteId);
    }

    public static net.evrem.service.model.TodoNote updateImpl(
        net.evrem.service.model.TodoNote todoNote)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(todoNote);
    }

    /**
    * Returns the todo note with the primary key or throws a {@link net.evrem.service.NoSuchTodoNoteException} if it could not be found.
    *
    * @param todoNoteId the primary key of the todo note
    * @return the todo note
    * @throws net.evrem.service.NoSuchTodoNoteException if a todo note with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.evrem.service.model.TodoNote findByPrimaryKey(
        long todoNoteId)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchTodoNoteException {
        return getPersistence().findByPrimaryKey(todoNoteId);
    }

    /**
    * Returns the todo note with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param todoNoteId the primary key of the todo note
    * @return the todo note, or <code>null</code> if a todo note with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.evrem.service.model.TodoNote fetchByPrimaryKey(
        long todoNoteId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(todoNoteId);
    }

    /**
    * Returns all the todo notes.
    *
    * @return the todo notes
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<net.evrem.service.model.TodoNote> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<net.evrem.service.model.TodoNote> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the todo notes.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.evrem.service.model.impl.TodoNoteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of todo notes
    * @param end the upper bound of the range of todo notes (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of todo notes
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<net.evrem.service.model.TodoNote> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the todo notes from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of todo notes.
    *
    * @return the number of todo notes
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static TodoNotePersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (TodoNotePersistence) PortletBeanLocatorUtil.locate(net.evrem.service.service.ClpSerializer.getServletContextName(),
                    TodoNotePersistence.class.getName());

            ReferenceRegistry.registerReference(TodoNoteUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(TodoNotePersistence persistence) {
    }
}
