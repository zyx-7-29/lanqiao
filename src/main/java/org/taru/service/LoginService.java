package org.taru.service;

import org.taru.Entity.UserAM;
import org.taru.dao.UserLoginDaoImpl;

public class LoginService {
	public UserAM Login(String username, String password ) {
		UserLoginDaoImpl userLoginDaoImpl=new UserLoginDaoImpl();
		UserAM user=userLoginDaoImpl.LoginDaoImpl(username, password);
		return user;
	}
}
