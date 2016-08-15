package com.han.shiro.service;

import com.han.shiro.entity.Permission;

/**
 * @ClassName: PermissionService
 * @Description: 实现基本的创建/删除权限。
 * @author handx 908716835@qq.com
 * @date 2016年8月11日 下午11:10:42
 *
 */
public interface PermissionService {
	
	public Permission createPermission(Permission permission);

	public void deletePermission(Long permissionId);
}
