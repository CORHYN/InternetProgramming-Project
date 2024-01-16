package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.RedirectView;
import java.text.SimpleDateFormat;  
import java.util.Date;  

@Service
public class CarbonFootprintDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void storeElectricityBill(String email, int electricity,byte[] file) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");  
		Date date = new Date();
		String sql = "INSERT INTO electricity(email, electricity, file, vstatus, submit_date) VALUES (?, ?, ?, ?, ?);";
		int row = jdbcTemplate.update(sql, email, electricity, file, "PENDING", formatter.format(date));
	}
	
	public void storewaterbill(String email,int water, byte[] file) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");  
		Date date = new Date();
		String sql = "INSERT INTO water(email, water, file, vstatus, submit_date) VALUES(?, ?, ?, ? , ?)";
		int row = jdbcTemplate.update(sql,email,water, file, "PENDING", formatter.format(date));
	}

	public void storerecyclebill(String email, int recycle,byte[] file) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");  
		Date date = new Date();	
		String sql = "INSERT INTO recycle(email, recycle, file, vstatus, submit_date) VALUES(?, ?, ?, ?, ?)";
		int row = jdbcTemplate.update(sql,email, recycle, file, "PENDING", formatter.format(date));
	}
	
}
