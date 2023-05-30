package nos2jdbc.tutorial.spring.entity.nonauto;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import nos2jdbc.annotation.NoFk;
import nos2jdbc.annotation.NonAuto;

@Entity @NonAuto
public class MemberItem {
    @Id
    public Long lunchFeeId;
    public LocalDate payOn;
    public BigDecimal amount;
    public int count;
    
    @Transient @ManyToOne @NoFk
    public MemberYm ym;
 }
