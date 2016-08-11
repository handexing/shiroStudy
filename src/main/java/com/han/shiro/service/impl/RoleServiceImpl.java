package com.han.shiro.service.impl;

import com.han.shiro.dao.RoleDao;
import com.han.shiro.dao.impl.RoleDaoImpl;
import com.han.shiro.entity.Role;
import com.han.shiro.service.RoleService;

/**
 * @ClassName: RoleServiceImpl 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author handx 908716835@qq.com 
 * @date 2016年8月11日 下午11:12:02 
 *
 */
public class RoleServiceImpl implements RoleService {

    private RoleDao roleDao = new RoleDaoImpl();


    public Role createRole(Role role) {
        return roleDao.createRole(role);
    }

    public void deleteRole(Long roleId) {
        roleDao.deleteRole(roleId);
    }

    /**
     * 添加角色-权限之间关系
     * @param roleId
     * @param permissionIds
     */
    public void correlationPermissions(Long roleId, Long... permissionIds) {
        roleDao.correlationPermissions(roleId, permissionIds);
    }

    /**
     * 移除角色-权限之间关系
     * @param roleId
     * @param permissionIds
     */
    public void uncorrelationPermissions(Long roleId, Long... permissionIds) {
        roleDao.uncorrelationPermissions(roleId, permissionIds);
    }

}
