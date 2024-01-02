package config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
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

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user")
				.password("{bcrypt}$2a$12$NGNBHolK/7YT7SHgZvIjT.JtYvOF6I0G750DcVjJbBzTx2TE2iS/S").roles("USER").and()
				.withUser("admin").password("{noop}admin").roles("USER", "ADMIN").and().withUser("inventory")
				.password("{noop}inventory").roles("ADMIN");
	}

}// end class
