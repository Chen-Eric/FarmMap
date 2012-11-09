package dao;

import java.util.List;

import domain.Corner;
import domain.Paddock;

public interface ICornerDAO {

	public abstract void save(Corner transientInstance);

	public abstract void delete(Corner persistentInstance);

	public abstract Corner findById(domain.CornerId id);

	public abstract List findByExample(Corner instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByCLat(Object CLat);

	public abstract List findByCLon(Object CLon);

	public abstract List findByCEle(Object CEle);

	public abstract List findAll();
	
	public abstract List<Corner> findByFarmAndPaddock(Paddock paddock);

	public abstract Corner merge(Corner detachedInstance);

	public abstract void attachDirty(Corner instance);

	public abstract void attachClean(Corner instance);

	public abstract void updateCorner(Corner corner);

	
}