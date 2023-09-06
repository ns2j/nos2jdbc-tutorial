package nos2jdbc.tutorial.wildfly.service;

import static nos2jdbc.tutorial.wildfly.gen.names.ClubNames.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.seasar.extension.jdbc.operation.Operations.*;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit5.ArquillianExtension;
import org.jboss.arquillian.transaction.api.annotation.Transactional;
import org.jboss.shrinkwrap.api.Archive;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.seasar.extension.jdbc.JdbcManager;

import jakarta.inject.Inject;
import nos2jdbc.tutorial.wildfly.ArchiveTestUtil;
import nos2jdbc.tutorial.wildfly.entity.Club;
/**
 * {@link ClubService}のテストクラスです。
 * 
 */
@ExtendWith(ArquillianExtension.class)
@Transactional
public class ClubServiceTest {

    @Inject
    private ClubService clubService;
    
    @Inject
    JdbcManager jdbcManager;

    @Test
    public void insert() {
        Club c = new Club();
        c.name = "test1";
        clubService.insert(c);
        
        Club actual = jdbcManager.from(Club.class).where(eq(name(), "test1")).getSingleResult();
        assertEquals("test1", actual.name);
    }
    
    @Deployment
    public static Archive<?> createTestArchive() {
	return ArchiveTestUtil.createTestArchive();
    }

}