package dao;

import java.util.List;

import domain.Block;

public interface IBlockDAO {

	public abstract void save(Block transientInstance);

	public abstract void delete(Block persistentInstance);

	public abstract Block findById(domain.BlockId id);

	public abstract List findByExample(Block instance);

	public abstract List findByProperty(String propertyName, Object value);

	public abstract List findByBName(Object BName);

	public abstract List findByBType(Object BType);

	public abstract List findByBDescription(Object BDescription);

	public abstract List findByBData(Object BData);

	public abstract List findAll();

	public abstract Block merge(Block detachedInstance);

	public abstract void attachDirty(Block instance);

	public abstract void attachClean(Block instance);

	public abstract void updateBlock(Block block);
}