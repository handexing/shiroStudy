package com.han.shiro.service.impl;

import com.han.shiro.dao.PermissionDao;
import com.han.shiro.dao.impl.PermissionDaoImpl;
import com.han.shiro.entity.Permission;
import com.han.shiro.service.PermissionService;

/**
 * @ClassName: PermissionServiceImpl 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author handx 908716835@qq.com 
 * @date 2016年8月11日 下午11:11:56 
 *
 */
public class PermissionServiceImpl implements PermissionService {

    private PermissionDao permissionDao = new PermissionDaoImpl();

    public Permission createPermission(Permission permission) {
        return permissionDao.createPermission(permission);
    }

    public void deletePermission(Long permissionId) {
        permissionDao.deletePermission(permissionId);
    }
}
