package com.fidel.sms.service;

import java.util.List;

import com.fidel.sms.model.Users;

public interface UsersService {
	
	public boolean validateUser(String username, String password);
	
	public boolean checkUserStatus(String username, String password);
	
	public List<Users> getUserById(Users user);
	
	public int getUserId(String username);
	
	public boolean updateUserNamePassword(Users users);

}
