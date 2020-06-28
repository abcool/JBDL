package com.abcool.SpringSecurity.SpringSecurityDemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.abcool.SpringSecurity.SpringSecurityDemo.service.UserService;
import com.abcool.SpringSecurity.SpringSecurityDemo.utils.JWTRequestFilter;

@EnableWebSecurity
public class DemoConfigWithDB extends WebSecurityConfigurerAdapter{

	@Autowired
	UserService service;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(service);
	}
	
	@Autowired
    private JWTRequestFilter jwtRequestFilter;
	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http
//		.httpBasic()
//		.and()
//		.csrf().disable()
//		.authorizeRequests()
//		.antMatchers("/admin/**").hasAuthority("admin")
//		.antMatchers("/staff/**").hasAnyAuthority("user","admin")
//		.antMatchers("/**").permitAll()
//		.and()
//		.formLogin();
//	}
	
	@Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                .authorizeRequests().antMatchers("/authenticate", "/home").permitAll()
                .anyRequest()
                .authenticated().and().
                exceptionHandling().and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
