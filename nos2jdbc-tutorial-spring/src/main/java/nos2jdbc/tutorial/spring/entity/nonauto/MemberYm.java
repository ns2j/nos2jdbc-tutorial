package nos2jdbc.tutorial.spring.entity.nonauto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
