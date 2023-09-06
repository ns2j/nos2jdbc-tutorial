package nos2jdbc.tutorial.wildfly.service;

import java.util.ArrayList;
import java.util.List;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import nos2jdbc.tutorial.wildfly.entity.Club;
import nos2jdbc.tutorial.wildfly.entity.ClubMemberRel;
import nos2jdbc.tutorial.wildfly.entity.Member;
import nos2jdbc.tutorial.wildfly.gen.service.ClubMemberRelServiceBase;

@Dependent
@Transactional
public class ClubMemberRelService extends ClubMemberRelServiceBase {
    @Inject
    ClubService clubService;

    @Inject
    MemberService memberService;

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
