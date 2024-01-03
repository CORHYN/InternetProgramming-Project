package config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
//this class create the spring security filter chain for our app
	// don’t put any code at this moment
	
	@Autowired
	DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

			auth.jdbcAuthentication()
			.dataSource(this.dataSource)
		    .usersByUsernameQuery("SELECT email,password,enabled FROM users WHERE email = ?")
		    .authoritiesByUsernameQuery("SELECT email,authority FROM authorities WHERE email = ?")
			.passwordEncoder(new BCryptPasswordEncoder());
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{

		http
		.authorizeRequests()
		.antMatchers("/Home")
		.permitAll()
		.antMatchers("/register/**")
		.permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.permitAll()
		.and()
		.logout()
		.permitAll();
		
		// This is used to add custom login page
//		.loginPage("/login")
	}

}// end class
