package nos2jdbc.tutorial.wildfly.config;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;
import javax.transaction.TransactionManager;
import javax.transaction.TransactionSynchronizationRegistry;
import javax.transaction.UserTransaction;

import org.seasar.extension.jdbc.DbmsDialect;
import org.seasar.extension.jdbc.JdbcManager;
import org.seasar.extension.jdbc.dialect.PostgreDialect;
import org.seasar.extension.jdbc.manager.JdbcManagerImpl;

import nos2jdbc.ManagerSetter;
import nos2jdbc.TransactionManagerRegistry;

@Dependent
public class Resources {
    @Resource
    private TransactionSynchronizationRegistry syncRegistry;

    @Resource(lookup = "java:/Ns2jTutorial")
    private DataSource dataSource;

    private DbmsDialect dialect = new PostgreDialect();

    static private JdbcManager jdbcManager;

  //GenerationType.TABLEを使わないときはいりません。
    @Resource(lookup="java:jboss/TransactionManager")
    private TransactionManager transactionManager;

    @Produces @ApplicationScoped
    public JdbcManager produceJdbcManager() throws SQLException {
	JdbcManagerImpl jdbcManagerImpl = new JdbcManagerImpl();
	ManagerSetter.setToJdbcManagerImpl(jdbcManagerImpl, dataSource, dialect, syncRegistry);
	jdbcManager = jdbcManagerImpl;
	TransactionManagerRegistry.register(transactionManager);//GenerationType.TABLEを使わないときはいりません。
	return jdbcManager;
    }
}
