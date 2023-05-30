package nos2jdbc.tutorial.spring.entity.nonauto;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import nos2jdbc.annotation.NonAuto;

@Entity @NonAuto
public class MemberKey {
    @Id
    public Long memberId;
    
    public String memberName;
    
    @OneToMany(mappedBy = "member")
    public List<MemberYm> ymList;
    

}
