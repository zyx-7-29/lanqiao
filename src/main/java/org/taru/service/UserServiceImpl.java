package org.taru.service;

import org.springframework.stereotype.Service;
import org.taru.Entity.User;
import org.taru.Entity.UserAM;
import org.taru.dao.UserLoginDaoImpl;

@Service
public class UserServiceImpl {

    public UserAM  login(String username,String password){
        UserLoginDaoImpl doImpl=new UserLoginDaoImpl();
        UserAM user=doImpl.LoginDaoImpl(username,password);
        return  user;
    }

    public void print(){

    }

    public User query(){
        return null;
    }
}
