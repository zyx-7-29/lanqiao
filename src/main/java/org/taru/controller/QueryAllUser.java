package org.taru.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.taru.Entity.User;
import org.taru.service.SearchAllUserService;

import java.util.List;

@Controller
public class QueryAllUser {

    @RequestMapping("/admin/queryall")
    public  String Query(Model model){
        SearchAllUserService searchAllUserService=new SearchAllUserService();
        List<User> list=searchAllUserService.SearchUserDetail();
        System.out.println(list);
        model.addAttribute("users",list);
        return "main";

    }
}
