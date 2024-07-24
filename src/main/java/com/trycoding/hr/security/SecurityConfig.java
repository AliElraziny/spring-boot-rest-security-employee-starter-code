package com.trycoding.hr.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.trycoding.hr.service.CustomDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Autowired
	private CustomDetailsService customDetailsService;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(configurer -> configurer
				.requestMatchers(HttpMethod.GET, "/apiForEmployees/**").hasRole("EMPLOYEE")
				.requestMatchers(HttpMethod.GET, "/apiForEmployees/**").hasRole("ADMIN")
				.requestMatchers(HttpMethod.POST, "/apiForEmployees/**").hasRole("ADMIN")
				.requestMatchers(HttpMethod.PUT, "/apiForEmployees/**").hasRole("ADMIN")
				.requestMatchers(HttpMethod.DELETE, "/apiForEmployees/**").hasRole("ADMIN")
				.requestMatchers(HttpMethod.GET, "/members/**").hasRole("ADMIN")
				.requestMatchers(HttpMethod.POST, "/members/**").hasRole("ADMIN")
				.requestMatchers(HttpMethod.GET, "/roles/**").hasRole("ADMIN")
				.requestMatchers(HttpMethod.POST, "/roles/**").hasRole("ADMIN")
				.requestMatchers(HttpMethod.GET, "/apiForEmployees/**").hasRole("MANAGER")
				.requestMatchers(HttpMethod.POST, "/apiForEmployees/**").hasRole("MANAGER")
				.requestMatchers(HttpMethod.PUT, "/apiForEmployees/**").hasRole("MANAGER")
				.requestMatchers(HttpMethod.DELETE, "/apiForEmployees/**").hasRole("MANAGER")
				.requestMatchers(HttpMethod.GET, "/members/**").hasRole("MANAGER")
				.requestMatchers(HttpMethod.POST, "/members/**").hasRole("MANAGER")
				.requestMatchers(HttpMethod.PUT, "/members/**").hasRole("MANAGER")
				.requestMatchers(HttpMethod.DELETE, "/members/**").hasRole("MANAGER")
				.requestMatchers(HttpMethod.GET, "/roles/**").hasRole("MANAGER")
				.requestMatchers(HttpMethod.POST, "/roles/**").hasRole("MANAGER")
				.requestMatchers(HttpMethod.PUT, "/roles/**").hasRole("MANAGER")
				.requestMatchers(HttpMethod.DELETE, "/roles/**").hasRole("MANAGER")


				

		);

		http.httpBasic(Customizer.withDefaults());
		http.csrf(csrf -> csrf.disable());

		return http.build();
	}

	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(customDetailsService);
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance()); // No password encoding
		return provider;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance(); // No password encoding
	}

}