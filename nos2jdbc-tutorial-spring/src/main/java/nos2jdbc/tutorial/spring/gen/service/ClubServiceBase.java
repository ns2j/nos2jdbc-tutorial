package nos2jdbc.tutorial.spring.gen.service;

import java.util.List;
import javax.annotation.Generated;
import nos2jdbc.tutorial.spring.gen.entity.Club;

import static nos2jdbc.tutorial.spring.gen.entity.names.ClubNames.*;
import static org.seasar.extension.jdbc.operation.Operations.*;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * {@link Club}のサービスクラスです。
 * 
 */
@Generated(value = {"NOS2JDBC-Gen unknown", "org.seasar.extension.jdbc.gen.internal.model.ServiceModelFactoryImpl"}, date = "2018/03/07 14:16:14")
@Service
@Transactional
public class ClubServiceBase extends NoS2AbstractServiceBase<Club> {

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
}