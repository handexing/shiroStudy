package com.han.shiro.util;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @ClassName: JdbcTemplateUtils
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author handx 908716835@qq.com
 * @date 2016年8月11日 下午11:07:46
 *
 */
public class JdbcTemplateUtils {

	private static JdbcTemplate jdbcTemplate;

	public static JdbcTemplate jdbcTemplate() {
		if (jdbcTemplate == null) {
			jdbcTemplate = createJdbcTemplate();
		}
		return jdbcTemplate;
	}

	private static JdbcTemplate createJdbcTemplate() {

		DruidDataSource ds = new DruidDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/shirostudy");
		ds.setUsername("root");
		ds.setPassword("root");

		return new JdbcTemplate(ds);
	}

}
