package nos2jdbc.tutorial.wildfly.service;

import static nos2jdbc.tutorial.wildfly.gen.names.MemberNames.*;
import static org.seasar.extension.jdbc.operation.Operations.*;

import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.Dependent;
import jakarta.transaction.Transactional;
import nos2jdbc.tutorial.wildfly.entity.Member;
import nos2jdbc.tutorial.wildfly.gen.service.MemberServiceBase;

@Dependent
@Transactional
public class MemberService extends MemberServiceBase {
    @Override
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
