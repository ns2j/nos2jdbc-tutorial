package nos2jdbc.tutorial.spring;

import org.seasar.extension.jdbc.JdbcManager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;

import nos2jdbc.TransactionManagerRegistry;
import nos2jdbc.standalone.NoS2JdbcManager;

@EnableTransactionManagement
@Configuration
//@ComponentScan(basePackages = "nos2jdbc.tutorial.spring", scopeResolver = Jsr330ScopeMetadataResolver.class)
@ComponentScan(basePackages = "nos2jdbc.tutorial.spring")
public class AppConfig {
    @Bean
    public MyApp myApp() {
        return new MyApp();
    }
    @Bean
    public JdbcManager getJdbcManager() {
	return NoS2JdbcManager.getJdbcManager();
    }
    
    @Bean
    public PlatformTransactionManager getPlatformTransactionManager() {
	System.out.println(TransactionManagerRegistry.get());
	return new JtaTransactionManager(TransactionManagerRegistry.get());
    }
}
