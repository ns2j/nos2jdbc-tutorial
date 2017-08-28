package nos2jdbc.tutorial.spring.service;

import java.util.List;
import javax.annotation.Generated;
import nos2jdbc.tutorial.spring.entity.ClubMemberRel;

import static nos2jdbc.tutorial.spring.entity.ClubMemberRelNames.*;
import static org.seasar.extension.jdbc.operation.Operations.*;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * {@link ClubMemberRel}のサービスクラスです。
 * 
 */
@Generated(value = {"NOS2JDBC-Gen unknown", "org.seasar.extension.jdbc.gen.internal.model.ServiceModelFactoryImpl"}, date = "2017/07/20 16:55:48")
@Service
@Transactional
public class ClubMemberRelService extends NoS2AbstractService<ClubMemberRel> {

    /**
     * 識別子でエンティティを検索します。
     * 
     * @param clubId
     *            識別子
     * @param memberId
     *            識別子
     * @return エンティティ
     */
    public ClubMemberRel findById(Long clubId, Long memberId) {
        return select().id(clubId, memberId).getSingleResult();
    }

    /**
     * 識別子の昇順ですべてのエンティティを検索します。
     * 
     * @return エンティティのリスト
     */
    public List<ClubMemberRel> findAllOrderById() {
        return select().orderBy(asc(clubId()), asc(memberId())).getResultList();
    }
}