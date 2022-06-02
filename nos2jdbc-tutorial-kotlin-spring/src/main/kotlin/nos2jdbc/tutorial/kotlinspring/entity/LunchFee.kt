package nos2jdbc.tutorial.kotlinspring.entity

import java.math.BigDecimal
import java.time.LocalDate

import javax.persistence.Entity
import javax.persistence.ManyToOne

@Entity
class LunchFee : EntityBase() {
    var memberId: Long? = null
    @ManyToOne
    var member: Member? = null
    
    var payOn: LocalDate? = null
    var amount: BigDecimal? = null
}
