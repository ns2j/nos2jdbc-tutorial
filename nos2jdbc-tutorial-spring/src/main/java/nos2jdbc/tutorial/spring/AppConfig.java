package nos2jdbc.tutorial.spring;

import org.seasar.extension.jdbc.JdbcManager;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;

import nos2jdbc.TransactionManagerRegistry;
import nos2jdbc.standalone.NoS2JdbcManager;

@EnableTransactionManagement
@Configuration
public class AppConfig {
    @Bean
    public JdbcManager getJdbcManager() {
	return NoS2JdbcManager.getJdbcManager();
    }
    
    @Bean
    public PlatformTransactionManager getPlatformTransactionManager() {
	return new JtaTransactionManager(TransactionManagerRegistry.get());
    }

    @Bean
    public ApplicationListener<ContextClosedEvent> closeListener() {
        return event -> NoS2JdbcManager.closeAll();
    }
}
