package nos2jdbc.tutorial.kotlinspring.entity.nonauto

import java.math.BigDecimal
import java.time.LocalDate

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.Transient

import nos2jdbc.annotation.NoFk
import nos2jdbc.annotation.NonAuto

@Entity @NonAuto
class MemberItem {
    @Id
    var lunchFeeId: Long? = null
    var payOn: LocalDate? = null
    var amount: BigDecimal = BigDecimal.ZERO
    var count: Int = 0
    
    @Transient @ManyToOne @NoFk
    var ym: MemberYm? = null
 }
