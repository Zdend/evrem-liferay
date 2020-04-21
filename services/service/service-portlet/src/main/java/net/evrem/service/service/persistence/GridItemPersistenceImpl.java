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

import net.evrem.service.NoSuchGridItemException;
import net.evrem.service.model.GridItem;
import net.evrem.service.model.impl.GridItemImpl;
import net.evrem.service.model.impl.GridItemModelImpl;
import net.evrem.service.service.persistence.GridItemPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the grid item service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Zdenek Vecek
 * @see GridItemPersistence
 * @see GridItemUtil
 * @generated
 */
public class GridItemPersistenceImpl extends BasePersistenceImpl<GridItem>
    implements GridItemPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link GridItemUtil} to access the grid item persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = GridItemImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(GridItemModelImpl.ENTITY_CACHE_ENABLED,
            GridItemModelImpl.FINDER_CACHE_ENABLED, GridItemImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(GridItemModelImpl.ENTITY_CACHE_ENABLED,
            GridItemModelImpl.FINDER_CACHE_ENABLED, GridItemImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(GridItemModelImpl.ENTITY_CACHE_ENABLED,
            GridItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_FETCH_BY_NOTEID = new FinderPath(GridItemModelImpl.ENTITY_CACHE_ENABLED,
            GridItemModelImpl.FINDER_CACHE_ENABLED, GridItemImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByNoteId",
            new String[] { Long.class.getName() },
            GridItemModelImpl.NOTEID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_NOTEID = new FinderPath(GridItemModelImpl.ENTITY_CACHE_ENABLED,
            GridItemModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNoteId",
            new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_NOTEID_NOTEID_2 = "gridItem.noteId = ?";
    private static final String _SQL_SELECT_GRIDITEM = "SELECT gridItem FROM GridItem gridItem";
    private static final String _SQL_SELECT_GRIDITEM_WHERE = "SELECT gridItem FROM GridItem gridItem WHERE ";
    private static final String _SQL_COUNT_GRIDITEM = "SELECT COUNT(gridItem) FROM GridItem gridItem";
    private static final String _SQL_COUNT_GRIDITEM_WHERE = "SELECT COUNT(gridItem) FROM GridItem gridItem WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "gridItem.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No GridItem exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No GridItem exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(GridItemPersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "gridItemId", "noteId"
            });
    private static GridItem _nullGridItem = new GridItemImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<GridItem> toCacheModel() {
                return _nullGridItemCacheModel;
            }
        };

    private static CacheModel<GridItem> _nullGridItemCacheModel = new CacheModel<GridItem>() {
            @Override
            public GridItem toEntityModel() {
                return _nullGridItem;
            }
        };

    public GridItemPersistenceImpl() {
        setModelClass(GridItem.class);
    }

    /**
     * Returns the grid item where noteId = &#63; or throws a {@link net.evrem.service.NoSuchGridItemException} if it could not be found.
     *
     * @param noteId the note ID
     * @return the matching grid item
     * @throws net.evrem.service.NoSuchGridItemException if a matching grid item could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public GridItem findByNoteId(long noteId)
        throws NoSuchGridItemException, SystemException {
        GridItem gridItem = fetchByNoteId(noteId);

        if (gridItem == null) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("noteId=");
            msg.append(noteId);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchGridItemException(msg.toString());
        }

        return gridItem;
    }

    /**
     * Returns the grid item where noteId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param noteId the note ID
     * @return the matching grid item, or <code>null</code> if a matching grid item could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public GridItem fetchByNoteId(long noteId) throws SystemException {
        return fetchByNoteId(noteId, true);
    }

    /**
     * Returns the grid item where noteId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param noteId the note ID
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching grid item, or <code>null</code> if a matching grid item could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public GridItem fetchByNoteId(long noteId, boolean retrieveFromCache)
        throws SystemException {
        Object[] finderArgs = new Object[] { noteId };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_NOTEID,
                    finderArgs, this);
        }

        if (result instanceof GridItem) {
            GridItem gridItem = (GridItem) result;

            if ((noteId != gridItem.getNoteId())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_SELECT_GRIDITEM_WHERE);

            query.append(_FINDER_COLUMN_NOTEID_NOTEID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(noteId);

                List<GridItem> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NOTEID,
                        finderArgs, list);
                } else {
                    if ((list.size() > 1) && _log.isWarnEnabled()) {
                        _log.warn(
                            "GridItemPersistenceImpl.fetchByNoteId(long, boolean) with parameters (" +
                            StringUtil.merge(finderArgs) +
                            ") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
                    }

                    GridItem gridItem = list.get(0);

                    result = gridItem;

                    cacheResult(gridItem);

                    if ((gridItem.getNoteId() != noteId)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NOTEID,
                            finderArgs, gridItem);
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
            return (GridItem) result;
        }
    }

    /**
     * Removes the grid item where noteId = &#63; from the database.
     *
     * @param noteId the note ID
     * @return the grid item that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public GridItem removeByNoteId(long noteId)
        throws NoSuchGridItemException, SystemException {
        GridItem gridItem = findByNoteId(noteId);

        return remove(gridItem);
    }

    /**
     * Returns the number of grid items where noteId = &#63;.
     *
     * @param noteId the note ID
     * @return the number of matching grid items
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

            query.append(_SQL_COUNT_GRIDITEM_WHERE);

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
     * Caches the grid item in the entity cache if it is enabled.
     *
     * @param gridItem the grid item
     */
    @Override
    public void cacheResult(GridItem gridItem) {
        EntityCacheUtil.putResult(GridItemModelImpl.ENTITY_CACHE_ENABLED,
            GridItemImpl.class, gridItem.getPrimaryKey(), gridItem);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NOTEID,
            new Object[] { gridItem.getNoteId() }, gridItem);

        gridItem.resetOriginalValues();
    }

    /**
     * Caches the grid items in the entity cache if it is enabled.
     *
     * @param gridItems the grid items
     */
    @Override
    public void cacheResult(List<GridItem> gridItems) {
        for (GridItem gridItem : gridItems) {
            if (EntityCacheUtil.getResult(
                        GridItemModelImpl.ENTITY_CACHE_ENABLED,
                        GridItemImpl.class, gridItem.getPrimaryKey()) == null) {
                cacheResult(gridItem);
            } else {
                gridItem.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all grid items.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(GridItemImpl.class.getName());
        }

        EntityCacheUtil.clearCache(GridItemImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the grid item.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(GridItem gridItem) {
        EntityCacheUtil.removeResult(GridItemModelImpl.ENTITY_CACHE_ENABLED,
            GridItemImpl.class, gridItem.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(gridItem);
    }

    @Override
    public void clearCache(List<GridItem> gridItems) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (GridItem gridItem : gridItems) {
            EntityCacheUtil.removeResult(GridItemModelImpl.ENTITY_CACHE_ENABLED,
                GridItemImpl.class, gridItem.getPrimaryKey());

            clearUniqueFindersCache(gridItem);
        }
    }

    protected void cacheUniqueFindersCache(GridItem gridItem) {
        if (gridItem.isNew()) {
            Object[] args = new Object[] { gridItem.getNoteId() };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NOTEID, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NOTEID, args,
                gridItem);
        } else {
            GridItemModelImpl gridItemModelImpl = (GridItemModelImpl) gridItem;

            if ((gridItemModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_NOTEID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { gridItem.getNoteId() };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NOTEID, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NOTEID, args,
                    gridItem);
            }
        }
    }

    protected void clearUniqueFindersCache(GridItem gridItem) {
        GridItemModelImpl gridItemModelImpl = (GridItemModelImpl) gridItem;

        Object[] args = new Object[] { gridItem.getNoteId() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NOTEID, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NOTEID, args);

        if ((gridItemModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_NOTEID.getColumnBitmask()) != 0) {
            args = new Object[] { gridItemModelImpl.getOriginalNoteId() };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NOTEID, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NOTEID, args);
        }
    }

    /**
     * Creates a new grid item with the primary key. Does not add the grid item to the database.
     *
     * @param gridItemId the primary key for the new grid item
     * @return the new grid item
     */
    @Override
    public GridItem create(long gridItemId) {
        GridItem gridItem = new GridItemImpl();

        gridItem.setNew(true);
        gridItem.setPrimaryKey(gridItemId);

        return gridItem;
    }

    /**
     * Removes the grid item with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param gridItemId the primary key of the grid item
     * @return the grid item that was removed
     * @throws net.evrem.service.NoSuchGridItemException if a grid item with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public GridItem remove(long gridItemId)
        throws NoSuchGridItemException, SystemException {
        return remove((Serializable) gridItemId);
    }

    /**
     * Removes the grid item with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the grid item
     * @return the grid item that was removed
     * @throws net.evrem.service.NoSuchGridItemException if a grid item with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public GridItem remove(Serializable primaryKey)
        throws NoSuchGridItemException, SystemException {
        Session session = null;

        try {
            session = openSession();

            GridItem gridItem = (GridItem) session.get(GridItemImpl.class,
                    primaryKey);

            if (gridItem == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchGridItemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(gridItem);
        } catch (NoSuchGridItemException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected GridItem removeImpl(GridItem gridItem) throws SystemException {
        gridItem = toUnwrappedModel(gridItem);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(gridItem)) {
                gridItem = (GridItem) session.get(GridItemImpl.class,
                        gridItem.getPrimaryKeyObj());
            }

            if (gridItem != null) {
                session.delete(gridItem);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (gridItem != null) {
            clearCache(gridItem);
        }

        return gridItem;
    }

    @Override
    public GridItem updateImpl(net.evrem.service.model.GridItem gridItem)
        throws SystemException {
        gridItem = toUnwrappedModel(gridItem);

        boolean isNew = gridItem.isNew();

        Session session = null;

        try {
            session = openSession();

            if (gridItem.isNew()) {
                session.save(gridItem);

                gridItem.setNew(false);
            } else {
                session.merge(gridItem);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !GridItemModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }

        EntityCacheUtil.putResult(GridItemModelImpl.ENTITY_CACHE_ENABLED,
            GridItemImpl.class, gridItem.getPrimaryKey(), gridItem);

        clearUniqueFindersCache(gridItem);
        cacheUniqueFindersCache(gridItem);

        return gridItem;
    }

    protected GridItem toUnwrappedModel(GridItem gridItem) {
        if (gridItem instanceof GridItemImpl) {
            return gridItem;
        }

        GridItemImpl gridItemImpl = new GridItemImpl();

        gridItemImpl.setNew(gridItem.isNew());
        gridItemImpl.setPrimaryKey(gridItem.getPrimaryKey());

        gridItemImpl.setGridItemId(gridItem.getGridItemId());
        gridItemImpl.setNoteId(gridItem.getNoteId());
        gridItemImpl.setW(gridItem.getW());
        gridItemImpl.setH(gridItem.getH());
        gridItemImpl.setX(gridItem.getX());
        gridItemImpl.setY(gridItem.getY());

        return gridItemImpl;
    }

    /**
     * Returns the grid item with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the grid item
     * @return the grid item
     * @throws net.evrem.service.NoSuchGridItemException if a grid item with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public GridItem findByPrimaryKey(Serializable primaryKey)
        throws NoSuchGridItemException, SystemException {
        GridItem gridItem = fetchByPrimaryKey(primaryKey);

        if (gridItem == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchGridItemException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return gridItem;
    }

    /**
     * Returns the grid item with the primary key or throws a {@link net.evrem.service.NoSuchGridItemException} if it could not be found.
     *
     * @param gridItemId the primary key of the grid item
     * @return the grid item
     * @throws net.evrem.service.NoSuchGridItemException if a grid item with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public GridItem findByPrimaryKey(long gridItemId)
        throws NoSuchGridItemException, SystemException {
        return findByPrimaryKey((Serializable) gridItemId);
    }

    /**
     * Returns the grid item with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the grid item
     * @return the grid item, or <code>null</code> if a grid item with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public GridItem fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        GridItem gridItem = (GridItem) EntityCacheUtil.getResult(GridItemModelImpl.ENTITY_CACHE_ENABLED,
                GridItemImpl.class, primaryKey);

        if (gridItem == _nullGridItem) {
            return null;
        }

        if (gridItem == null) {
            Session session = null;

            try {
                session = openSession();

                gridItem = (GridItem) session.get(GridItemImpl.class, primaryKey);

                if (gridItem != null) {
                    cacheResult(gridItem);
                } else {
                    EntityCacheUtil.putResult(GridItemModelImpl.ENTITY_CACHE_ENABLED,
                        GridItemImpl.class, primaryKey, _nullGridItem);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(GridItemModelImpl.ENTITY_CACHE_ENABLED,
                    GridItemImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return gridItem;
    }

    /**
     * Returns the grid item with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param gridItemId the primary key of the grid item
     * @return the grid item, or <code>null</code> if a grid item with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public GridItem fetchByPrimaryKey(long gridItemId)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) gridItemId);
    }

    /**
     * Returns all the grid items.
     *
     * @return the grid items
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<GridItem> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the grid items.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.evrem.service.model.impl.GridItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of grid items
     * @param end the upper bound of the range of grid items (not inclusive)
     * @return the range of grid items
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<GridItem> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the grid items.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.evrem.service.model.impl.GridItemModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of grid items
     * @param end the upper bound of the range of grid items (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of grid items
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<GridItem> findAll(int start, int end,
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

        List<GridItem> list = (List<GridItem>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_GRIDITEM);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_GRIDITEM;

                if (pagination) {
                    sql = sql.concat(GridItemModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<GridItem>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<GridItem>(list);
                } else {
                    list = (List<GridItem>) QueryUtil.list(q, getDialect(),
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
     * Removes all the grid items from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (GridItem gridItem : findAll()) {
            remove(gridItem);
        }
    }

    /**
     * Returns the number of grid items.
     *
     * @return the number of grid items
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

                Query q = session.createQuery(_SQL_COUNT_GRIDITEM);

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
     * Initializes the grid item persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.net.evrem.service.model.GridItem")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<GridItem>> listenersList = new ArrayList<ModelListener<GridItem>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<GridItem>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(GridItemImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
