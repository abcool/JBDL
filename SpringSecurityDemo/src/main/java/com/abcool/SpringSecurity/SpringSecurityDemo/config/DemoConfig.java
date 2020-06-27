//package com.abcool.SpringSecurity.SpringSecurityDemo.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@EnableWebSecurity
//public class DemoConfig extends WebSecurityConfigurerAdapter{
//
//	/** 
//	 * @apiNote This method is for authentication
//	 */
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication()
//		.withUser("abcool")
//		.password("Abcool@24")
//		.roles("admin","user")
//		.and()
//		.withUser("snehal")
//		.password("failure")
//		.roles("user");
//	}
//	
//	/**@apiNote This method is for authorization 
//	 * **/
//	@Override
//	public void configure(HttpSecurity http) throws Exception {
//			
//		http
//		.httpBasic()
//		.and()
//		.authorizeRequests()
//		.antMatchers("/admin/**").hasRole("admin")
//		.antMatchers("/staff/**").hasAnyRole("user","admin")
//		.antMatchers("/**").permitAll()
//		.and()
//		.formLogin();
//		
//	}
//	
//	@Bean
//	public PasswordEncoder getPasswordEncoder() {
//		return NoOpPasswordEncoder.getInstance();
//	}
//	
//	
//}
