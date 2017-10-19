package nos2jdbc.tutorial.wildfly.entity;

import javax.annotation.Generated;
import org.seasar.extension.jdbc.JdbcManager;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;

import nos2jdbc.tutorial.wildfly.ArchiveTestUtil;

import static nos2jdbc.tutorial.wildfly.entity.MemberNames.*;

/**
 * {@link Member}のテストクラスです。
 * 
 */
@RunWith(Arquillian.class)
@Generated(value = {"NOS2JDBC-Gen unknown", "org.seasar.extension.jdbc.gen.internal.model.EntityTestModelFactoryImpl"}, date = "2017/10/16 13:28:43")
public class MemberTest {
    @Inject
    private JdbcManager jdbcManager;

    /**
     * 識別子による取得をテストします。
     * 
     * @throws Exception
     */
    @Test
    public void testFindById() throws Exception {
        jdbcManager.from(Member.class).id(1L).getSingleResult();
    }

    /**
     * clubMemberRelListとの外部結合をテストします。
     * 
     * @throws Exception
     */
    @Test
    public void testLeftOuterJoin_clubMemberRelList() throws Exception {
        jdbcManager.from(Member.class).leftOuterJoin(clubMemberRelList()).id(1L).getSingleResult();
    }

    @Deployment
    public static Archive<?> createTestArchive() {
	return ArchiveTestUtil.createTestArchive();
    }
}