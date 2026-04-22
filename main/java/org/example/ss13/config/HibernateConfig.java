package org.example.ss13.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class HibernateConfig {

    @Value("${spring.datasource.url}")
    private String datasourceUrl;

    @Value("${spring.datasource.username}")
    private String datasourceUsername;

    @Value("${spring.datasource.password}")
    private String datasourcePassword;

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Value("${hibernate.dialect:org.hibernate.dialect.MySQL8Dialect}")
    private String hibernateDialect;

    @Value("${hibernate.show_sql:true}")
    private String showSql;

    @Value("${hibernate.format_sql:true}")
    private String formatSql;

    @Value("${hibernate.hbm2ddl.auto:update}")
    private String hbm2ddlAuto;

    @Value("${hibernate.packagesToScan:org.example.session12.entity}")
    private String packagesToScan;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(datasourceUrl);
        dataSource.setUsername(datasourceUsername);
        dataSource.setPassword(datasourcePassword);
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(packagesToScan.split(","));

        Properties hibernateProperties = new Properties();
        hibernateProperties.put("hibernate.dialect", hibernateDialect);
        hibernateProperties.put("hibernate.show_sql", showSql);
        hibernateProperties.put("hibernate.format_sql", formatSql);
        hibernateProperties.put("hibernate.hbm2ddl.auto", hbm2ddlAuto);

        // Thuộc tính quan trọng cho Hibernate 6
        hibernateProperties.put("hibernate.current_session_context_class", "org.springframework.orm.hibernate5.SpringSessionContext");

        sessionFactory.setHibernateProperties(hibernateProperties);
        return sessionFactory;
    }
}