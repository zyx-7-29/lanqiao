package org.taru.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.taru.Entity.PrivilegeAM;
import org.taru.service.AuthorityManagementService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ShowAllPrivilege {
    @RequestMapping("/admin/showprivilege")
    public  String  showPrivilege(HttpServletRequest request){
        AuthorityManagementService authorityManagementService=new AuthorityManagementService();
        List<PrivilegeAM> list=authorityManagementService.GetAllPrivilegeService();
        request.setAttribute("list",list);
        return "showallprivilege";
    }
}
