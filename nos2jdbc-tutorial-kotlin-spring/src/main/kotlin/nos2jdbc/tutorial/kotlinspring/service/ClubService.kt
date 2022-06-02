package nos2jdbc.tutorial.kotlinspring.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import nos2jdbc.tutorial.kotlinspring.entity.Club
import nos2jdbc.tutorial.kotlinspring.gen.service.ClubServiceBase

import nos2jdbc.tutorial.kotlinspring.gen.names.ClubNames.*
import org.seasar.extension.jdbc.operation.Operations.*


@Service
@Transactional
class ClubService(): ClubServiceBase() {
	
    public fun findAllWithMembers(): List<Club> {
	return select()
		.leftOuterJoin(clubMemberRelList())
		.leftOuterJoin(clubMemberRelList().member())
		.getResultList();
    }
    
    public fun getByOrderer(co: Int): Club {
	
	return select().orderBy(asc(id())).offset(co).limit(1).getSingleResult();
    }
}