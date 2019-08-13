package org.taru.dao;

import org.taru.Entity.PrivilegeAM;
import org.taru.Entity.RoleAM;
import org.taru.Entity.UserAM;
import org.taru.util.SqlUtil;
import org.taru.util.StringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AuthorityManagementDao {
    /**
     * 登陆
     * @param name
     * @param password
     * @return
     */
    public UserAM Login(String name, String password){
        String sql="select * from where user_name=? ,user_password=?";
        ArrayList<HashMap<String, Object>> list = SqlUtil.executeQuery(sql,name,password);
        UserAM user=null;
        if(list.size()>0){
            user =new UserAM();
           // user.setUserId(StringUtil.valueOf(list.get(0).get("")));
            user.setUserName(StringUtil.valueOf(list.get(0).get("user_name")));
            user.setUserPassword(StringUtil.valueOf(list.get(0).get("user_password")));
        }
        return user;
    }

    /**
     * 得到普通管理员 的功能菜单
     * @param name
     * @return
     */
    public List<PrivilegeAM> querySunPrivs(String name) {
        String sql ="select e.priv_id,priv_name,priv_level,priv_father_id,priv_url,priv_status from user a left join user_role b on a.user_id=b.user_id left join role c on b.role_id= c.role_id left join role_priv d on c.role_id = d.role_id left join privs e on d.priv_id=e.priv_id where user_name=?";
        ArrayList<HashMap<String, Object>> list= SqlUtil.executeQuery(sql,name);
        List<PrivilegeAM> list2=new ArrayList();
        if(list.size()>0) {
            for(Map<String,Object> map: list) {
                PrivilegeAM priv =new PrivilegeAM();
                priv.setPrivId(map.get("priv_id")==null?null:map.get("priv_id").toString());
                priv.setPrivName(map.get("priv_name")==null?null:map.get("priv_name").toString());
                priv.setPrivLevel(map.get("priv_level")==null?null:map.get("priv_level").toString());
                priv.setPrivFatherid(map.get("priv_father_id")==null?null:map.get("priv_father_id").toString());
                priv.setPrivUrl(map.get("priv_url")==null?null:map.get("priv_url").toString());
                priv.setPrivStaus(map.get("priv_status")==null?null:map.get("priv_status").toString());
                list2.add(priv);
            }
        }
        return list2;
    }
//------------------------------------------------------------------------------------------------------------------------
    /**
     * 查看所有用户
     * @return
     */
    public List<UserAM> QueryALL(){
        String sql="select * from user";
        List<HashMap<String, Object>> list = SqlUtil.executeQuery(sql);
        List<UserAM> list2= new ArrayList<UserAM>();
        if(list.size()>0){
            UserAM user=null;
            for (int i=0;i<list.size();i++){
                user=new UserAM();
                user.setUserId(StringUtil.valueOf(list.get(i).get("user_id")));
                user.setUserName(StringUtil.valueOf(list.get(i).get("user_name")));
                user.setUserPassword(StringUtil.valueOf(list.get(i).get("user_password")));
                list2.add(user);
            }
        }
        System.out.println(list2);
        return list2;
    }

    /**
     * 根据id 查询指定用户
     * @param userId
     * @return
     */
    public UserAM QueryOne(String userId){
        String sql="select * from user where user_id=?";
        ArrayList<HashMap<String, Object>> list =SqlUtil.executeQuery(sql,userId);
        UserAM user=null;
        if (list.size()>0){
            user= new UserAM();
            user.setUserId(StringUtil.valueOf(list.get(0).get("user_id")));
            user.setUserName(StringUtil.valueOf(list.get(0).get("user_name")));
            user.setUserPassword(StringUtil.valueOf(list.get(0).get("user_password")));
        }
        return user;
    }

    /**
     * 根据id 删除指定用户
     * @param userId
     */
    public void Delete (String userId){
        String sql="delete from user where user_id=?";
        SqlUtil.executeQuery(sql,userId);
    }

    /**
     * 添加用户
     */
    public void  Add(UserAM user){
        String sql="insert into user(user_id,user_user_name,user_password) values(?,?,?)";
        String id=user.getUserId();
        String name=user.getUserName();

        String password=user.getUserPassword();
        SqlUtil.executeUpdate(sql,id,name,password);
    }

    /**
     * 修改用户
     * @param user
     */
    public void Altere(UserAM user){
        String sql="update user set user_name=?,user_password=? where user_id=?";
        String name=StringUtil.valueOf(user.getUserName());
        String password=StringUtil.valueOf(user.getUserPassword());
        String id=StringUtil.valueOf(user.getUserId());
        SqlUtil.executeUpdate(sql,name,password,id);
    }
//--------------------------------------------------------------------------------------------------------

    /**
     * 添加权限
     * @param privilegeAM
     */
    public void AddPrivilege(PrivilegeAM privilegeAM){
            String sql="insert into privs (priv_id,priv_name,priv_level,priv_father_id,priv_url,priv_status) values(?,?,?,?,?,?)";
            String pid=privilegeAM.getPrivId();
            String pname=privilegeAM.getPrivName();
            String plevel=privilegeAM.getPrivLevel();
            String pfatherid=privilegeAM.getPrivFatherid();
            String purl=privilegeAM.getPrivUrl();
            String pstatus=privilegeAM.getPrivStaus();
            SqlUtil.executeUpdate(sql,pid,pname,plevel,pfatherid,purl,pstatus);
    }

    /**
     * 查找权限
     * @param id
     * @return
     */
    public PrivilegeAM FindPrivilege(String id){
        String sql="select * from privs where priv_id=?";
        ArrayList<HashMap<String, Object>> list =SqlUtil.executeQuery(sql,id);
        System.out.println(list);
        PrivilegeAM privilegeAM=null;
        if(list.size()>0){
            privilegeAM=new PrivilegeAM();
            privilegeAM.setPrivId(StringUtil.valueOf(list.get(0).get("priv_id")));
            privilegeAM.setPrivName(StringUtil.valueOf(list.get(0).get("priv_name")));
            privilegeAM.setPrivLevel(StringUtil.valueOf(list.get(0).get("priv_level")));
            privilegeAM.setPrivFatherid(StringUtil.valueOf(list.get(0).get("priv_father_id")));
            privilegeAM.setPrivUrl(StringUtil.valueOf(list.get(0).get("priv_url")));
            privilegeAM.setPrivStaus(StringUtil.valueOf(list.get(0).get("priv_status")));
        }
        return privilegeAM;
    }

    /**
     * 查询所有权限
     * @return
     */
    public List<PrivilegeAM> FindALLPrivilege(){
        String sql="select * from privs";
        ArrayList<HashMap<String, Object>> list=SqlUtil.executeQuery(sql);
        List<PrivilegeAM> list2=new ArrayList<>();
        PrivilegeAM privilegeAM=null;
        if(list.size()>0){

            for(int i=0;i<list.size();i++){
                privilegeAM =new PrivilegeAM();
                privilegeAM.setPrivId(StringUtil.valueOf(list.get(i).get("priv_id")));
                privilegeAM.setPrivName(StringUtil.valueOf(list.get(i).get("priv_name")));
                privilegeAM.setPrivLevel(StringUtil.valueOf(list.get(i).get("priv_level")));
                privilegeAM.setPrivFatherid(StringUtil.valueOf(list.get(i).get("priv_father_id")));
                privilegeAM.setPrivUrl(StringUtil.valueOf(list.get(i).get("priv_url")));
                privilegeAM.setPrivStaus(StringUtil.valueOf(list.get(i).get("priv_status")));
                list2.add(privilegeAM);
            }
        }
        System.out.println(list2);
        return  list2;
    }

//----------------------------------------------------------------------------------------------------------------------------

    /**
     * 添加角色
     * @param roleAM
     */
    public void AddRole(RoleAM roleAM){
        String sql="insert into role(role_id,role_name,role_status) valuse(?,?,?)";
        SqlUtil.executeUpdate(sql,roleAM);
    }

    /**
     * 查找角色
     * @param id
     * @return
     */
    public RoleAM FindRoleDao(String id){
        String sql="select * from role where role_id=?";
        ArrayList<HashMap<String, Object>> list=SqlUtil.executeQuery(sql,id);
        RoleAM roleAM=null;
        if(list.size()>0){
            for (int i=0;i<list.size();i++){
                roleAM=new RoleAM();
                roleAM.setId(StringUtil.valueOf(list.get(i).get("role_id")));
                roleAM.setName(StringUtil.valueOf(list.get(i).get("role_name")));
            }
        }
        return  roleAM;
    }

    /**
     * 查询所有角色
     * @return
     */
    public List<RoleAM> FindAllRoleDao(){
        String sql="select * from role";
        ArrayList<HashMap<String, Object>> list=SqlUtil.executeQuery(sql);
        List<RoleAM> list2=new ArrayList();
        RoleAM roleAM=null;
        if(list.size()>0){
            for(int i=0;i<list.size();i++){
                roleAM=new RoleAM();
                roleAM.setId(StringUtil.valueOf(list.get(i).get("role_id")));
                roleAM.setName(StringUtil.valueOf(list.get(i).get("role_name")));
                list2.add(roleAM);
            }
        }
        System.out.println(list2.toString());
        return  list2;
    }
//--------------------------------------------------------------------------------------------------------------

    /**
     * 查询某用户的所有角色
     * @param user_id
     * @return
     */
    public List<RoleAM> FindUserAllRoles(String user_id){
        String sql="select r.* from role r , user_role ur where ur.user_id=? and r.role_id=ur.role_id";
        ArrayList<HashMap<String, Object>> list=SqlUtil.executeQuery(sql,user_id);
        List<RoleAM> list2=new ArrayList();
        RoleAM roleAM=null;
        if(list.size()>0){
            for(int i=0;i<list.size();i++){
                roleAM=new RoleAM();
                roleAM.setId(StringUtil.valueOf(list.get(i).get("role_id")));
                roleAM.setName(StringUtil.valueOf(list.get(i).get("role_name")));
                list2.add(roleAM);
            }
        }
        return  list2;
    }
//--------------------------------------------------------------------------------------------------------------

    /**
     * 查询某角色 所有的权限
     * @param role_id
     * @return
     */
    public List<PrivilegeAM> FindRoleAllPrivilege(String role_id){
        String sql="select p.* from privs p ,role_priv rp where rp.role_id=? and p.priv_id=rp.priv_id";
        ArrayList<HashMap<String, Object>> list=SqlUtil.executeQuery(sql,role_id);
        List<PrivilegeAM> list2=new ArrayList();
        PrivilegeAM privilegeAM=null;
        if(list.size()>0){
            for(int i=0;i<list.size();i++){
                privilegeAM =new PrivilegeAM();
                privilegeAM.setPrivId(StringUtil.valueOf(list.get(i).get("priv_id")));
                privilegeAM.setPrivName(StringUtil.valueOf(list.get(i).get("priv_name")));
                privilegeAM.setPrivLevel(StringUtil.valueOf(list.get(i).get("priv_level")));
                privilegeAM.setPrivFatherid(StringUtil.valueOf(list.get(i).get("priv_father_id")));
                privilegeAM.setPrivUrl(StringUtil.valueOf(list.get(i).get("priv_url")));
                privilegeAM.setPrivStaus(StringUtil.valueOf(list.get(i).get("priv_status")));
                list2.add(privilegeAM);
            }
        }
       // System.out.println(list2);
        return  list2;

    }

//-------------------------------------------------------------------------------------------------------------

    /**
     * 修改用户角色
     * @param user
     * @param roles
     */
    public void AlterUserRole(UserAM user,List<RoleAM> roles){
        //先删除该用户所有角色
        String sql="delete from user_role where user_id=?";
        String user_id=user.getUserId();
        SqlUtil.executeUpdate(sql,user_id);

        //赋予用户新角色
        String sql2="insert into user_role (user_id,role_id) values(?,?)";
        for(int i=0;i<roles.size();i++){
            String roleid=roles.get(i).getId();
            SqlUtil.executeUpdate(sql2,user_id,roleid);//此处一定要记得  传入的是 sql2  【被这个问题  困扰了 大半天的时间  太粗心了】
        }
//        for (RoleAM role: roles) {
//            SqlUtil.executeUpdate(sql,new Object[]{user_id,role.getId()});
//        }
    }


    public void AlterUserRoleOne(UserAM user,RoleAM roleAM){
        //先删除某个用户所有角色
        String sql="delete from user_role where user_id=?";
        String user_id=user.getUserId();
        SqlUtil.executeUpdate(sql,user_id);

        //赋予用户新角色  只能一个
        String sql2="insert into user_role (user_id,role_id) values(?,?)";
            SqlUtil.executeUpdate(sql2,roleAM);
    }
//---------------------------------------------------------------------------------------------------------
    /**
     * 给某个角色添加权限
     * @param role
     * @param privilegeAMS
     */
    public void AddRolePrivilegeDao(RoleAM role,List<PrivilegeAM> privilegeAMS){
        //先删除某个角色所有权限
        String sql="delete from role_priv where role_id=?";
        String role_id=role.getId();
        SqlUtil.executeUpdate(sql,role_id);

        //赋予角色新权限
        String sql2="insert into role_priv (role_id,priv_id) values(?,?)";
        for (PrivilegeAM privilegeAM: privilegeAMS) {
            SqlUtil.executeUpdate(sql2,new Object[]{role.getId(),privilegeAM.getPrivId()});
        }
    }

    public void AddRolePrivilegeOneDao(RoleAM role,PrivilegeAM privilegeAM){
        //先删除某个角色所有权限
        String sql="delete from role_priv where role_id=?";
        String role_id=role.getId();
        SqlUtil.executeUpdate(sql,role_id);

        //赋予角色新权限 一个
        String sql2="insert into role_priv (role_id,priv_id) values(?,?)";
        SqlUtil.executeUpdate(sql2,role_id,privilegeAM);
    }
}
