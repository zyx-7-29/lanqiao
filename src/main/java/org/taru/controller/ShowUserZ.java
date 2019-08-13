package org.taru.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.taru.Entity.UserAM;
import org.taru.service.AuthorityManagementService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ShowUserZ {
    @RequestMapping("/admin/showuser")
    public String showUser(HttpServletRequest request){
            AuthorityManagementService authorityManagementService=new AuthorityManagementService();
            List<UserAM> users=authorityManagementService.QueryAll();
            System.out.println(users);
        request.setAttribute("users",users);
            return  "showuser";
    }
}
