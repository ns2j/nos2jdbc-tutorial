package nos2jdbc.tutorial.spring;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import nos2jdbc.tutorial.spring.entity.Club;
import nos2jdbc.tutorial.spring.entity.ClubMemberRel;
import nos2jdbc.tutorial.spring.entity.Member;
import nos2jdbc.tutorial.spring.entity.nonauto.MemberItem;
import nos2jdbc.tutorial.spring.entity.nonauto.MemberKey;
import nos2jdbc.tutorial.spring.entity.nonauto.MemberYm;
import nos2jdbc.tutorial.spring.entity.nonauto.Ym;
import nos2jdbc.tutorial.spring.entity.nonauto.YmItem;
import nos2jdbc.tutorial.spring.entity.nonauto.rollup.Key;
import nos2jdbc.tutorial.spring.service.ClubMemberRelService;
import nos2jdbc.tutorial.spring.service.ClubService;
import nos2jdbc.tutorial.spring.service.LunchFeeService;
import nos2jdbc.tutorial.spring.service.MemberService;

@Component
public class MyApp {
    @Autowired
    ClubService clubService;
    @Autowired
    MemberService memberService;
    @Autowired
    ClubMemberRelService relService;
    @Autowired
    LunchFeeService lfService;

    
    public void dump() {
        for (Club club: clubService.findAllWithMembers()) {
            System.out.println(club.name);
            for (ClubMemberRel rel: club.clubMemberRelList) {
                System.out.println("--" + rel.member.name);
            }
        }
        System.out.println("");
        for (Member mem: memberService.findAllWithClubs()) {
            System.out.println(mem.name);
            for (ClubMemberRel rel: mem.clubMemberRelList) {
                System.out.println("--" + rel.club.name);
            }
        }
    }

    public void dumpSqlSelect() {
        System.out.println("");
        for (Ym ym: lfService.getYm()) {
            printWithFormat("y: %d, m: %d", ym.y, ym.m);
            for (YmItem i: ym.itemList) {
                printWithFormat("    member: %s, payOn: %s, amount: %s", i.member.memberName, i.payOn, i.amount);
            }
        }
        System.out.println("");
        for (MemberKey mk: lfService.getMember()) {
            printWithFormat("memberId: %d, memberNmae: %s", mk.memberId, mk.memberName);
            for (MemberYm ym: mk.ymList) {
                printWithFormat("    y: %d, m: %d", ym.y, ym.m);
                for (MemberItem mi: ym.itemList) {
                    printWithFormat("        lunchFeeId: %d, payOn: %s, amount: %s", mi.lunchFeeId, mi.payOn, mi.amount);
                }
            }
        }
    }
    
    public void dumpRollup() {
        System.out.println("");
        System.out.println("rollup example");
        for (Key k: lfService.getRollup())
            printWithFormat("(%s): (amount: %s, count: %d))", "" + k, k.item.amount, k.item.count);
        System.out.println("");
        System.out.println("rollup example2");
        for (Key k: lfService.getRollup2())
            printWithFormat("(%s): (amount: %s, count: %d))", "" + k, k.item.amount, k.item.count);
        System.out.println("");
        System.out.println("rollup example3");
        for (Key k: lfService.getRollup3())
            printWithFormat("(%s): (amount: %s, count: %d))", "" + k, k.item.amount, k.item.count);
        System.out.println("");
        System.out.println("cube example");
        for (Key k: lfService.getCube())
            printWithFormat("(%s): (amount: %s, count: %d))", "" + k, k.item.amount, k.item.count);
    }

    void printWithFormat(String format, Object...objs) {
        System.out.println(String.format(format, objs));
    }
}
