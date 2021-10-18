package nos2jdbc.tutorial.spring.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import nos2jdbc.tutorial.spring.entity.Club;

/**
 * {@link ClubService}のテストクラスです。
 * 
 */
@SpringBootTest
@Transactional
public class ClubServiceTest {

    @Autowired
    private ClubService clubService;

    @Test
    public void insert() {
        Club c = new Club();
        c.name = "test";
        clubService.insert(c);
    }
}