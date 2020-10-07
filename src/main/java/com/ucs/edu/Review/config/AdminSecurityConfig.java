/*
 * package com.ucs.edu.Review.config;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.core.annotation.Order; import
 * org.springframework.security.config.annotation.authentication.builders.
 * AuthenticationManagerBuilder; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity; import
 * org.springframework.security.config.annotation.web.configuration.
 * WebSecurityConfigurerAdapter; import
 * org.springframework.security.core.userdetails.UserDetailsService; import
 * org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
 * 
 * @Configuration
 * 
 * @EnableWebSecurity public class AdminSecurityConfig extends
 * WebSecurityConfigurerAdapter{
 * 
 * @Autowired private BCryptPasswordEncoder passwordEncoder;
 * 
 * @Autowired private UserDetailsService adminDetailsService;
 * 
 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
 * Exception {
 * auth.userDetailsService(adminDetailsService).passwordEncoder(passwordEncoder)
 * ; }
 * 
 * @Override protected void configure(HttpSecurity http) throws Exception { http
 * .authorizeRequests() .antMatchers("/", "/public/**", "/resources/**",
 * "/images/**", "/register.htm","/product_list").permitAll()
 * .antMatchers("/*").fullyAuthenticated() .and() .formLogin()
 * .loginPage("/admin/login") .usernameParameter("email")
 * .defaultSuccessUrl("/admin/product_list",true) .permitAll() .and() .logout()
 * .logoutUrl("/logout") .logoutSuccessUrl("/admin/login") .permitAll() .and()
 * .csrf().disable().cors(); super.configure(http); }
 * 
 * 
 * 
 * }
 */