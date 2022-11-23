package com.visethboti.portfolio.schoolmanagementsystem.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	// add a reference to our security data source
	
	@Autowired
	@Qualifier("securityDataSource")
	private DataSource securityDataSource;
		
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// use jdbc authentication ... oh yeah!!!		
		auth.jdbcAuthentication().dataSource(securityDataSource)
		.usersByUsernameQuery("select userID, password, enabled from User where userID=?")
        .authoritiesByUsernameQuery("select userID, role from User where userID=?");
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
			.antMatchers("/").hasAnyRole("STUDENT", "STAFF", "ADMIN")
			.antMatchers("/users/**").hasRole("ADMIN")
			.antMatchers("/courses/**").hasRole("ADMIN")
			.antMatchers("/sections/**").hasRole("ADMIN")
			.antMatchers("/resources/**").permitAll()
			.and()
			.formLogin()
				.loginPage("/showMyLoginPage")
				.loginProcessingUrl("/authenticateTheUser")
				.permitAll()
			.and()
			.logout().permitAll()
			.and()
			.exceptionHandling().accessDeniedPage("/access-denied");
		
	}
		
}






