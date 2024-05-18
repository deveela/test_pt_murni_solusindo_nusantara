package test.msn.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


@Configuration
@EnableTransactionManagement
@ComponentScan({"test.msn"})
public class HibernateConfig {

    @Autowired
    private ApplicationContext context;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(dbConfig().getProperty("driverClassname"));
        dataSource.setUrl(dbConfig().getProperty("url"));
        dataSource.setUsername(dbConfig().getProperty("username"));
        dataSource.setPassword(dbConfig().getProperty("password"));

        return dataSource;
    }

    private final Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        hibernateProperties.setProperty("hibernate.connection.driver_class", dbConfig().getProperty("driverClassname"));
        hibernateProperties.setProperty("hibernate.connection.url", dbConfig().getProperty("url"));
        hibernateProperties.setProperty("hibernate.connection.username", dbConfig().getProperty("username"));
        hibernateProperties.setProperty("hibernate.connection.password", dbConfig().getProperty("password"));

        return hibernateProperties;
    }

    private final Properties dbConfig() {
        Properties properties = new Properties();
        String configFile = "/home/backend/workspace/java/springSecurity/app.config";
        try {
            FileInputStream fs = new FileInputStream(configFile);
            properties.load(fs);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return properties;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("test.msn");
        sessionFactory.setHibernateProperties(hibernateProperties());

        return sessionFactory;
    }

    @Bean
    public HibernateTransactionManager getTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());

        return transactionManager;
    }


}
