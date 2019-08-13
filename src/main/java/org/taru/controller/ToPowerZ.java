package org.taru.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.taru.Entity.RoleAM;
import org.taru.Entity.UserAM;
import org.taru.service.AuthorityManagementService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ToPowerZ {
    @RequestMapping("/admin/topower")
    public String topower(HttpServletRequest request){
        String user_id = request.getParameter("user_id");
        AuthorityManagementService authorityManagementService=new AuthorityManagementService();
        //获得用户所有的角色
        List<RoleAM> userRoles=authorityManagementService.GetUserAllRole(user_id);
        System.out.println(userRoles.toArray());
        //得到全部的角色
        List<RoleAM> allRoles=authorityManagementService.GetAllRoleService();
        //获得该用户信息
        UserAM user=authorityManagementService.QueryOne(user_id);
        request.setAttribute("user", user);
        request.setAttribute("userRoles", userRoles);
        request.setAttribute("allRoles", allRoles);
        return "topowerZ";
    }
}
