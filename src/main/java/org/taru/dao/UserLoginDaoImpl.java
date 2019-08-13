package org.taru.dao;

import org.taru.Entity.UserAM;
import org.taru.util.SqlUtil;
import org.taru.util.StringUtil;

import java.util.HashMap;
import java.util.List;

public class UserLoginDaoImpl {

	public UserAM LoginDaoImpl(String username, String password) {
		String sql = "select *  from user where user_name=? and  user_password=?";
		List<HashMap<String, Object>> list = SqlUtil.executeQuery(sql, username, password);
		System.out.println("dsfsfsdffsfs");
		UserAM user = null;
		if (list.size() > 0) {
			user = new UserAM();
			user.setUserId(StringUtil.valueOf(list.get(0).get("user_id")));
			user.setUserName(StringUtil.valueOf(list.get(0).get("user_name")));
			user.setUserPassword(StringUtil.valueOf(list.get(0).get("user_password")));
		}
		System.out.println("===============");
		System.out.println(user);
		System.out.println("===============");
		return user;
	}
}
