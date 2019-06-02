package com.fidel.sms.dao;

import java.util.List;

import com.fidel.sms.model.Users;

public interface UsersDao {
	
	public boolean validateUser(String username, String password);
	
	public boolean checkUserStatus(String username, String password);
	
	public List<Users> getUserById(Users user);
	
	public int getUserId(String username);
	
	public boolean updateUserNamePassword(Users users);

}
