package org.taru.service;

import org.taru.Entity.User;
import org.taru.dao.SearchAllUserDaoImpl;

import java.util.List;

public class SearchAllUserService {
	public List<User> SearchUserDetail() {
		SearchAllUserDaoImpl userDetailDaoImpl=new SearchAllUserDaoImpl();
		List<User> list=userDetailDaoImpl.SearchUserDetail();
		return list;
	}
}
