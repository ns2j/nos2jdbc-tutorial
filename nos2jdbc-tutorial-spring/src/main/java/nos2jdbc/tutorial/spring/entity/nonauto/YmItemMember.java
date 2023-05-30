package nos2jdbc.tutorial.spring.entity.nonauto;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import nos2jdbc.annotation.NoFk;
import nos2jdbc.annotation.NonAuto;

@Entity @NonAuto
public class YmItemMember {
    public Long memberId;
    public String memberName;
    @OneToOne @NoFk
    public YmItem ymItem;
}
