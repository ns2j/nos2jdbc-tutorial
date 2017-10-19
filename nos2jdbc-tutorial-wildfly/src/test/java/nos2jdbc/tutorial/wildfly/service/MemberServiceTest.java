package nos2jdbc.tutorial.wildfly.service;

import javax.annotation.Generated;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;

import nos2jdbc.tutorial.wildfly.ArchiveTestUtil;

/**
 * {@link MemberService}のテストクラスです。
 * 
 */
@RunWith(Arquillian.class)
@Generated(value = {"NOS2JDBC-Gen unknown", "org.seasar.extension.jdbc.gen.internal.model.ServiceTestModelFactoryImpl"}, date = "2017/10/16 13:28:44")
public class MemberServiceTest {

    @Inject
    private MemberService memberService;

    /**
     * {@link #memberService}が利用可能であることをテストします。
     * 
     * @throws Exception
     */
    @Test
    public void testAvailable() throws Exception {
        assertNotNull(memberService);
    }
    
    @Deployment
    public static Archive<?> createTestArchive() {
	return ArchiveTestUtil.createTestArchive();
    }

}