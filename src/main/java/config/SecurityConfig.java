package config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity(debug = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
//this class create the spring security filter chain for our app
	// don’t put any code at this moment
	
	@Autowired
	DataSource dataSource;
	
//	@Autowired
//	public SecurityConfig(DataSource dataSource) {
//		this.dataSource = dataSource;
//	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
			.dataSource(this.dataSource)
			.passwordEncoder(new BCryptPasswordEncoder());
		
//	.authoritiesByUsernameQuery(
//    "SELECT username, 'ROLE_USER' FROM users WHERE username=?")
		
	}

}// end class
