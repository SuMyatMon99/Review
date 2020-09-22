
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
        .antMatchers("/", "/public/**","/resources/**","/images/**","/products/**",
        		"/profile","/header","/footer",
        		"/create_shop","/shop_list","/save_shop","/product_list/add_rate","/product_list/save_rate",
        		"/create_brand","/brand_list","/save_brand",
        		"/create_product","/product_list","/save_product"
        		,"/category_list","/save_category","/create_category"
        		,"/blog-details.htm","/faq.htm","/blog.htm",
        		"/create_location","/save_location","/location_list",
        		"/login.htm","/register.htm").permitAll()
            .antMatchers("/users/**").hasAuthority("ADMIN")
            .anyRequest().fullyAuthenticated()
            .and()
        .formLogin()
        .loginProcessingUrl("login.htm")
        .loginPage("/login.htm")
        	.failureUrl("/login.htm?error=1")
        	.defaultSuccessUrl("/product_list")
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
