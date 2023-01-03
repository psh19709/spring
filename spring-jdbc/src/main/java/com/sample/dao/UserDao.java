package com.sample.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sample.vo.User;

@Repository
public class UserDao {
	
	@Autowired
	private JdbcTemplate template;
	
	public void insertUser(User user) {
		String sql = "insert into web_users(user_id, user_password, user_name, user_email) values (?,?,?,?)";
		template.update(sql, user.getId(), user.getPassword(), user.getName(), user.getEmail());
	}

	public void updateUser(User user) {
		String sql = "update web_users set user_password = ?, user_updated_date = sysdate where user_id = ?";
		template.update(sql, user.getPassword(), user.getId());
	}
	
	public List<User> getAllUsers(){
		String sql = "select * from web_users";
		return template.query(sql, new UserRowMapper());
	}
	
	public User getUserById(String id) {
		String sql = "select * from web_users where user_id = ?";
		return template.queryForObject(sql, new UserRowMapper(), id);
	}
	
	public User getUserByEmail(String email) {
		String sql = "select * from web_users where user_email = ?";
		return template.queryForObject(sql, new UserRowMapper(), email);
	}
	
	// Select문의 실행 후 획득된 ResultSet을 어떻게 처리할지 구현한 객체다.
	private class UserRowMapper implements RowMapper<User>{
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setId(rs.getString("user_id"));
			user.setPassword(rs.getString("user_password"));
			user.setName(rs.getString("user_name"));
			user.setEmail(rs.getString("user_email"));
			user.setEnabled(rs.getString("user_enabled"));
			user.setUpdatedDate(rs.getDate("user_updated_date"));
			user.setCreatedDate(rs.getDate("user_created_date"));
			return user;
		}
		
	}
	
}
