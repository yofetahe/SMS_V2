package com.fidel.sms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fidel.sms.dao.UsersDao;
import com.fidel.sms.model.Users;
import com.fidel.sms.service.UsersService;
import com.fidel.sms.utils.PasswordEncription;

@Service
public class UsersServiceImpl implements UsersService {
	
	@Autowired
	UsersDao usersDao;

	@Override
	public boolean validateUser(String username, String password) {
		
		String enc_password = "";
		
		try {
			enc_password = PasswordEncription.encrypt(password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return usersDao.validateUser(username, enc_password);
	}

	@Override
	public boolean checkUserStatus(String username, String password) {
		
		String dec_password = "";
		
		try {
			dec_password = PasswordEncription.encrypt(password);
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
		return usersDao.checkUserStatus(username, dec_password);
	}

	@Override
	public int getUserId(String username) {
		
		return usersDao.getUserId(username);
	}

	@Override
	public boolean updateUserNamePassword(Users users) {
		
		return usersDao.updateUserNamePassword(users);
	}

	@Override
	public List<Users> getUserById(Users user) {
		
		return usersDao.getUserById(user);
	}

}
