package dao.impl;

import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.IStockCountDAO;
import domain.StockCount;
import domain.StockCountId;

/**
 	* A data access object (DAO) providing persistence and search support for StockCount entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see domain.StockCount
  * @author MyEclipse Persistence Tools 
 */

public class StockCountDAO extends HibernateDaoSupport implements IStockCountDAO {
	     private static final Logger log = LoggerFactory.getLogger(StockCountDAO.class);
	

	protected void initDao() {
		//do nothing
	}
    
    public void save(StockCount transientInstance) {
        log.debug("saving StockCount instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(StockCount persistentInstance) {
        log.debug("deleting StockCount instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public StockCount findById( domain.StockCountId id) {
        log.debug("getting StockCount instance with id: " + id);
        try {
            StockCount instance = (StockCount) getHibernateTemplate()
                    .get("domain.StockCount", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(StockCount instance) {
        log.debug("finding StockCount instance by example");
        try {
            List results = getHibernateTemplate().findByExample(instance);
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding StockCount instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from StockCount as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}


	public List findAll() {
		log.debug("finding all StockCount instances");
		try {
			String queryString = "from StockCount";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public StockCount merge(StockCount detachedInstance) {
        log.debug("merging StockCount instance");
        try {
            StockCount result = (StockCount) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(StockCount instance) {
        log.debug("attaching dirty StockCount instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(StockCount instance) {
        log.debug("attaching clean StockCount instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static StockCountDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (StockCountDAO) ctx.getBean("StockCountDAO");
	}

	@Override
	public List findByScCount(Object scCount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateStockCount(StockCount stockCount) {
		this.getHibernateTemplate().update(stockCount);		
	}
}