package com.trycoding.hr.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
public class DemoSecurityConfig {
	
	
	//use in memory to add users and it's roles
	@Bean
	public InMemoryUserDetailsManager userDetailsManager() {
		
		UserDetails omar = User.builder()
								.username("omar")
								.password("{noop}test123")
								.roles("EMPLOYEE")
								.build();
		
		UserDetails ahmed = User.builder()
				.username("ahmed")
				.password("{noop}test123")
				.roles("EMPLOYEE","MANAGER")
				.build();
		
		UserDetails samu = User.builder()
				.username("ali")
				.password("{noop}test123")
				.roles("ADMIN","EMPLOYEE","MANAGER")
				.build();
		
		return new InMemoryUserDetailsManager(omar , ahmed ,samu);
				
	}
	
	//use jdbc
	// you must create table users and table authorities 
//	@Bean
//	public UserDetailsManager userDetailsManager(DataSource dataSource) {
//		return new JdbcUserDetailsManager(dataSource);
//		
//	}
	
	//use custom data base tables
//	@Bean
//	public UserDetailsManager userDetailsManager(DataSource dataSource) {
//		
//		JdbcUserDetailsManager jdbcUserDetailsManager =new JdbcUserDetailsManager(dataSource);
//		
//		//for user 
//		jdbcUserDetailsManager.setUsersByUsernameQuery("select user_id ,pw,active from members where user_id=?");
//		//for authorities
//		jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select user_id ,role from roles where user_id=?");
//		
//		
//		return jdbcUserDetailsManager ;
//		
//	}
	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests(configurer -> 
					configurer 
							.requestMatchers(HttpMethod.GET,"/api/employees").hasRole("EMPLOYEE")
							.requestMatchers(HttpMethod.GET,"/api/employees/**").hasRole("EMPLOYEE")
							.requestMatchers(HttpMethod.POST,"/api/employees/**").hasRole("MANAGER")
							.requestMatchers(HttpMethod.PUT,"/api/employees/**").hasRole("MANAGER")
							.requestMatchers(HttpMethod.DELETE,"/api/employees/**").hasRole("ADMIN")
							.requestMatchers(HttpMethod.POST,"/members/**").hasRole("ADMIN")
							.requestMatchers(HttpMethod.GET,"/members/**").hasRole("ADMIN")
							.requestMatchers(HttpMethod.POST,"/roles/**").hasRole("ADMIN")
							.requestMatchers(HttpMethod.GET,"/roles/**").hasRole("ADMIN")
							
							
							);
		
		http.httpBasic(Customizer.withDefaults());
		http.csrf(csrf -> csrf.disable());
		
		return http.build();
		
		
	}

}
