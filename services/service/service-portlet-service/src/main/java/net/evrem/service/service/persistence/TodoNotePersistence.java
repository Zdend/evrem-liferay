package net.evrem.service.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import net.evrem.service.model.TodoNote;

/**
 * The persistence interface for the todo note service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Zdenek Vecek
 * @see TodoNotePersistenceImpl
 * @see TodoNoteUtil
 * @generated
 */
public interface TodoNotePersistence extends BasePersistence<TodoNote> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link TodoNoteUtil} to access the todo note persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the todo notes where noteId = &#63;.
    *
    * @param noteId the note ID
    * @return the matching todo notes
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<net.evrem.service.model.TodoNote> findByNoteId(
        long noteId) throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<net.evrem.service.model.TodoNote> findByNoteId(
        long noteId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<net.evrem.service.model.TodoNote> findByNoteId(
        long noteId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first todo note in the ordered set where noteId = &#63;.
    *
    * @param noteId the note ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching todo note
    * @throws net.evrem.service.NoSuchTodoNoteException if a matching todo note could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.evrem.service.model.TodoNote findByNoteId_First(long noteId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchTodoNoteException;

    /**
    * Returns the first todo note in the ordered set where noteId = &#63;.
    *
    * @param noteId the note ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching todo note, or <code>null</code> if a matching todo note could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.evrem.service.model.TodoNote fetchByNoteId_First(long noteId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last todo note in the ordered set where noteId = &#63;.
    *
    * @param noteId the note ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching todo note
    * @throws net.evrem.service.NoSuchTodoNoteException if a matching todo note could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.evrem.service.model.TodoNote findByNoteId_Last(long noteId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchTodoNoteException;

    /**
    * Returns the last todo note in the ordered set where noteId = &#63;.
    *
    * @param noteId the note ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching todo note, or <code>null</code> if a matching todo note could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.evrem.service.model.TodoNote fetchByNoteId_Last(long noteId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public net.evrem.service.model.TodoNote[] findByNoteId_PrevAndNext(
        long todoNoteId, long noteId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchTodoNoteException;

    /**
    * Removes all the todo notes where noteId = &#63; from the database.
    *
    * @param noteId the note ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByNoteId(long noteId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of todo notes where noteId = &#63;.
    *
    * @param noteId the note ID
    * @return the number of matching todo notes
    * @throws SystemException if a system exception occurred
    */
    public int countByNoteId(long noteId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the todo note where noteId = &#63; and sortNo = &#63; or throws a {@link net.evrem.service.NoSuchTodoNoteException} if it could not be found.
    *
    * @param noteId the note ID
    * @param sortNo the sort no
    * @return the matching todo note
    * @throws net.evrem.service.NoSuchTodoNoteException if a matching todo note could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.evrem.service.model.TodoNote findByNoteIdAndSortNo(long noteId,
        int sortNo)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchTodoNoteException;

    /**
    * Returns the todo note where noteId = &#63; and sortNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param noteId the note ID
    * @param sortNo the sort no
    * @return the matching todo note, or <code>null</code> if a matching todo note could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.evrem.service.model.TodoNote fetchByNoteIdAndSortNo(
        long noteId, int sortNo)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the todo note where noteId = &#63; and sortNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param noteId the note ID
    * @param sortNo the sort no
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching todo note, or <code>null</code> if a matching todo note could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.evrem.service.model.TodoNote fetchByNoteIdAndSortNo(
        long noteId, int sortNo, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the todo note where noteId = &#63; and sortNo = &#63; from the database.
    *
    * @param noteId the note ID
    * @param sortNo the sort no
    * @return the todo note that was removed
    * @throws SystemException if a system exception occurred
    */
    public net.evrem.service.model.TodoNote removeByNoteIdAndSortNo(
        long noteId, int sortNo)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchTodoNoteException;

    /**
    * Returns the number of todo notes where noteId = &#63; and sortNo = &#63;.
    *
    * @param noteId the note ID
    * @param sortNo the sort no
    * @return the number of matching todo notes
    * @throws SystemException if a system exception occurred
    */
    public int countByNoteIdAndSortNo(long noteId, int sortNo)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the todo note in the entity cache if it is enabled.
    *
    * @param todoNote the todo note
    */
    public void cacheResult(net.evrem.service.model.TodoNote todoNote);

    /**
    * Caches the todo notes in the entity cache if it is enabled.
    *
    * @param todoNotes the todo notes
    */
    public void cacheResult(
        java.util.List<net.evrem.service.model.TodoNote> todoNotes);

    /**
    * Creates a new todo note with the primary key. Does not add the todo note to the database.
    *
    * @param todoNoteId the primary key for the new todo note
    * @return the new todo note
    */
    public net.evrem.service.model.TodoNote create(long todoNoteId);

    /**
    * Removes the todo note with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param todoNoteId the primary key of the todo note
    * @return the todo note that was removed
    * @throws net.evrem.service.NoSuchTodoNoteException if a todo note with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.evrem.service.model.TodoNote remove(long todoNoteId)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchTodoNoteException;

    public net.evrem.service.model.TodoNote updateImpl(
        net.evrem.service.model.TodoNote todoNote)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the todo note with the primary key or throws a {@link net.evrem.service.NoSuchTodoNoteException} if it could not be found.
    *
    * @param todoNoteId the primary key of the todo note
    * @return the todo note
    * @throws net.evrem.service.NoSuchTodoNoteException if a todo note with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.evrem.service.model.TodoNote findByPrimaryKey(long todoNoteId)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchTodoNoteException;

    /**
    * Returns the todo note with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param todoNoteId the primary key of the todo note
    * @return the todo note, or <code>null</code> if a todo note with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.evrem.service.model.TodoNote fetchByPrimaryKey(long todoNoteId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the todo notes.
    *
    * @return the todo notes
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<net.evrem.service.model.TodoNote> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<net.evrem.service.model.TodoNote> findAll(int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<net.evrem.service.model.TodoNote> findAll(int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the todo notes from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of todo notes.
    *
    * @return the number of todo notes
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
