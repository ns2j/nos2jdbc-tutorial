package nos2jdbc.tutorial.spring;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import nos2jdbc.tutorial.spring.entity.Club;
import nos2jdbc.tutorial.spring.entity.ClubMemberRel;
import nos2jdbc.tutorial.spring.entity.LunchFee;
import nos2jdbc.tutorial.spring.entity.Member;
import nos2jdbc.tutorial.spring.service.ClubMemberRelService;
import nos2jdbc.tutorial.spring.service.ClubService;
import nos2jdbc.tutorial.spring.service.LunchFeeService;
import nos2jdbc.tutorial.spring.service.MemberService;

@Component
public class Data {
    @Autowired
    ClubService clubService;
    @Autowired
    MemberService memberService;
    @Autowired
    ClubMemberRelService relService;
    @Autowired
    LunchFeeService lfService;

    Club createClub(String name) {
        Club club = new Club();
        club.name = name;
        return club;
    }
    List<Club> getClubList() {
        List<Club> clubs = new ArrayList<>();
        clubs.add(createClub("野球"));
        clubs.add(createClub("サッカー"));
        clubs.add(createClub("吹奏楽"));
        return clubs;
    }

    Member createMember(String name) {
        Member member = new Member();
        member.name = name;
        return member;
    }

    List<Member> getMemberList() {
        List<Member> members = new ArrayList<>();
        members.add(createMember("太郎"));
        members.add(createMember("花子"));
        members.add(createMember("やぎ"));
        members.add(createMember("ねこ"));
        return members;
    }

    ClubMemberRel createRel(int co, int mo) {
        System.out.println(String.format("co: %d, mo: %d", co, mo));
        Club c = clubService.getByOrder(co - 1);
        Member m = memberService.getByOrder(mo - 1);
        ClubMemberRel rel = new ClubMemberRel();
        rel.clubId = c.id;
        rel.memberId = m.id;
        return rel;
    }
    List<ClubMemberRel> getRelList() {
        List<ClubMemberRel> rels = new ArrayList<>();
        rels.add(createRel(1, 1));
        rels.add(createRel(1, 2));
        rels.add(createRel(1, 3));
        rels.add(createRel(2, 2));
        rels.add(createRel(2, 3));
        rels.add(createRel(3, 3));
        return rels;
    }
    
    LunchFee createLunchFee(int mo, int y, int m, int d, String amountStr) {
        Member member = memberService.getByOrder(mo - 1);
        LunchFee lf = new LunchFee();
        lf.memberId = member.id;
        lf.payOn = LocalDate.of(y, m, d);
        lf.amount = new BigDecimal(amountStr);
        return lf;
    }
    List<LunchFee> getLunchFeeList() {
        List<LunchFee> lfs = new ArrayList<>();
        lfs.add(createLunchFee(1, 2020, 11, 24, "3000"));
        lfs.add(createLunchFee(1, 2020, 12, 23, "3001"));
        lfs.add(createLunchFee(1, 2021, 1, 22, "3002"));
        lfs.add(createLunchFee(1, 2021, 2, 21, "3003"));
        lfs.add(createLunchFee(2, 2020, 12, 21, "4000"));
        lfs.add(createLunchFee(2, 2021, 1, 22, "4001"));
        lfs.add(createLunchFee(2, 2021, 1, 28, "4002"));
        return lfs;
    }

    @Transactional
    public void insert() {
        if (clubService.findAll().size() == 0) {
            for (Club club: getClubList()) 
                clubService.insert(club);
        }
        if (memberService.findAll().size() == 0) {
            for (Member mem: getMemberList())
                memberService.insert(mem);
        }
        if (relService.findAll().size() == 0) {
            for (ClubMemberRel rel: getRelList())
                relService.insert(rel);
        }
        if (lfService.findAll().size() == 0) {
            for (LunchFee lf: getLunchFeeList())
                lfService.insert(lf);
        }
    }
}
