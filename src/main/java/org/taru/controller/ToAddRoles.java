package org.taru.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.taru.Entity.PrivilegeAM;
import org.taru.Entity.RoleAM;
import org.taru.service.AuthorityManagementService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ToAddRoles {
    @RequestMapping("/admin/addprivilege")
    public String showRole(HttpServletRequest request){
        String role_id= request.getParameter("role_id");

        AuthorityManagementService authorityManagementService =new AuthorityManagementService();
        //根据id 获取到role对象
        RoleAM role=authorityManagementService.FindRoleService(role_id);
        //得到当前角色所有的权力
        List<PrivilegeAM> rolePrivilege=authorityManagementService.GetRoleAllPrivilegeService(role_id);
        //得到系统的所有权利
        List<PrivilegeAM> allPrivilege=authorityManagementService.GetAllPrivilegeService();

        request.setAttribute("role",role);
        request.setAttribute("rolePrivilege",rolePrivilege);
        request.setAttribute("allPrivilege",allPrivilege);

        return "addRolePrivilege";
    }
}
