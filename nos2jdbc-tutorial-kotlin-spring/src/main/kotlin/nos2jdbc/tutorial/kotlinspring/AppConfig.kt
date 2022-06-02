package nos2jdbc.tutorial.kotlinspring

import org.springframework.transaction.annotation.EnableTransactionManagement
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.jta.JtaTransactionManager;
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Bean


import nos2jdbc.standalone.NoS2JdbcManager
import org.seasar.extension.jdbc.JdbcManager
import nos2jdbc.TransactionManagerRegistry
import org.seasar.extension.jdbc.manager.JdbcManagerImplementor

@EnableTransactionManagement
@Configuration
open class AppConfig {
    @Bean
    open fun getJdbcManager(): JdbcManager {
	return NoS2JdbcManager.getJdbcManager();
    }
    
	@Bean
    open fun getJdbcManagerImplementor(): JdbcManagerImplementor {
	return NoS2JdbcManager.getJdbcManager() as JdbcManagerImplementor
    }
     
    @Bean
    open fun getPlatformTransactionManager(): PlatformTransactionManager {
	println(TransactionManagerRegistry.get());
	return JtaTransactionManager(TransactionManagerRegistry.get());
    }
}