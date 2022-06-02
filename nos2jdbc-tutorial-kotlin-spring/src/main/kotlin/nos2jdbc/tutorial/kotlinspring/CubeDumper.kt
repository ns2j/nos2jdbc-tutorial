package nos2jdbc.tutorial.kotlinspring

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import nos2jdbc.tutorial.kotlinspring.entity.Member
import nos2jdbc.tutorial.kotlinspring.entity.nonauto.rollup.Item
import nos2jdbc.tutorial.kotlinspring.entity.nonauto.rollup.Key
import nos2jdbc.tutorial.kotlinspring.service.LunchFeeService
import nos2jdbc.tutorial.kotlinspring.service.MemberService

@Component
class CubeDumper(val memberService: MemberService,    @Autowired
        val lfService: LunchFeeService) {

    var keys: List<Key> = mutableListOf()

    fun loadKeys() {
        keys = lfService.getCubeWithJoin() 
    }

    fun dumpCube() {
        println("")
        println("cube example")
        for (k: Key in keys)
            printWithFormat("(%s): (amount: %s, count: %d)",
                    "" + k, k.item!!.amount, k.item!!.count)
    }

    fun dumpCubeWithJoin() { 
        println("")
        println("year")
        for (y in 2020..2021)
            printWithFormat("year sum: %d: %s", y, getItemStr(y, null, null))

        println("")
        println("year month")
            for (y in 2020..2021)
                for (m in 1..12) {
                    val key: Key = Key(y, m, null)
                    if (findItem(key) != null)
                        printWithFormat("year month sum: %d %d: %s",
                            y, m, getItemStr(key))
                        }

        val mems: List<Member> = memberService.findAll() 
        println("")
        println("member year month")
        for (mem: Member in mems)
            for (y in 2020..2021)
                for (m in 1..12) {
                    val key: Key = Key(y, m, mem.id)
                    if (findItem(key) != null)
                        printWithFormat("member year month sum: %d-%s %d %d: %s",
                                mem.id, mem.name, y, m, getItemStr(key))
                }
        println("")
        println("member year")
        for (mem: Member in mems)
            for (y in 2020..2021)
                printWithFormat("member year sum: %d-%s %d: %s",
                        mem.id, mem.name, y, getItemStr(y, null, mem.id))

        println("")
        println("member")
        for (mem: Member in mems)
            printWithFormat("member sum: %d-%s: %s",
                    mem.id, mem.name, getItemStr(null, null, mem.id))

        println("")
        printWithFormat("grand sum: %s", getItemStr(null, null, null))
    }

    fun printWithFormat(format: String, vararg objs: Any?) {
        println(String.format(format, *objs))
    }

    fun findItem(key: Key) : Item? {
        for (k: Key in keys)
            if (k.equals(key))
                return k.item
        return null
    }
    fun getItemStr(y: Int?, m: Int?, memberId: Long?) : String {
        return getItemStr(Key(y, m, memberId))
    }
    fun getItemStr(key: Key) : String {
        val item: Item? = findItem(key)
        return if (item == null) "null" else String.format("(amount: %s, count: %d)", item.amount, item.count)
    }

}
