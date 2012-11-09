package dao;

import java.util.List;

import domain.Grazing;
import domain.Paddock;
import domain.Todo;

public interface ITodoDAO {

	public abstract void save(Todo transientInstance);

	public abstract void delete(Todo persistentInstance);

	public abstract Todo findById(java.lang.Short id);

	public abstract List findByExample(Todo instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByTDescription(Object TDescription);

	public abstract List findAll();
	
	public List<Todo> findByFarmAndPaddock(Paddock paddock);

	public abstract Todo merge(Todo detachedInstance);

	public abstract void attachDirty(Todo instance);

	public abstract void attachClean(Todo instance);
	
	public abstract void updateTodo(Todo todo);

}