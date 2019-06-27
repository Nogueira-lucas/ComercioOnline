package br.com.resource.comercio.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class HibernateConfig {

	@Bean
	public LocalSessionFactoryBean sessionFactory(){
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan("br.com.resource.comercio.model");
		sessionFactory.setHibernateProperties(hibernatePropeties());
		
		return sessionFactory;
	}
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/dbcomercio");
		dataSource.setUsername("root");
		dataSource.setPassword("1234");
		
		return dataSource;
	}
	
	@Bean
	public HibernateTransactionManager getTransactionMananger() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
	}
	
	private final Properties hibernatePropeties() {
		Properties hibernatePropeties = new Properties();
		hibernatePropeties.setProperty("hibernate.hbm2ddl.auto", "update");
		hibernatePropeties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL55Dialect");
		hibernatePropeties.setProperty("hibernate.show_sql", "true");
		hibernatePropeties.setProperty("hibernate.jdbc.time_zone", "UTC");
		
		return hibernatePropeties;
	}
}
