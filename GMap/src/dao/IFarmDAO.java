package dao;

import java.util.List;

import domain.Farm;

public interface IFarmDAO {

	public abstract void save(Farm transientInstance);

	public abstract void delete(Farm persistentInstance);

	public abstract Farm findById(java.lang.Short id);

	public abstract List findByExample(Farm instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByFName(Object FName);

	public abstract List findByFDescription(Object FDescription);

	public abstract List findAll();

	public abstract Farm merge(Farm detachedInstance);

	public abstract void attachDirty(Farm instance);

	public abstract void attachClean(Farm instance);
	
	public abstract Farm update(Farm farm);

}