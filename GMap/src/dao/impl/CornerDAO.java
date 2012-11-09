package dao.impl;

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.ICornerDAO;
import domain.Corner;
import domain.CornerId;
import domain.Paddock;

/**
 * A data access object (DAO) providing persistence and search support for
 * Corner entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see domain.Corner
 * @author MyEclipse Persistence Tools
 */

public class CornerDAO extends HibernateDaoSupport implements ICornerDAO {
	private static final Logger log = LoggerFactory.getLogger(CornerDAO.class);
	// property constants
	public static final String _CLAT = "CLat";
	public static final String _CLON = "CLon";
	public static final String _CELE = "CEle";

	protected void initDao() {
		// do nothing
	}

	@Override
	public void save(Corner transientInstance) {
		log.debug("saving Corner instance");
		try {
			this.getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	@Override
	public void delete(Corner persistentInstance) {
		log.debug("deleting Corner instance");
		try {
			this.getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	@Override
	public Corner findById(domain.CornerId id) {
		log.debug("getting Corner instance with id: " + id);
		try {
			Corner instance = (Corner) getHibernateTemplate().get(
					"domain.Corner", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public List findByExample(Corner instance) {
		log.debug("finding Corner instance by example");
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
		log.debug("finding Corner instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Corner as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	@Override
	public List findByCLat(Object CLat) {
		return findByProperty(_CLAT, CLat);
	}

	@Override
	public List findByCLon(Object CLon) {
		return findByProperty(_CLON, CLon);
	}

	@Override
	public List findByCEle(Object CEle) {
		return findByProperty(_CELE, CEle);
	}

	@Override
	public List findAll() {
		log.debug("finding all Corner instances");
		try {
			String queryString = "from Corner";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	@Override
	public Corner merge(Corner detachedInstance) {
		log.debug("merging Corner instance");
		try {
			Corner result = (Corner) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	@Override
	public void attachDirty(Corner instance) {
		log.debug("attaching dirty Corner instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@Override
	public void attachClean(Corner instance) {
		log.debug("attaching clean Corner instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ICornerDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ICornerDAO) ctx.getBean("CornerDAO");
	}

	@Override
	public void updateCorner(Corner corner) {
		this.getHibernateTemplate().update(corner);
	}

	@Override
	public List<Corner> findByFarmAndPaddock(Paddock paddock) {
		Query query = getSession()
				.createQuery(
						"from domain.Corner as corner where corner.id.paddockPId = ? and corner.id.paddockFarmFId = ?");
		query.setParameter(0, paddock.getId().getPId());
		query.setParameter(1, paddock.getId().getFarmFId());
		
		return query.list();
	}

}