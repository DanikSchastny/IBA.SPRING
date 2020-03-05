package by.iba.schastny.config;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

import static by.iba.schastny.constants.ApplicationStringConstants.BASE_PACKAGES;
import static by.iba.schastny.constants.ApplicationStringConstants.HIBERNATE_PROPERTY_SOURCE;
import static by.iba.schastny.constants.ApplicationStringConstants.JDBC_PROPERTY_DRIVER_CLASSNAME;
import static by.iba.schastny.constants.ApplicationStringConstants.JDBC_PROPERTY_PASSWORD;
import static by.iba.schastny.constants.ApplicationStringConstants.JDBC_PROPERTY_URL;
import static by.iba.schastny.constants.ApplicationStringConstants.JDBC_PROPERTY_USERNAME;
import static by.iba.schastny.constants.ApplicationStringConstants.MODEL;

@Configuration
@ComponentScan(basePackages = BASE_PACKAGES)
@EnableTransactionManagement
@PropertySource(value = {HIBERNATE_PROPERTY_SOURCE})
public class HibernateConfig {
    private final static String HIBERNATE_DIALECT = "hibernate.dialect";
    private final static String HIBERNATE_SHOW_SQL = "hibernate.show_sql";

    private Environment environment;

    @Autowired
    public void setEnvironment(Environment environment){
        this.environment = environment;
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put(HIBERNATE_DIALECT, environment.getRequiredProperty(HIBERNATE_DIALECT));
        properties.put(HIBERNATE_SHOW_SQL, environment.getRequiredProperty(HIBERNATE_SHOW_SQL));
        return properties;
    }

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty(JDBC_PROPERTY_DRIVER_CLASSNAME));
        dataSource.setUrl(environment.getRequiredProperty(JDBC_PROPERTY_URL));
        dataSource.setUsername(environment.getRequiredProperty(JDBC_PROPERTY_USERNAME));
        dataSource.setPassword(environment.getRequiredProperty(JDBC_PROPERTY_PASSWORD));
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(BASE_PACKAGES + "/" + MODEL);
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }
}
