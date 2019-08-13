package org.taru.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Entrance {
    @RequestMapping("/admin/index")
    public String entrance(){
        return  "index";
    }
}
