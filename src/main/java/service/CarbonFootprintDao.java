package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.RedirectView;

@Service
public class CarbonFootprintDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public boolean checkbill(String email) {
		String sql = "SELECT * FROM electricity WHERE email=? ";
		return true;
	}
	
	public void storebill(String email, int electricity, int gas , int fuel_oil, String other_energy_sources,byte[] file) {
		String sql = "INSERT INTO electricity(email, electricity, gas, fuel_oil, other_energy_sources, file, status) VALUES (?, ?, ?, ?, ?, ? , ?);";
		int row = jdbcTemplate.update(sql, email, electricity, gas, fuel_oil, other_energy_sources, file, false);
	}
	
	public void storewaterbill(String email,int household_water_usage, int outdoor_water_usage) {
		String sql = "INSERT INTO water(email, household_water_usage, outdoor_water_usage) VALUES(?, ?, ?)";
		int row = jdbcTemplate.update(sql,email,household_water_usage, outdoor_water_usage);
	}

	public void storerecyclebill(String email, String recycling_habit, String composting_habits, String landfill_waste_generation) {
			String sql = "INSERT INTO recycle(email, recycling_habit, composting_habits, landfill_waste_generation) VALUES(?, ?, ?, ?)";
			int row = jdbcTemplate.update(sql,email,recycling_habit, composting_habits, landfill_waste_generation);
	}
}
