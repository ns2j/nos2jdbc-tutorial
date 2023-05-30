package nos2jdbc.tutorial.spring.entity.nonauto.rollup;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
import nos2jdbc.annotation.NoFk;
import nos2jdbc.annotation.NonAuto;

@Entity @NonAuto
public class Item {
    public BigDecimal amount;
    public int count;
    @Transient @OneToOne @NoFk
    public Key key;

    public Long lunchFeeId;
    public String memberName;
}
