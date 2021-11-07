package nos2jdbc.tutorial.spring.entity.nonauto;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import nos2jdbc.annotation.NoFk;
import nos2jdbc.annotation.NonAuto;

@Entity @NonAuto
public class YmItemMember {
    public Long memberId;
    public String memberName;
    @OneToOne @NoFk
    public YmItem ymItem;
}
