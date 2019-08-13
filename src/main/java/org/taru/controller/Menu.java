package org.taru.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.taru.Entity.PrivilegeAM;
import org.taru.Entity.RoleAM;
import org.taru.Entity.UserAM;
import org.taru.service.AuthorityManagementService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class Menu {
    @RequestMapping("/admin/menu")
    public String initPower(HttpServletRequest request){
        UserAM user = (UserAM) request.getSession().getAttribute("loginUserKey");
//        String user_id=request.getParameter("loginUserKey");//这个是 在jsp中获取 传入的值
        System.out.println("---用户信息----------------------------");
        System.out.println(user);
        System.out.println("-------------------------------");
        String user_id=user.getUserId();
        //System.out.println(user.getUserId());
       // System.out.println(user_id);
        List<PrivilegeAM> privilegeAMList=new ArrayList<>();
        AuthorityManagementService authorityManagementService=new AuthorityManagementService();
        List<RoleAM> rlist= authorityManagementService.GetUserAllRole(user_id);//获取 该用户所有的角色
        System.out.println("`````````该用户所具有的角色``````````````````````````````````````");
        System.out.println(rlist);
        System.out.println("```````````````````````````````````````````````");

        //初始化一级菜单
        //遍历每一个角色，并获取每个角色拥有的一级菜单 保存到权限表中
        for(RoleAM role: rlist){
            String roleId=role.getId();
            List<PrivilegeAM> priv=authorityManagementService.GetRoleAllPrivilegeService(roleId);
//            System.out.println(priv+"该角色所拥有的权限");
           for (PrivilegeAM  pri: priv){                     //遍历所拥有 的 所有权限
               if (pri.getPrivLevel().equals("1")){          //从拥有的 所有权限中   找出权限等级 为 1 的权限
                   if (!privilegeAMList.contains(pri)) {     // 如果 权限列表privilegeAMList中，没有 pri这个权限
//                       System.out.println(pri.getPrivName()+"权限等级为1 权限");
                       privilegeAMList.add(pri);             //便将这个权限 加到权限列表privilegeAMList中
//                       System.out.println(privilegeAMList.toString()+"此时 初始化一级菜单后 权限列表里边的权限");
                   }
               }
           }
        }

        //初始化二级菜单
        //同样遍历角色列表，拿出所有角色的二级子权限放入列表
        for (RoleAM role:rlist){
            String  role_id=role.getId();
            List<PrivilegeAM> priv=authorityManagementService.GetRoleAllPrivilegeService(role_id);
            for (PrivilegeAM pri:priv){
                if (pri.getPrivLevel() .equals("2")){
                    for(PrivilegeAM pri2:privilegeAMList){
                        if(pri.getPrivFatherid().equals(pri2.getPrivId())){ //看 所有权限等级是2 级别的权限，他们的父id 是否等于权限表中0 级别权限的id
                            if (!pri2.getPrivilegeAMS().contains(pri)) {    //判断 权限列表中 是否有权限等级为2 的权限，若无等级为1的权限
//                                System.out.println(pri2.getPrivName()+"权限等级为2 权限");
                                pri2.getPrivilegeAMS().add(pri);            //便将 等级为 2 的权限  加到 权限列表中
//                                System.out.println(privilegeAMList.toString()+"此时 初始化二级菜单后 权限列表里边的权限");
                            }
                        }
                    }
                }
            }
        }

        //初始化三级菜单
        //同样遍历角色列表，拿出所有角色的三级子权限放入列表
        for (RoleAM role :rlist){
            String  role_id=role.getId();
            List<PrivilegeAM> priv=authorityManagementService.GetRoleAllPrivilegeService(role_id);//获得所有权限
            for (PrivilegeAM pri: priv){                                        //遍历所有权限
                if (pri.getPrivLevel().equals("3")){                            //在所有权限中 得到所有权限等级为3的权限
                    for (PrivilegeAM pri2: privilegeAMList){                    //遍历此时的  权限列表
                        for (PrivilegeAM pri3 :pri2.getPrivilegeAMS()){         //获得 权限列表中 所有权限的  权限等级
                            if (pri.getPrivFatherid().equals(pri3.getPrivId())){//判断 等级为3 的权限的 父id，在权限列中 有没有和它父id相同的 权限  ，如果有 继续向下执行
                                if (!pri3.getPrivilegeAMS().contains(pri)) {    //若 权限列表中权限  没有 这些级别为3的权限
//                                    System.out.println(pri3.getPrivName()+"权限等级为3 权限");
                                    pri3.getPrivilegeAMS().add(pri);            //便将 这些等级为3 的权限加到权限列表中
//                                    System.out.println(pri3.getPrivilegeAMS()+"此时 初始化三级级菜单后 权限列表里边的权限");
                                }
                            }
                        }
                    }
                }
            }
        }

        //将所有的菜单权限列表保存到session中
        //request.setAttribute("privilegeAMList",privilegeAMList);
//        System.out.println(privilegeAMList+"----------------==============================-------------------------");//此时
        request.getSession().setAttribute("privilegeAMList",privilegeAMList);
        return "menu";
    }
}
