package net.evrem.service.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import net.evrem.service.model.GridItem;

/**
 * The persistence interface for the grid item service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Zdenek Vecek
 * @see GridItemPersistenceImpl
 * @see GridItemUtil
 * @generated
 */
public interface GridItemPersistence extends BasePersistence<GridItem> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link GridItemUtil} to access the grid item persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns the grid item where noteId = &#63; or throws a {@link net.evrem.service.NoSuchGridItemException} if it could not be found.
    *
    * @param noteId the note ID
    * @return the matching grid item
    * @throws net.evrem.service.NoSuchGridItemException if a matching grid item could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.evrem.service.model.GridItem findByNoteId(long noteId)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchGridItemException;

    /**
    * Returns the grid item where noteId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param noteId the note ID
    * @return the matching grid item, or <code>null</code> if a matching grid item could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.evrem.service.model.GridItem fetchByNoteId(long noteId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the grid item where noteId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param noteId the note ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching grid item, or <code>null</code> if a matching grid item could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.evrem.service.model.GridItem fetchByNoteId(long noteId,
        boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the grid item where noteId = &#63; from the database.
    *
    * @param noteId the note ID
    * @return the grid item that was removed
    * @throws SystemException if a system exception occurred
    */
    public net.evrem.service.model.GridItem removeByNoteId(long noteId)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchGridItemException;

    /**
    * Returns the number of grid items where noteId = &#63;.
    *
    * @param noteId the note ID
    * @return the number of matching grid items
    * @throws SystemException if a system exception occurred
    */
    public int countByNoteId(long noteId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the grid item in the entity cache if it is enabled.
    *
    * @param gridItem the grid item
    */
    public void cacheResult(net.evrem.service.model.GridItem gridItem);

    /**
    * Caches the grid items in the entity cache if it is enabled.
    *
    * @param gridItems the grid items
    */
    public void cacheResult(
        java.util.List<net.evrem.service.model.GridItem> gridItems);

    /**
    * Creates a new grid item with the primary key. Does not add the grid item to the database.
    *
    * @param gridItemId the primary key for the new grid item
    * @return the new grid item
    */
    public net.evrem.service.model.GridItem create(long gridItemId);

    /**
    * Removes the grid item with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param gridItemId the primary key of the grid item
    * @return the grid item that was removed
    * @throws net.evrem.service.NoSuchGridItemException if a grid item with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.evrem.service.model.GridItem remove(long gridItemId)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchGridItemException;

    public net.evrem.service.model.GridItem updateImpl(
        net.evrem.service.model.GridItem gridItem)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the grid item with the primary key or throws a {@link net.evrem.service.NoSuchGridItemException} if it could not be found.
    *
    * @param gridItemId the primary key of the grid item
    * @return the grid item
    * @throws net.evrem.service.NoSuchGridItemException if a grid item with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.evrem.service.model.GridItem findByPrimaryKey(long gridItemId)
        throws com.liferay.portal.kernel.exception.SystemException,
            net.evrem.service.NoSuchGridItemException;

    /**
    * Returns the grid item with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param gridItemId the primary key of the grid item
    * @return the grid item, or <code>null</code> if a grid item with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public net.evrem.service.model.GridItem fetchByPrimaryKey(long gridItemId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the grid items.
    *
    * @return the grid items
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<net.evrem.service.model.GridItem> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<net.evrem.service.model.GridItem> findAll(int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<net.evrem.service.model.GridItem> findAll(int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the grid items from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of grid items.
    *
    * @return the number of grid items
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
