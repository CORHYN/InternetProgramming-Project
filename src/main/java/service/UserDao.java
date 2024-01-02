package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public String createUser(String username,String password) {
		String sql1 = "INSERT INTO users (username, password, enabled) VALUES (?, ?, ?)";
		String sql2 = "INSERT INTO authorities(username,authority) VALUES (?, ?)";
		int row1 = jdbcTemplate.update(sql1, username, new BCryptPasswordEncoder().encode(password), true);
		int row2 = jdbcTemplate.update(sql2, username, "USER");
		return "Rows Effected :" + row1 + row2;
	}
	
}
