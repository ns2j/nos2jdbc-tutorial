package nos2jdbc.tutorial.spring.service;

import java.util.List;
import javax.annotation.Generated;
import nos2jdbc.tutorial.spring.entity.Club;

import static nos2jdbc.tutorial.spring.entity.ClubNames.*;
import static org.seasar.extension.jdbc.operation.Operations.*;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * {@link Club}のサービスクラスです。
 * 
 */
@Generated(value = {"NOS2JDBC-Gen unknown", "org.seasar.extension.jdbc.gen.internal.model.ServiceModelFactoryImpl"}, date = "2017/07/06 16:30:08")
@Service
@Transactional
public class ClubService extends NoS2AbstractService<Club> {

    /**
     * 識別子でエンティティを検索します。
     * 
     * @param id
     *            識別子
     * @return エンティティ
     */
    public Club findById(Long id) {
        return select().id(id).getSingleResult();
    }

    /**
     * 識別子の昇順ですべてのエンティティを検索します。
     * 
     * @return エンティティのリスト
     */
    public List<Club> findAllOrderById() {
        return select().orderBy(asc(id())).getResultList();
    }
    
    public List<Club> findAllWithMembers() {
	return select()
		.leftOuterJoin(clubMemberRelList())
		.leftOuterJoin(clubMemberRelList().member())
		.getResultList();
    }
    
    public void onlyWait() {
	Club c = new Club();
	c.name = "abcdefgh";
	insert(c);
	try {
	    Thread.sleep(5000);
	} catch (InterruptedException ie) {
	}
//	throw new RuntimeException("test exception");
    }
    
    public void doNothing() {
	findAll();
    }

}