package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class DocumentDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void uploaddocument(String email,byte[] file) {
		String sql = "INSERT INTO document(email,file) VALUES (?, ?)";
		int rows = jdbcTemplate.update(sql, email,file);
	}
}
