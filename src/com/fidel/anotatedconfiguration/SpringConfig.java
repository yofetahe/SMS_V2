package com.fidel.anotatedconfiguration;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;



@EnableWebMvc
@Configuration
@ComponentScan(basePackages="com.fidel")
public class SpringConfig extends WebMvcConfigurerAdapter {
	
	///*** EnableTransactionManagement --- enable spring's annotation-driven transaction management capability

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
	    registry.addResourceHandler("/Resources/**").addResourceLocations("/Resources/");
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer){
		
		configurer.enable();
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		
		registry.addViewController("/").setViewName("General/login");
	}
	
	@Bean
	public ViewResolver viewResolver(){
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/Modules/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
	
	@Bean(name = "dataSource")
	public DataSource dataSource(){
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3309/sms_everest_v2");//?useUnicode=yes&characterEncoding=UTF-8&connectionCollection=utf8_general_ci&characterSetResult=utf8
		dataSource.setUsername("root");
		dataSource.setPassword("P@55w0rd@yamget");
		
		return dataSource;
	}
	
	private Properties getHibernateProperties(){
		
		Properties properties = new Properties();
		
		properties.put("hibernate.show_sql", false);
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		
		return properties;
	}
	
	@Bean
	public AnnotationSessionFactoryBean sessionFactory(){
		
		AnnotationSessionFactoryBean sessionFactory = new AnnotationSessionFactoryBean();
		
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(new String[]{"com.fidel.sms.model"});
		sessionFactory.setHibernateProperties(getHibernateProperties());
		
		return sessionFactory;
	}
	
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory){
		
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		
		transactionManager.setSessionFactory(sessionFactory);
		
		return transactionManager;
	}
	

////>>> USED FOR HIBERNATE-4 <<<//
//	@Autowired
//	@Bean(name = "sessionFactory")
//	public SessionFactory getSessionFactory(DataSource dataSource){
//				
//		//LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
//		
//		///*** used for a specific class
//		//sessionBuilder.addAnnotatedClass(Users.class);
//		
//		///*** used for a specific class
//		//sessionBuilder.addAnnotatedClasses(Users.class, Object.class);
//		
//		///*** scan packages for annotated class
//		//sessionBuilder.scanPackages("com.fidel.dms.model");
//		
//		///*** set hibernate properties
//		//sessionBuilder.addProperties(getHibernateProperties());
//		
//		return sessionBuilder.buildSessionFactory();
//	}
//	@Autowired
//	@Bean(name = "transactionManager")
//	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory){
//		
//		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
//		
//		return transactionManager;
//	}
////>>> END - USED FOR HIBERNATE-4 <<<//

}
