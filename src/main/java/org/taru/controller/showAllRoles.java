package org.taru.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.taru.Entity.RoleAM;
import org.taru.service.AuthorityManagementService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class showAllRoles {
    @RequestMapping("/admin/showallroles")
    public String showRoles(HttpServletRequest request){
        AuthorityManagementService authorityManagementService=new AuthorityManagementService();
        List<RoleAM> list=authorityManagementService.GetAllRoleService();
        System.out.println(list);
        request.setAttribute("list",list);
        return "showRoles";
    }
}
