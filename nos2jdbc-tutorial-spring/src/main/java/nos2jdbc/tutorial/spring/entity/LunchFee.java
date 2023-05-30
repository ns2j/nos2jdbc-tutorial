package nos2jdbc.tutorial.spring.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class LunchFee extends EntityBase {
    public Long memberId;
    @ManyToOne
    public Member member;
    
    public LocalDate payOn;
    public BigDecimal amount;
}
