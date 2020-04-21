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

import net.evrem.service.NoSuchTodoNoteException;
import net.evrem.service.model.TodoNote;
import net.evrem.service.model.impl.TodoNoteImpl;
import net.evrem.service.model.impl.TodoNoteModelImpl;
import net.evrem.service.service.persistence.TodoNotePersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the todo note service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Zdenek Vecek
 * @see TodoNotePersistence
 * @see TodoNoteUtil
 * @generated
 */
public class TodoNotePersistenceImpl extends BasePersistenceImpl<TodoNote>
    implements TodoNotePersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link TodoNoteUtil} to access the todo note persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = TodoNoteImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TodoNoteModelImpl.ENTITY_CACHE_ENABLED,
            TodoNoteModelImpl.FINDER_CACHE_ENABLED, TodoNoteImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TodoNoteModelImpl.ENTITY_CACHE_ENABLED,
            TodoNoteModelImpl.FINDER_CACHE_ENABLED, TodoNoteImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TodoNoteModelImpl.ENTITY_CACHE_ENABLED,
            TodoNoteModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NOTEID = new FinderPath(TodoNoteModelImpl.ENTITY_CACHE_ENABLED,
            TodoNoteModelImpl.FINDER_CACHE_ENABLED, TodoNoteImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByNoteId",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NOTEID =
        new FinderPath(TodoNoteModelImpl.ENTITY_CACHE_ENABLED,
            TodoNoteModelImpl.FINDER_CACHE_ENABLED, TodoNoteImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByNoteId",
            new String[] { Long.class.getName() },
            TodoNoteModelImpl.NOTEID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_NOTEID = new FinderPath(TodoNoteModelImpl.ENTITY_CACHE_ENABLED,
            TodoNoteModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNoteId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_NOTEID_NOTEID_2 = "todoNote.noteId = ?";
    public static final FinderPath FINDER_PATH_FETCH_BY_NOTEIDANDSORTNO = new FinderPath(TodoNoteModelImpl.ENTITY_CACHE_ENABLED,
            TodoNoteModelImpl.FINDER_CACHE_ENABLED, TodoNoteImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByNoteIdAndSortNo",
            new String[] { Long.class.getName(), Integer.class.getName() },
            TodoNoteModelImpl.NOTEID_COLUMN_BITMASK |
            TodoNoteModelImpl.SORTNO_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_NOTEIDANDSORTNO = new FinderPath(TodoNoteModelImpl.ENTITY_CACHE_ENABLED,
            TodoNoteModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByNoteIdAndSortNo",
            new String[] { Long.class.getName(), Integer.class.getName() });
    private static final String _FINDER_COLUMN_NOTEIDANDSORTNO_NOTEID_2 = "todoNote.noteId = ? AND ";
    private static final String _FINDER_COLUMN_NOTEIDANDSORTNO_SORTNO_2 = "todoNote.sortNo = ?";
    private static final String _SQL_SELECT_TODONOTE = "SELECT todoNote FROM TodoNote todoNote";
    private static final String _SQL_SELECT_TODONOTE_WHERE = "SELECT todoNote FROM TodoNote todoNote WHERE ";
    private static final String _SQL_COUNT_TODONOTE = "SELECT COUNT(todoNote) FROM TodoNote todoNote";
    private static final String _SQL_COUNT_TODONOTE_WHERE = "SELECT COUNT(todoNote) FROM TodoNote todoNote WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "todoNote.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TodoNote exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TodoNote exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(TodoNotePersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "todoNoteId", "noteId", "isDone", "sortNo", "modifiedDate"
            });
    private static TodoNote _nullTodoNote = new TodoNoteImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<TodoNote> toCacheModel() {
                return _nullTodoNoteCacheModel;
            }
        };

    private static CacheModel<TodoNote> _nullTodoNoteCacheModel = new CacheModel<TodoNote>() {
            @Override
            public TodoNote toEntityModel() {
                return _nullTodoNote;
            }
        };

    public TodoNotePersistenceImpl() {
        setModelClass(TodoNote.class);
    }

    /**
     * Returns all the todo notes where noteId = &#63;.
     *
     * @param noteId the note ID
     * @return the matching todo notes
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<TodoNote> findByNoteId(long noteId) throws SystemException {
        return findByNoteId(noteId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    @Override
    public List<TodoNote> findByNoteId(long noteId, int start, int end)
        throws SystemException {
        return findByNoteId(noteId, start, end, null);
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
    @Override
    public List<TodoNote> findByNoteId(long noteId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NOTEID;
            finderArgs = new Object[] { noteId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NOTEID;
            finderArgs = new Object[] { noteId, start, end, orderByComparator };
        }

        List<TodoNote> list = (List<TodoNote>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (TodoNote todoNote : list) {
                if ((noteId != todoNote.getNoteId())) {
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

            query.append(_SQL_SELECT_TODONOTE_WHERE);

            query.append(_FINDER_COLUMN_NOTEID_NOTEID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(TodoNoteModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(noteId);

                if (!pagination) {
                    list = (List<TodoNote>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<TodoNote>(list);
                } else {
                    list = (List<TodoNote>) QueryUtil.list(q, getDialect(),
                            start, end);
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
     * Returns the first todo note in the ordered set where noteId = &#63;.
     *
     * @param noteId the note ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching todo note
     * @throws net.evrem.service.NoSuchTodoNoteException if a matching todo note could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public TodoNote findByNoteId_First(long noteId,
        OrderByComparator orderByComparator)
        throws NoSuchTodoNoteException, SystemException {
        TodoNote todoNote = fetchByNoteId_First(noteId, orderByComparator);

        if (todoNote != null) {
            return todoNote;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("noteId=");
        msg.append(noteId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchTodoNoteException(msg.toString());
    }

    /**
     * Returns the first todo note in the ordered set where noteId = &#63;.
     *
     * @param noteId the note ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching todo note, or <code>null</code> if a matching todo note could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public TodoNote fetchByNoteId_First(long noteId,
        OrderByComparator orderByComparator) throws SystemException {
        List<TodoNote> list = findByNoteId(noteId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public TodoNote findByNoteId_Last(long noteId,
        OrderByComparator orderByComparator)
        throws NoSuchTodoNoteException, SystemException {
        TodoNote todoNote = fetchByNoteId_Last(noteId, orderByComparator);

        if (todoNote != null) {
            return todoNote;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("noteId=");
        msg.append(noteId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchTodoNoteException(msg.toString());
    }

    /**
     * Returns the last todo note in the ordered set where noteId = &#63;.
     *
     * @param noteId the note ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching todo note, or <code>null</code> if a matching todo note could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public TodoNote fetchByNoteId_Last(long noteId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByNoteId(noteId);

        if (count == 0) {
            return null;
        }

        List<TodoNote> list = findByNoteId(noteId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public TodoNote[] findByNoteId_PrevAndNext(long todoNoteId, long noteId,
        OrderByComparator orderByComparator)
        throws NoSuchTodoNoteException, SystemException {
        TodoNote todoNote = findByPrimaryKey(todoNoteId);

        Session session = null;

        try {
            session = openSession();

            TodoNote[] array = new TodoNoteImpl[3];

            array[0] = getByNoteId_PrevAndNext(session, todoNote, noteId,
                    orderByComparator, true);

            array[1] = todoNote;

            array[2] = getByNoteId_PrevAndNext(session, todoNote, noteId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected TodoNote getByNoteId_PrevAndNext(Session session,
        TodoNote todoNote, long noteId, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_TODONOTE_WHERE);

        query.append(_FINDER_COLUMN_NOTEID_NOTEID_2);

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
            query.append(TodoNoteModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(noteId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(todoNote);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<TodoNote> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the todo notes where noteId = &#63; from the database.
     *
     * @param noteId the note ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByNoteId(long noteId) throws SystemException {
        for (TodoNote todoNote : findByNoteId(noteId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(todoNote);
        }
    }

    /**
     * Returns the number of todo notes where noteId = &#63;.
     *
     * @param noteId the note ID
     * @return the number of matching todo notes
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByNoteId(long noteId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_NOTEID;

        Object[] finderArgs = new Object[] { noteId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_TODONOTE_WHERE);

            query.append(_FINDER_COLUMN_NOTEID_NOTEID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(noteId);

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
     * Returns the todo note where noteId = &#63; and sortNo = &#63; or throws a {@link net.evrem.service.NoSuchTodoNoteException} if it could not be found.
     *
     * @param noteId the note ID
     * @param sortNo the sort no
     * @return the matching todo note
     * @throws net.evrem.service.NoSuchTodoNoteException if a matching todo note could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public TodoNote findByNoteIdAndSortNo(long noteId, int sortNo)
        throws NoSuchTodoNoteException, SystemException {
        TodoNote todoNote = fetchByNoteIdAndSortNo(noteId, sortNo);

        if (todoNote == null) {
            StringBundler msg = new StringBundler(6);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("noteId=");
            msg.append(noteId);

            msg.append(", sortNo=");
            msg.append(sortNo);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchTodoNoteException(msg.toString());
        }

        return todoNote;
    }

    /**
     * Returns the todo note where noteId = &#63; and sortNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param noteId the note ID
     * @param sortNo the sort no
     * @return the matching todo note, or <code>null</code> if a matching todo note could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public TodoNote fetchByNoteIdAndSortNo(long noteId, int sortNo)
        throws SystemException {
        return fetchByNoteIdAndSortNo(noteId, sortNo, true);
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
    @Override
    public TodoNote fetchByNoteIdAndSortNo(long noteId, int sortNo,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { noteId, sortNo };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_NOTEIDANDSORTNO,
                    finderArgs, this);
        }

        if (result instanceof TodoNote) {
            TodoNote todoNote = (TodoNote) result;

            if ((noteId != todoNote.getNoteId()) ||
                    (sortNo != todoNote.getSortNo())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_SELECT_TODONOTE_WHERE);

            query.append(_FINDER_COLUMN_NOTEIDANDSORTNO_NOTEID_2);

            query.append(_FINDER_COLUMN_NOTEIDANDSORTNO_SORTNO_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(noteId);

                qPos.add(sortNo);

                List<TodoNote> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NOTEIDANDSORTNO,
                        finderArgs, list);
                } else {
                    if ((list.size() > 1) && _log.isWarnEnabled()) {
                        _log.warn(
                            "TodoNotePersistenceImpl.fetchByNoteIdAndSortNo(long, int, boolean) with parameters (" +
                            StringUtil.merge(finderArgs) +
                            ") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
                    }

                    TodoNote todoNote = list.get(0);

                    result = todoNote;

                    cacheResult(todoNote);

                    if ((todoNote.getNoteId() != noteId) ||
                            (todoNote.getSortNo() != sortNo)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NOTEIDANDSORTNO,
                            finderArgs, todoNote);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NOTEIDANDSORTNO,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (TodoNote) result;
        }
    }

    /**
     * Removes the todo note where noteId = &#63; and sortNo = &#63; from the database.
     *
     * @param noteId the note ID
     * @param sortNo the sort no
     * @return the todo note that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public TodoNote removeByNoteIdAndSortNo(long noteId, int sortNo)
        throws NoSuchTodoNoteException, SystemException {
        TodoNote todoNote = findByNoteIdAndSortNo(noteId, sortNo);

        return remove(todoNote);
    }

    /**
     * Returns the number of todo notes where noteId = &#63; and sortNo = &#63;.
     *
     * @param noteId the note ID
     * @param sortNo the sort no
     * @return the number of matching todo notes
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByNoteIdAndSortNo(long noteId, int sortNo)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_NOTEIDANDSORTNO;

        Object[] finderArgs = new Object[] { noteId, sortNo };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_TODONOTE_WHERE);

            query.append(_FINDER_COLUMN_NOTEIDANDSORTNO_NOTEID_2);

            query.append(_FINDER_COLUMN_NOTEIDANDSORTNO_SORTNO_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(noteId);

                qPos.add(sortNo);

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
     * Caches the todo note in the entity cache if it is enabled.
     *
     * @param todoNote the todo note
     */
    @Override
    public void cacheResult(TodoNote todoNote) {
        EntityCacheUtil.putResult(TodoNoteModelImpl.ENTITY_CACHE_ENABLED,
            TodoNoteImpl.class, todoNote.getPrimaryKey(), todoNote);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NOTEIDANDSORTNO,
            new Object[] { todoNote.getNoteId(), todoNote.getSortNo() },
            todoNote);

        todoNote.resetOriginalValues();
    }

    /**
     * Caches the todo notes in the entity cache if it is enabled.
     *
     * @param todoNotes the todo notes
     */
    @Override
    public void cacheResult(List<TodoNote> todoNotes) {
        for (TodoNote todoNote : todoNotes) {
            if (EntityCacheUtil.getResult(
                        TodoNoteModelImpl.ENTITY_CACHE_ENABLED,
                        TodoNoteImpl.class, todoNote.getPrimaryKey()) == null) {
                cacheResult(todoNote);
            } else {
                todoNote.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all todo notes.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(TodoNoteImpl.class.getName());
        }

        EntityCacheUtil.clearCache(TodoNoteImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the todo note.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(TodoNote todoNote) {
        EntityCacheUtil.removeResult(TodoNoteModelImpl.ENTITY_CACHE_ENABLED,
            TodoNoteImpl.class, todoNote.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(todoNote);
    }

    @Override
    public void clearCache(List<TodoNote> todoNotes) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (TodoNote todoNote : todoNotes) {
            EntityCacheUtil.removeResult(TodoNoteModelImpl.ENTITY_CACHE_ENABLED,
                TodoNoteImpl.class, todoNote.getPrimaryKey());

            clearUniqueFindersCache(todoNote);
        }
    }

    protected void cacheUniqueFindersCache(TodoNote todoNote) {
        if (todoNote.isNew()) {
            Object[] args = new Object[] {
                    todoNote.getNoteId(), todoNote.getSortNo()
                };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NOTEIDANDSORTNO,
                args, Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NOTEIDANDSORTNO,
                args, todoNote);
        } else {
            TodoNoteModelImpl todoNoteModelImpl = (TodoNoteModelImpl) todoNote;

            if ((todoNoteModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_NOTEIDANDSORTNO.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        todoNote.getNoteId(), todoNote.getSortNo()
                    };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NOTEIDANDSORTNO,
                    args, Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NOTEIDANDSORTNO,
                    args, todoNote);
            }
        }
    }

    protected void clearUniqueFindersCache(TodoNote todoNote) {
        TodoNoteModelImpl todoNoteModelImpl = (TodoNoteModelImpl) todoNote;

        Object[] args = new Object[] { todoNote.getNoteId(), todoNote.getSortNo() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NOTEIDANDSORTNO, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NOTEIDANDSORTNO, args);

        if ((todoNoteModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_NOTEIDANDSORTNO.getColumnBitmask()) != 0) {
            args = new Object[] {
                    todoNoteModelImpl.getOriginalNoteId(),
                    todoNoteModelImpl.getOriginalSortNo()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NOTEIDANDSORTNO,
                args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NOTEIDANDSORTNO,
                args);
        }
    }

    /**
     * Creates a new todo note with the primary key. Does not add the todo note to the database.
     *
     * @param todoNoteId the primary key for the new todo note
     * @return the new todo note
     */
    @Override
    public TodoNote create(long todoNoteId) {
        TodoNote todoNote = new TodoNoteImpl();

        todoNote.setNew(true);
        todoNote.setPrimaryKey(todoNoteId);

        return todoNote;
    }

    /**
     * Removes the todo note with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param todoNoteId the primary key of the todo note
     * @return the todo note that was removed
     * @throws net.evrem.service.NoSuchTodoNoteException if a todo note with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public TodoNote remove(long todoNoteId)
        throws NoSuchTodoNoteException, SystemException {
        return remove((Serializable) todoNoteId);
    }

    /**
     * Removes the todo note with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the todo note
     * @return the todo note that was removed
     * @throws net.evrem.service.NoSuchTodoNoteException if a todo note with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public TodoNote remove(Serializable primaryKey)
        throws NoSuchTodoNoteException, SystemException {
        Session session = null;

        try {
            session = openSession();

            TodoNote todoNote = (TodoNote) session.get(TodoNoteImpl.class,
                    primaryKey);

            if (todoNote == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchTodoNoteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(todoNote);
        } catch (NoSuchTodoNoteException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected TodoNote removeImpl(TodoNote todoNote) throws SystemException {
        todoNote = toUnwrappedModel(todoNote);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(todoNote)) {
                todoNote = (TodoNote) session.get(TodoNoteImpl.class,
                        todoNote.getPrimaryKeyObj());
            }

            if (todoNote != null) {
                session.delete(todoNote);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (todoNote != null) {
            clearCache(todoNote);
        }

        return todoNote;
    }

    @Override
    public TodoNote updateImpl(net.evrem.service.model.TodoNote todoNote)
        throws SystemException {
        todoNote = toUnwrappedModel(todoNote);

        boolean isNew = todoNote.isNew();

        TodoNoteModelImpl todoNoteModelImpl = (TodoNoteModelImpl) todoNote;

        Session session = null;

        try {
            session = openSession();

            if (todoNote.isNew()) {
                session.save(todoNote);

                todoNote.setNew(false);
            } else {
                session.merge(todoNote);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !TodoNoteModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((todoNoteModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NOTEID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        todoNoteModelImpl.getOriginalNoteId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NOTEID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NOTEID,
                    args);

                args = new Object[] { todoNoteModelImpl.getNoteId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NOTEID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NOTEID,
                    args);
            }
        }

        EntityCacheUtil.putResult(TodoNoteModelImpl.ENTITY_CACHE_ENABLED,
            TodoNoteImpl.class, todoNote.getPrimaryKey(), todoNote);

        clearUniqueFindersCache(todoNote);
        cacheUniqueFindersCache(todoNote);

        return todoNote;
    }

    protected TodoNote toUnwrappedModel(TodoNote todoNote) {
        if (todoNote instanceof TodoNoteImpl) {
            return todoNote;
        }

        TodoNoteImpl todoNoteImpl = new TodoNoteImpl();

        todoNoteImpl.setNew(todoNote.isNew());
        todoNoteImpl.setPrimaryKey(todoNote.getPrimaryKey());

        todoNoteImpl.setTodoNoteId(todoNote.getTodoNoteId());
        todoNoteImpl.setNoteId(todoNote.getNoteId());
        todoNoteImpl.setIsDone(todoNote.isIsDone());
        todoNoteImpl.setText(todoNote.getText());
        todoNoteImpl.setSortNo(todoNote.getSortNo());
        todoNoteImpl.setModifiedDate(todoNote.getModifiedDate());

        return todoNoteImpl;
    }

    /**
     * Returns the todo note with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the todo note
     * @return the todo note
     * @throws net.evrem.service.NoSuchTodoNoteException if a todo note with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public TodoNote findByPrimaryKey(Serializable primaryKey)
        throws NoSuchTodoNoteException, SystemException {
        TodoNote todoNote = fetchByPrimaryKey(primaryKey);

        if (todoNote == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchTodoNoteException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return todoNote;
    }

    /**
     * Returns the todo note with the primary key or throws a {@link net.evrem.service.NoSuchTodoNoteException} if it could not be found.
     *
     * @param todoNoteId the primary key of the todo note
     * @return the todo note
     * @throws net.evrem.service.NoSuchTodoNoteException if a todo note with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public TodoNote findByPrimaryKey(long todoNoteId)
        throws NoSuchTodoNoteException, SystemException {
        return findByPrimaryKey((Serializable) todoNoteId);
    }

    /**
     * Returns the todo note with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the todo note
     * @return the todo note, or <code>null</code> if a todo note with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public TodoNote fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        TodoNote todoNote = (TodoNote) EntityCacheUtil.getResult(TodoNoteModelImpl.ENTITY_CACHE_ENABLED,
                TodoNoteImpl.class, primaryKey);

        if (todoNote == _nullTodoNote) {
            return null;
        }

        if (todoNote == null) {
            Session session = null;

            try {
                session = openSession();

                todoNote = (TodoNote) session.get(TodoNoteImpl.class, primaryKey);

                if (todoNote != null) {
                    cacheResult(todoNote);
                } else {
                    EntityCacheUtil.putResult(TodoNoteModelImpl.ENTITY_CACHE_ENABLED,
                        TodoNoteImpl.class, primaryKey, _nullTodoNote);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(TodoNoteModelImpl.ENTITY_CACHE_ENABLED,
                    TodoNoteImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return todoNote;
    }

    /**
     * Returns the todo note with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param todoNoteId the primary key of the todo note
     * @return the todo note, or <code>null</code> if a todo note with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public TodoNote fetchByPrimaryKey(long todoNoteId)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) todoNoteId);
    }

    /**
     * Returns all the todo notes.
     *
     * @return the todo notes
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<TodoNote> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    public List<TodoNote> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
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
    @Override
    public List<TodoNote> findAll(int start, int end,
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

        List<TodoNote> list = (List<TodoNote>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_TODONOTE);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_TODONOTE;

                if (pagination) {
                    sql = sql.concat(TodoNoteModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<TodoNote>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<TodoNote>(list);
                } else {
                    list = (List<TodoNote>) QueryUtil.list(q, getDialect(),
                            start, end);
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
     * Removes all the todo notes from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (TodoNote todoNote : findAll()) {
            remove(todoNote);
        }
    }

    /**
     * Returns the number of todo notes.
     *
     * @return the number of todo notes
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

                Query q = session.createQuery(_SQL_COUNT_TODONOTE);

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
     * Initializes the todo note persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.net.evrem.service.model.TodoNote")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<TodoNote>> listenersList = new ArrayList<ModelListener<TodoNote>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<TodoNote>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(TodoNoteImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
