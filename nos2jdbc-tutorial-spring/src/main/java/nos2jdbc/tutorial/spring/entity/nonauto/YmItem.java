package nos2jdbc.tutorial.spring.entity.nonauto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

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
