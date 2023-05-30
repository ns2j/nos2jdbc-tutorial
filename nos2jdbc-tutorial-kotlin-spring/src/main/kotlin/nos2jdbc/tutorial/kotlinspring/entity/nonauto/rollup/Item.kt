package nos2jdbc.tutorial.kotlinspring.entity.nonauto.rollup

import java.math.BigDecimal

import jakarta.persistence.Entity
import jakarta.persistence.OneToOne
import jakarta.persistence.Transient

import nos2jdbc.annotation.NoFk
import nos2jdbc.annotation.NonAuto

@Entity @NonAuto
class Item {
    var amount: BigDecimal = BigDecimal.ZERO
    var count: Int = 0
    @Transient @OneToOne @NoFk
    var key: Key? = null

    var lunchFeeId: Long? = null
    var memberName: String? = null
}
