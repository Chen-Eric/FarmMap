package dao;

import java.util.List;

import domain.StockCount;

public interface IStockCountDAO {

	public abstract void save(StockCount transientInstance);

	public abstract void delete(StockCount persistentInstance);

	public abstract StockCount findById(domain.StockCountId id);
	
	public abstract List<StockCount> findByGrazingId(int gid);

	public abstract List findByExample(StockCount instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByScCount(Object scCount);

	public abstract List findAll();

	public abstract StockCount merge(StockCount detachedInstance);

	public abstract void attachDirty(StockCount instance);

	public abstract void attachClean(StockCount instance);

	public abstract void updateStockCount(StockCount stockCount);
}