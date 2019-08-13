package org.taru.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.taru.Entity.PrivilegeAM;
import org.taru.Entity.RoleAM;
import org.taru.service.AuthorityManagementService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AddroleServlete {
    @RequestMapping("/admin/addquan")
    public  String  toroleprivilege(HttpServletRequest request){
        System.out.println("-----------------------------");
        String [] ids=request.getParameterValues("privilege_id");
        System.out.println("=============================");
        System.out.println(ids);
        String role_id=request.getParameter("role_id");
        try{
            AuthorityManagementService authorityManagementService=new AuthorityManagementService();
            RoleAM role=authorityManagementService.FindRoleService(role_id);

            List<PrivilegeAM> privileges=new ArrayList<>();
            for(String id : ids){
                System.out.println(id);
                PrivilegeAM privilege=authorityManagementService.FindPrivilegeService(id);
                privileges.add(privilege);
            }
            authorityManagementService.AlterRolePrivilegeService(role,privileges);
            request.setAttribute("message","为角色添加权利成功");
        }catch (Exception e){
            e.printStackTrace();
            request.setAttribute("message","为角色添加权利失败");
        }
        return  "test";
    }
}
