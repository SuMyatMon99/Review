
package com.ucs.edu.Review.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.ucs.edu.Review.error.MyAccessDeniedHandler;
import com.ucs.edu.Review.service.UserService;

@EnableWebSecurity
@EnableWebMvc
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	MyAccessDeniedHandler accessDeniedHandler;

	@Autowired
	UserService securityServiceImpl;

	@Override

	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
        .authorizeRequests()
        .antMatchers("/static/**").permitAll()
        .antMatchers("/", "/public/**","/user/login.htm","/user/register.htm").permitAll()
            .antMatchers("/user/**").hasAuthority("ADMIN")
            .anyRequest().fullyAuthenticated()
            .and()
        .formLogin()
            .loginPage("/user/login.htm")
            .failureUrl("/login.htm?error")
            .usernameParameter("email")
            .permitAll()
            .and()
        .logout()
         .logoutUrl("/logout.htm")
            .logoutSuccessUrl("/")
            .permitAll();	
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(securityServiceImpl).passwordEncoder(passwordEncoder());

	}
}
