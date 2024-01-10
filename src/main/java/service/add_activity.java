package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class add_activity {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void addActivity(String name, String date , String location, byte[] file) {
		System.out.print("File Uploaded Successfully : " + file);
		String sql1 = "INSERT INTO activity(activity_name, activity_date, activity_location, activity_file) VALUES (?, ?, ?, ?)";
		int row1 = jdbcTemplate.update(sql1, name,date,location,file);
		
	}
	
}
