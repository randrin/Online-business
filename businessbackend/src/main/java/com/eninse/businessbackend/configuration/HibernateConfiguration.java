package com.eninse.businessbackend.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.eninse.businessbackend.constants.Constants;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages={"com.eninse.businessbackend.dto"})
public class HibernateConfiguration {
	

	@Bean
	private DataSource getDataSource() {
		
		BasicDataSource basicDataSource = new BasicDataSource();
		
		basicDataSource.setUrl(Constants.DATASOURCE_URL);
		basicDataSource.setDriverClassName(Constants.DATASOURCE_DRIVER);
		basicDataSource.setUsername(Constants.DATASOURCE_USERNAME);
		basicDataSource.setPassword(Constants.DATASOURCE_PWD);
		
		return basicDataSource;
	}
	
	@Bean
	private SessionFactory getSessionFactory(DataSource datasource) {
		
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(datasource);
		builder.addProperties(getProperties());
		builder.scanPackages("com.eninse.businessbackend.dto");
		return builder.buildSessionFactory();
		
	}

	private Properties getProperties() {
		Properties pro = new Properties();
		pro.put("hibernate.dialect", Constants.DATASOURCE_DIALECT);
		pro.put("hibernate.show_sql", "true");
		pro.put("hibernate.format_sql", "true");
		return pro;
	}
	
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		
		HibernateTransactionManager hinernate = new HibernateTransactionManager(sessionFactory);
		
		return hinernate;
		
	}
}