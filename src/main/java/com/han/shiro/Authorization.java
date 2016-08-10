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
 * @Description: ��Ȩ/Ȩ��
 * @author handx 908716835@qq.com
 * @date 2016��8��10�� ����9:48:57
 *
 */
public class Authorization {

	private Subject subject;

	@Test
	public void testHasRole() {
		 login("classpath:shiro_role.ini", "handx", "123");  
		 //�ж�ӵ�н�ɫ��role1  
		 Assert.assertTrue(subject.hasRole("role1"));
		 //�ж�ӵ�н�ɫ��role1 and role2  
		 Assert.assertTrue(subject.hasAllRoles(Arrays.asList("role1", "role2")));  
		 //�ж�ӵ�н�ɫ��role1 and role2 and !role3  
		 boolean[] result = subject.hasRoles(Arrays.asList("role1", "role2", "role3"));  
		 Assert.assertEquals(true, result[0]);  
		 Assert.assertEquals(true, result[1]);  
		 Assert.assertEquals(false, result[2]); 
	}

	/**
	 * @Title: login 
	 * @Description: ��½
	 * @param @param configFile
	 * @param @param name
	 * @param @param pwd    �趨�ļ� 
	 * @return void    �������� 
	 * @throws
	 */
	private void login(String configFile,String name,String pwd) {
		// 1����ȡSecurityManager�������˴�ʹ��Ini�����ļ���ʼ��SecurityManager
		Factory<org.apache.shiro.mgt.SecurityManager> factory = new IniSecurityManagerFactory(configFile);
		// 2���õ�SecurityManagerʵ�� ���󶨸�SecurityUtils
		org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(name, pwd);
		subject.login(token);
	}
	
	
	@Test  
	public void testIsPermitted() {  
	    login("classpath:shiro_permission.ini", "handx", "123");  
	    //�ж�ӵ��Ȩ�ޣ�user:create  
//	    Assert.assertTrue(subject.isPermitted("user:create"));  
	    //�ж�ӵ��Ȩ�ޣ�user:update and user:delete  
//	    Assert.assertTrue(subject.isPermittedAll("user:update", "user:delete"));  
	    //�ж�û��Ȩ�ޣ�user:view  
	    Assert.assertFalse(subject.isPermitted("user:view"));  
	}   
	
	
}
