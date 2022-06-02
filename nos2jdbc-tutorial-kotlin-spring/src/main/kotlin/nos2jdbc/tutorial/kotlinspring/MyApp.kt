package nos2jdbc.tutorial.kotlinspring

import java.util.ArrayList

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

import nos2jdbc.tutorial.kotlinspring.entity.nonauto.rollup.Key
import nos2jdbc.tutorial.kotlinspring.entity.nonauto.rollup.Item
import nos2jdbc.tutorial.kotlinspring.entity.Club
import nos2jdbc.tutorial.kotlinspring.entity.ClubMemberRel
import nos2jdbc.tutorial.kotlinspring.entity.Member
import nos2jdbc.tutorial.kotlinspring.service.ClubMemberRelService
import nos2jdbc.tutorial.kotlinspring.service.ClubService
import nos2jdbc.tutorial.kotlinspring.service.MemberService
import nos2jdbc.tutorial.kotlinspring.service.LunchFeeService
import java.nio.channels.MembershipKey
import nos2jdbc.tutorial.kotlinspring.entity.nonauto.Ym
import nos2jdbc.tutorial.kotlinspring.entity.nonauto.YmItem
import nos2jdbc.tutorial.kotlinspring.entity.nonauto.MemberKey
import nos2jdbc.tutorial.kotlinspring.entity.nonauto.MemberItem
import nos2jdbc.tutorial.kotlinspring.entity.nonauto.MemberYm

@Component
open class MyApp(protected val clubService: ClubService,
		 protected val memberService: MemberService,
		 protected val relService: ClubMemberRelService,
		 protected val lfService: LunchFeeService) {
    fun dump() {
	for (club in clubService.findAllWithMembers()) {
	    println("*" + club.name + "*")
	    println("club size: " + club.clubMemberRelList.size)
	    club.clubMemberRelList.forEach{
		    println(" " + it.member?.name)}
	}
	println("")
	for (mem in memberService.findAllWithClubs()) {
	    println("+" + mem.name + "+")
	    mem.clubMemberRelList.forEach{
		    println(" " + it.club?.name)}
	}
    }


    fun dumpSqlSelect() {
        println("")
        for (ym: Ym in lfService.getYm()) {
            printWithFormat("y: %d, m: %d", ym.y, ym.m)
            for (i: YmItem in ym.itemList) {
                printWithFormat("    member: %s, payOn: %s, amount: %s", i.member!!.memberName, i.payOn, i.amount)
            }
        }
        println("")
        for (mk: MemberKey in lfService.getMember()) {
            printWithFormat("memberId: %d, memberNmae: %s", mk.memberId, mk.memberName)
            for (ym: MemberYm in mk.ymList) {
                printWithFormat("    y: %d, m: %d", ym.y, ym.m)
                for (mi: MemberItem in ym.itemList) {
                    printWithFormat("        lunchFeeId: %d, payOn: %s, amount: %s", mi.lunchFeeId, mi.payOn, mi.amount)
                }
            }
        }
    }
    
    fun dumpRollup() {
        println("")
        println("rollup example")
        for (k: Key in lfService.getRollup())
            printWithFormat("(%s): (amount: %s, count: %d))", "" + k, k.item!!.amount, k.item!!.count)
        println("")
        println("rollup example2")
        for (k: Key in lfService.getRollup2())
            printWithFormat("(%s): (amount: %s, count: %d))", "" + k, k.item!!.amount, k.item!!.count)
        println("")
        println("rollup example3")
        for (k: Key in lfService.getRollup3())
            printWithFormat("(%s): (amount: %s, count: %d))", "" + k, k.item!!.amount, k.item!!.count)
        println("")
        println("cube example")
        for (k: Key in lfService.getCube())
            printWithFormat("(%s): (amount: %s, count: %d))", "" + k, k.item!!.amount, k.item!!.count)
    }

    private fun printWithFormat(format: String, vararg args: Any?) {
        println(String.format(format, *args))
    }
}
