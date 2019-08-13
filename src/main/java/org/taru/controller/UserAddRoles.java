package org.taru.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.taru.Entity.RoleAM;
import org.taru.Entity.UserAM;
import org.taru.service.AuthorityManagementService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserAddRoles {

    @RequestMapping("/admin/addrole")
    public String addUserRoles(HttpServletRequest request, Model model){
        String [] ids=request.getParameterValues("role_id");
        AuthorityManagementService authorityManagementService=new AuthorityManagementService();
        try{
            String user_id =request.getParameter("user_id");
            UserAM user=authorityManagementService.QueryOne(user_id);
            List<RoleAM> list =new ArrayList<>();
            for (String id: ids
                 ) {
                RoleAM role=authorityManagementService.FindRoleService(id);
                list.add(role);
            }
            authorityManagementService.AlterUserRoleService(user,list);
            request.setAttribute("message","添加角色成功");
        }catch (Exception e){
            e.printStackTrace();
            request.setAttribute("message","添加角色成功");
        }
        return "test";
    }
}
