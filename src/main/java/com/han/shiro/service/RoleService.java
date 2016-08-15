package com.han.shiro.service;

import com.han.shiro.entity.Role;

/**
 * @ClassName: RoleService 
 * @Description:关联/移除关联角色-权限功能
 * @author handx 908716835@qq.com 
 * @date 2016年8月11日 下午11:10:31 
 *
 */
public interface RoleService {


    public Role createRole(Role role);
    public void deleteRole(Long roleId);

    /**
     * 添加角色-权限之间关系
     * @param roleId
     * @param permissionIds
     */
    public void correlationPermissions(Long roleId, Long... permissionIds);

    /**
     * 移除角色-权限之间关系
     * @param roleId
     * @param permissionIds
     */
    public void uncorrelationPermissions(Long roleId, Long... permissionIds);

}
