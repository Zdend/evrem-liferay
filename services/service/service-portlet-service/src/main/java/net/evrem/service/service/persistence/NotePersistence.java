package net.evrem.service.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import net.evrem.service.model.Note;

/**
 * The persistence interface for the note service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Zdenek Vecek
 * @see NotePersistenceImpl
 * @see NoteUtil
 * @generated
 */
public interface NotePersistence extends BasePersistence<Note> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link NoteUtil} to access the note persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the notes where userId = &#63;.
    *
    * @param userId the user ID
    * @return the matching notes
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<net.evrem.service.model.Note> findByAllNotesByUserId(
        long userId) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the notes where userId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.evrem.service.model.impl.NoteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userId the user ID
    * @param start the lower bound of the range of notes
    * @param end the upper bound of the range of notes (not inclusive)
    * @return the range of matching notes
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<net.evrem.service.model.Note> findByAllNotesByUserId(
        long userId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the notes where userId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.evrem.service.model.impl.NoteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userId the user ID
    * @param start the lower bound of the range of notes
    * @param end the upper bound of the range of notes (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching notes
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<net.evrem.service.model.Note> findByAllNotesByUserId(
        long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first note in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching note
    * @throws net.evrem.service.NoSuchNoteException if a matching note could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.evrem.service.model.Note findByAllNotesByUserId_First(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchNoteException;

    /**
    * Returns the first note in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching note, or <code>null</code> if a matching note could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.evrem.service.model.Note fetchByAllNotesByUserId_First(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last note in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching note
    * @throws net.evrem.service.NoSuchNoteException if a matching note could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.evrem.service.model.Note findByAllNotesByUserId_Last(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchNoteException;

    /**
    * Returns the last note in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching note, or <code>null</code> if a matching note could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.evrem.service.model.Note fetchByAllNotesByUserId_Last(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the notes before and after the current note in the ordered set where userId = &#63;.
    *
    * @param noteId the primary key of the current note
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next note
    * @throws net.evrem.service.NoSuchNoteException if a note with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.evrem.service.model.Note[] findByAllNotesByUserId_PrevAndNext(
        long noteId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchNoteException;

    /**
    * Removes all the notes where userId = &#63; from the database.
    *
    * @param userId the user ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByAllNotesByUserId(long userId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of notes where userId = &#63;.
    *
    * @param userId the user ID
    * @return the number of matching notes
    * @throws SystemException if a system exception occurred
    */
    public int countByAllNotesByUserId(long userId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the notes where userId = &#63;.
    *
    * @param userId the user ID
    * @return the matching notes
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<net.evrem.service.model.Note> findByUserIdOnWall(
        long userId) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the notes where userId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.evrem.service.model.impl.NoteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userId the user ID
    * @param start the lower bound of the range of notes
    * @param end the upper bound of the range of notes (not inclusive)
    * @return the range of matching notes
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<net.evrem.service.model.Note> findByUserIdOnWall(
        long userId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the notes where userId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.evrem.service.model.impl.NoteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userId the user ID
    * @param start the lower bound of the range of notes
    * @param end the upper bound of the range of notes (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching notes
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<net.evrem.service.model.Note> findByUserIdOnWall(
        long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first note in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching note
    * @throws net.evrem.service.NoSuchNoteException if a matching note could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.evrem.service.model.Note findByUserIdOnWall_First(long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchNoteException;

    /**
    * Returns the first note in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching note, or <code>null</code> if a matching note could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.evrem.service.model.Note fetchByUserIdOnWall_First(long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last note in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching note
    * @throws net.evrem.service.NoSuchNoteException if a matching note could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.evrem.service.model.Note findByUserIdOnWall_Last(long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchNoteException;

    /**
    * Returns the last note in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching note, or <code>null</code> if a matching note could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.evrem.service.model.Note fetchByUserIdOnWall_Last(long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the notes before and after the current note in the ordered set where userId = &#63;.
    *
    * @param noteId the primary key of the current note
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next note
    * @throws net.evrem.service.NoSuchNoteException if a note with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.evrem.service.model.Note[] findByUserIdOnWall_PrevAndNext(
        long noteId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchNoteException;

    /**
    * Removes all the notes where userId = &#63; from the database.
    *
    * @param userId the user ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByUserIdOnWall(long userId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of notes where userId = &#63;.
    *
    * @param userId the user ID
    * @return the number of matching notes
    * @throws SystemException if a system exception occurred
    */
    public int countByUserIdOnWall(long userId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the notes where userId = &#63;.
    *
    * @param userId the user ID
    * @return the matching notes
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<net.evrem.service.model.Note> findByUserId(
        long userId) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the notes where userId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.evrem.service.model.impl.NoteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userId the user ID
    * @param start the lower bound of the range of notes
    * @param end the upper bound of the range of notes (not inclusive)
    * @return the range of matching notes
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<net.evrem.service.model.Note> findByUserId(
        long userId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the notes where userId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.evrem.service.model.impl.NoteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userId the user ID
    * @param start the lower bound of the range of notes
    * @param end the upper bound of the range of notes (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching notes
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<net.evrem.service.model.Note> findByUserId(
        long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first note in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching note
    * @throws net.evrem.service.NoSuchNoteException if a matching note could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.evrem.service.model.Note findByUserId_First(long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchNoteException;

    /**
    * Returns the first note in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching note, or <code>null</code> if a matching note could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.evrem.service.model.Note fetchByUserId_First(long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last note in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching note
    * @throws net.evrem.service.NoSuchNoteException if a matching note could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.evrem.service.model.Note findByUserId_Last(long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchNoteException;

    /**
    * Returns the last note in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching note, or <code>null</code> if a matching note could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.evrem.service.model.Note fetchByUserId_Last(long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the notes before and after the current note in the ordered set where userId = &#63;.
    *
    * @param noteId the primary key of the current note
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next note
    * @throws net.evrem.service.NoSuchNoteException if a note with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.evrem.service.model.Note[] findByUserId_PrevAndNext(
        long noteId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchNoteException;

    /**
    * Removes all the notes where userId = &#63; from the database.
    *
    * @param userId the user ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByUserId(long userId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of notes where userId = &#63;.
    *
    * @param userId the user ID
    * @return the number of matching notes
    * @throws SystemException if a system exception occurred
    */
    public int countByUserId(long userId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the notes where userId = &#63;.
    *
    * @param userId the user ID
    * @return the matching notes
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<net.evrem.service.model.Note> findByDeletedNotesByUserId(
        long userId) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the notes where userId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.evrem.service.model.impl.NoteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userId the user ID
    * @param start the lower bound of the range of notes
    * @param end the upper bound of the range of notes (not inclusive)
    * @return the range of matching notes
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<net.evrem.service.model.Note> findByDeletedNotesByUserId(
        long userId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the notes where userId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.evrem.service.model.impl.NoteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userId the user ID
    * @param start the lower bound of the range of notes
    * @param end the upper bound of the range of notes (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching notes
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<net.evrem.service.model.Note> findByDeletedNotesByUserId(
        long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first note in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching note
    * @throws net.evrem.service.NoSuchNoteException if a matching note could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.evrem.service.model.Note findByDeletedNotesByUserId_First(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchNoteException;

    /**
    * Returns the first note in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching note, or <code>null</code> if a matching note could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.evrem.service.model.Note fetchByDeletedNotesByUserId_First(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last note in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching note
    * @throws net.evrem.service.NoSuchNoteException if a matching note could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.evrem.service.model.Note findByDeletedNotesByUserId_Last(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchNoteException;

    /**
    * Returns the last note in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching note, or <code>null</code> if a matching note could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.evrem.service.model.Note fetchByDeletedNotesByUserId_Last(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the notes before and after the current note in the ordered set where userId = &#63;.
    *
    * @param noteId the primary key of the current note
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next note
    * @throws net.evrem.service.NoSuchNoteException if a note with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.evrem.service.model.Note[] findByDeletedNotesByUserId_PrevAndNext(
        long noteId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchNoteException;

    /**
    * Removes all the notes where userId = &#63; from the database.
    *
    * @param userId the user ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByDeletedNotesByUserId(long userId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of notes where userId = &#63;.
    *
    * @param userId the user ID
    * @return the number of matching notes
    * @throws SystemException if a system exception occurred
    */
    public int countByDeletedNotesByUserId(long userId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the notes where userId = &#63;.
    *
    * @param userId the user ID
    * @return the matching notes
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<net.evrem.service.model.Note> findByEventTime(
        long userId) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the notes where userId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.evrem.service.model.impl.NoteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userId the user ID
    * @param start the lower bound of the range of notes
    * @param end the upper bound of the range of notes (not inclusive)
    * @return the range of matching notes
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<net.evrem.service.model.Note> findByEventTime(
        long userId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the notes where userId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.evrem.service.model.impl.NoteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userId the user ID
    * @param start the lower bound of the range of notes
    * @param end the upper bound of the range of notes (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching notes
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<net.evrem.service.model.Note> findByEventTime(
        long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first note in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching note
    * @throws net.evrem.service.NoSuchNoteException if a matching note could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.evrem.service.model.Note findByEventTime_First(long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchNoteException;

    /**
    * Returns the first note in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching note, or <code>null</code> if a matching note could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.evrem.service.model.Note fetchByEventTime_First(long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last note in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching note
    * @throws net.evrem.service.NoSuchNoteException if a matching note could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.evrem.service.model.Note findByEventTime_Last(long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchNoteException;

    /**
    * Returns the last note in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching note, or <code>null</code> if a matching note could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.evrem.service.model.Note fetchByEventTime_Last(long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the notes before and after the current note in the ordered set where userId = &#63;.
    *
    * @param noteId the primary key of the current note
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next note
    * @throws net.evrem.service.NoSuchNoteException if a note with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.evrem.service.model.Note[] findByEventTime_PrevAndNext(
        long noteId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchNoteException;

    /**
    * Removes all the notes where userId = &#63; from the database.
    *
    * @param userId the user ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByEventTime(long userId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of notes where userId = &#63;.
    *
    * @param userId the user ID
    * @return the number of matching notes
    * @throws SystemException if a system exception occurred
    */
    public int countByEventTime(long userId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the notes where userId = &#63;.
    *
    * @param userId the user ID
    * @return the matching notes
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<net.evrem.service.model.Note> findByRemindDate(
        long userId) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the notes where userId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.evrem.service.model.impl.NoteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userId the user ID
    * @param start the lower bound of the range of notes
    * @param end the upper bound of the range of notes (not inclusive)
    * @return the range of matching notes
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<net.evrem.service.model.Note> findByRemindDate(
        long userId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the notes where userId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.evrem.service.model.impl.NoteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param userId the user ID
    * @param start the lower bound of the range of notes
    * @param end the upper bound of the range of notes (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching notes
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<net.evrem.service.model.Note> findByRemindDate(
        long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first note in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching note
    * @throws net.evrem.service.NoSuchNoteException if a matching note could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.evrem.service.model.Note findByRemindDate_First(long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchNoteException;

    /**
    * Returns the first note in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching note, or <code>null</code> if a matching note could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.evrem.service.model.Note fetchByRemindDate_First(long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last note in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching note
    * @throws net.evrem.service.NoSuchNoteException if a matching note could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.evrem.service.model.Note findByRemindDate_Last(long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchNoteException;

    /**
    * Returns the last note in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching note, or <code>null</code> if a matching note could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.evrem.service.model.Note fetchByRemindDate_Last(long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the notes before and after the current note in the ordered set where userId = &#63;.
    *
    * @param noteId the primary key of the current note
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next note
    * @throws net.evrem.service.NoSuchNoteException if a note with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.evrem.service.model.Note[] findByRemindDate_PrevAndNext(
        long noteId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchNoteException;

    /**
    * Removes all the notes where userId = &#63; from the database.
    *
    * @param userId the user ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByRemindDate(long userId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of notes where userId = &#63;.
    *
    * @param userId the user ID
    * @return the number of matching notes
    * @throws SystemException if a system exception occurred
    */
    public int countByRemindDate(long userId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the note in the entity cache if it is enabled.
    *
    * @param note the note
    */
    public void cacheResult(net.evrem.service.model.Note note);

    /**
    * Caches the notes in the entity cache if it is enabled.
    *
    * @param notes the notes
    */
    public void cacheResult(java.util.List<net.evrem.service.model.Note> notes);

    /**
    * Creates a new note with the primary key. Does not add the note to the database.
    *
    * @param noteId the primary key for the new note
    * @return the new note
    */
    public net.evrem.service.model.Note create(long noteId);

    /**
    * Removes the note with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param noteId the primary key of the note
    * @return the note that was removed
    * @throws net.evrem.service.NoSuchNoteException if a note with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.evrem.service.model.Note remove(long noteId)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchNoteException;

    public net.evrem.service.model.Note updateImpl(
        net.evrem.service.model.Note note)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the note with the primary key or throws a {@link net.evrem.service.NoSuchNoteException} if it could not be found.
    *
    * @param noteId the primary key of the note
    * @return the note
    * @throws net.evrem.service.NoSuchNoteException if a note with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.evrem.service.model.Note findByPrimaryKey(long noteId)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchNoteException;

    /**
    * Returns the note with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param noteId the primary key of the note
    * @return the note, or <code>null</code> if a note with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.evrem.service.model.Note fetchByPrimaryKey(long noteId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the notes.
    *
    * @return the notes
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<net.evrem.service.model.Note> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<net.evrem.service.model.Note> findAll(int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the notes.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.evrem.service.model.impl.NoteModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of notes
    * @param end the upper bound of the range of notes (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of notes
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<net.evrem.service.model.Note> findAll(int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the notes from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of notes.
    *
    * @return the number of notes
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
