package nos2jdbc.tutorial.kotlinspring.entity

import java.math.BigDecimal
import java.time.LocalDate

import jakarta.persistence.Entity
import jakarta.persistence.ManyToOne

@Entity
class LunchFee : EntityBase() {
    var memberId: Long? = null
    @ManyToOne
    var member: Member? = null
    
    var payOn: LocalDate? = null
    var amount: BigDecimal? = null
}
