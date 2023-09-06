package nos2jdbc.tutorial.wildfly.service;

import static nos2jdbc.tutorial.wildfly.gen.names.ClubNames.*;
import static org.seasar.extension.jdbc.operation.Operations.*;

import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.Dependent;
import jakarta.transaction.Transactional;
import nos2jdbc.tutorial.wildfly.entity.Club;
import nos2jdbc.tutorial.wildfly.gen.service.ClubServiceBase;

@Dependent
@Transactional
public class ClubService extends ClubServiceBase {
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
