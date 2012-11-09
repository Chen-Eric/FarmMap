package dao.impl;

import java.util.Date;
import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.ITodoDAO;
import domain.Paddock;
import domain.Todo;

/**
 * A data access object (DAO) providing persistence and search support for Todo
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see domain.Todo
 * @author MyEclipse Persistence Tools
 */

public class TodoDAO extends HibernateDaoSupport implements ITodoDAO {
	private static final Logger log = LoggerFactory.getLogger(TodoDAO.class);
	// property constants
	public static final String _TDESCRIPTION = "TDescription";

	protected void initDao() {
		// do nothing
	}

	public void save(Todo transientInstance) {
		log.debug("saving Todo instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Todo persistentInstance) {
		log.debug("deleting Todo instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Todo findById(java.lang.Short id) {
		log.debug("getting Todo instance with id: " + id);
		try {
			Todo instance = (Todo) getHibernateTemplate()
					.get("domain.Todo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Todo instance) {
		log.debug("finding Todo instance by example");
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
		log.debug("finding Todo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Todo as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByTDescription(Object TDescription) {
		return findByProperty(_TDESCRIPTION, TDescription);
	}

	public List findAll() {
		log.debug("finding all Todo instances");
		try {
			String queryString = "from Todo";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Todo merge(Todo detachedInstance) {
		log.debug("merging Todo instance");
		try {
			Todo result = (Todo) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Todo instance) {
		log.debug("attaching dirty Todo instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Todo instance) {
		log.debug("attaching clean Todo instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TodoDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TodoDAO) ctx.getBean("TodoDAO");
	}

	@Override
	public void updateTodo(Todo todo) {
		this.getHibernateTemplate().update(todo);		
	}

	@Override
	public List<Todo> findByFarmAndPaddock(Paddock paddock) {
		String qString = "from domain.Todo as todo where todo.paddockPId = ? and todo.paddockFarmFId = ?";
		Query query = getSession().createQuery(qString);
		query.setParameter(0, paddock.getId().getPId());
		query.setParameter(1, paddock.getId().getFarmFId());
		return query.list();
	}
}