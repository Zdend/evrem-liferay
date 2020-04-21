package net.evrem.service.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import net.evrem.service.NoSuchNoteException;
import net.evrem.service.model.Note;
import net.evrem.service.model.impl.NoteImpl;
import net.evrem.service.model.impl.NoteModelImpl;
import net.evrem.service.service.persistence.NotePersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the note service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Zdenek Vecek
 * @see NotePersistence
 * @see NoteUtil
 * @generated
 */
public class NotePersistenceImpl extends BasePersistenceImpl<Note>
    implements NotePersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link NoteUtil} to access the note persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = NoteImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(NoteModelImpl.ENTITY_CACHE_ENABLED,
            NoteModelImpl.FINDER_CACHE_ENABLED, NoteImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(NoteModelImpl.ENTITY_CACHE_ENABLED,
            NoteModelImpl.FINDER_CACHE_ENABLED, NoteImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(NoteModelImpl.ENTITY_CACHE_ENABLED,
            NoteModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ALLNOTESBYUSERID =
        new FinderPath(NoteModelImpl.ENTITY_CACHE_ENABLED,
            NoteModelImpl.FINDER_CACHE_ENABLED, NoteImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAllNotesByUserId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLNOTESBYUSERID =
        new FinderPath(NoteModelImpl.ENTITY_CACHE_ENABLED,
            NoteModelImpl.FINDER_CACHE_ENABLED, NoteImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByAllNotesByUserId", new String[] { Long.class.getName() },
            NoteModelImpl.USERID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_ALLNOTESBYUSERID = new FinderPath(NoteModelImpl.ENTITY_CACHE_ENABLED,
            NoteModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByAllNotesByUserId", new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_ALLNOTESBYUSERID_USERID_2 = "note.userId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDONWALL =
        new FinderPath(NoteModelImpl.ENTITY_CACHE_ENABLED,
            NoteModelImpl.FINDER_CACHE_ENABLED, NoteImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserIdOnWall",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDONWALL =
        new FinderPath(NoteModelImpl.ENTITY_CACHE_ENABLED,
            NoteModelImpl.FINDER_CACHE_ENABLED, NoteImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserIdOnWall",
            new String[] { Long.class.getName() },
            NoteModelImpl.USERID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_USERIDONWALL = new FinderPath(NoteModelImpl.ENTITY_CACHE_ENABLED,
            NoteModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserIdOnWall",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_USERIDONWALL_USERID_2 = "note.userId = ? AND note.hasWall=1 AND note.isDeleted=0";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(NoteModelImpl.ENTITY_CACHE_ENABLED,
            NoteModelImpl.FINDER_CACHE_ENABLED, NoteImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
        new FinderPath(NoteModelImpl.ENTITY_CACHE_ENABLED,
            NoteModelImpl.FINDER_CACHE_ENABLED, NoteImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
            new String[] { Long.class.getName() },
            NoteModelImpl.USERID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(NoteModelImpl.ENTITY_CACHE_ENABLED,
            NoteModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_USERID_USERID_2 = "note.userId = ? AND note.isDeleted=0";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DELETEDNOTESBYUSERID =
        new FinderPath(NoteModelImpl.ENTITY_CACHE_ENABLED,
            NoteModelImpl.FINDER_CACHE_ENABLED, NoteImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByDeletedNotesByUserId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DELETEDNOTESBYUSERID =
        new FinderPath(NoteModelImpl.ENTITY_CACHE_ENABLED,
            NoteModelImpl.FINDER_CACHE_ENABLED, NoteImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByDeletedNotesByUserId",
            new String[] { Long.class.getName() },
            NoteModelImpl.USERID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_DELETEDNOTESBYUSERID = new FinderPath(NoteModelImpl.ENTITY_CACHE_ENABLED,
            NoteModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByDeletedNotesByUserId", new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_DELETEDNOTESBYUSERID_USERID_2 = "note.userId = ? AND note.isDeleted=1";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EVENTTIME =
        new FinderPath(NoteModelImpl.ENTITY_CACHE_ENABLED,
            NoteModelImpl.FINDER_CACHE_ENABLED, NoteImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEventTime",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTTIME =
        new FinderPath(NoteModelImpl.ENTITY_CACHE_ENABLED,
            NoteModelImpl.FINDER_CACHE_ENABLED, NoteImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEventTime",
            new String[] { Long.class.getName() },
            NoteModelImpl.USERID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_EVENTTIME = new FinderPath(NoteModelImpl.ENTITY_CACHE_ENABLED,
            NoteModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEventTime",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_EVENTTIME_USERID_2 = "note.userId = ? AND note.hasTime=1 AND note.isDeleted=0";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_REMINDDATE =
        new FinderPath(NoteModelImpl.ENTITY_CACHE_ENABLED,
            NoteModelImpl.FINDER_CACHE_ENABLED, NoteImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRemindDate",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REMINDDATE =
        new FinderPath(NoteModelImpl.ENTITY_CACHE_ENABLED,
            NoteModelImpl.FINDER_CACHE_ENABLED, NoteImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRemindDate",
            new String[] { Long.class.getName() },
            NoteModelImpl.USERID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_REMINDDATE = new FinderPath(NoteModelImpl.ENTITY_CACHE_ENABLED,
            NoteModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRemindDate",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_REMINDDATE_USERID_2 = "note.userId = ? AND note.hasReminder=1 AND note.isDeleted=0";
    private static final String _SQL_SELECT_NOTE = "SELECT note FROM Note note";
    private static final String _SQL_SELECT_NOTE_WHERE = "SELECT note FROM Note note WHERE ";
    private static final String _SQL_COUNT_NOTE = "SELECT COUNT(note) FROM Note note";
    private static final String _SQL_COUNT_NOTE_WHERE = "SELECT COUNT(note) FROM Note note WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "note.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Note exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Note exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(NotePersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "noteId", "userId", "hasCheck", "hasTime", "hasReminder",
                "hasTodo", "hasRepeat", "hasColor", "hasWall", "isDone",
                "eventTime", "createdDate", "modifiedDate", "isDeleted"
            });
    private static Note _nullNote = new NoteImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Note> toCacheModel() {
                return _nullNoteCacheModel;
            }
        };

    private static CacheModel<Note> _nullNoteCacheModel = new CacheModel<Note>() {
            @Override
            public Note toEntityModel() {
                return _nullNote;
            }
        };

    public NotePersistenceImpl() {
        setModelClass(Note.class);
    }

    /**
     * Returns all the notes where userId = &#63;.
     *
     * @param userId the user ID
     * @return the matching notes
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Note> findByAllNotesByUserId(long userId)
        throws SystemException {
        return findByAllNotesByUserId(userId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
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
    @Override
    public List<Note> findByAllNotesByUserId(long userId, int start, int end)
        throws SystemException {
        return findByAllNotesByUserId(userId, start, end, null);
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
    @Override
    public List<Note> findByAllNotesByUserId(long userId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLNOTESBYUSERID;
            finderArgs = new Object[] { userId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ALLNOTESBYUSERID;
            finderArgs = new Object[] { userId, start, end, orderByComparator };
        }

        List<Note> list = (List<Note>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Note note : list) {
                if ((userId != note.getUserId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_NOTE_WHERE);

            query.append(_FINDER_COLUMN_ALLNOTESBYUSERID_USERID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(NoteModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                if (!pagination) {
                    list = (List<Note>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Note>(list);
                } else {
                    list = (List<Note>) QueryUtil.list(q, getDialect(), start,
                            end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
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
    @Override
    public Note findByAllNotesByUserId_First(long userId,
        OrderByComparator orderByComparator)
        throws NoSuchNoteException, SystemException {
        Note note = fetchByAllNotesByUserId_First(userId, orderByComparator);

        if (note != null) {
            return note;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userId=");
        msg.append(userId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchNoteException(msg.toString());
    }

    /**
     * Returns the first note in the ordered set where userId = &#63;.
     *
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching note, or <code>null</code> if a matching note could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Note fetchByAllNotesByUserId_First(long userId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Note> list = findByAllNotesByUserId(userId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Note findByAllNotesByUserId_Last(long userId,
        OrderByComparator orderByComparator)
        throws NoSuchNoteException, SystemException {
        Note note = fetchByAllNotesByUserId_Last(userId, orderByComparator);

        if (note != null) {
            return note;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userId=");
        msg.append(userId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchNoteException(msg.toString());
    }

    /**
     * Returns the last note in the ordered set where userId = &#63;.
     *
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching note, or <code>null</code> if a matching note could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Note fetchByAllNotesByUserId_Last(long userId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByAllNotesByUserId(userId);

        if (count == 0) {
            return null;
        }

        List<Note> list = findByAllNotesByUserId(userId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Note[] findByAllNotesByUserId_PrevAndNext(long noteId, long userId,
        OrderByComparator orderByComparator)
        throws NoSuchNoteException, SystemException {
        Note note = findByPrimaryKey(noteId);

        Session session = null;

        try {
            session = openSession();

            Note[] array = new NoteImpl[3];

            array[0] = getByAllNotesByUserId_PrevAndNext(session, note, userId,
                    orderByComparator, true);

            array[1] = note;

            array[2] = getByAllNotesByUserId_PrevAndNext(session, note, userId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Note getByAllNotesByUserId_PrevAndNext(Session session,
        Note note, long userId, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_NOTE_WHERE);

        query.append(_FINDER_COLUMN_ALLNOTESBYUSERID_USERID_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(NoteModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(userId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(note);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Note> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the notes where userId = &#63; from the database.
     *
     * @param userId the user ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByAllNotesByUserId(long userId) throws SystemException {
        for (Note note : findByAllNotesByUserId(userId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(note);
        }
    }

    /**
     * Returns the number of notes where userId = &#63;.
     *
     * @param userId the user ID
     * @return the number of matching notes
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByAllNotesByUserId(long userId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_ALLNOTESBYUSERID;

        Object[] finderArgs = new Object[] { userId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_NOTE_WHERE);

            query.append(_FINDER_COLUMN_ALLNOTESBYUSERID_USERID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the notes where userId = &#63;.
     *
     * @param userId the user ID
     * @return the matching notes
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Note> findByUserIdOnWall(long userId) throws SystemException {
        return findByUserIdOnWall(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
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
    @Override
    public List<Note> findByUserIdOnWall(long userId, int start, int end)
        throws SystemException {
        return findByUserIdOnWall(userId, start, end, null);
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
    @Override
    public List<Note> findByUserIdOnWall(long userId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDONWALL;
            finderArgs = new Object[] { userId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERIDONWALL;
            finderArgs = new Object[] { userId, start, end, orderByComparator };
        }

        List<Note> list = (List<Note>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Note note : list) {
                if ((userId != note.getUserId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_NOTE_WHERE);

            query.append(_FINDER_COLUMN_USERIDONWALL_USERID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(NoteModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                if (!pagination) {
                    list = (List<Note>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Note>(list);
                } else {
                    list = (List<Note>) QueryUtil.list(q, getDialect(), start,
                            end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
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
    @Override
    public Note findByUserIdOnWall_First(long userId,
        OrderByComparator orderByComparator)
        throws NoSuchNoteException, SystemException {
        Note note = fetchByUserIdOnWall_First(userId, orderByComparator);

        if (note != null) {
            return note;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userId=");
        msg.append(userId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchNoteException(msg.toString());
    }

    /**
     * Returns the first note in the ordered set where userId = &#63;.
     *
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching note, or <code>null</code> if a matching note could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Note fetchByUserIdOnWall_First(long userId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Note> list = findByUserIdOnWall(userId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Note findByUserIdOnWall_Last(long userId,
        OrderByComparator orderByComparator)
        throws NoSuchNoteException, SystemException {
        Note note = fetchByUserIdOnWall_Last(userId, orderByComparator);

        if (note != null) {
            return note;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userId=");
        msg.append(userId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchNoteException(msg.toString());
    }

    /**
     * Returns the last note in the ordered set where userId = &#63;.
     *
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching note, or <code>null</code> if a matching note could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Note fetchByUserIdOnWall_Last(long userId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUserIdOnWall(userId);

        if (count == 0) {
            return null;
        }

        List<Note> list = findByUserIdOnWall(userId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Note[] findByUserIdOnWall_PrevAndNext(long noteId, long userId,
        OrderByComparator orderByComparator)
        throws NoSuchNoteException, SystemException {
        Note note = findByPrimaryKey(noteId);

        Session session = null;

        try {
            session = openSession();

            Note[] array = new NoteImpl[3];

            array[0] = getByUserIdOnWall_PrevAndNext(session, note, userId,
                    orderByComparator, true);

            array[1] = note;

            array[2] = getByUserIdOnWall_PrevAndNext(session, note, userId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Note getByUserIdOnWall_PrevAndNext(Session session, Note note,
        long userId, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_NOTE_WHERE);

        query.append(_FINDER_COLUMN_USERIDONWALL_USERID_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(NoteModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(userId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(note);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Note> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the notes where userId = &#63; from the database.
     *
     * @param userId the user ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUserIdOnWall(long userId) throws SystemException {
        for (Note note : findByUserIdOnWall(userId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(note);
        }
    }

    /**
     * Returns the number of notes where userId = &#63;.
     *
     * @param userId the user ID
     * @return the number of matching notes
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByUserIdOnWall(long userId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_USERIDONWALL;

        Object[] finderArgs = new Object[] { userId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_NOTE_WHERE);

            query.append(_FINDER_COLUMN_USERIDONWALL_USERID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the notes where userId = &#63;.
     *
     * @param userId the user ID
     * @return the matching notes
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Note> findByUserId(long userId) throws SystemException {
        return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    @Override
    public List<Note> findByUserId(long userId, int start, int end)
        throws SystemException {
        return findByUserId(userId, start, end, null);
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
    @Override
    public List<Note> findByUserId(long userId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
            finderArgs = new Object[] { userId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
            finderArgs = new Object[] { userId, start, end, orderByComparator };
        }

        List<Note> list = (List<Note>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Note note : list) {
                if ((userId != note.getUserId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_NOTE_WHERE);

            query.append(_FINDER_COLUMN_USERID_USERID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(NoteModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                if (!pagination) {
                    list = (List<Note>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Note>(list);
                } else {
                    list = (List<Note>) QueryUtil.list(q, getDialect(), start,
                            end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
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
    @Override
    public Note findByUserId_First(long userId,
        OrderByComparator orderByComparator)
        throws NoSuchNoteException, SystemException {
        Note note = fetchByUserId_First(userId, orderByComparator);

        if (note != null) {
            return note;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userId=");
        msg.append(userId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchNoteException(msg.toString());
    }

    /**
     * Returns the first note in the ordered set where userId = &#63;.
     *
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching note, or <code>null</code> if a matching note could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Note fetchByUserId_First(long userId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Note> list = findByUserId(userId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Note findByUserId_Last(long userId,
        OrderByComparator orderByComparator)
        throws NoSuchNoteException, SystemException {
        Note note = fetchByUserId_Last(userId, orderByComparator);

        if (note != null) {
            return note;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userId=");
        msg.append(userId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchNoteException(msg.toString());
    }

    /**
     * Returns the last note in the ordered set where userId = &#63;.
     *
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching note, or <code>null</code> if a matching note could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Note fetchByUserId_Last(long userId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUserId(userId);

        if (count == 0) {
            return null;
        }

        List<Note> list = findByUserId(userId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Note[] findByUserId_PrevAndNext(long noteId, long userId,
        OrderByComparator orderByComparator)
        throws NoSuchNoteException, SystemException {
        Note note = findByPrimaryKey(noteId);

        Session session = null;

        try {
            session = openSession();

            Note[] array = new NoteImpl[3];

            array[0] = getByUserId_PrevAndNext(session, note, userId,
                    orderByComparator, true);

            array[1] = note;

            array[2] = getByUserId_PrevAndNext(session, note, userId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Note getByUserId_PrevAndNext(Session session, Note note,
        long userId, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_NOTE_WHERE);

        query.append(_FINDER_COLUMN_USERID_USERID_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(NoteModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(userId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(note);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Note> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the notes where userId = &#63; from the database.
     *
     * @param userId the user ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByUserId(long userId) throws SystemException {
        for (Note note : findByUserId(userId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(note);
        }
    }

    /**
     * Returns the number of notes where userId = &#63;.
     *
     * @param userId the user ID
     * @return the number of matching notes
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByUserId(long userId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

        Object[] finderArgs = new Object[] { userId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_NOTE_WHERE);

            query.append(_FINDER_COLUMN_USERID_USERID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the notes where userId = &#63;.
     *
     * @param userId the user ID
     * @return the matching notes
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Note> findByDeletedNotesByUserId(long userId)
        throws SystemException {
        return findByDeletedNotesByUserId(userId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
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
    @Override
    public List<Note> findByDeletedNotesByUserId(long userId, int start, int end)
        throws SystemException {
        return findByDeletedNotesByUserId(userId, start, end, null);
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
    @Override
    public List<Note> findByDeletedNotesByUserId(long userId, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DELETEDNOTESBYUSERID;
            finderArgs = new Object[] { userId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DELETEDNOTESBYUSERID;
            finderArgs = new Object[] { userId, start, end, orderByComparator };
        }

        List<Note> list = (List<Note>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Note note : list) {
                if ((userId != note.getUserId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_NOTE_WHERE);

            query.append(_FINDER_COLUMN_DELETEDNOTESBYUSERID_USERID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(NoteModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                if (!pagination) {
                    list = (List<Note>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Note>(list);
                } else {
                    list = (List<Note>) QueryUtil.list(q, getDialect(), start,
                            end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
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
    @Override
    public Note findByDeletedNotesByUserId_First(long userId,
        OrderByComparator orderByComparator)
        throws NoSuchNoteException, SystemException {
        Note note = fetchByDeletedNotesByUserId_First(userId, orderByComparator);

        if (note != null) {
            return note;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userId=");
        msg.append(userId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchNoteException(msg.toString());
    }

    /**
     * Returns the first note in the ordered set where userId = &#63;.
     *
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching note, or <code>null</code> if a matching note could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Note fetchByDeletedNotesByUserId_First(long userId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Note> list = findByDeletedNotesByUserId(userId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Note findByDeletedNotesByUserId_Last(long userId,
        OrderByComparator orderByComparator)
        throws NoSuchNoteException, SystemException {
        Note note = fetchByDeletedNotesByUserId_Last(userId, orderByComparator);

        if (note != null) {
            return note;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userId=");
        msg.append(userId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchNoteException(msg.toString());
    }

    /**
     * Returns the last note in the ordered set where userId = &#63;.
     *
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching note, or <code>null</code> if a matching note could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Note fetchByDeletedNotesByUserId_Last(long userId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByDeletedNotesByUserId(userId);

        if (count == 0) {
            return null;
        }

        List<Note> list = findByDeletedNotesByUserId(userId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Note[] findByDeletedNotesByUserId_PrevAndNext(long noteId,
        long userId, OrderByComparator orderByComparator)
        throws NoSuchNoteException, SystemException {
        Note note = findByPrimaryKey(noteId);

        Session session = null;

        try {
            session = openSession();

            Note[] array = new NoteImpl[3];

            array[0] = getByDeletedNotesByUserId_PrevAndNext(session, note,
                    userId, orderByComparator, true);

            array[1] = note;

            array[2] = getByDeletedNotesByUserId_PrevAndNext(session, note,
                    userId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Note getByDeletedNotesByUserId_PrevAndNext(Session session,
        Note note, long userId, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_NOTE_WHERE);

        query.append(_FINDER_COLUMN_DELETEDNOTESBYUSERID_USERID_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(NoteModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(userId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(note);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Note> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the notes where userId = &#63; from the database.
     *
     * @param userId the user ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByDeletedNotesByUserId(long userId)
        throws SystemException {
        for (Note note : findByDeletedNotesByUserId(userId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(note);
        }
    }

    /**
     * Returns the number of notes where userId = &#63;.
     *
     * @param userId the user ID
     * @return the number of matching notes
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByDeletedNotesByUserId(long userId)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_DELETEDNOTESBYUSERID;

        Object[] finderArgs = new Object[] { userId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_NOTE_WHERE);

            query.append(_FINDER_COLUMN_DELETEDNOTESBYUSERID_USERID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the notes where userId = &#63;.
     *
     * @param userId the user ID
     * @return the matching notes
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Note> findByEventTime(long userId) throws SystemException {
        return findByEventTime(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
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
    @Override
    public List<Note> findByEventTime(long userId, int start, int end)
        throws SystemException {
        return findByEventTime(userId, start, end, null);
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
    @Override
    public List<Note> findByEventTime(long userId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTTIME;
            finderArgs = new Object[] { userId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EVENTTIME;
            finderArgs = new Object[] { userId, start, end, orderByComparator };
        }

        List<Note> list = (List<Note>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Note note : list) {
                if ((userId != note.getUserId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_NOTE_WHERE);

            query.append(_FINDER_COLUMN_EVENTTIME_USERID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(NoteModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                if (!pagination) {
                    list = (List<Note>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Note>(list);
                } else {
                    list = (List<Note>) QueryUtil.list(q, getDialect(), start,
                            end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
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
    @Override
    public Note findByEventTime_First(long userId,
        OrderByComparator orderByComparator)
        throws NoSuchNoteException, SystemException {
        Note note = fetchByEventTime_First(userId, orderByComparator);

        if (note != null) {
            return note;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userId=");
        msg.append(userId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchNoteException(msg.toString());
    }

    /**
     * Returns the first note in the ordered set where userId = &#63;.
     *
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching note, or <code>null</code> if a matching note could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Note fetchByEventTime_First(long userId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Note> list = findByEventTime(userId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Note findByEventTime_Last(long userId,
        OrderByComparator orderByComparator)
        throws NoSuchNoteException, SystemException {
        Note note = fetchByEventTime_Last(userId, orderByComparator);

        if (note != null) {
            return note;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userId=");
        msg.append(userId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchNoteException(msg.toString());
    }

    /**
     * Returns the last note in the ordered set where userId = &#63;.
     *
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching note, or <code>null</code> if a matching note could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Note fetchByEventTime_Last(long userId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByEventTime(userId);

        if (count == 0) {
            return null;
        }

        List<Note> list = findByEventTime(userId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Note[] findByEventTime_PrevAndNext(long noteId, long userId,
        OrderByComparator orderByComparator)
        throws NoSuchNoteException, SystemException {
        Note note = findByPrimaryKey(noteId);

        Session session = null;

        try {
            session = openSession();

            Note[] array = new NoteImpl[3];

            array[0] = getByEventTime_PrevAndNext(session, note, userId,
                    orderByComparator, true);

            array[1] = note;

            array[2] = getByEventTime_PrevAndNext(session, note, userId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Note getByEventTime_PrevAndNext(Session session, Note note,
        long userId, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_NOTE_WHERE);

        query.append(_FINDER_COLUMN_EVENTTIME_USERID_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(NoteModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(userId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(note);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Note> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the notes where userId = &#63; from the database.
     *
     * @param userId the user ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByEventTime(long userId) throws SystemException {
        for (Note note : findByEventTime(userId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(note);
        }
    }

    /**
     * Returns the number of notes where userId = &#63;.
     *
     * @param userId the user ID
     * @return the number of matching notes
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByEventTime(long userId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_EVENTTIME;

        Object[] finderArgs = new Object[] { userId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_NOTE_WHERE);

            query.append(_FINDER_COLUMN_EVENTTIME_USERID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns all the notes where userId = &#63;.
     *
     * @param userId the user ID
     * @return the matching notes
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Note> findByRemindDate(long userId) throws SystemException {
        return findByRemindDate(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
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
    @Override
    public List<Note> findByRemindDate(long userId, int start, int end)
        throws SystemException {
        return findByRemindDate(userId, start, end, null);
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
    @Override
    public List<Note> findByRemindDate(long userId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REMINDDATE;
            finderArgs = new Object[] { userId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_REMINDDATE;
            finderArgs = new Object[] { userId, start, end, orderByComparator };
        }

        List<Note> list = (List<Note>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Note note : list) {
                if ((userId != note.getUserId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_NOTE_WHERE);

            query.append(_FINDER_COLUMN_REMINDDATE_USERID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(NoteModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                if (!pagination) {
                    list = (List<Note>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Note>(list);
                } else {
                    list = (List<Note>) QueryUtil.list(q, getDialect(), start,
                            end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
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
    @Override
    public Note findByRemindDate_First(long userId,
        OrderByComparator orderByComparator)
        throws NoSuchNoteException, SystemException {
        Note note = fetchByRemindDate_First(userId, orderByComparator);

        if (note != null) {
            return note;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userId=");
        msg.append(userId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchNoteException(msg.toString());
    }

    /**
     * Returns the first note in the ordered set where userId = &#63;.
     *
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching note, or <code>null</code> if a matching note could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Note fetchByRemindDate_First(long userId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Note> list = findByRemindDate(userId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Note findByRemindDate_Last(long userId,
        OrderByComparator orderByComparator)
        throws NoSuchNoteException, SystemException {
        Note note = fetchByRemindDate_Last(userId, orderByComparator);

        if (note != null) {
            return note;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userId=");
        msg.append(userId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchNoteException(msg.toString());
    }

    /**
     * Returns the last note in the ordered set where userId = &#63;.
     *
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching note, or <code>null</code> if a matching note could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Note fetchByRemindDate_Last(long userId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByRemindDate(userId);

        if (count == 0) {
            return null;
        }

        List<Note> list = findByRemindDate(userId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Note[] findByRemindDate_PrevAndNext(long noteId, long userId,
        OrderByComparator orderByComparator)
        throws NoSuchNoteException, SystemException {
        Note note = findByPrimaryKey(noteId);

        Session session = null;

        try {
            session = openSession();

            Note[] array = new NoteImpl[3];

            array[0] = getByRemindDate_PrevAndNext(session, note, userId,
                    orderByComparator, true);

            array[1] = note;

            array[2] = getByRemindDate_PrevAndNext(session, note, userId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Note getByRemindDate_PrevAndNext(Session session, Note note,
        long userId, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_NOTE_WHERE);

        query.append(_FINDER_COLUMN_REMINDDATE_USERID_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(NoteModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(userId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(note);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Note> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the notes where userId = &#63; from the database.
     *
     * @param userId the user ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByRemindDate(long userId) throws SystemException {
        for (Note note : findByRemindDate(userId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(note);
        }
    }

    /**
     * Returns the number of notes where userId = &#63;.
     *
     * @param userId the user ID
     * @return the number of matching notes
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByRemindDate(long userId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_REMINDDATE;

        Object[] finderArgs = new Object[] { userId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_NOTE_WHERE);

            query.append(_FINDER_COLUMN_REMINDDATE_USERID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Caches the note in the entity cache if it is enabled.
     *
     * @param note the note
     */
    @Override
    public void cacheResult(Note note) {
        EntityCacheUtil.putResult(NoteModelImpl.ENTITY_CACHE_ENABLED,
            NoteImpl.class, note.getPrimaryKey(), note);

        note.resetOriginalValues();
    }

    /**
     * Caches the notes in the entity cache if it is enabled.
     *
     * @param notes the notes
     */
    @Override
    public void cacheResult(List<Note> notes) {
        for (Note note : notes) {
            if (EntityCacheUtil.getResult(NoteModelImpl.ENTITY_CACHE_ENABLED,
                        NoteImpl.class, note.getPrimaryKey()) == null) {
                cacheResult(note);
            } else {
                note.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all notes.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(NoteImpl.class.getName());
        }

        EntityCacheUtil.clearCache(NoteImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the note.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Note note) {
        EntityCacheUtil.removeResult(NoteModelImpl.ENTITY_CACHE_ENABLED,
            NoteImpl.class, note.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<Note> notes) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Note note : notes) {
            EntityCacheUtil.removeResult(NoteModelImpl.ENTITY_CACHE_ENABLED,
                NoteImpl.class, note.getPrimaryKey());
        }
    }

    /**
     * Creates a new note with the primary key. Does not add the note to the database.
     *
     * @param noteId the primary key for the new note
     * @return the new note
     */
    @Override
    public Note create(long noteId) {
        Note note = new NoteImpl();

        note.setNew(true);
        note.setPrimaryKey(noteId);

        return note;
    }

    /**
     * Removes the note with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param noteId the primary key of the note
     * @return the note that was removed
     * @throws net.evrem.service.NoSuchNoteException if a note with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Note remove(long noteId) throws NoSuchNoteException, SystemException {
        return remove((Serializable) noteId);
    }

    /**
     * Removes the note with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the note
     * @return the note that was removed
     * @throws net.evrem.service.NoSuchNoteException if a note with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Note remove(Serializable primaryKey)
        throws NoSuchNoteException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Note note = (Note) session.get(NoteImpl.class, primaryKey);

            if (note == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchNoteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(note);
        } catch (NoSuchNoteException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Note removeImpl(Note note) throws SystemException {
        note = toUnwrappedModel(note);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(note)) {
                note = (Note) session.get(NoteImpl.class,
                        note.getPrimaryKeyObj());
            }

            if (note != null) {
                session.delete(note);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (note != null) {
            clearCache(note);
        }

        return note;
    }

    @Override
    public Note updateImpl(net.evrem.service.model.Note note)
        throws SystemException {
        note = toUnwrappedModel(note);

        boolean isNew = note.isNew();

        NoteModelImpl noteModelImpl = (NoteModelImpl) note;

        Session session = null;

        try {
            session = openSession();

            if (note.isNew()) {
                session.save(note);

                note.setNew(false);
            } else {
                session.merge(note);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !NoteModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((noteModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLNOTESBYUSERID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { noteModelImpl.getOriginalUserId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ALLNOTESBYUSERID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLNOTESBYUSERID,
                    args);

                args = new Object[] { noteModelImpl.getUserId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ALLNOTESBYUSERID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALLNOTESBYUSERID,
                    args);
            }

            if ((noteModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDONWALL.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { noteModelImpl.getOriginalUserId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDONWALL,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDONWALL,
                    args);

                args = new Object[] { noteModelImpl.getUserId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERIDONWALL,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERIDONWALL,
                    args);
            }

            if ((noteModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { noteModelImpl.getOriginalUserId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
                    args);

                args = new Object[] { noteModelImpl.getUserId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
                    args);
            }

            if ((noteModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DELETEDNOTESBYUSERID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { noteModelImpl.getOriginalUserId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DELETEDNOTESBYUSERID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DELETEDNOTESBYUSERID,
                    args);

                args = new Object[] { noteModelImpl.getUserId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DELETEDNOTESBYUSERID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DELETEDNOTESBYUSERID,
                    args);
            }

            if ((noteModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTTIME.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { noteModelImpl.getOriginalUserId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EVENTTIME,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTTIME,
                    args);

                args = new Object[] { noteModelImpl.getUserId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EVENTTIME,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTTIME,
                    args);
            }

            if ((noteModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REMINDDATE.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { noteModelImpl.getOriginalUserId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_REMINDDATE,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REMINDDATE,
                    args);

                args = new Object[] { noteModelImpl.getUserId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_REMINDDATE,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_REMINDDATE,
                    args);
            }
        }

        EntityCacheUtil.putResult(NoteModelImpl.ENTITY_CACHE_ENABLED,
            NoteImpl.class, note.getPrimaryKey(), note);

        return note;
    }

    protected Note toUnwrappedModel(Note note) {
        if (note instanceof NoteImpl) {
            return note;
        }

        NoteImpl noteImpl = new NoteImpl();

        noteImpl.setNew(note.isNew());
        noteImpl.setPrimaryKey(note.getPrimaryKey());

        noteImpl.setNoteId(note.getNoteId());
        noteImpl.setUserId(note.getUserId());
        noteImpl.setHasCheck(note.isHasCheck());
        noteImpl.setHasTime(note.isHasTime());
        noteImpl.setHasReminder(note.isHasReminder());
        noteImpl.setHasTodo(note.isHasTodo());
        noteImpl.setHasRepeat(note.isHasRepeat());
        noteImpl.setHasColor(note.isHasColor());
        noteImpl.setHasWall(note.isHasWall());
        noteImpl.setText(note.getText());
        noteImpl.setIsDone(note.isIsDone());
        noteImpl.setEventTime(note.getEventTime());
        noteImpl.setPeriod(note.getPeriod());
        noteImpl.setColor(note.getColor());
        noteImpl.setCreatedDate(note.getCreatedDate());
        noteImpl.setModifiedDate(note.getModifiedDate());
        noteImpl.setIsDeleted(note.isIsDeleted());

        return noteImpl;
    }

    /**
     * Returns the note with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the note
     * @return the note
     * @throws net.evrem.service.NoSuchNoteException if a note with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Note findByPrimaryKey(Serializable primaryKey)
        throws NoSuchNoteException, SystemException {
        Note note = fetchByPrimaryKey(primaryKey);

        if (note == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchNoteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return note;
    }

    /**
     * Returns the note with the primary key or throws a {@link net.evrem.service.NoSuchNoteException} if it could not be found.
     *
     * @param noteId the primary key of the note
     * @return the note
     * @throws net.evrem.service.NoSuchNoteException if a note with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Note findByPrimaryKey(long noteId)
        throws NoSuchNoteException, SystemException {
        return findByPrimaryKey((Serializable) noteId);
    }

    /**
     * Returns the note with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the note
     * @return the note, or <code>null</code> if a note with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Note fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Note note = (Note) EntityCacheUtil.getResult(NoteModelImpl.ENTITY_CACHE_ENABLED,
                NoteImpl.class, primaryKey);

        if (note == _nullNote) {
            return null;
        }

        if (note == null) {
            Session session = null;

            try {
                session = openSession();

                note = (Note) session.get(NoteImpl.class, primaryKey);

                if (note != null) {
                    cacheResult(note);
                } else {
                    EntityCacheUtil.putResult(NoteModelImpl.ENTITY_CACHE_ENABLED,
                        NoteImpl.class, primaryKey, _nullNote);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(NoteModelImpl.ENTITY_CACHE_ENABLED,
                    NoteImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return note;
    }

    /**
     * Returns the note with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param noteId the primary key of the note
     * @return the note, or <code>null</code> if a note with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Note fetchByPrimaryKey(long noteId) throws SystemException {
        return fetchByPrimaryKey((Serializable) noteId);
    }

    /**
     * Returns all the notes.
     *
     * @return the notes
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Note> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    public List<Note> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
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
    @Override
    public List<Note> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<Note> list = (List<Note>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_NOTE);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_NOTE;

                if (pagination) {
                    sql = sql.concat(NoteModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Note>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Note>(list);
                } else {
                    list = (List<Note>) QueryUtil.list(q, getDialect(), start,
                            end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the notes from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Note note : findAll()) {
            remove(note);
        }
    }

    /**
     * Returns the number of notes.
     *
     * @return the number of notes
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_NOTE);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    @Override
    protected Set<String> getBadColumnNames() {
        return _badColumnNames;
    }

    /**
     * Initializes the note persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.net.evrem.service.model.Note")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Note>> listenersList = new ArrayList<ModelListener<Note>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Note>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(NoteImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
