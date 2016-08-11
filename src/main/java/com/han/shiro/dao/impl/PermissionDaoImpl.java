package com.han.shiro.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import com.han.shiro.dao.PermissionDao;
import com.han.shiro.entity.Permission;
import com.han.shiro.util.JdbcTemplateUtils;

/**
 * @ClassName: PermissionDaoImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author handx 908716835@qq.com
 * @date 2016年8月11日 下午11:07:09
 *
 */
public class PermissionDaoImpl implements PermissionDao {

	private JdbcTemplate jdbcTemplate = JdbcTemplateUtils.jdbcTemplate();

	public Permission createPermission(final Permission permission) {
		final String sql = "insert into sys_permissions(permission, description, available) values(?,?,?)";

		GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement psst = connection.prepareStatement(sql, new String[] { "id" });
				psst.setString(1, permission.getPermission());
				psst.setString(2, permission.getDescription());
				psst.setBoolean(3, permission.getAvailable());
				return psst;
			}
		}, keyHolder);
		permission.setId(keyHolder.getKey().longValue());

		return permission;
	}

	public void deletePermission(Long permissionId) {
		// 首先把与permission关联的相关表的数据删掉
		String sql = "delete from sys_roles_permissions where permission_id=?";
		jdbcTemplate.update(sql, permissionId);

		sql = "delete from sys_permissions where id=?";
		jdbcTemplate.update(sql, permissionId);
	}

}
