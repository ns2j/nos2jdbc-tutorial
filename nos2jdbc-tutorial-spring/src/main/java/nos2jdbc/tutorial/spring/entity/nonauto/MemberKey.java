package nos2jdbc.tutorial.spring.entity.nonauto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import nos2jdbc.annotation.NonAuto;

@Entity @NonAuto
public class MemberKey {
    @Id
    public Long memberId;
    
    public String memberName;
    
    @OneToMany(mappedBy = "member")
    public List<MemberYm> ymList;
    

}
