package org.taru.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.taru.Entity.UserAM;
import org.taru.controller.LoginController;
import org.taru.service.LoginService;
import org.taru.vo.JsonResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Api  ?????Applition Program Interface?
 *      ??????????????????????
 *      ?Ajax ????   ?? JSON ?????
 */

//@RestController   //?????? ??LoginApi???????? ???? @ResponseBody
@Controller
public class LoginApi {
    //??
    private  static final Logger logger= LoggerFactory.getLogger(LoginController.class);
    /**
     * ??
     * @param userName
     * @param userPasswod
     * @param session
     * @return
     */
    @RequestMapping(value = "/api/login")
    @ResponseBody  //Ajax
    //public Object login(String userName,String userPasswod){??????????? JsonResult
    public JsonResult login(String userName, String userPasswod, HttpSession session, HttpServletRequest request){
        logger.debug("loger:"+request.getRequestURI());//??
        JsonResult result=null;
        try {
            LoginService loginService=new LoginService();
            UserAM user = loginService.Login(userName,userPasswod);
            if (user==null){
                result =new JsonResult("404","?????????","");
                logger.debug("???[{}]?",request.getRequestURI());
            }else{
                result =new JsonResult("200","????","");
                session.setAttribute("longinUserKey",user); //??????
                logger.info("{}??????",userName);
            }
        }catch (Exception e){
            e.printStackTrace();
            result= new JsonResult("500","error","");
            logger.error("????????[{}]",e.getCause().getMessage());
        }
        return result;
    }

    /**
     * ????
     * @param session
     * @return
     */
    @RequestMapping(value = "/api/loginout'")
    @ResponseBody //Ajax
    public  JsonResult loginOut(HttpSession session){
        JsonResult result=null;
        try{
            session.invalidate(); //Session ??
            result =new JsonResult("200","????","");
        }catch (Exception e){
            e.printStackTrace();
            result=new JsonResult("500","error","");
        }
        return result;
    }
}
