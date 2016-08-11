package com.han.shiro.service;

import java.util.Set;

import com.han.shiro.entity.User;

/**
 * @ClassName: UserService
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author handx 908716835@qq.com
 * @date 2016年8月11日 下午11:10:16
 *
 */
public interface UserService {

	/**
	 * 创建用户
	 * 
	 * @param user
	 */
	public User createUser(User user);

	/**
	 * 修改密码
	 * 
	 * @param userId
	 * @param newPassword
	 */
	public void changePassword(Long userId, String newPassword);

	/**
	 * 添加用户-角色关系
	 * 
	 * @param userId
	 * @param roleIds
	 */
	public void correlationRoles(Long userId, Long... roleIds);

	/**
	 * 移除用户-角色关系
	 * 
	 * @param userId
	 * @param roleIds
	 */
	public void uncorrelationRoles(Long userId, Long... roleIds);

	/**
	 * 根据用户名查找用户
	 * 
	 * @param username
	 * @return
	 */
	public User findByUsername(String username);

	/**
	 * 根据用户名查找其角色
	 * 
	 * @param username
	 * @return
	 */
	public Set<String> findRoles(String username);

	/**
	 * 根据用户名查找其权限
	 * 
	 * @param username
	 * @return
	 */
	public Set<String> findPermissions(String username);

}
