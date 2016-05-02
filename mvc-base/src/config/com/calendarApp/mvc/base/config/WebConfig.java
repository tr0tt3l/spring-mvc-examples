package com.calendarApp.mvc.base.config;

import com.calendarApp.mvc.service.EventDAO;
import com.calendarApp.mvc.service.EventDAOImpl;
import com.calendarApp.mvc.service.EventService;
import com.calendarApp.mvc.service.EventServiceImpl;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.Properties;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.calendarApp.mvc.base.controller"})
public class WebConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("lang");
		registry.addInterceptor(localeChangeInterceptor);
	}

	@Bean
	public LocaleResolver localeResolver() {

		CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
		cookieLocaleResolver.setDefaultLocale(StringUtils.parseLocaleString("en"));
		return cookieLocaleResolver;
	}

	@Bean
	public ViewResolver viewResolver() {

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Bean
	public MessageSource messageSource() {

		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasenames("classpath:messages/messages", "classpath:messages/validation");
		messageSource.setUseCodeAsDefaultMessage(true);
		messageSource.setDefaultEncoding("UTF-8");
		messageSource.setCacheSeconds(0);
		return messageSource;
	}
	@Bean
	public BasicDataSource dataSource(){
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/CalendarDB");
		dataSource.setUsername("root");
		dataSource.setPassword("calendar");

		return dataSource;
	}

	@Bean
	public LocalSessionFactoryBean hibernate4AnnotatedSessionFactory(){
		LocalSessionFactoryBean hibernate4AnnotatedSessionFactory = new LocalSessionFactoryBean();
		hibernate4AnnotatedSessionFactory.setDataSource(dataSource());
		//TODO: Modelliste implementieren
		hibernate4AnnotatedSessionFactory.setAnnotatedClasses(com.calendarApp.mvc.base.model.Event.class);
		Properties hibernateProperty = new Properties();
		hibernateProperty.setProperty("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
		hibernateProperty.setProperty("hibernate.show_sql","true");
		hibernate4AnnotatedSessionFactory.setHibernateProperties(hibernateProperty);

		return hibernate4AnnotatedSessionFactory;
	}

	@Bean
	public EventDAO eventDAO(){
		EventDAO eventDAO = new EventDAOImpl();
		eventDAO.setSessionFactory((SessionFactory)hibernate4AnnotatedSessionFactory()); //// Typecast fragwürdig. Zudem sollte setSessionFactory nicht in der abstrakten Klasse bekannt gemacht sein

		return eventDAO;
	}

	@Bean
	public EventService eventService(){
		EventService eventService = new EventServiceImpl();
		eventService.setEventDAO(eventDAO());
		return eventService;
	}

/*	@Bean
	public CommonsMultipartResolver multipartResolver() {

		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		return multipartResolver;
	}
*/
}