package nos2jdbc.tutorial.wildfly.gen.service;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import nos2jdbc.tutorial.wildfly.gen.entity.Member;

import static nos2jdbc.tutorial.wildfly.gen.entity.names.MemberNames.*;
import static org.seasar.extension.jdbc.operation.Operations.*;

import javax.enterprise.context.Dependent;
import javax.transaction.Transactional;

/**
 * {@link Member}のサービスクラスです。
 * 
 */
@Generated(value = {"NOS2JDBC-Gen unknown", "org.seasar.extension.jdbc.gen.internal.model.ServiceModelFactoryImpl"}, date = "2017/07/12 15:34:20")
@Dependent
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
		.getResultListWithoutInverseField();
    }

    public Member getByOrder(int mo) {
	return select().orderBy(asc(id())).offset(mo).limit(1).getSingleResult();
    }

    protected Member createMember(String name) {
	Member member = new Member();
	member.name = name;
	return member;
    }
    protected List<Member> getMemberList() {
	List<Member> members = new ArrayList<>();
	members.add(createMember("太郎"));
	members.add(createMember("花子"));
	members.add(createMember("やぎ"));
	members.add(createMember("ねこ"));
	return members;
    }
    public void insertData() { 
	if (findAll().size() == 0)
	    for (Member mem: getMemberList())
		insert(mem);
    }
}
