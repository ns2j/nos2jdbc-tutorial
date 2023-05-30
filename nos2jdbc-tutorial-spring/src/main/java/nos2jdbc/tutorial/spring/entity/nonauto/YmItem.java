package nos2jdbc.tutorial.spring.entity.nonauto;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
import nos2jdbc.annotation.NoFk;
import nos2jdbc.annotation.NonAuto;

@Entity @NonAuto
public class YmItem {
    @Id
    public Long lunchFeeId;
    @OneToOne(mappedBy = "ymItem")
    public YmItemMember member;
    public LocalDate payOn;
    public BigDecimal amount;
    public int count;
    
    @Transient @ManyToOne @NoFk
    public Ym ym;
 }
