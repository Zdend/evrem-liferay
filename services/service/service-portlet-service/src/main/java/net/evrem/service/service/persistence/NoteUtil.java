package net.evrem.service.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import net.evrem.service.model.Note;

import java.util.List;

/**
 * The persistence utility for the note service. This utility wraps {@link NotePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Zdenek Vecek
 * @see NotePersistence
 * @see NotePersistenceImpl
 * @generated
 */
public class NoteUtil {
    private static NotePersistence _persistence;

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
    public static void clearCache(Note note) {
        getPersistence().clearCache(note);
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
    public static List<Note> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Note> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Note> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static Note update(Note note) throws SystemException {
        return getPersistence().update(note);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static Note update(Note note, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(note, serviceContext);
    }

    /**
    * Returns all the notes where userId = &#63;.
    *
    * @param userId the user ID
    * @return the matching notes
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<net.evrem.service.model.Note> findByAllNotesByUserId(
        long userId) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByAllNotesByUserId(userId);
    }

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
    public static java.util.List<net.evrem.service.model.Note> findByAllNotesByUserId(
        long userId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByAllNotesByUserId(userId, start, end);
    }

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
    public static java.util.List<net.evrem.service.model.Note> findByAllNotesByUserId(
        long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByAllNotesByUserId(userId, start, end, orderByComparator);
    }

    /**
    * Returns the first note in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching note
    * @throws net.evrem.service.NoSuchNoteException if a matching note could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.evrem.service.model.Note findByAllNotesByUserId_First(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchNoteException {
        return getPersistence()
                   .findByAllNotesByUserId_First(userId, orderByComparator);
    }

    /**
    * Returns the first note in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching note, or <code>null</code> if a matching note could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.evrem.service.model.Note fetchByAllNotesByUserId_First(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByAllNotesByUserId_First(userId, orderByComparator);
    }

    /**
    * Returns the last note in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching note
    * @throws net.evrem.service.NoSuchNoteException if a matching note could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.evrem.service.model.Note findByAllNotesByUserId_Last(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchNoteException {
        return getPersistence()
                   .findByAllNotesByUserId_Last(userId, orderByComparator);
    }

    /**
    * Returns the last note in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching note, or <code>null</code> if a matching note could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.evrem.service.model.Note fetchByAllNotesByUserId_Last(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByAllNotesByUserId_Last(userId, orderByComparator);
    }

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
    public static net.evrem.service.model.Note[] findByAllNotesByUserId_PrevAndNext(
        long noteId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchNoteException {
        return getPersistence()
                   .findByAllNotesByUserId_PrevAndNext(noteId, userId,
            orderByComparator);
    }

    /**
    * Removes all the notes where userId = &#63; from the database.
    *
    * @param userId the user ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByAllNotesByUserId(long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByAllNotesByUserId(userId);
    }

    /**
    * Returns the number of notes where userId = &#63;.
    *
    * @param userId the user ID
    * @return the number of matching notes
    * @throws SystemException if a system exception occurred
    */
    public static int countByAllNotesByUserId(long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByAllNotesByUserId(userId);
    }

    /**
    * Returns all the notes where userId = &#63;.
    *
    * @param userId the user ID
    * @return the matching notes
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<net.evrem.service.model.Note> findByUserIdOnWall(
        long userId) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUserIdOnWall(userId);
    }

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
    public static java.util.List<net.evrem.service.model.Note> findByUserIdOnWall(
        long userId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUserIdOnWall(userId, start, end);
    }

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
    public static java.util.List<net.evrem.service.model.Note> findByUserIdOnWall(
        long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUserIdOnWall(userId, start, end, orderByComparator);
    }

    /**
    * Returns the first note in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching note
    * @throws net.evrem.service.NoSuchNoteException if a matching note could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.evrem.service.model.Note findByUserIdOnWall_First(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchNoteException {
        return getPersistence()
                   .findByUserIdOnWall_First(userId, orderByComparator);
    }

    /**
    * Returns the first note in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching note, or <code>null</code> if a matching note could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.evrem.service.model.Note fetchByUserIdOnWall_First(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByUserIdOnWall_First(userId, orderByComparator);
    }

    /**
    * Returns the last note in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching note
    * @throws net.evrem.service.NoSuchNoteException if a matching note could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.evrem.service.model.Note findByUserIdOnWall_Last(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchNoteException {
        return getPersistence()
                   .findByUserIdOnWall_Last(userId, orderByComparator);
    }

    /**
    * Returns the last note in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching note, or <code>null</code> if a matching note could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.evrem.service.model.Note fetchByUserIdOnWall_Last(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByUserIdOnWall_Last(userId, orderByComparator);
    }

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
    public static net.evrem.service.model.Note[] findByUserIdOnWall_PrevAndNext(
        long noteId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchNoteException {
        return getPersistence()
                   .findByUserIdOnWall_PrevAndNext(noteId, userId,
            orderByComparator);
    }

    /**
    * Removes all the notes where userId = &#63; from the database.
    *
    * @param userId the user ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByUserIdOnWall(long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByUserIdOnWall(userId);
    }

    /**
    * Returns the number of notes where userId = &#63;.
    *
    * @param userId the user ID
    * @return the number of matching notes
    * @throws SystemException if a system exception occurred
    */
    public static int countByUserIdOnWall(long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUserIdOnWall(userId);
    }

    /**
    * Returns all the notes where userId = &#63;.
    *
    * @param userId the user ID
    * @return the matching notes
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<net.evrem.service.model.Note> findByUserId(
        long userId) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUserId(userId);
    }

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
    public static java.util.List<net.evrem.service.model.Note> findByUserId(
        long userId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUserId(userId, start, end);
    }

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
    public static java.util.List<net.evrem.service.model.Note> findByUserId(
        long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUserId(userId, start, end, orderByComparator);
    }

    /**
    * Returns the first note in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching note
    * @throws net.evrem.service.NoSuchNoteException if a matching note could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.evrem.service.model.Note findByUserId_First(long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchNoteException {
        return getPersistence().findByUserId_First(userId, orderByComparator);
    }

    /**
    * Returns the first note in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching note, or <code>null</code> if a matching note could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.evrem.service.model.Note fetchByUserId_First(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUserId_First(userId, orderByComparator);
    }

    /**
    * Returns the last note in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching note
    * @throws net.evrem.service.NoSuchNoteException if a matching note could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.evrem.service.model.Note findByUserId_Last(long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchNoteException {
        return getPersistence().findByUserId_Last(userId, orderByComparator);
    }

    /**
    * Returns the last note in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching note, or <code>null</code> if a matching note could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.evrem.service.model.Note fetchByUserId_Last(long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUserId_Last(userId, orderByComparator);
    }

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
    public static net.evrem.service.model.Note[] findByUserId_PrevAndNext(
        long noteId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchNoteException {
        return getPersistence()
                   .findByUserId_PrevAndNext(noteId, userId, orderByComparator);
    }

    /**
    * Removes all the notes where userId = &#63; from the database.
    *
    * @param userId the user ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByUserId(long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByUserId(userId);
    }

    /**
    * Returns the number of notes where userId = &#63;.
    *
    * @param userId the user ID
    * @return the number of matching notes
    * @throws SystemException if a system exception occurred
    */
    public static int countByUserId(long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUserId(userId);
    }

    /**
    * Returns all the notes where userId = &#63;.
    *
    * @param userId the user ID
    * @return the matching notes
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<net.evrem.service.model.Note> findByDeletedNotesByUserId(
        long userId) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByDeletedNotesByUserId(userId);
    }

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
    public static java.util.List<net.evrem.service.model.Note> findByDeletedNotesByUserId(
        long userId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByDeletedNotesByUserId(userId, start, end);
    }

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
    public static java.util.List<net.evrem.service.model.Note> findByDeletedNotesByUserId(
        long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByDeletedNotesByUserId(userId, start, end,
            orderByComparator);
    }

    /**
    * Returns the first note in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching note
    * @throws net.evrem.service.NoSuchNoteException if a matching note could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.evrem.service.model.Note findByDeletedNotesByUserId_First(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchNoteException {
        return getPersistence()
                   .findByDeletedNotesByUserId_First(userId, orderByComparator);
    }

    /**
    * Returns the first note in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching note, or <code>null</code> if a matching note could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.evrem.service.model.Note fetchByDeletedNotesByUserId_First(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByDeletedNotesByUserId_First(userId, orderByComparator);
    }

    /**
    * Returns the last note in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching note
    * @throws net.evrem.service.NoSuchNoteException if a matching note could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.evrem.service.model.Note findByDeletedNotesByUserId_Last(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchNoteException {
        return getPersistence()
                   .findByDeletedNotesByUserId_Last(userId, orderByComparator);
    }

    /**
    * Returns the last note in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching note, or <code>null</code> if a matching note could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.evrem.service.model.Note fetchByDeletedNotesByUserId_Last(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByDeletedNotesByUserId_Last(userId, orderByComparator);
    }

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
    public static net.evrem.service.model.Note[] findByDeletedNotesByUserId_PrevAndNext(
        long noteId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchNoteException {
        return getPersistence()
                   .findByDeletedNotesByUserId_PrevAndNext(noteId, userId,
            orderByComparator);
    }

    /**
    * Removes all the notes where userId = &#63; from the database.
    *
    * @param userId the user ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByDeletedNotesByUserId(long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByDeletedNotesByUserId(userId);
    }

    /**
    * Returns the number of notes where userId = &#63;.
    *
    * @param userId the user ID
    * @return the number of matching notes
    * @throws SystemException if a system exception occurred
    */
    public static int countByDeletedNotesByUserId(long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByDeletedNotesByUserId(userId);
    }

    /**
    * Returns all the notes where userId = &#63;.
    *
    * @param userId the user ID
    * @return the matching notes
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<net.evrem.service.model.Note> findByEventTime(
        long userId) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByEventTime(userId);
    }

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
    public static java.util.List<net.evrem.service.model.Note> findByEventTime(
        long userId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByEventTime(userId, start, end);
    }

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
    public static java.util.List<net.evrem.service.model.Note> findByEventTime(
        long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByEventTime(userId, start, end, orderByComparator);
    }

    /**
    * Returns the first note in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching note
    * @throws net.evrem.service.NoSuchNoteException if a matching note could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.evrem.service.model.Note findByEventTime_First(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchNoteException {
        return getPersistence().findByEventTime_First(userId, orderByComparator);
    }

    /**
    * Returns the first note in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching note, or <code>null</code> if a matching note could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.evrem.service.model.Note fetchByEventTime_First(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByEventTime_First(userId, orderByComparator);
    }

    /**
    * Returns the last note in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching note
    * @throws net.evrem.service.NoSuchNoteException if a matching note could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.evrem.service.model.Note findByEventTime_Last(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchNoteException {
        return getPersistence().findByEventTime_Last(userId, orderByComparator);
    }

    /**
    * Returns the last note in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching note, or <code>null</code> if a matching note could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.evrem.service.model.Note fetchByEventTime_Last(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByEventTime_Last(userId, orderByComparator);
    }

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
    public static net.evrem.service.model.Note[] findByEventTime_PrevAndNext(
        long noteId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchNoteException {
        return getPersistence()
                   .findByEventTime_PrevAndNext(noteId, userId,
            orderByComparator);
    }

    /**
    * Removes all the notes where userId = &#63; from the database.
    *
    * @param userId the user ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByEventTime(long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByEventTime(userId);
    }

    /**
    * Returns the number of notes where userId = &#63;.
    *
    * @param userId the user ID
    * @return the number of matching notes
    * @throws SystemException if a system exception occurred
    */
    public static int countByEventTime(long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByEventTime(userId);
    }

    /**
    * Returns all the notes where userId = &#63;.
    *
    * @param userId the user ID
    * @return the matching notes
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<net.evrem.service.model.Note> findByRemindDate(
        long userId) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByRemindDate(userId);
    }

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
    public static java.util.List<net.evrem.service.model.Note> findByRemindDate(
        long userId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByRemindDate(userId, start, end);
    }

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
    public static java.util.List<net.evrem.service.model.Note> findByRemindDate(
        long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByRemindDate(userId, start, end, orderByComparator);
    }

    /**
    * Returns the first note in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching note
    * @throws net.evrem.service.NoSuchNoteException if a matching note could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.evrem.service.model.Note findByRemindDate_First(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchNoteException {
        return getPersistence().findByRemindDate_First(userId, orderByComparator);
    }

    /**
    * Returns the first note in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching note, or <code>null</code> if a matching note could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.evrem.service.model.Note fetchByRemindDate_First(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByRemindDate_First(userId, orderByComparator);
    }

    /**
    * Returns the last note in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching note
    * @throws net.evrem.service.NoSuchNoteException if a matching note could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.evrem.service.model.Note findByRemindDate_Last(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchNoteException {
        return getPersistence().findByRemindDate_Last(userId, orderByComparator);
    }

    /**
    * Returns the last note in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching note, or <code>null</code> if a matching note could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.evrem.service.model.Note fetchByRemindDate_Last(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByRemindDate_Last(userId, orderByComparator);
    }

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
    public static net.evrem.service.model.Note[] findByRemindDate_PrevAndNext(
        long noteId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchNoteException {
        return getPersistence()
                   .findByRemindDate_PrevAndNext(noteId, userId,
            orderByComparator);
    }

    /**
    * Removes all the notes where userId = &#63; from the database.
    *
    * @param userId the user ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByRemindDate(long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByRemindDate(userId);
    }

    /**
    * Returns the number of notes where userId = &#63;.
    *
    * @param userId the user ID
    * @return the number of matching notes
    * @throws SystemException if a system exception occurred
    */
    public static int countByRemindDate(long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByRemindDate(userId);
    }

    /**
    * Caches the note in the entity cache if it is enabled.
    *
    * @param note the note
    */
    public static void cacheResult(net.evrem.service.model.Note note) {
        getPersistence().cacheResult(note);
    }

    /**
    * Caches the notes in the entity cache if it is enabled.
    *
    * @param notes the notes
    */
    public static void cacheResult(
        java.util.List<net.evrem.service.model.Note> notes) {
        getPersistence().cacheResult(notes);
    }

    /**
    * Creates a new note with the primary key. Does not add the note to the database.
    *
    * @param noteId the primary key for the new note
    * @return the new note
    */
    public static net.evrem.service.model.Note create(long noteId) {
        return getPersistence().create(noteId);
    }

    /**
    * Removes the note with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param noteId the primary key of the note
    * @return the note that was removed
    * @throws net.evrem.service.NoSuchNoteException if a note with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.evrem.service.model.Note remove(long noteId)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchNoteException {
        return getPersistence().remove(noteId);
    }

    public static net.evrem.service.model.Note updateImpl(
        net.evrem.service.model.Note note)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(note);
    }

    /**
    * Returns the note with the primary key or throws a {@link net.evrem.service.NoSuchNoteException} if it could not be found.
    *
    * @param noteId the primary key of the note
    * @return the note
    * @throws net.evrem.service.NoSuchNoteException if a note with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.evrem.service.model.Note findByPrimaryKey(long noteId)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchNoteException {
        return getPersistence().findByPrimaryKey(noteId);
    }

    /**
    * Returns the note with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param noteId the primary key of the note
    * @return the note, or <code>null</code> if a note with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static net.evrem.service.model.Note fetchByPrimaryKey(long noteId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(noteId);
    }

    /**
    * Returns all the notes.
    *
    * @return the notes
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<net.evrem.service.model.Note> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<net.evrem.service.model.Note> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

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
    public static java.util.List<net.evrem.service.model.Note> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the notes from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of notes.
    *
    * @return the number of notes
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static NotePersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (NotePersistence) PortletBeanLocatorUtil.locate(net.evrem.service.service.ClpSerializer.getServletContextName(),
                    NotePersistence.class.getName());

            ReferenceRegistry.registerReference(NoteUtil.class, "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(NotePersistence persistence) {
    }
}
