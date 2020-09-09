package com.ucs.edu.Review.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	AuthenticationProvider dohKyaungAuthenticationProvider;
	
	
	

	@Override

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(dohKyaungAuthenticationProvider);
		

	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/login").permitAll()
		.antMatchers("/forgot-password.htm").permitAll()
		.antMatchers("/reset-password.htm").permitAll()
		.antMatchers("/login.htm").permitAll()
		.antMatchers("/resources/css/**").permitAll()
		.antMatchers("/resources/fonts/**").permitAll()
		.antMatchers("/resources/font/**").permitAll()
		.antMatchers("/resources/font-awesome/**").permitAll()
		.antMatchers("/resources/datatable/**").permitAll()
		.antMatchers("/resources/images/**").permitAll()
		.antMatchers("/resources/js/**").permitAll()
		.antMatchers("/permit-all/**").permitAll()
		.antMatchers("/admin-management/**").hasAnyAuthority("RCV,ADMIN,CH_SETT,AM_TEACHER")
		.antMatchers("/admin-management/delete/**").hasAnyAuthority("RCV,ADMIN,CH_SETT")
		.antMatchers("/teacher/create/**").hasAnyAuthority("AM_TEACHER,VE_TEACHER")
		.antMatchers("/teacher/edit/**").hasAuthority("AM_TEACHER")
		.antMatchers("/teacher/delete/**").hasAuthority("AM_TEACHER")
		.antMatchers("/teacher/substitute/**").hasAuthority("AM_SUBSTITUTE")
		.antMatchers("/parent/create/**").hasAnyAuthority("AM_PARENT,VE_PARENT")
		.antMatchers("/parent/edit/**").hasAuthority("AM_PARENT")
		.antMatchers("/parent/delete/**").hasAuthority("AM_PARENT")
		.antMatchers("/student/create/**").hasAuthority("AM_STU")
		.antMatchers("/student/view/**").permitAll()
		.antMatchers("/student/search/**").hasAnyAuthority("VE_STU','AM_STU")
		.antMatchers("/student/search/view/**").hasAuthority("VE_CLD")
		.antMatchers("/student/edit/**").hasAuthority("AM_STU")
		.antMatchers("/student/delete/**").hasAuthority("AM_STU")
		.antMatchers("/student/export/**").hasAuthority("AM_STU")
		.antMatchers("/student/guest/**").hasAuthority("AM_STU")
		.antMatchers("/class/class_edit/**").hasAuthority("AM_CLASS")
		.antMatchers("/class/class_delete/**").hasAuthority("AM_CLASS")
		.antMatchers("/class/section_edit/**").hasAuthority("AM_CLASS")
		.antMatchers("/class/section_delete/**").hasAuthority("AM_SEC")
		.antMatchers("/class/subject_create/**").hasAnyAuthority("AM_SUB,VE_SUB")
		.antMatchers("/class/subject_edit/**").hasAuthority("AM_SUB")
		.antMatchers("/class/subject_delete/**").hasAuthority("AM_SUB")
		.antMatchers("/routine/delete/**").hasAuthority("AM_SUB")
		.antMatchers("/routine/delete-class-routine.htm/**").hasAuthority("AM_ROU")
		.antMatchers("/routine/edit_classroutine.htm/**").hasAuthority("AM_ROU")
		.antMatchers("/promotion/**").hasAuthority("C_PRO")
		.antMatchers("/attendance/create/**").hasAuthority("AM_ATT")
		.antMatchers("/attendance/report/**").hasAnyAuthority("AM_ATT,VE_ATT")
		.antMatchers("/activity/create/**").hasAuthority("AM_ACT")
		.antMatchers("/library/edit/**").hasAuthority("AM_LIB")
		.antMatchers("/library/delete/**").hasAuthority("AM_LIB")
		.antMatchers("/transport/**").hasAuthority("AM_TRSP")
		.antMatchers("/dormitory/**").hasAuthority("AM_DOTY")
		.antMatchers("/leave/create/**").hasAuthority("AM_LE")
		.antMatchers("/leave/view/viewleavetype.htm/**").permitAll()
		.antMatchers("/leave/view/**").hasAuthority("VE_LE")
		.antMatchers("/leave/ajax/**").permitAll()
		.antMatchers("/admin-accounting/**").hasAuthority("ACC")
		.antMatchers("/examAndGrade/**").hasAnyAuthority("AM_EXAM,AM_GRADE")
		.antMatchers("/manage-mark/**").hasAuthority("AM_MARK")
		.antMatchers("/syllabus/create/**").hasAuthority("AM_SYLB")
		.antMatchers("/syllabus/view/**").hasAnyAuthority("AM_SYLB,VE_SYLB")
		.antMatchers("/notice/**").hasAuthority("AM_NOTI")
		.antMatchers("/fingerprint/**").hasAuthority("FP")
		.antMatchers("/studentInfo/create/**").hasAnyAuthority("AM_FOOD,AM_DSE,AM_POMO,AM_CHAR,VE_FOOD,VE_DSE,VE_POMO,VE_CHAR")
		.antMatchers("/studentInfo/edit/**").hasAnyAuthority("AM_FOOD,AM_DSE,AM_POMO,AM_CHAR")
		.antMatchers("/studentInfo/delete/**").hasAnyAuthority("AM_FOOD,AM_DSE,AM_POMO,AM_CHAR")
		.antMatchers("/studentInfo/view/**").hasAnyAuthority("AM_POMO,VE_POMO")
		.antMatchers("/studentInfo/major/**").hasAuthority("AM_MJ")
		.antMatchers("/parent/delete/outpasscheckinlist.htm/**").hasAuthority("AM_OutPass")
		.antMatchers("/parent/outpass/**").hasAuthority("AM_OutPass")
		.antMatchers("/parent/checkin/**").hasAuthority("AM_OutPass")
		.antMatchers("/payment/teacherPay.htm").hasAuthority("AM_TPAY_SALARY")
		.antMatchers("/payment/teacherPayTitle.htm").hasAnyAuthority("AM_TPAY_TITLE,VE_TPAY_TITLE")
		
		.antMatchers("/payment/monthlyPayList.htm").hasAuthority("AM_TPAY_TITLE,VE_TPAY_TITLE")
		.antMatchers("/**").fullyAuthenticated()
		.and().formLogin().loginPage("/user-login.htm").loginProcessingUrl("/login.htm").failureUrl("/user-login.htm?error=1").defaultSuccessUrl("/gettest.htm")
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

