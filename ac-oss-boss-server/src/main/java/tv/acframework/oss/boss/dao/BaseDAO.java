package tv.acframework.oss.boss.dao;

import javax.annotation.Resource;

import tv.acframework.orm.hibernate.client.HibernateBaseDAO;

public class BaseDAO {
	
	@Resource
	protected  HibernateBaseDAO hibernateBaseDAO;
	
	public Integer save(Object object) {
		Integer i = (Integer)hibernateBaseDAO.save(object);
		hibernateBaseDAO.flush();
		return i;
	}
	
	public void update(Object object) {
		hibernateBaseDAO.update(object);
	}
	
	public void saveOrUpdate(Object object) {
		hibernateBaseDAO.saveOrUpdate(object);
	}
	
	public void delete(Object object) {
		hibernateBaseDAO.delete(object);
	}

}
