package com.han.shiro.dao;

import com.han.shiro.entity.Role;

/**
 * @ClassName: RoleDao
 * @Description: TODO(这里用一句话描述这个类的作用)
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
