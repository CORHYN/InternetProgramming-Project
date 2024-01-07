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
	
		public String createUser(String authority,String fullName, String dob,Integer phone,String address,String email,String password) {
		String sql1 = "INSERT INTO users(email, password, enabled) VALUES (?, ?, ?)";
		String sql2 = "INSERT INTO authorities(email,authority) VALUES (?, ?)";
		String sql3 = "INSERT INTO user_info(email, fullname, dob, phone, address) VALUES (?, ?, ?, ?, ?)";
		int row1 = jdbcTemplate.update(sql1, email, new BCryptPasswordEncoder().encode(password), true);
		int row2 = jdbcTemplate.update(sql2, email, authority);
		int row3 = jdbcTemplate.update(sql3,email, fullName,dob, phone, address);
		return "Rows Effected :" + row1 + row2;
	}
	
}
