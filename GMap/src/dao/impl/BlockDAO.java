package dao.impl;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.IBlockDAO;
import domain.Block;
import domain.BlockId;

/**
 * A data access object (DAO) providing persistence and search support for Block
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see domain.Block
 * @author MyEclipse Persistence Tools
 */

public class BlockDAO extends HibernateDaoSupport implements IBlockDAO {
	private static final Logger log = LoggerFactory.getLogger(BlockDAO.class);
	// property constants
	public static final String _BNAME = "BName";
	public static final String _BTYPE = "BType";
	public static final String _BDESCRIPTION = "BDescription";
	public static final String _BDATA = "BData";

	protected void initDao() {
		// do nothing
	}

	@Override
	public void save(Block transientInstance) {
		log.debug("saving Block instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	@Override
	public void delete(Block persistentInstance) {
		log.debug("deleting Block instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	@Override
	public Block findById(domain.BlockId id) {
		log.debug("getting Block instance with id: " + id);
		try {
			Block instance = (Block) getHibernateTemplate().get("domain.Block",
					id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public List findByExample(Block instance) {
		log.debug("finding Block instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	@Override
	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Block instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Block as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	@Override
	public List findByBName(Object BName) {
		return findByProperty(_BNAME, BName);
	}

	@Override
	public List findByBType(Object BType) {
		return findByProperty(_BTYPE, BType);
	}

	@Override
	public List findByBDescription(Object BDescription) {
		return findByProperty(_BDESCRIPTION, BDescription);
	}

	@Override
	public List findByBData(Object BData) {
		return findByProperty(_BDATA, BData);
	}

	@Override
	public List findAll() {
		log.debug("finding all Block instances");
		try {
			String queryString = "from Block";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	@Override
	public Block merge(Block detachedInstance) {
		log.debug("merging Block instance");
		try {
			Block result = (Block) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	@Override
	public void attachDirty(Block instance) {
		log.debug("attaching dirty Block instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@Override
	public void attachClean(Block instance) {
		log.debug("attaching clean Block instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IBlockDAO getFromApplicationContext(ApplicationContext ctx) {
		return (IBlockDAO) ctx.getBean("BlockDAO");
	}

	@Override
	public void updateBlock(Block block) {
		this.getHibernateTemplate().update(block);		
	}
}