package nos2jdbc.tutorial.spring.entity.nonauto;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import nos2jdbc.annotation.NoFk;
import nos2jdbc.annotation.NonAuto;

@Entity @NonAuto
public class MemberYm {
    @Id
    public Integer y;
    @Id
    public Integer m;
    
    @ManyToOne @NoFk
    public MemberKey member;
    
    @OneToMany(mappedBy = "ym")
    public List<MemberItem> itemList;
    

}
