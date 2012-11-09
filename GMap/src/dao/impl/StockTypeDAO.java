package dao.impl;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.IStockTypeDAO;
import domain.StockType;

/**
 * A data access object (DAO) providing persistence and search support for
 * StockType entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see domain.StockType
 * @author MyEclipse Persistence Tools
 */

public class StockTypeDAO extends HibernateDaoSupport implements IStockTypeDAO {
	private static final Logger log = LoggerFactory
			.getLogger(StockTypeDAO.class);
	// property constants
	public static final String _STYPE = "SType";
	public static final String STOCK_UNITS = "stockUnits";

	protected void initDao() {
		// do nothing
	}

	@Override
	public void save(StockType transientInstance) {
		log.debug("saving StockType instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	@Override
	public void delete(StockType persistentInstance) {
		log.debug("deleting StockType instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	@Override
	public StockType findById(java.lang.Short id) {
		log.debug("getting StockType instance with id: " + id);
		try {
			StockType instance = (StockType) getHibernateTemplate().get(
					"domain.StockType", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public List findByExample(StockType instance) {
		log.debug("finding StockType instance by example");
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
		log.debug("finding StockType instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from StockType as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	@Override
	public List findBySType(Object SType) {
		return findByProperty(_STYPE, SType);
	}

	@Override
	public List findByStockUnits(Object stockUnits) {
		return findByProperty(STOCK_UNITS, stockUnits);
	}

	@Override
	public List findAll() {
		log.debug("finding all StockType instances");
		try {
			String queryString = "from StockType";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	@Override
	public StockType merge(StockType detachedInstance) {
		log.debug("merging StockType instance");
		try {
			StockType result = (StockType) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	@Override
	public void attachDirty(StockType instance) {
		log.debug("attaching dirty StockType instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@Override
	public void attachClean(StockType instance) {
		log.debug("attaching clean StockType instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IStockTypeDAO getFromApplicationContext(ApplicationContext ctx) {
		return (IStockTypeDAO) ctx.getBean("StockTypeDAO");
	}

	@Override
	public void updateStockType(StockType stockType) {
		this.getHibernateTemplate().update(stockType);		
	}
}