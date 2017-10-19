package nos2jdbc.tutorial.wildfly.service;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

import nos2jdbc.tutorial.wildfly.entity.Club;
import nos2jdbc.tutorial.wildfly.entity.ClubMemberRel;
import nos2jdbc.tutorial.wildfly.entity.Member;

import static nos2jdbc.tutorial.wildfly.entity.ClubMemberRelNames.*;
import static org.seasar.extension.jdbc.operation.Operations.*;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 * {@link ClubMemberRel}のサービスクラスです。
 * 
 */
@Generated(value = {"NOS2JDBC-Gen unknown", "org.seasar.extension.jdbc.gen.internal.model.ServiceModelFactoryImpl"}, date = "2017/07/12 15:34:20")
@Dependent
@Transactional
public class ClubMemberRelService extends NoS2AbstractService<ClubMemberRel> {
    @Inject
    ClubService clubService;

    @Inject
    MemberService memberService;
    
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

    protected ClubMemberRel createRel(int co, int mo) {
	Club c = clubService.getByOrderer(co - 1);
	Member m = memberService.getByOrder(mo - 1);
	ClubMemberRel rel = new ClubMemberRel();
	rel.clubId = c.id;
	rel.memberId = m.id;
	return rel;
    }

    protected List<ClubMemberRel> getRelList() {
	List<ClubMemberRel> rels = new ArrayList<>();
	rels.add(createRel(1, 1));
	rels.add(createRel(1, 2));
	rels.add(createRel(1, 3));
	rels.add(createRel(2, 2));
	rels.add(createRel(2, 3));
	rels.add(createRel(3, 3));
	return rels;
    }

    public void insertData() {
	clubService.insertData();
	memberService.insertData();
	if (findAll().size() == 0)
	    for (ClubMemberRel rel: getRelList())
		insert(rel);
    }
}