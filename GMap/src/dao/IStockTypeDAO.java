package dao;

import java.util.List;

import domain.StockType;

public interface IStockTypeDAO {

	public abstract void save(StockType transientInstance);

	public abstract void delete(StockType persistentInstance);

	public abstract StockType findById(java.lang.Short id);

	public abstract List findByExample(StockType instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findBySType(Object SType);

	public abstract List findByStockUnits(Object stockUnits);

	public abstract List findAll();

	public abstract StockType merge(StockType detachedInstance);

	public abstract void attachDirty(StockType instance);

	public abstract void attachClean(StockType instance);

	public abstract void updateStockType(StockType stockType);
}