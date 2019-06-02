package com.fidel.sms.dao.impl;

import java.util.List;

import com.fidel.sms.utils.PasswordEncription;
import com.fidel.sms.utils.SessionManager;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fidel.sms.dao.UsersDao;
import com.fidel.sms.model.Users;

@Repository
public class UsersDaoImpl implements UsersDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public UsersDaoImpl() { }
	
	public UsersDaoImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public boolean validateUser(String username, String password) {
		
		final String hql = "SELECT ua_id FROM user_account WHERE user_name = :user_name and password = :password";
		
		Query query = sessionFactory.openSession().createSQLQuery(hql)
				.setParameter("user_name", username)
				.setParameter("password", password);
		
		if(query.list().size() > 0){
			
			return true;
		}		
		return false;
	}

	@Override
	public boolean checkUserStatus(String username, String password) {

		String hql = "SELECT COUNT(b) FROM Users b WHERE user_name = '" + username + "' and password = '" + password + "' and ua_status = 'Inactive'";
		
		Query query = sessionFactory.openSession().createQuery(hql);
		
		int count = ((Long)query.uniqueResult()).intValue();
		
		if(count > 0){
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int getUserId(String username) {
		
		String hql = "SELECT b.user_id FROM Users b WHERE b.user_name = '" + username + "'";
		
		Query query = sessionFactory.openSession().createQuery(hql);
		
		///*** added just for initial usage only ***///
		if(query.list().size() == 0){ return 0; }
		
		return (Integer)query.list().get(0);
	}

	@Override
	public boolean updateUserNamePassword(Users users) {
		
		String encript_password = "";
		String old_encript_password = "";
		
		users.setUa_id(SessionManager.getUserIdOnSession());
		
		///*** getting previous password ***///
		List<Users> userList = getUserById(users);
		
		String perviousPassword = "";
		
		for(Object obj : userList){
			
			Object[] field = (Object[])obj;
			
			perviousPassword = field[5].toString();
		}
		///*** ------------------------ ***///
		
		try {
			
			encript_password = PasswordEncription.encrypt(users.getPassword());
			
			old_encript_password = PasswordEncription.encrypt(users.getOldPassword());
			
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
		if(!perviousPassword.equals(old_encript_password)){
			
			return false;
		}
		
		final String hql = "UPDATE Users SET user_name = :user_name, password = :password WHERE user_id = :user_id";
		
		Query query = sessionFactory.openSession().createQuery(hql)
				.setParameter("user_name", users.getUser_name())
				.setParameter("password", encript_password)
				.setParameter("user_id", users.getUa_id());
		int rslt = query.executeUpdate();
		
		if(rslt > 0){
			
			return true;
		}
		
		return false;
	}
	
	@Override
	public List<Users> getUserById(Users user) {
		
		String sql = "SELECT a.user_id, a.fname, a.mname, a.gname, a.user_name, a.password, a.ua_status, a.ur_id, b.ur_name "
				+ "FROM Users a, UsersRole b "
				+ "WHERE a.ur_id = b.ur_id and a.user_id = :user_id";
		
		List<Users> userById = (List<Users>)sessionFactory.openSession().createQuery(sql).setParameter("user_id", user.getUa_id()).list();
		
		return userById;		
	}


}
