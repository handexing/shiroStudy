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
 * @Description: TODO(������һ�仰��������������)
 * @author handx 908716835@qq.com
 * @date 2016��8��8�� ����9:35:05
 *
 */
public class Tutorial {

	private static final Logger log = LoggerFactory.getLogger(Tutorial.class);

	public static void main(String[] args) {
		/**
		 * 1,����ʹ�� Shiro �� IniSecurityManager ʵ������ȡ���ǵ� shiro.ini �ļ�����λ�� classpath
		 * �ĸ�Ŀ¼����ʵ�ַ� ӳ�� Shiro �Թ������ģʽ��֧�֡�classpath: ǰ׺��һ����Դ��λ������������ shiro ȥ�ļ���
		 * ini �ļ����� ��ǰ׺���� url:�� file:Ҳͬ����֧�֣���
		 */
		IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:shiro.ini");
		/**
		 * 2,factory.getInstance()���������ã��������� INI �ļ������ط�ӳ�����õ� SecurityManager ʵ����
		 */
		SecurityManager securityManager = factory.getInstance();
		/**
		 * �ǰ� SecurityManager ����Ϊһ����̬�ģ�memory���������ܹ��� JVM ���ʡ�
		 */
		SecurityUtils.setSecurityManager(securityManager);

		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		session.setAttribute("someKey", "aValue");
		String value = (String) session.getAttribute("someKey");
		if (value.equals("aValue")) {
			System.out.println("������ȷֵ��" + value);
		}

		if (!subject.isAuthenticated()) {
			UsernamePasswordToken token = new UsernamePasswordToken("lonestarr", "vespa");
			token.setRememberMe(true);// ���ü�ס��
			try {
				subject.login(token);
			} catch (UnknownAccountException uae) {
				System.out.println("�û������ڣ�");
			} catch (IncorrectCredentialsException ice) {
				System.out.println("�û��������벻��ȷ��");
			} catch (LockedAccountException lae) {
				System.out.println("�ʻ����û���������-���ܵ�¼");
			} catch (AuthenticationException ae) {
				System.out.println("��������");
			}
		}
		System.out.println("�û���" + subject.getPrincipal() + "��½�ɹ���");

	}
}
