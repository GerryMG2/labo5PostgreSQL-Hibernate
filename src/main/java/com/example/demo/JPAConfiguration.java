package com.example.demo;



import java.util.Properties;

import javax.sql.DataSource;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class JPAConfiguration {
	
	@Bean
	public LocalContainerEntityManagerFactoryBean EntityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		
		em.setPersistenceUnitName("capas");
		em.setPackagesToScan("com.example.demo");
		
		JpaVendorAdapter vda = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vda);
		em.setJpaProperties(HibernateProperties());
		
	
		
		
		
		return em;
	}
	@Bean
	public DataSource dataSource() {
		System.out.println("url:");
		System.out.println(System.getenv("URI_POSTGRES"));
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl(System.getenv("URI_POSTGRES"));
		
		dataSource.setUsername(System.getenv("POSTGRES_USER"));
		dataSource.setPassword(System.getenv("POSTGRES_PASS"));
		
		return dataSource;
	}
	
	public Properties HibernateProperties () {
		Properties pro = new Properties();
		pro.setProperty("hibernate.show_sql", "true");
		pro.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		
		return pro;
		
	}

}
