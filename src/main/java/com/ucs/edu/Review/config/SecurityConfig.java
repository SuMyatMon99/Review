
package com.ucs.edu.Review.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.ucs.edu.Review.error.MyAccessDeniedHandler;
import com.ucs.edu.Review.service.UserService;


@Configuration
@EnableWebSecurity 
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	MyAccessDeniedHandler accessDeniedHandler;

	@Autowired
	UserService userService;

	

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
		.csrf().disable()
        .authorizeRequests()
        .antMatchers("/", "/public/**","/resources/**","/images/**",
        		"/create_shop","/shop_list","/save_shop",
        		"/create_brand","/brand_list","/save_brand",
        		"/create_product","/product_list","/save_product"
        		,"/category_list","/save_category","/blog-details.htm","/faq.htm","/blog.htm",
        		"/create_category","/create_location","/save_location","/location_list","/register.htm").permitAll()
            .antMatchers("/users/**").hasAuthority("ADMIN")
            .anyRequest().fullyAuthenticated()
            .and()
        .formLogin()
        .loginProcessingUrl("login.htm")
        .loginPage("/login.htm")
        	.failureUrl("/login.htm?error=1")
        	.defaultSuccessUrl("/")
            .permitAll()
            .and()
        .logout()
         .logoutUrl("/logout.htm")
            .logoutSuccessUrl("/login.htm")
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
