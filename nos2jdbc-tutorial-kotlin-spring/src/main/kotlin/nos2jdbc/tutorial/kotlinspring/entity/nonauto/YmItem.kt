package nos2jdbc.tutorial.kotlinspring.entity.nonauto

import java.math.BigDecimal
import java.time.LocalDate

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToOne
import jakarta.persistence.Transient

import nos2jdbc.annotation.NoFk
import nos2jdbc.annotation.NonAuto

@Entity @NonAuto
class YmItem {
    @Id
    var lunchFeeId: Long? = null
    @OneToOne(mappedBy = "ymItem")
    var member: YmItemMember? = null
    var payOn: LocalDate? = null
    var amount: BigDecimal = BigDecimal.ZERO
    var count: Int = 0
    
    @Transient @ManyToOne @NoFk
    var ym: Ym? = null
 }
