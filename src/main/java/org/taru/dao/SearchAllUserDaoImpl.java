package org.taru.dao;

import org.taru.Entity.User;
import org.taru.util.ByteUtil;
import org.taru.util.SqlUtil;
import org.taru.util.StringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class  SearchAllUserDaoImpl {
	public List<User> SearchUserDetail() {
		String sql="select * from user";
		List<HashMap<String, Object>> list= SqlUtil.executeQuery(sql);
		List<User> list2=new ArrayList<User>();
		User user=null;
		if(list.size()>0) {
			for(int i=0;i<list.size();i++) {
				user=new User();
				user.setUserId(StringUtil.valueOf(list.get(i).get("USER_ID")));
				user.setUserUserName(StringUtil.valueOf(list.get(i).get("USER_USER_NAME")));
				user.setUserPassword(StringUtil.valueOf(list.get(i).get("USER_PASSWORD")));
				user.setUserTelphone(StringUtil.valueOf(list.get(i).get("USER_TELPHONE")));
				user.setUserAddress(StringUtil.valueOf(list.get(i).get("USER_ADDRESS")));
				user.setUserShopName(StringUtil.valueOf(list.get(i).get("USER_SHOP_NAME")));
				user.setUserComment(StringUtil.valueOf(list.get(i).get("USER_COMMENT")));
				user.setUserStatus(ByteUtil.toByte(list.get(i).get("USER_STATUS")));
				list2.add(user);
			}
		}
		System.out.println(list2);
		return list2;
	}
}
