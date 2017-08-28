package nos2jdbc.tutorial.spring.entity;

import javax.annotation.Generated;
import org.seasar.extension.jdbc.JdbcManager;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static nos2jdbc.tutorial.spring.entity.ClubNames.*;

/**
 * {@link Club}のテストクラスです。
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {nos2jdbc.tutorial.spring.AppConfig.class})
@Generated(value = {"NOS2JDBC-Gen unknown", "org.seasar.extension.jdbc.gen.internal.model.EntityTestModelFactoryImpl"}, date = "2017/07/12 15:10:02")
public class ClubTest {
    @Autowired
    private JdbcManager jdbcManager;

    /**
     * 識別子による取得をテストします。
     * 
     * @throws Exception
     */
    @Test
    public void testFindById() throws Exception {
        jdbcManager.from(Club.class).id(1L).getSingleResult();
    }

    /**
     * clubMemberRelListとの外部結合をテストします。
     * 
     * @throws Exception
     */
    @Test
    public void testLeftOuterJoin_clubMemberRelList() throws Exception {
        jdbcManager.from(Club.class).leftOuterJoin(clubMemberRelList()).id(1L).getSingleResult();
    }

}