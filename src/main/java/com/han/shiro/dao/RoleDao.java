package com.han.shiro.dao;

import com.han.shiro.entity.Role;

/**
 * @ClassName: RoleDao
 * @Description: 关联/移除关联角色-权限功能
 * @author handx 908716835@qq.com
 * @date 2016年8月11日 下午11:06:14
 *
 */
public interface RoleDao {

	public Role createRole(Role role);

	public void deleteRole(Long roleId);

	public void correlationPermissions(Long roleId, Long... permissionIds);

	public void uncorrelationPermissions(Long roleId, Long... permissionIds);

}
