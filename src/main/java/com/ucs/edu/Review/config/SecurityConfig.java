
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

import com.ucs.edu.Review.error.MyAccessDeniedHandler;
import com.ucs.edu.Review.service.UserDetailsServiceImpl;


@Configuration
@EnableWebSecurity 
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	MyAccessDeniedHandler accessDeniedHandler;

	@Autowired
	UserDetailsServiceImpl userService;

	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
        .authorizeRequests()
				.antMatchers("/",
						"/public/**", "/resources/**",
						"/images/**",
						"/register.htm","/product_list").permitAll()
				.antMatchers("/create_product").hasAnyAuthority("ADMIN","USER","MANAGER")
				.antMatchers("/product/**").hasAnyAuthority("ADMIN","USER","MANAGER")
				.antMatchers("/category/**").hasAuthority("ADMIN")
				.antMatchers("/brand/**").hasAuthority("ADMIN")
				.antMatchers("/shop/**").hasAuthority("ADMIN")
            .antMatchers("/**").fullyAuthenticated()
            .and()
        .formLogin()
        .loginPage("/login")
        .loginProcessingUrl("/login")
        
        	.failureUrl("/login?error=1")
        	.defaultSuccessUrl("/",true)
            .permitAll()
            .and()
        .logout()
         .logoutUrl("/logout")
            .logoutSuccessUrl("/login")
            .permitAll();	
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(passwordEncoder());

	}
}
