package com.han.shiro;

import java.util.Arrays;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;

/**
 * @ClassName: Authorization
 * @Description: 授权/权限
 * @author handx 908716835@qq.com
 * @date 2016年8月10日 下午9:48:57
 *
 */
public class Authorization {

	private Subject subject;

	@Test
	public void testHasRole() {
		 login("classpath:shiro_role.ini", "handx", "123");  
		 //判断拥有角色：role1  
		 Assert.assertTrue(subject.hasRole("role1"));
		 //判断拥有角色：role1 and role2  
		 Assert.assertTrue(subject.hasAllRoles(Arrays.asList("role1", "role2")));  
		 //判断拥有角色：role1 and role2 and !role3  
		 boolean[] result = subject.hasRoles(Arrays.asList("role1", "role2", "role3"));  
		 Assert.assertEquals(true, result[0]);  
		 Assert.assertEquals(true, result[1]);  
		 Assert.assertEquals(false, result[2]); 
	}

	/**
	 * @Title: login 
	 * @Description: 登陆
	 * @param @param configFile
	 * @param @param name
	 * @param @param pwd    设定文件 
	 * @return void    返回类型 
	 * @throws
	 */
	private void login(String configFile,String name,String pwd) {
		// 1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
		Factory<org.apache.shiro.mgt.SecurityManager> factory = new IniSecurityManagerFactory(configFile);
		// 2、得到SecurityManager实例 并绑定给SecurityUtils
		org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(name, pwd);
		subject.login(token);
	}
	
	
	@Test  
	public void testIsPermitted() {  
	    login("classpath:shiro_permission.ini", "handx", "123");  
	    //判断拥有权限：user:create  
//	    Assert.assertTrue(subject.isPermitted("user:create"));  
	    //判断拥有权限：user:update and user:delete  
//	    Assert.assertTrue(subject.isPermittedAll("user:update", "user:delete"));  
	    //判断没有权限：user:view  
	    Assert.assertFalse(subject.isPermitted("user:view"));  
	}   
	
	
}
