package nos2jdbc.tutorial.wildfly.config;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.seasar.extension.jdbc.DbmsDialect;
import org.seasar.extension.jdbc.JdbcManager;
import org.seasar.extension.jdbc.dialect.PostgreDialect;
import org.seasar.extension.jdbc.manager.JdbcManagerImpl;
import org.seasar.extension.jdbc.manager.JdbcManagerImplementor;

import jakarta.annotation.Resource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.inject.Produces;
import jakarta.transaction.TransactionManager;
import jakarta.transaction.TransactionSynchronizationRegistry;
import nos2jdbc.ManagerSetter;
import nos2jdbc.TransactionManagerRegistry;

@Dependent
public class Resources {
    @Resource
    private TransactionSynchronizationRegistry syncRegistry;

    @Resource(lookup = "java:/Ns2jDS")
    private DataSource dataSource;

    private DbmsDialect dialect = new PostgreDialect();

    static private JdbcManagerImpl jdbcManagerImpl;

  //GenerationType.TABLEを使わないときはいりません。
    @Resource(lookup="java:jboss/TransactionManager")
    private TransactionManager transactionManager;

    @Produces @ApplicationScoped
    public JdbcManager produceJdbcManager() throws SQLException {
        if (jdbcManagerImpl != null)
            return jdbcManagerImpl;
        jdbcManagerImpl = new JdbcManagerImpl();
	ManagerSetter.setToJdbcManagerImpl(jdbcManagerImpl, dataSource, dialect, syncRegistry);
	TransactionManagerRegistry.register(transactionManager);//GenerationType.TABLEを使わないときはいりません。
	return jdbcManagerImpl;
    }

    @Produces @ApplicationScoped
    public JdbcManagerImplementor produceJdbcManagerImplementor() throws SQLException {
        if (jdbcManagerImpl != null)
            return jdbcManagerImpl;
        jdbcManagerImpl = new JdbcManagerImpl();
	ManagerSetter.setToJdbcManagerImpl(jdbcManagerImpl, dataSource, dialect, syncRegistry);
	TransactionManagerRegistry.register(transactionManager);//GenerationType.TABLEを使わないときはいりません。
	return jdbcManagerImpl;
    }


}
