package nos2jdbc.tutorial.wildfly.gen.service;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import nos2jdbc.tutorial.wildfly.gen.entity.Club;
import nos2jdbc.tutorial.wildfly.gen.entity.ClubMemberRel;
import nos2jdbc.tutorial.wildfly.gen.entity.Member;

import static nos2jdbc.tutorial.wildfly.gen.entity.names.ClubNames.*;
import static org.seasar.extension.jdbc.operation.Operations.*;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 * {@link Club}のサービスクラスです。
 * 
 */
@Generated(value = {"NOS2JDBC-Gen unknown", "org.seasar.extension.jdbc.gen.internal.model.ServiceModelFactoryImpl"}, date = "2017/07/12 15:34:20")
@Dependent
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
		.getResultListWithoutInverseField();
    }
    
    public Club getByOrderer(int co) {
	return select().orderBy(asc(id())).offset(co).limit(1).getSingleResult();
    }

    protected Club createClub(String name) {
	Club club = new Club();
	club.name = name;
	return club;
    }
    protected List<Club> getClubList() {
	List<Club> clubs = new ArrayList<>();
	clubs.add(createClub("野球"));
	clubs.add(createClub("サッカー"));
	clubs.add(createClub("吹奏楽"));
	return clubs;
    }
    
    public void insertData() {
	if (findAll().size() == 0)
	    for (Club club: getClubList()) 
		insert(club);
    }
}
