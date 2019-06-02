package com.fidel.sms.dao.impl;

import java.util.List;

import com.fidel.sms.dao.SystemURLDao;
import com.fidel.sms.model.SystemURL;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SystemURLDaoImpl implements SystemURLDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public SystemURLDaoImpl() { }
	
//	public SystemURLDaoImpl(SessionFactory sessionFactory){
//		this.sessionFactory = sessionFactory;
//	}

	@Override
	public List<SystemURL> getAllURL() {
		System.out.println("in dao");
		final String hql = "SELECT a.su_id, a.description, a.url, a.sm_id FROM u_system_url a";
		
		Query query = sessionFactory.openSession().createSQLQuery(hql);
		
		return (List<SystemURL>)query.list();
	}

	@Override
	public List<SystemURL> getRelatedModule(int m_id, int ur_id) {
		
		final String hql = "SELECT a.su_id, a.description, a.url, a.sm_id, c.urmr_id "
				+ "FROM admin_system_url a, admin_system_module b, admin_users_role_module_relation c, admin_users_authentication d "
				+ "WHERE a.sm_id = b.sm_id and a.sm_id = c.m_id and a.su_id = d.su_id and c.urmr_id = d.urmr_id and d.ua_status = 'Active' and a.sm_id = :sm_id and c.ur_id = :ur_id";
		
		Query query = sessionFactory.openSession().createSQLQuery(hql)
				.setParameter("sm_id", m_id)
				.setParameter("ur_id", ur_id);
		
		return (List<SystemURL>)query.list();
	}

	@Override
	public List<SystemURL> getUnrelatedModule(int m_id, int ur_id) {
		
		final String hql = "SELECT a.su_id, a.description, a.url, a.sm_id, c.urmr_id "
				+ "FROM admin_system_url a, admin_system_module b, admin_users_role_module_relation c "
				+ "WHERE a.sm_id = b.sm_id and a.sm_id = c.m_id and a.su_id not in (select d.su_id from admin_users_authentication d where d.ua_status = 'Active' and c.urmr_id = d.urmr_id) and a.sm_id = :sm_id and c.ur_id = :ur_id";
		
		Query query = sessionFactory.openSession().createSQLQuery(hql)
				.setParameter("sm_id", m_id)
				.setParameter("ur_id", ur_id);
		
		return (List<SystemURL>)query.list();
	}
	
	@Override
	public List<SystemURL> getAuthenticatedURL(String user_name) {
		
		final String hql = "SELECT d.su_id, d.description, d.url, d.sm_id, c.urmr_id "
						+ "FROM admin_users_authentication a, admin_users b, admin_users_role_module_relation c, admin_system_url d, admin_users_role e "
						+ "WHERE b.user_name = :user_name and e.ur_id = b.ur_id and c.ur_id = e.ur_id and c.urmr_id = a.urmr_id and d.su_id = a.su_id and a.ua_status = 'Active'";
		
		Query query = sessionFactory.openSession().createSQLQuery(hql)
				.setParameter("user_name", user_name);
		
		return (List<SystemURL>)query.list();
	}

//	public SessionFactory getSessionFactory() {
//		return sessionFactory;
//	}
//
//	public void setSessionFactory(SessionFactory sessionFactory) {
//		this.sessionFactory = sessionFactory;
//	}
		
}
