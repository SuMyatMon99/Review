package com.ucs.edu.Review.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
   
	

	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("user").password("password").roles("USER")
                .and()
                .withUser("admin").password("password").roles("ADMIN");
    }

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/register").permitAll()
		.antMatchers("/login").permitAll()
		.antMatchers("/admin/**").hasAnyAuthority("ROLE_ADMIN")
		.antMatchers("/reviewer/**").hasAnyAuthority("ROLE_REVIEWER")
		.antMatchers("/user/**").hasAnyAuthority("ROLE_USER")
		.antMatchers("/**").fullyAuthenticated()
		.and().formLogin().loginPage("/login.htm").loginProcessingUrl("/login.htm").failureUrl("/user-login.htm?error=1").defaultSuccessUrl("/gettest.htm")
		.and().exceptionHandling().accessDeniedPage("/403")
		.and().logout().logoutUrl("/logout.htm").logoutSuccessUrl("/user-login.htm").deleteCookies("JSESSIONID").invalidateHttpSession(true)
		.and().csrf().disable();
		
//
//				.antMatchers("/detailmap/**").hasAuthority("USER_ROLE")
//
//				.and().formLogin().loginPage("/memberarea.htm").loginProcessingUrl("/log")
//				.usernameParameter("useremail").passwordParameter("password").successHandler(customAuthenticationSuccessHandler)
//				.and().logout().logoutUrl("/logout")

		;

	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}

