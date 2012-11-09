package dao.impl;

import java.util.Date;
import java.util.List;
import java.util.Set;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.IGrazingDAO;
import domain.Corner;
import domain.Grazing;
import domain.Paddock;

/**
 * A data access object (DAO) providing persistence and search support for
 * Grazing entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see domain.Grazing
 * @author MyEclipse Persistence Tools
 */

public class GrazingDAO extends HibernateDaoSupport implements IGrazingDAO {
	private static final Logger log = LoggerFactory.getLogger(GrazingDAO.class);
	// property constants
	public static final String _GNOTE = "GNote";

	protected void initDao() {
		// do nothing
	}

	public void save(Grazing transientInstance) {
		log.debug("saving Grazing instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Grazing persistentInstance) {
		log.debug("deleting Grazing instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Grazing findById(java.lang.Integer id) {
		log.debug("getting Grazing instance with id: " + id);
		try {
			Grazing instance = (Grazing) getHibernateTemplate().get(
					"domain.Grazing", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Grazing instance) {
		log.debug("finding Grazing instance by example");
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

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Grazing instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Grazing as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByGNote(Object GNote) {
		return findByProperty(_GNOTE, GNote);
	}

	public List findAll() {
		log.debug("finding all Grazing instances");
		try {
			String queryString = "from Grazing";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Grazing merge(Grazing detachedInstance) {
		log.debug("merging Grazing instance");
		try {
			Grazing result = (Grazing) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Grazing instance) {
		log.debug("attaching dirty Grazing instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Grazing instance) {
		log.debug("attaching clean Grazing instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static GrazingDAO getFromApplicationContext(ApplicationContext ctx) {
		return (GrazingDAO) ctx.getBean("GrazingDAO");
	}

	@Override
	public void updateGrazing(Grazing grazing) {
		this.getHibernateTemplate().update(grazing);
	}

	@Override
	public List<Grazing> findByFarmAndPaddock(Paddock paddock) {
		String queryString = "from domain.Grazing as grazing where grazing.paddockPId = ? and grazing.paddockFarmFId = ?";
		Query query = getSession().createQuery(queryString);
		query.setParameter(0, paddock.getId().getPId());
		query.setParameter(1, paddock.getId().getFarmFId());
		return query.list();
	}

}