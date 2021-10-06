package nos2jdbc.tutorial.spring.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Member extends EntityBase {
    @Column
    public String name;
    
    @OneToMany(mappedBy ="member")
    public List<ClubMemberRel> clubMemberRelList;

}
