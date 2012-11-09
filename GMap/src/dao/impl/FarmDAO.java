package dao.impl;

import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.IFarmDAO;
import domain.Farm;

/**
 * A data access object (DAO) providing persistence and search support for Farm
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see domain.Farm
 * @author MyEclipse Persistence Tools
 */

public class FarmDAO extends HibernateDaoSupport implements IFarmDAO {
	private static final Logger log = LoggerFactory.getLogger(FarmDAO.class);
	// property constants
	public static final String _FNAME = "FName";
	public static final String _FDESCRIPTION = "FDescription";

	protected void initDao() {
		// do nothing
	}

	@Override
	public void save(Farm transientInstance) {
		log.debug("saving Farm instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	@Override
	public void delete(Farm persistentInstance) {
		log.debug("deleting Farm instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	@Override
	public Farm findById(java.lang.Short id) {
		log.debug("getting Farm instance with id: " + id);
		try {
			Farm instance = (Farm) getHibernateTemplate()
					.get("domain.Farm", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public List findByExample(Farm instance) {
		log.debug("finding Farm instance by example");
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
		log.debug("finding Farm instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Farm as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	@Override
	public List findByFName(Object FName) {
		return findByProperty(_FNAME, FName);
	}

	@Override
	public List findByFDescription(Object FDescription) {
		return findByProperty(_FDESCRIPTION, FDescription);
	}

	@Override
	public List findAll() {
		log.debug("finding all Farm instances");
		try {
			String queryString = "from Farm";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	@Override
	public Farm merge(Farm detachedInstance) {
		log.debug("merging Farm instance");
		try {
			Farm result = (Farm) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	@Override
	public void attachDirty(Farm instance) {
		log.debug("attaching dirty Farm instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@Override
	public void attachClean(Farm instance) {
		log.debug("attaching clean Farm instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static IFarmDAO getFromApplicationContext(ApplicationContext ctx) {
		return (IFarmDAO) ctx.getBean("FarmDAO");
	}

	@Override
	public Farm update(Farm farm) {
		this.getHibernateTemplate().update(farm);
		return farm;
	}
}