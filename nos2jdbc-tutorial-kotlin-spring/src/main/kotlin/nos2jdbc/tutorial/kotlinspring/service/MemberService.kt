package nos2jdbc.tutorial.kotlinspring.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import nos2jdbc.tutorial.kotlinspring.entity.Member
import nos2jdbc.tutorial.kotlinspring.gen.service.MemberServiceBase

import nos2jdbc.tutorial.kotlinspring.gen.names.MemberNames.*
import org.seasar.extension.jdbc.operation.Operations.*


@Service
@Transactional
class MemberService(): MemberServiceBase() {
    public fun findAllWithClubs(): List<Member> {
	return select()
		.leftOuterJoin(clubMemberRelList())
		.leftOuterJoin(clubMemberRelList().club())
		.getResultList();
    }

    public fun getByOrder(mo: Int): Member {
	return select().orderBy(asc(id())).offset(mo).limit(1).getSingleResult();
    }
}