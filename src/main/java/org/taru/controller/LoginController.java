package org.taru.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.taru.Entity.UserAM;
import org.taru.service.LoginService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;



//@RequestMapping("/admin")  写了这个注解  在下面的每个方法的上边注解中 @RequestMapping("/admin/login") 就不用再写/admin 了
//@SessionAttributes("loginUserKey") //和下面的model.SetAttribute() 配套使用
@Controller
public class LoginController {

    //日志
    private  static final Logger logger= LoggerFactory.getLogger(LoginController.class);

    /**
     * 通过请求转发跳转到登陆页面 或者 login.jsp在外面再写一份
     * @return
     */
    @RequestMapping("/admin/tologin")//注意：login.jsp 文件是放在WEB-INF 目录下，是受到保护的，你不可以 直接在地址栏输入地址 例如：http://localhost/login.jsp去访问。 而是通过这个方法  间接去访问WEB-INF目录下的 login.jsp 文件
    public String tologin(){
        return "login";
    }


    /**
     * 登陆
     * URL 是 /admin/login
     * 前提是 没有 @ResponseBody

     * @param model
     * @param session
     * @return  String类型 String表示的是 逻辑视图的名字 。 return 请求转发的作用
     */
    @RequestMapping(value = "/admin/login" ,method = RequestMethod.POST)
    public String  login(@RequestParam("username") String uname,
                         @RequestParam("password") String upassword,
                         Model model,
                         HttpSession session,
                         HttpServletRequest request){
        LoginService loginService=new LoginService();
        UserAM user =loginService.Login(uname,upassword);
        System.out.println(user);
        if (user == null){
            //用户名或者密码错误  跳转到登陆页面
            //model.addAttribute("logixnError","用户名或者密码错误"); //相当于 request.setAttribute("","")
            request.setAttribute("logixnError","用户名或者密码错误");
            return "login"; //请求转发 跳转到登陆页面
        }else{
            //登陆成功  跳转到一个页面 或者 跳转到一个查询的的Controller
            request.getSession().setAttribute("loginUserKey",user);
            //model.addAttribute("loginUserKey",user); // 把model中数据  放置到Session中 一份

            //return "index"; // 跳转到另一个JSP页面
            return "redirect:/admin/menu";//跳转到一个查询的的Controller
        }
    }

    /**
     * 退出登陆
     * @param session
     * @return
     */
    @RequestMapping("/admin/loginout")
    public String loginOut(HttpSession session){
        session.invalidate();
        //跳转到 登陆页面 重定向
        return "login";
    }

}
