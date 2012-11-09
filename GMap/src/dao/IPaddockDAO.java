package dao;

import java.util.List;

import domain.Paddock;

public interface IPaddockDAO {

	public abstract void save(Paddock transientInstance);

	public abstract void delete(Paddock persistentInstance);

	public abstract Paddock findById(domain.PaddockId id);

	public abstract List findByExample(Paddock instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByPName(Object PName);

	public abstract List findByPCenterLat(Object PCenterLat);

	public abstract List findByPCenterLon(Object PCenterLon);

	public abstract List findByPDescription(Object PDescription);

	public abstract List findByPFeedCapacity(Object PFeedCapacity);

	public abstract List findAll();

	public abstract Paddock merge(Paddock detachedInstance);

	public abstract void attachDirty(Paddock instance);

	public abstract void attachClean(Paddock instance);
	
	public abstract void updatePaddock(Paddock paddock);

}