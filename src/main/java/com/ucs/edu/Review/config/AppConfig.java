package com.ucs.edu.Review.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;


//@ComponentScan("com.ucs.edu.Review.*")
@Configuration
public class AppConfig {

	@Bean
	public TilesConfigurer tilesConfigurer() {
		final TilesConfigurer configurer = new TilesConfigurer();
		configurer.setDefinitions(new String[] { "WEB-INF/tiles/tiles.xml" });
		configurer.setCheckRefresh(true);
		return configurer;
	}

	@Bean
	public TilesViewResolver tilesViewResolver() {
		final TilesViewResolver resolver = new TilesViewResolver();
		resolver.setViewClass(TilesView.class);
		return resolver;
	}
	
	/*
	 * @Bean public FormattingConversionServiceFactoryBean conversionService(){
	 * FormattingConversionServiceFactoryBean conversionService=new
	 * FormattingConversionServiceFactoryBean(); return conversionService;
	 * 
	 * }
	 * 
	 * @Bean public ReloadableResourceBundleMessageSource messageSource() {
	 * 
	 * ReloadableResourceBundleMessageSource source = new
	 * ReloadableResourceBundleMessageSource();
	 * source.setBasename("classpath:messages"); source.setDefaultEncoding("UTF-8");
	 * source.setCacheSeconds(1); return source;
	 * 
	 * }
	 * 
	 * @Bean public MessageSource messagefuSource() { ResourceBundleMessageSource
	 * source = new ResourceBundleMessageSource(); source.setBasename("message");
	 * return source; }
	 * 
	 * @Bean public SessionLocaleResolver localeResolver() { SessionLocaleResolver
	 * localeResolver=new SessionLocaleResolver(); Locale zg= new Locale("en");
	 * //not really zawgyi ,myanmar language code is"my";
	 * localeResolver.setDefaultLocale(zg);; return localeResolver;
	 * 
	 * }
	 * 
	 * @Bean public LocaleChangeInterceptor localeChangeInterceptor() {
	 * LocaleChangeInterceptor local= new LocaleChangeInterceptor();
	 * local.setParamName("language"); return local;
	 * 
	 * }
	 * 
	 * @Bean public HttpFirewall allowUrlEncodedSlashHttpFirewall() {
	 * StrictHttpFirewall firewall = new StrictHttpFirewall();
	 * 
	 * firewall.setAllowUrlEncodedDoubleSlash(true); return firewall; }
	 * 
	 * // @Autowired // private EntityManagerFactory entityManagerFactory; //
	 * // @Bean // public SessionFactory sessionFactory() { // if
	 * (entityManagerFactory.unwrap(SessionFactory.class) == null) { // throw new
	 * NullPointerException("factory is not a hibernate factory"); // } // return
	 * entityManagerFactory.unwrap(SessionFactory.class); // }
	 * 
	 * @Bean public FilterRegistrationBean<CharacterEncodingFilter>
	 * filterRegistrationBean() { FilterRegistrationBean<CharacterEncodingFilter>
	 * registrationBean = new FilterRegistrationBean<CharacterEncodingFilter>();
	 * CharacterEncodingFilter characterEncodingFilter = new
	 * CharacterEncodingFilter(); characterEncodingFilter.setForceEncoding(true);
	 * characterEncodingFilter.setEncoding("UTF-8");
	 * 
	 * registrationBean.setFilter(characterEncodingFilter); return registrationBean;
	 * }
	 * 
	 * @Bean public CommonsMultipartResolver commonsMultipartResolver() {
	 * CommonsMultipartResolver commonsMultipartResolver=new
	 * CommonsMultipartResolver();
	 * commonsMultipartResolver.setMaxUploadSize(500000000);
	 * commonsMultipartResolver.setMaxInMemorySize(500000000); return
	 * commonsMultipartResolver; }
	 */
	
	@Bean
	public WebMvcConfigurer addResourceHandlers() {
		return new WebMvcConfigurer() {
			@Override
			public void addResourceHandlers(final ResourceHandlerRegistry registry) {
				registry.addResourceHandler("/resources/**")
			      .addResourceLocations("/resources/**","classpath:/static/");
				registry.addResourceHandler("/images/**")
			      .addResourceLocations("/images/**","/images/");
			
			}

		};
	}
}