package nos2jdbc.tutorial.spring.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class LunchFee extends EntityBase {
    public Long memberId;
    @ManyToOne
    public Member member;
    
    public LocalDate payOn;
    public BigDecimal amount;
}
