package nos2jdbc.tutorial.kotlinspring.entity.nonauto.rollup

import javax.persistence.Entity
import javax.persistence.OneToOne

import nos2jdbc.annotation.NonAuto

@Entity @NonAuto
class Key() {
    constructor(y: Int?, m: Int?, memberId: Long?): this() {
	this.y = y
        this.m = m
        this.memberId = memberId
    }
    
    var y: Int? = null
    var m: Int? = null
    var memberId: Long? = null

    @OneToOne(mappedBy = "key")
    var item: Item? = null

    override
    fun hashCode() : Int {
        val y0: Int = y ?: 0
        val m0: Int = m ?: 0
        val memberId0: Long = memberId ?: 0
        val l0: Long = y0 + m0 + memberId0
        return l0.hashCode()
    }

    fun equalsInt(i1: Int?, i2: Int?) : Boolean {
        if (i1 == null && i2 == null) return true
        if (i1 == null && i2 != null) return false
        if (i1 != null && i2 == null) return false
        return i1!!.equals(i2)
    }

    fun equalsLong(l1: Long?, l2: Long?) : Boolean {
        if (l1 == null && l2 == null) return true
        if (l1 == null && l2 != null) return false
        if (l1 != null && l2 == null) return false
        return l1!!.equals(l2)
    }

    override
    fun equals(o: Any?) : Boolean {
        if (o == null) return false
        val k: Key = o as Key
        if (!equalsInt(y, k.y)) return false
        if (!equalsInt(m, k.m)) return false
        return equalsLong(memberId, k.memberId)
    }
    
    override
    fun toString() : String {
        return String.format("y: %d, m: %d, memberId: %d", y, m, memberId)
    }
}
