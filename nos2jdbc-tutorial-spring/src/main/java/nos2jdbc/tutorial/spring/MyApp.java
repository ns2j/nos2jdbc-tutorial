package nos2jdbc.tutorial.spring;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import nos2jdbc.tutorial.spring.entity.Club;
import nos2jdbc.tutorial.spring.entity.ClubMemberRel;
import nos2jdbc.tutorial.spring.entity.Member;
import nos2jdbc.tutorial.spring.service.ClubMemberRelService;
import nos2jdbc.tutorial.spring.service.ClubService;
import nos2jdbc.tutorial.spring.service.MemberService;

public class MyApp {
    @Autowired
    protected ClubService clubService;
    @Autowired
    protected MemberService memberService;
    @Autowired
    protected ClubMemberRelService relService;
    
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

    protected ClubMemberRel createRel(long cid, long mid) {
	ClubMemberRel rel = new ClubMemberRel();
	rel.clubId = cid;
	rel.memberId = mid;
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
    
    @Transactional
    public void insertData() {
	if (clubService.findAll().size() == 0)
	    for (Club club: getClubList()) 
		clubService.insert(club);
	if (memberService.findAll().size() == 0)
	    for (Member mem: getMemberList())
		memberService.insert(mem);
	if (relService.findAll().size() == 0)
	    for (ClubMemberRel rel: getRelList())
		relService.insert(rel);
    }

    public void dump() {
	for (Club club: clubService.findAllWithMembers()) {
	    System.out.println("*" + club.name + "*");
	    for (ClubMemberRel rel: club.clubMemberRelList) {
		System.out.println(" " + rel.member.name);
	    }
	}
	System.out.println("");
	for (Member mem: memberService.findAllWithClubs()) {
	    System.out.println("+" + mem.name + "+");
	    for (ClubMemberRel rel: mem.clubMemberRelList) {
		System.out.println(" " + rel.club.name);
	    }
	}
    }

}
