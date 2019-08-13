package org.taru.service;

import org.taru.Entity.PrivilegeAM;
import org.taru.Entity.RoleAM;
import org.taru.Entity.UserAM;
import org.taru.dao.AuthorityManagementDao;

import java.util.ArrayList;
import java.util.List;

public class AuthorityManagementService {
    /**
     * 登陆
     * @param name
     * @param password
     * @return
     */
        public UserAM login(String name,String password){
            AuthorityManagementDao authorityManagementDao =new AuthorityManagementDao();
            UserAM user= authorityManagementDao.Login(name,password);
            return user;
        }

    /**
     * 返回普通管理员菜单
      * @param name
     * @return
     */
        public List<PrivilegeAM> QueryService(String name) {
            AuthorityManagementDao authorityManagementDao = new AuthorityManagementDao();
            List<PrivilegeAM> list = authorityManagementDao.querySunPrivs(name);
            List list1=new ArrayList();
            PrivilegeAM privilegeAM = null;
            if (list.size() > 0) {
                privilegeAM = new PrivilegeAM();
                for (int i = 0; i < list.size(); i++) {
                    privilegeAM.setPrivName(list.get(i).getPrivName());
                    list1.add(privilegeAM);
                }
            }
            return list1;
        }
//---------------------------------------------------------------------------------------------------------
    /**
     * 查询所有用户
     * @return
     */
    public List<UserAM> QueryAll(){
            AuthorityManagementDao authorityManagementDao = new AuthorityManagementDao();
            List<UserAM> list =authorityManagementDao.QueryALL();
            return list;
        }

    /**
     * 根据id 删除指定用户
      * @param id
     */
    public void DeleteOne(String id){
            AuthorityManagementDao authorityManagementDao = new AuthorityManagementDao();
            authorityManagementDao.Delete(id);
        }

    /**
     * 根据id 查询指定用户
     * @param id
     * @return
     */
    public UserAM QueryOne(String id){
            AuthorityManagementDao authorityManagementDao = new AuthorityManagementDao();
            UserAM user= authorityManagementDao.QueryOne(id);
            return user;
    }

    /**
     * 添加用户

     */
    public void AddService(UserAM user){
        AuthorityManagementDao authorityManagementDao = new AuthorityManagementDao();
        authorityManagementDao.Add(user);
    }

    /**
     * 修改用户
     * @param user
     */
    public void AlterService(UserAM user){
        AuthorityManagementDao authorityManagementDao = new AuthorityManagementDao();
        authorityManagementDao.Altere(user);
    }

    /**
     * 获取用户所有角色
     * @param user_id
     * @return
     */
    public List<RoleAM> GetUserAllRole(String user_id){
        AuthorityManagementDao authorityManagementDao =new AuthorityManagementDao();
        return authorityManagementDao.FindUserAllRoles(user_id);
    }

    /**
     * 修改用户角色/给用户添加角色
     * @param user
     * @param roles
     */
    public void AlterUserRoleService(UserAM user,List<RoleAM> roles){
        AuthorityManagementDao authorityManagementDao =new AuthorityManagementDao();
        authorityManagementDao.AlterUserRole(user,roles);
    }

    /**
     * 只能设置一次角色、但却可以超管 BUG
     * @param user
     * @param roleAM
     */
    public void AlterUserRoleOneService(UserAM user,RoleAM roleAM){
        AuthorityManagementDao authorityManagementDao =new AuthorityManagementDao();
        authorityManagementDao.AlterUserRoleOne(user,roleAM);
    }
//------------------------------------------------------------------------------------------------

    /**
     * 添加角色
     * @param roleAM
     */
    public void AddRole(RoleAM roleAM){
        AuthorityManagementDao authorityManagementDao =new AuthorityManagementDao();
        authorityManagementDao.AddRole(roleAM);
    }

    /**
     * 根据id查找角色
     * @param id
     * @return
     */
    public RoleAM FindRoleService(String id){
        AuthorityManagementDao authorityManagementDao =new AuthorityManagementDao();
        return authorityManagementDao.FindRoleDao(id);
    }

    /**
     * 获取所有的角色
     * @return
     */
    public List<RoleAM> GetAllRoleService(){
        AuthorityManagementDao authorityManagementDao =new AuthorityManagementDao();
        return authorityManagementDao.FindAllRoleDao();
    }

    /**
     * 获取角色所有权限
     * @param role_id
     * @return
     */
    public List<PrivilegeAM> GetRoleAllPrivilegeService(String role_id){
        AuthorityManagementDao authorityManagementDao =new AuthorityManagementDao();
        return authorityManagementDao.FindRoleAllPrivilege(role_id);
    }

    /**
     * 给角色添加权限/修改角色权限
     * @param roleAM
     * @param privilegeAMS
     */
    public void AlterRolePrivilegeService(RoleAM roleAM,List<PrivilegeAM> privilegeAMS){
        AuthorityManagementDao authorityManagementDao =new AuthorityManagementDao();
        authorityManagementDao.AddRolePrivilegeDao(roleAM,privilegeAMS);
    }

    /**
     * 给角色添加权限  只能添加一个角色
     * @param roleAM
     * @param privilegeAM
     */
    public void AlterRolePrivilegeService(RoleAM roleAM,PrivilegeAM privilegeAM){
        AuthorityManagementDao authorityManagementDao =new AuthorityManagementDao();
        authorityManagementDao.AddRolePrivilegeOneDao(roleAM,privilegeAM);
    }
//----------------------------------------------------------------------------------------------------------

    /**
     * 添加权限
     * @param privilegeAM
     */
    public void AddPrivilegeService(PrivilegeAM privilegeAM){
        AuthorityManagementDao authorityManagementDao =new AuthorityManagementDao();
        authorityManagementDao.AddPrivilege(privilegeAM);
    }

    /**
     * 根据id获得权限
     * @param id
     * @return
     */
    public PrivilegeAM FindPrivilegeService(String id){
        AuthorityManagementDao authorityManagementDao =new AuthorityManagementDao();
        return authorityManagementDao.FindPrivilege(id);
    }

    /**
     * 获得所有权限
     * @return
     */
    public List<PrivilegeAM> GetAllPrivilegeService(){
        AuthorityManagementDao authorityManagementDao =new AuthorityManagementDao();
        return authorityManagementDao.FindALLPrivilege();
    }
}

