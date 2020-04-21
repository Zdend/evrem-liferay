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

import net.evrem.service.NoSuchUserDetailException;
import net.evrem.service.model.UserDetail;
import net.evrem.service.model.impl.UserDetailImpl;
import net.evrem.service.model.impl.UserDetailModelImpl;
import net.evrem.service.service.persistence.UserDetailPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the user detail service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Zdenek Vecek
 * @see UserDetailPersistence
 * @see UserDetailUtil
 * @generated
 */
public class UserDetailPersistenceImpl extends BasePersistenceImpl<UserDetail>
    implements UserDetailPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link UserDetailUtil} to access the user detail persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = UserDetailImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(UserDetailModelImpl.ENTITY_CACHE_ENABLED,
            UserDetailModelImpl.FINDER_CACHE_ENABLED, UserDetailImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(UserDetailModelImpl.ENTITY_CACHE_ENABLED,
            UserDetailModelImpl.FINDER_CACHE_ENABLED, UserDetailImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(UserDetailModelImpl.ENTITY_CACHE_ENABLED,
            UserDetailModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_FETCH_BY_USERID = new FinderPath(UserDetailModelImpl.ENTITY_CACHE_ENABLED,
            UserDetailModelImpl.FINDER_CACHE_ENABLED, UserDetailImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByUserId",
            new String[] { Long.class.getName() },
            UserDetailModelImpl.USERID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(UserDetailModelImpl.ENTITY_CACHE_ENABLED,
            UserDetailModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_USERID_USERID_2 = "userDetail.userId = ?";
    private static final String _SQL_SELECT_USERDETAIL = "SELECT userDetail FROM UserDetail userDetail";
    private static final String _SQL_SELECT_USERDETAIL_WHERE = "SELECT userDetail FROM UserDetail userDetail WHERE ";
    private static final String _SQL_COUNT_USERDETAIL = "SELECT COUNT(userDetail) FROM UserDetail userDetail";
    private static final String _SQL_COUNT_USERDETAIL_WHERE = "SELECT COUNT(userDetail) FROM UserDetail userDetail WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "userDetail.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No UserDetail exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No UserDetail exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(UserDetailPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "userDetailId", "userId", "timeZoneId"
            });
    private static UserDetail _nullUserDetail = new UserDetailImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<UserDetail> toCacheModel() {
                return _nullUserDetailCacheModel;
            }
        };

    private static CacheModel<UserDetail> _nullUserDetailCacheModel = new CacheModel<UserDetail>() {
            @Override
            public UserDetail toEntityModel() {
                return _nullUserDetail;
            }
        };

    public UserDetailPersistenceImpl() {
        setModelClass(UserDetail.class);
    }

    /**
     * Returns the user detail where userId = &#63; or throws a {@link net.evrem.service.NoSuchUserDetailException} if it could not be found.
     *
     * @param userId the user ID
     * @return the matching user detail
     * @throws net.evrem.service.NoSuchUserDetailException if a matching user detail could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public UserDetail findByUserId(long userId)
        throws NoSuchUserDetailException, SystemException {
        UserDetail userDetail = fetchByUserId(userId);

        if (userDetail == null) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("userId=");
            msg.append(userId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchUserDetailException(msg.toString());
        }

        return userDetail;
    }

    /**
     * Returns the user detail where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param userId the user ID
     * @return the matching user detail, or <code>null</code> if a matching user detail could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public UserDetail fetchByUserId(long userId) throws SystemException {
        return fetchByUserId(userId, true);
    }

    /**
     * Returns the user detail where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param userId the user ID
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching user detail, or <code>null</code> if a matching user detail could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public UserDetail fetchByUserId(long userId, boolean retrieveFromCache)
        throws SystemException {
        Object[] finderArgs = new Object[] { userId };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_USERID,
                    finderArgs, this);
        }

        if (result instanceof UserDetail) {
            UserDetail userDetail = (UserDetail) result;

            if ((userId != userDetail.getUserId())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_SELECT_USERDETAIL_WHERE);

            query.append(_FINDER_COLUMN_USERID_USERID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                List<UserDetail> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
                        finderArgs, list);
                } else {
                    if ((list.size() > 1) && _log.isWarnEnabled()) {
                        _log.warn(
                            "UserDetailPersistenceImpl.fetchByUserId(long, boolean) with parameters (" +
                            StringUtil.merge(finderArgs) +
                            ") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
                    }

                    UserDetail userDetail = list.get(0);

                    result = userDetail;

                    cacheResult(userDetail);

                    if ((userDetail.getUserId() != userId)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
                            finderArgs, userDetail);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (UserDetail) result;
        }
    }

    /**
     * Removes the user detail where userId = &#63; from the database.
     *
     * @param userId the user ID
     * @return the user detail that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public UserDetail removeByUserId(long userId)
        throws NoSuchUserDetailException, SystemException {
        UserDetail userDetail = findByUserId(userId);

        return remove(userDetail);
    }

    /**
     * Returns the number of user details where userId = &#63;.
     *
     * @param userId the user ID
     * @return the number of matching user details
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

            query.append(_SQL_COUNT_USERDETAIL_WHERE);

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
     * Caches the user detail in the entity cache if it is enabled.
     *
     * @param userDetail the user detail
     */
    @Override
    public void cacheResult(UserDetail userDetail) {
        EntityCacheUtil.putResult(UserDetailModelImpl.ENTITY_CACHE_ENABLED,
            UserDetailImpl.class, userDetail.getPrimaryKey(), userDetail);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID,
            new Object[] { userDetail.getUserId() }, userDetail);

        userDetail.resetOriginalValues();
    }

    /**
     * Caches the user details in the entity cache if it is enabled.
     *
     * @param userDetails the user details
     */
    @Override
    public void cacheResult(List<UserDetail> userDetails) {
        for (UserDetail userDetail : userDetails) {
            if (EntityCacheUtil.getResult(
                        UserDetailModelImpl.ENTITY_CACHE_ENABLED,
                        UserDetailImpl.class, userDetail.getPrimaryKey()) == null) {
                cacheResult(userDetail);
            } else {
                userDetail.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all user details.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(UserDetailImpl.class.getName());
        }

        EntityCacheUtil.clearCache(UserDetailImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the user detail.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(UserDetail userDetail) {
        EntityCacheUtil.removeResult(UserDetailModelImpl.ENTITY_CACHE_ENABLED,
            UserDetailImpl.class, userDetail.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(userDetail);
    }

    @Override
    public void clearCache(List<UserDetail> userDetails) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (UserDetail userDetail : userDetails) {
            EntityCacheUtil.removeResult(UserDetailModelImpl.ENTITY_CACHE_ENABLED,
                UserDetailImpl.class, userDetail.getPrimaryKey());

            clearUniqueFindersCache(userDetail);
        }
    }

    protected void cacheUniqueFindersCache(UserDetail userDetail) {
        if (userDetail.isNew()) {
            Object[] args = new Object[] { userDetail.getUserId() };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERID, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID, args,
                userDetail);
        } else {
            UserDetailModelImpl userDetailModelImpl = (UserDetailModelImpl) userDetail;

            if ((userDetailModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_USERID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { userDetail.getUserId() };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERID, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_USERID, args,
                    userDetail);
            }
        }
    }

    protected void clearUniqueFindersCache(UserDetail userDetail) {
        UserDetailModelImpl userDetailModelImpl = (UserDetailModelImpl) userDetail;

        Object[] args = new Object[] { userDetail.getUserId() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID, args);

        if ((userDetailModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_USERID.getColumnBitmask()) != 0) {
            args = new Object[] { userDetailModelImpl.getOriginalUserId() };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_USERID, args);
        }
    }

    /**
     * Creates a new user detail with the primary key. Does not add the user detail to the database.
     *
     * @param userDetailId the primary key for the new user detail
     * @return the new user detail
     */
    @Override
    public UserDetail create(long userDetailId) {
        UserDetail userDetail = new UserDetailImpl();

        userDetail.setNew(true);
        userDetail.setPrimaryKey(userDetailId);

        return userDetail;
    }

    /**
     * Removes the user detail with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param userDetailId the primary key of the user detail
     * @return the user detail that was removed
     * @throws net.evrem.service.NoSuchUserDetailException if a user detail with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public UserDetail remove(long userDetailId)
        throws NoSuchUserDetailException, SystemException {
        return remove((Serializable) userDetailId);
    }

    /**
     * Removes the user detail with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the user detail
     * @return the user detail that was removed
     * @throws net.evrem.service.NoSuchUserDetailException if a user detail with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public UserDetail remove(Serializable primaryKey)
        throws NoSuchUserDetailException, SystemException {
        Session session = null;

        try {
            session = openSession();

            UserDetail userDetail = (UserDetail) session.get(UserDetailImpl.class,
                    primaryKey);

            if (userDetail == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchUserDetailException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(userDetail);
        } catch (NoSuchUserDetailException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected UserDetail removeImpl(UserDetail userDetail)
        throws SystemException {
        userDetail = toUnwrappedModel(userDetail);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(userDetail)) {
                userDetail = (UserDetail) session.get(UserDetailImpl.class,
                        userDetail.getPrimaryKeyObj());
            }

            if (userDetail != null) {
                session.delete(userDetail);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (userDetail != null) {
            clearCache(userDetail);
        }

        return userDetail;
    }

    @Override
    public UserDetail updateImpl(net.evrem.service.model.UserDetail userDetail)
        throws SystemException {
        userDetail = toUnwrappedModel(userDetail);

        boolean isNew = userDetail.isNew();

        Session session = null;

        try {
            session = openSession();

            if (userDetail.isNew()) {
                session.save(userDetail);

                userDetail.setNew(false);
            } else {
                session.merge(userDetail);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !UserDetailModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }

        EntityCacheUtil.putResult(UserDetailModelImpl.ENTITY_CACHE_ENABLED,
            UserDetailImpl.class, userDetail.getPrimaryKey(), userDetail);

        clearUniqueFindersCache(userDetail);
        cacheUniqueFindersCache(userDetail);

        return userDetail;
    }

    protected UserDetail toUnwrappedModel(UserDetail userDetail) {
        if (userDetail instanceof UserDetailImpl) {
            return userDetail;
        }

        UserDetailImpl userDetailImpl = new UserDetailImpl();

        userDetailImpl.setNew(userDetail.isNew());
        userDetailImpl.setPrimaryKey(userDetail.getPrimaryKey());

        userDetailImpl.setUserDetailId(userDetail.getUserDetailId());
        userDetailImpl.setUserId(userDetail.getUserId());
        userDetailImpl.setTimeZoneId(userDetail.getTimeZoneId());

        return userDetailImpl;
    }

    /**
     * Returns the user detail with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the user detail
     * @return the user detail
     * @throws net.evrem.service.NoSuchUserDetailException if a user detail with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public UserDetail findByPrimaryKey(Serializable primaryKey)
        throws NoSuchUserDetailException, SystemException {
        UserDetail userDetail = fetchByPrimaryKey(primaryKey);

        if (userDetail == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchUserDetailException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return userDetail;
    }

    /**
     * Returns the user detail with the primary key or throws a {@link net.evrem.service.NoSuchUserDetailException} if it could not be found.
     *
     * @param userDetailId the primary key of the user detail
     * @return the user detail
     * @throws net.evrem.service.NoSuchUserDetailException if a user detail with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public UserDetail findByPrimaryKey(long userDetailId)
        throws NoSuchUserDetailException, SystemException {
        return findByPrimaryKey((Serializable) userDetailId);
    }

    /**
     * Returns the user detail with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the user detail
     * @return the user detail, or <code>null</code> if a user detail with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public UserDetail fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        UserDetail userDetail = (UserDetail) EntityCacheUtil.getResult(UserDetailModelImpl.ENTITY_CACHE_ENABLED,
                UserDetailImpl.class, primaryKey);

        if (userDetail == _nullUserDetail) {
            return null;
        }

        if (userDetail == null) {
            Session session = null;

            try {
                session = openSession();

                userDetail = (UserDetail) session.get(UserDetailImpl.class,
                        primaryKey);

                if (userDetail != null) {
                    cacheResult(userDetail);
                } else {
                    EntityCacheUtil.putResult(UserDetailModelImpl.ENTITY_CACHE_ENABLED,
                        UserDetailImpl.class, primaryKey, _nullUserDetail);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(UserDetailModelImpl.ENTITY_CACHE_ENABLED,
                    UserDetailImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return userDetail;
    }

    /**
     * Returns the user detail with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param userDetailId the primary key of the user detail
     * @return the user detail, or <code>null</code> if a user detail with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public UserDetail fetchByPrimaryKey(long userDetailId)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) userDetailId);
    }

    /**
     * Returns all the user details.
     *
     * @return the user details
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<UserDetail> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the user details.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.evrem.service.model.impl.UserDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of user details
     * @param end the upper bound of the range of user details (not inclusive)
     * @return the range of user details
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<UserDetail> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the user details.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.evrem.service.model.impl.UserDetailModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of user details
     * @param end the upper bound of the range of user details (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of user details
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<UserDetail> findAll(int start, int end,
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

        List<UserDetail> list = (List<UserDetail>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_USERDETAIL);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_USERDETAIL;

                if (pagination) {
                    sql = sql.concat(UserDetailModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<UserDetail>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<UserDetail>(list);
                } else {
                    list = (List<UserDetail>) QueryUtil.list(q, getDialect(),
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
     * Removes all the user details from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (UserDetail userDetail : findAll()) {
            remove(userDetail);
        }
    }

    /**
     * Returns the number of user details.
     *
     * @return the number of user details
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

                Query q = session.createQuery(_SQL_COUNT_USERDETAIL);

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
     * Initializes the user detail persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.net.evrem.service.model.UserDetail")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<UserDetail>> listenersList = new ArrayList<ModelListener<UserDetail>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<UserDetail>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(UserDetailImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
