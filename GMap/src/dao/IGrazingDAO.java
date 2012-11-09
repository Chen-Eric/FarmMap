package dao;

import java.util.List;

import domain.Corner;
import domain.Grazing;
import domain.Paddock;

public interface IGrazingDAO {

	public abstract void save(Grazing transientInstance);

	public abstract void delete(Grazing persistentInstance);

	public abstract Grazing findById(java.lang.Integer id);

	public abstract List findByExample(Grazing instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByGNote(Object GNote);

	public abstract List findAll();
	
	public abstract List<Grazing> findByFarmAndPaddock(Paddock paddock);

	public abstract Grazing merge(Grazing detachedInstance);

	public abstract void attachDirty(Grazing instance);

	public abstract void attachClean(Grazing instance);
	
	public abstract void updateGrazing(Grazing grazing);

}