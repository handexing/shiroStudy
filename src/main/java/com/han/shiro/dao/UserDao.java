package com.han.shiro.dao;


import java.util.Set;

import com.han.shiro.entity.User;

/**
 * @ClassName: UserDao 
 * @Description: 查找用户名对应的帐号、角色及权限信息
 * @author handx 908716835@qq.com 
 * @date 2016年8月11日 下午11:06:32 
 *
 */
public interface UserDao {

    public User createUser(User user);
    public void updateUser(User user);
    public void deleteUser(Long userId);

    public void correlationRoles(Long userId, Long... roleIds);
    public void uncorrelationRoles(Long userId, Long... roleIds);

    User findOne(Long userId);

    User findByUsername(String username);

    Set<String> findRoles(String username);

    Set<String> findPermissions(String username);
}
