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

import net.evrem.service.NoSuchRemindInfoException;
import net.evrem.service.model.RemindInfo;
import net.evrem.service.model.impl.RemindInfoImpl;
import net.evrem.service.model.impl.RemindInfoModelImpl;
import net.evrem.service.service.persistence.RemindInfoPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the remind info service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Zdenek Vecek
 * @see RemindInfoPersistence
 * @see RemindInfoUtil
 * @generated
 */
public class RemindInfoPersistenceImpl extends BasePersistenceImpl<RemindInfo>
    implements RemindInfoPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link RemindInfoUtil} to access the remind info persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = RemindInfoImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RemindInfoModelImpl.ENTITY_CACHE_ENABLED,
            RemindInfoModelImpl.FINDER_CACHE_ENABLED, RemindInfoImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RemindInfoModelImpl.ENTITY_CACHE_ENABLED,
            RemindInfoModelImpl.FINDER_CACHE_ENABLED, RemindInfoImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RemindInfoModelImpl.ENTITY_CACHE_ENABLED,
            RemindInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_FETCH_BY_NOTEID = new FinderPath(RemindInfoModelImpl.ENTITY_CACHE_ENABLED,
            RemindInfoModelImpl.FINDER_CACHE_ENABLED, RemindInfoImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByNoteId",
            new String[] { Long.class.getName() },
            RemindInfoModelImpl.NOTEID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_NOTEID = new FinderPath(RemindInfoModelImpl.ENTITY_CACHE_ENABLED,
            RemindInfoModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNoteId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_NOTEID_NOTEID_2 = "remindInfo.noteId = ?";
    private static final String _SQL_SELECT_REMINDINFO = "SELECT remindInfo FROM RemindInfo remindInfo";
    private static final String _SQL_SELECT_REMINDINFO_WHERE = "SELECT remindInfo FROM RemindInfo remindInfo WHERE ";
    private static final String _SQL_COUNT_REMINDINFO = "SELECT COUNT(remindInfo) FROM RemindInfo remindInfo";
    private static final String _SQL_COUNT_REMINDINFO_WHERE = "SELECT COUNT(remindInfo) FROM RemindInfo remindInfo WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "remindInfo.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No RemindInfo exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No RemindInfo exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(RemindInfoPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "remindInfoId", "noteId", "remindDate", "remindSubject",
                "recipientEmails", "lastRemindTime"
            });
    private static RemindInfo _nullRemindInfo = new RemindInfoImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<RemindInfo> toCacheModel() {
                return _nullRemindInfoCacheModel;
            }
        };

    private static CacheModel<RemindInfo> _nullRemindInfoCacheModel = new CacheModel<RemindInfo>() {
            @Override
            public RemindInfo toEntityModel() {
                return _nullRemindInfo;
            }
        };

    public RemindInfoPersistenceImpl() {
        setModelClass(RemindInfo.class);
    }

    /**
     * Returns the remind info where noteId = &#63; or throws a {@link net.evrem.service.NoSuchRemindInfoException} if it could not be found.
     *
     * @param noteId the note ID
     * @return the matching remind info
     * @throws net.evrem.service.NoSuchRemindInfoException if a matching remind info could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public RemindInfo findByNoteId(long noteId)
        throws NoSuchRemindInfoException, SystemException {
        RemindInfo remindInfo = fetchByNoteId(noteId);

        if (remindInfo == null) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("noteId=");
            msg.append(noteId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchRemindInfoException(msg.toString());
        }

        return remindInfo;
    }

    /**
     * Returns the remind info where noteId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param noteId the note ID
     * @return the matching remind info, or <code>null</code> if a matching remind info could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public RemindInfo fetchByNoteId(long noteId) throws SystemException {
        return fetchByNoteId(noteId, true);
    }

    /**
     * Returns the remind info where noteId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param noteId the note ID
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching remind info, or <code>null</code> if a matching remind info could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public RemindInfo fetchByNoteId(long noteId, boolean retrieveFromCache)
        throws SystemException {
        Object[] finderArgs = new Object[] { noteId };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_NOTEID,
                    finderArgs, this);
        }

        if (result instanceof RemindInfo) {
            RemindInfo remindInfo = (RemindInfo) result;

            if ((noteId != remindInfo.getNoteId())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_SELECT_REMINDINFO_WHERE);

            query.append(_FINDER_COLUMN_NOTEID_NOTEID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(noteId);

                List<RemindInfo> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NOTEID,
                        finderArgs, list);
                } else {
                    if ((list.size() > 1) && _log.isWarnEnabled()) {
                        _log.warn(
                            "RemindInfoPersistenceImpl.fetchByNoteId(long, boolean) with parameters (" +
                            StringUtil.merge(finderArgs) +
                            ") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
                    }

                    RemindInfo remindInfo = list.get(0);

                    result = remindInfo;

                    cacheResult(remindInfo);

                    if ((remindInfo.getNoteId() != noteId)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NOTEID,
                            finderArgs, remindInfo);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NOTEID,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (RemindInfo) result;
        }
    }

    /**
     * Removes the remind info where noteId = &#63; from the database.
     *
     * @param noteId the note ID
     * @return the remind info that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public RemindInfo removeByNoteId(long noteId)
        throws NoSuchRemindInfoException, SystemException {
        RemindInfo remindInfo = findByNoteId(noteId);

        return remove(remindInfo);
    }

    /**
     * Returns the number of remind infos where noteId = &#63;.
     *
     * @param noteId the note ID
     * @return the number of matching remind infos
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

            query.append(_SQL_COUNT_REMINDINFO_WHERE);

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
     * Caches the remind info in the entity cache if it is enabled.
     *
     * @param remindInfo the remind info
     */
    @Override
    public void cacheResult(RemindInfo remindInfo) {
        EntityCacheUtil.putResult(RemindInfoModelImpl.ENTITY_CACHE_ENABLED,
            RemindInfoImpl.class, remindInfo.getPrimaryKey(), remindInfo);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NOTEID,
            new Object[] { remindInfo.getNoteId() }, remindInfo);

        remindInfo.resetOriginalValues();
    }

    /**
     * Caches the remind infos in the entity cache if it is enabled.
     *
     * @param remindInfos the remind infos
     */
    @Override
    public void cacheResult(List<RemindInfo> remindInfos) {
        for (RemindInfo remindInfo : remindInfos) {
            if (EntityCacheUtil.getResult(
                        RemindInfoModelImpl.ENTITY_CACHE_ENABLED,
                        RemindInfoImpl.class, remindInfo.getPrimaryKey()) == null) {
                cacheResult(remindInfo);
            } else {
                remindInfo.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all remind infos.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(RemindInfoImpl.class.getName());
        }

        EntityCacheUtil.clearCache(RemindInfoImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the remind info.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(RemindInfo remindInfo) {
        EntityCacheUtil.removeResult(RemindInfoModelImpl.ENTITY_CACHE_ENABLED,
            RemindInfoImpl.class, remindInfo.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(remindInfo);
    }

    @Override
    public void clearCache(List<RemindInfo> remindInfos) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (RemindInfo remindInfo : remindInfos) {
            EntityCacheUtil.removeResult(RemindInfoModelImpl.ENTITY_CACHE_ENABLED,
                RemindInfoImpl.class, remindInfo.getPrimaryKey());

            clearUniqueFindersCache(remindInfo);
        }
    }

    protected void cacheUniqueFindersCache(RemindInfo remindInfo) {
        if (remindInfo.isNew()) {
            Object[] args = new Object[] { remindInfo.getNoteId() };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NOTEID, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NOTEID, args,
                remindInfo);
        } else {
            RemindInfoModelImpl remindInfoModelImpl = (RemindInfoModelImpl) remindInfo;

            if ((remindInfoModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_NOTEID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { remindInfo.getNoteId() };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NOTEID, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NOTEID, args,
                    remindInfo);
            }
        }
    }

    protected void clearUniqueFindersCache(RemindInfo remindInfo) {
        RemindInfoModelImpl remindInfoModelImpl = (RemindInfoModelImpl) remindInfo;

        Object[] args = new Object[] { remindInfo.getNoteId() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NOTEID, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NOTEID, args);

        if ((remindInfoModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_NOTEID.getColumnBitmask()) != 0) {
            args = new Object[] { remindInfoModelImpl.getOriginalNoteId() };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NOTEID, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NOTEID, args);
        }
    }

    /**
     * Creates a new remind info with the primary key. Does not add the remind info to the database.
     *
     * @param remindInfoId the primary key for the new remind info
     * @return the new remind info
     */
    @Override
    public RemindInfo create(long remindInfoId) {
        RemindInfo remindInfo = new RemindInfoImpl();

        remindInfo.setNew(true);
        remindInfo.setPrimaryKey(remindInfoId);

        return remindInfo;
    }

    /**
     * Removes the remind info with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param remindInfoId the primary key of the remind info
     * @return the remind info that was removed
     * @throws net.evrem.service.NoSuchRemindInfoException if a remind info with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public RemindInfo remove(long remindInfoId)
        throws NoSuchRemindInfoException, SystemException {
        return remove((Serializable) remindInfoId);
    }

    /**
     * Removes the remind info with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the remind info
     * @return the remind info that was removed
     * @throws net.evrem.service.NoSuchRemindInfoException if a remind info with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public RemindInfo remove(Serializable primaryKey)
        throws NoSuchRemindInfoException, SystemException {
        Session session = null;

        try {
            session = openSession();

            RemindInfo remindInfo = (RemindInfo) session.get(RemindInfoImpl.class,
                    primaryKey);

            if (remindInfo == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchRemindInfoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(remindInfo);
        } catch (NoSuchRemindInfoException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected RemindInfo removeImpl(RemindInfo remindInfo)
        throws SystemException {
        remindInfo = toUnwrappedModel(remindInfo);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(remindInfo)) {
                remindInfo = (RemindInfo) session.get(RemindInfoImpl.class,
                        remindInfo.getPrimaryKeyObj());
            }

            if (remindInfo != null) {
                session.delete(remindInfo);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (remindInfo != null) {
            clearCache(remindInfo);
        }

        return remindInfo;
    }

    @Override
    public RemindInfo updateImpl(net.evrem.service.model.RemindInfo remindInfo)
        throws SystemException {
        remindInfo = toUnwrappedModel(remindInfo);

        boolean isNew = remindInfo.isNew();

        Session session = null;

        try {
            session = openSession();

            if (remindInfo.isNew()) {
                session.save(remindInfo);

                remindInfo.setNew(false);
            } else {
                session.merge(remindInfo);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !RemindInfoModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }

        EntityCacheUtil.putResult(RemindInfoModelImpl.ENTITY_CACHE_ENABLED,
            RemindInfoImpl.class, remindInfo.getPrimaryKey(), remindInfo);

        clearUniqueFindersCache(remindInfo);
        cacheUniqueFindersCache(remindInfo);

        return remindInfo;
    }

    protected RemindInfo toUnwrappedModel(RemindInfo remindInfo) {
        if (remindInfo instanceof RemindInfoImpl) {
            return remindInfo;
        }

        RemindInfoImpl remindInfoImpl = new RemindInfoImpl();

        remindInfoImpl.setNew(remindInfo.isNew());
        remindInfoImpl.setPrimaryKey(remindInfo.getPrimaryKey());

        remindInfoImpl.setRemindInfoId(remindInfo.getRemindInfoId());
        remindInfoImpl.setNoteId(remindInfo.getNoteId());
        remindInfoImpl.setRemindDate(remindInfo.getRemindDate());
        remindInfoImpl.setRemindSubject(remindInfo.getRemindSubject());
        remindInfoImpl.setRecipientEmails(remindInfo.getRecipientEmails());
        remindInfoImpl.setLastRemindTime(remindInfo.getLastRemindTime());

        return remindInfoImpl;
    }

    /**
     * Returns the remind info with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the remind info
     * @return the remind info
     * @throws net.evrem.service.NoSuchRemindInfoException if a remind info with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public RemindInfo findByPrimaryKey(Serializable primaryKey)
        throws NoSuchRemindInfoException, SystemException {
        RemindInfo remindInfo = fetchByPrimaryKey(primaryKey);

        if (remindInfo == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchRemindInfoException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return remindInfo;
    }

    /**
     * Returns the remind info with the primary key or throws a {@link net.evrem.service.NoSuchRemindInfoException} if it could not be found.
     *
     * @param remindInfoId the primary key of the remind info
     * @return the remind info
     * @throws net.evrem.service.NoSuchRemindInfoException if a remind info with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public RemindInfo findByPrimaryKey(long remindInfoId)
        throws NoSuchRemindInfoException, SystemException {
        return findByPrimaryKey((Serializable) remindInfoId);
    }

    /**
     * Returns the remind info with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the remind info
     * @return the remind info, or <code>null</code> if a remind info with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public RemindInfo fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        RemindInfo remindInfo = (RemindInfo) EntityCacheUtil.getResult(RemindInfoModelImpl.ENTITY_CACHE_ENABLED,
                RemindInfoImpl.class, primaryKey);

        if (remindInfo == _nullRemindInfo) {
            return null;
        }

        if (remindInfo == null) {
            Session session = null;

            try {
                session = openSession();

                remindInfo = (RemindInfo) session.get(RemindInfoImpl.class,
                        primaryKey);

                if (remindInfo != null) {
                    cacheResult(remindInfo);
                } else {
                    EntityCacheUtil.putResult(RemindInfoModelImpl.ENTITY_CACHE_ENABLED,
                        RemindInfoImpl.class, primaryKey, _nullRemindInfo);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(RemindInfoModelImpl.ENTITY_CACHE_ENABLED,
                    RemindInfoImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return remindInfo;
    }

    /**
     * Returns the remind info with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param remindInfoId the primary key of the remind info
     * @return the remind info, or <code>null</code> if a remind info with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public RemindInfo fetchByPrimaryKey(long remindInfoId)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) remindInfoId);
    }

    /**
     * Returns all the remind infos.
     *
     * @return the remind infos
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<RemindInfo> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the remind infos.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.evrem.service.model.impl.RemindInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of remind infos
     * @param end the upper bound of the range of remind infos (not inclusive)
     * @return the range of remind infos
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<RemindInfo> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the remind infos.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.evrem.service.model.impl.RemindInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of remind infos
     * @param end the upper bound of the range of remind infos (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of remind infos
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<RemindInfo> findAll(int start, int end,
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

        List<RemindInfo> list = (List<RemindInfo>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_REMINDINFO);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_REMINDINFO;

                if (pagination) {
                    sql = sql.concat(RemindInfoModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<RemindInfo>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<RemindInfo>(list);
                } else {
                    list = (List<RemindInfo>) QueryUtil.list(q, getDialect(),
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
     * Removes all the remind infos from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (RemindInfo remindInfo : findAll()) {
            remove(remindInfo);
        }
    }

    /**
     * Returns the number of remind infos.
     *
     * @return the number of remind infos
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

                Query q = session.createQuery(_SQL_COUNT_REMINDINFO);

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
     * Initializes the remind info persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.net.evrem.service.model.RemindInfo")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<RemindInfo>> listenersList = new ArrayList<ModelListener<RemindInfo>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<RemindInfo>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(RemindInfoImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
