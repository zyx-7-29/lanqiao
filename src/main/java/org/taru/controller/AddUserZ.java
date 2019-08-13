package org.taru.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.taru.Entity.UserAM;
import org.taru.service.AuthorityManagementService;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;
@SessionAttributes("AddUser")
@Controller
public class AddUserZ {

    @RequestMapping("/admin/touser")
    public String adduser(){
        return  "PageZ";
    }

    @RequestMapping("/admin/adduser")
    public String AddUser(@RequestParam("username") String username,
                          @RequestParam("password") String password,
                          HttpServletRequest request,
                          Model model){
        UserAM user=new UserAM();
        String data=UUID.randomUUID().toString().replace("-", "").toUpperCase();
        user.setUserId(data);
        user.setUserName(username);
        user.setUserPassword(password);
        System.out.println(user);
        try{
            AuthorityManagementService AuthorityManagementService=new AuthorityManagementService();
            AuthorityManagementService.AddService(user);
            request.setAttribute("AddUser","添加用户成功");
            //return "PageZ";
            return "PageZ";
        }catch (Exception e){
            e.printStackTrace();
            request.setAttribute("AddUser","添加用户失败");
            return "PageZ";
        }
    }
}
