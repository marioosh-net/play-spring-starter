package configs;

import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import play.Play;

@Configuration
@EnableTransactionManagement
public class DataConfig {

    @Bean
    public PlatformTransactionManager transactionManager() throws Exception {
    	return new HibernateTransactionManager(sessionFactory());
    }
    
    @Bean
    public SessionFactory sessionFactory() throws Exception {
    	AnnotationSessionFactoryBean sessionFactory = new AnnotationSessionFactoryBean();
    	sessionFactory.setPackagesToScan(new String[]{"dao.entity"});
    	sessionFactory.setDataSource(dataSource());
    	sessionFactory.setSchemaUpdate(true);
    	sessionFactory.afterPropertiesSet(); // important
    	return sessionFactory.getObject();
    }

    @Bean
    public DataSource dataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(Play.application().configuration().getString("db.default.driver"));
        dataSource.setUrl(Play.application().configuration().getString("db.default.url"));
        return dataSource;
    }

}