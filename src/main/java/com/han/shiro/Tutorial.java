package com.han.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: Tutorial
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author handx 908716835@qq.com
 * @date 2016年8月8日 下午9:35:05
 *
 */
public class Tutorial {

	private static final Logger log = LoggerFactory.getLogger(Tutorial.class);

	public static void main(String[] args) {
		/**
		 * 1,我们使用 Shiro 的 IniSecurityManager 实现来提取我们的 shiro.ini 文件，它位于 classpath
		 * 的根目录。该实现反 映了 Shiro 对工厂设计模式的支持。classpath: 前缀是一个资源定位符，用来告诉 shiro 去哪加载
		 * ini 文件（其 他前缀，如 url:和 file:也同样被支持）。
		 */
		IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:shiro.ini");
		/**
		 * 2,factory.getInstance()方法被调用，它来解析 INI 文件并返回反映该配置的 SecurityManager 实例。
		 */
		SecurityManager securityManager = factory.getInstance();
		/**
		 * 们把 SecurityManager 设置为一个静态的（memory）单例，能够跨 JVM 访问。
		 */
		SecurityUtils.setSecurityManager(securityManager);

		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		session.setAttribute("someKey", "aValue");
		String value = (String) session.getAttribute("someKey");
		if (value.equals("aValue")) {
			System.out.println("检索正确值！" + value);
		}

		if (!subject.isAuthenticated()) {
			UsernamePasswordToken token = new UsernamePasswordToken("lonestarr", "vespa");
			token.setRememberMe(true);// 设置记住我
			try {
				subject.login(token);
			} catch (UnknownAccountException uae) {
				System.out.println("用户不存在！");
			} catch (IncorrectCredentialsException ice) {
				System.out.println("用户名，密码不正确！");
			} catch (LockedAccountException lae) {
				System.out.println("帐户的用户名被锁定-不能登录");
			} catch (AuthenticationException ae) {
				System.out.println("意外的情况");
			}
		}
		System.out.println("用户：" + subject.getPrincipal() + "登陆成功！");

	}
}
