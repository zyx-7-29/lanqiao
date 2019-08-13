package org.taru.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.taru.Entity.RoleAM;
import org.taru.service.AuthorityManagementService;

import javax.servlet.http.HttpServletRequest;


@Controller
public class AddRoles {
    @RequestMapping("")
    public String addroles(HttpServletRequest request){
        String name =request.getParameter("name");
       // String description=request.getParameter("description");

        try {
            RoleAM roleAM=new RoleAM();
           // roleAM.setId();
            roleAM.setName(name);
           // roleAM.setDescription(description);

            AuthorityManagementService authorityManagementService=new AuthorityManagementService();
            authorityManagementService.AddRole(roleAM);
            request.setAttribute("message","添加角色成功");
        }catch (Exception e){
            e.printStackTrace();
            request.setAttribute("message","添加角色失败");
        }
        return "test";
    }
}
