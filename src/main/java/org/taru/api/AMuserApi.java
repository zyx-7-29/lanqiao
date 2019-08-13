package org.taru.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.taru.Entity.PrivilegeAM;
import org.taru.Entity.RoleAM;
import org.taru.Entity.UserAM;
import org.taru.service.AuthorityManagementService;
import org.taru.vo.JsonResult;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class AMuserApi {
    /**
     * 登陆
     * @param name
     * @param password
     * @param session
     * @return
     */
    @RequestMapping("/api/am/login")
    public JsonResult LoginApi(String name, String password, HttpSession session){
        JsonResult result=null;
        try{
            AuthorityManagementService authorityManagementService=new AuthorityManagementService();
            UserAM user=authorityManagementService.login(name,password);
            if (user == null){
                result =new JsonResult("404","用户名或者密码错误","");
            }else{
                result =new JsonResult("200","登陆成功","user");
                session.setAttribute("UserKey",user);
            }
        }catch (Exception e){
            e.printStackTrace();
            result= new JsonResult("500","登陆异常","");
        }
        return  result;
    }

    /**
     * 查询普通管理员 功能
     * @param name
     * @return
     */
    public JsonResult QueryPrivilegeApi(String name){
        JsonResult result= null;
        try{
            AuthorityManagementService authorityManagementService=new AuthorityManagementService();
            List list=authorityManagementService.QueryService(name);
            if(list.size()>0){
                result =new JsonResult("200","查询功能成功",list);
            }else{
                result =new JsonResult("404","查询功能失败",list);
            }
        }catch(Exception e){
            e.printStackTrace();
            result =new JsonResult("500","查询功能异常","");
        }
        return result;
    }

    /**
     * 查询所有用户
     * @return
     */
    public JsonResult QueryAllApi(){
        JsonResult result=null;
        try{
            AuthorityManagementService authorityManagementService=new AuthorityManagementService();
            List list=authorityManagementService.QueryAll();
            if (list.size()>0){
                result =new JsonResult("200","查询所有用户成功",list);
            }else{
                result =new JsonResult("404","查询所有用户失败",list);
            }
        }catch (Exception e){
            e.printStackTrace();
            result =new JsonResult("500","查询异常","");
        }
        return  result;
    }

    /**
     * 查询单个用户
     * @param id
     * @return
     */
    public JsonResult QueryOneApi(String id){
        JsonResult result=null;
        try{
            AuthorityManagementService authorityManagementService=new AuthorityManagementService();
            UserAM user=authorityManagementService.QueryOne(id);
            result = new JsonResult("200","查询单个用户成功",user);
        }catch (Exception e){
            e.printStackTrace();
            result =new JsonResult("404","查询单个用户失败","");
        }
        return  result;
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    public JsonResult DeleteApi(String id){
        JsonResult result=null;
        try{
            AuthorityManagementService authorityManagementService=new AuthorityManagementService();
            authorityManagementService.DeleteOne(id);
            result =new JsonResult("200","删除用户成功","");
        }catch (Exception e){
            e.printStackTrace();
            result =new JsonResult("404","删除用户成功","");
        }
        return  result;
    }

    /**
     * 修改用户
     * @param user
     * @return
     */
    public JsonResult AlterApi(UserAM user){
        JsonResult result=null;
        try{
            AuthorityManagementService authorityManagementService=new AuthorityManagementService();
            authorityManagementService.AlterService(user);
            result =new JsonResult("200","修改用户成功","");
        }catch (Exception e){
            e.printStackTrace();
            result =new JsonResult("404","修改用户失败","");
        }
        return  result;
    }

    /**
     * 添加用户

     * @return
     */
    @RequestMapping("/api/am/adduser")
    public JsonResult AddApi(UserAM user){
        JsonResult result=null;
        try{
            AuthorityManagementService authorityManagementService=new AuthorityManagementService();
            authorityManagementService.AddService(user);
            result=new JsonResult("200","添加用户成功","");
        }catch (Exception e){
            e.printStackTrace();
            result =new JsonResult("404","添加用户失败","");
        }
        return  result;
    }

//-------------------------------------------------------------------------------------------------------------------------

    /**
     * 给用户赋予角色  但却可以赋予任意一个角色
     * @param user_id
     * @return
     */
    public JsonResult GetUserAllRoles(String user_id){
        JsonResult result=null;
        AuthorityManagementService authorityManagementService=new AuthorityManagementService();
        RoleAM roleAM=authorityManagementService.FindRoleService(user_id);
        return result;
    }

    /**
     * 修改用户角色/
     * @param user_id
     * @param roles
     * @return
     */
    public JsonResult UsreAddPrivilege(UserAM user_id, List<RoleAM> roles){
        JsonResult result=null;
        try{
            AuthorityManagementService authorityManagementService=new AuthorityManagementService();
            authorityManagementService.AlterUserRoleService(user_id,roles);
            result =new JsonResult("200","修改用户角色成功","");
        }catch (Exception e){
            e.printStackTrace();
            result =new JsonResult("404","修改用户角色失败","");
        }
        return result;
    }
//-----------------------------------------------------------------------------------------------------------------------
    /**
     * 为角色添加权限
     * @param roleAM
     * @param privilegeAMS
     * @return
     */
    public JsonResult AddUserRole(RoleAM roleAM,List<PrivilegeAM> privilegeAMS){
        JsonResult result=null;
        try{
            AuthorityManagementService authorityManagementService=new AuthorityManagementService();
            authorityManagementService.AlterRolePrivilegeService(roleAM,privilegeAMS);
            result =new JsonResult("200","角色增加权限成功","");
        }catch (Exception e){
            e.printStackTrace();
            result =new JsonResult("404","角色增加权限失败","");
        }
        return result;
    }


    /**
     * 为角色添加权限  可添加任意一个权限
     * @param roleAM
     * @param privilegeAM
     * @return
     */
    public JsonResult AddUserRole(RoleAM roleAM,PrivilegeAM privilegeAM){
        JsonResult result=null;
        try{
            AuthorityManagementService authorityManagementService=new AuthorityManagementService();
            authorityManagementService.AlterRolePrivilegeService(roleAM,privilegeAM);
            result=new JsonResult("200","角色添加权限成功","");
        }catch(Exception e){
            e.printStackTrace();
            result=new JsonResult("404","角色添加权限失败","");
        }
        return result;
    }

}
