package nos2jdbc.tutorial.spring.service;

import javax.annotation.Generated;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * {@link ClubService}のテストクラスです。
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {nos2jdbc.tutorial.spring.AppConfig.class})
@Generated(value = {"NOS2JDBC-Gen unknown", "org.seasar.extension.jdbc.gen.internal.model.ServiceTestModelFactoryImpl"}, date = "2017/07/12 15:10:02")
public class ClubServiceTest {

    @Autowired
    private ClubService clubService;

    /**
     * {@link #clubService}が利用可能であることをテストします。
     * 
     * @throws Exception
     */
    @Test
    public void testAvailable() throws Exception {
        assertNotNull(clubService);
    }
    

}