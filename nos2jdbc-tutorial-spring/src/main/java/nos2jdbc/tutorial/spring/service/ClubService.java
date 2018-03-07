package nos2jdbc.tutorial.spring.service;

import java.util.List;
import nos2jdbc.tutorial.spring.gen.entity.Club;
import nos2jdbc.tutorial.spring.gen.service.ClubServiceBase;

import static nos2jdbc.tutorial.spring.gen.entity.names.ClubNames.*;
import static org.seasar.extension.jdbc.operation.Operations.*;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ClubService extends ClubServiceBase {
    public List<Club> findAllWithMembers() {
	return select()
		.leftOuterJoin(clubMemberRelList())
		.leftOuterJoin(clubMemberRelList().member())
		.getResultList();
    }
    
    public Club getByOrderer(int co) {
	return select().orderBy(asc(id())).offset(co).limit(1).getSingleResult();
    }

}
