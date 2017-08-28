package nos2jdbc.tutorial.spring.entity;

import javax.annotation.Generated;
import org.seasar.extension.jdbc.JdbcManager;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static nos2jdbc.tutorial.spring.entity.ClubMemberRelNames.*;

/**
 * {@link ClubMemberRel}のテストクラスです。
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {nos2jdbc.tutorial.spring.AppConfig.class})
@Generated(value = {"NOS2JDBC-Gen unknown", "org.seasar.extension.jdbc.gen.internal.model.EntityTestModelFactoryImpl"}, date = "2017/07/12 15:10:02")
public class ClubMemberRelTest {
    @Autowired
    private JdbcManager jdbcManager;

    /**
     * 識別子による取得をテストします。
     * 
     * @throws Exception
     */
    @Test
    public void testFindById() throws Exception {
        jdbcManager.from(ClubMemberRel.class).id(1L, 1L).getSingleResult();
    }

    /**
     * clubとの外部結合をテストします。
     * 
     * @throws Exception
     */
    @Test
    public void testLeftOuterJoin_club() throws Exception {
        jdbcManager.from(ClubMemberRel.class).leftOuterJoin(club()).id(1L, 1L).getSingleResult();
    }

    /**
     * memberとの外部結合をテストします。
     * 
     * @throws Exception
     */
    @Test
    public void testLeftOuterJoin_member() throws Exception {
        jdbcManager.from(ClubMemberRel.class).leftOuterJoin(member()).id(1L, 1L).getSingleResult();
    }

}