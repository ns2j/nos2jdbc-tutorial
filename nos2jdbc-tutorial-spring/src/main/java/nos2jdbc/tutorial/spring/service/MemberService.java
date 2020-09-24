package nos2jdbc.tutorial.spring.service;

import java.util.List;

import nos2jdbc.tutorial.spring.entity.Member;
import nos2jdbc.tutorial.spring.gen.service.MemberServiceBase;

import static nos2jdbc.tutorial.spring.gen.names.MemberNames.*;
import static org.seasar.extension.jdbc.operation.Operations.*;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MemberService extends MemberServiceBase {
    public List<Member> findAllWithClubs() {
	return select()
		.leftOuterJoin(clubMemberRelList())
		.leftOuterJoin(clubMemberRelList().club())
		.getResultList();
    }

    public Member getByOrder(int mo) {
	return select().orderBy(asc(id())).offset(mo).limit(1).getSingleResult();
    }
}
