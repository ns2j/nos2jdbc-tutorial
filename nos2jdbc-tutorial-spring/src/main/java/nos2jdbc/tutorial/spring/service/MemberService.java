package nos2jdbc.tutorial.spring.service;

import java.util.List;
import javax.annotation.Generated;
import nos2jdbc.tutorial.spring.entity.Member;

import static nos2jdbc.tutorial.spring.entity.MemberNames.*;
import static org.seasar.extension.jdbc.operation.Operations.*;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * {@link Member}のサービスクラスです。
 * 
 */
@Generated(value = {"NOS2JDBC-Gen unknown", "org.seasar.extension.jdbc.gen.internal.model.ServiceModelFactoryImpl"}, date = "2017/07/06 16:30:08")
@Service
@Transactional
public class MemberService extends NoS2AbstractService<Member> {

    /**
     * 識別子でエンティティを検索します。
     * 
     * @param id
     *            識別子
     * @return エンティティ
     */
    public Member findById(Long id) {
        return select().id(id).getSingleResult();
    }

    /**
     * 識別子の昇順ですべてのエンティティを検索します。
     * 
     * @return エンティティのリスト
     */
    public List<Member> findAllOrderById() {
        return select().orderBy(asc(id())).getResultList();
    }

    public List<Member> findAllWithClubs() {
	return select()
		.leftOuterJoin(clubMemberRelList())
		.leftOuterJoin(clubMemberRelList().club())
		.getResultList();
    }
}