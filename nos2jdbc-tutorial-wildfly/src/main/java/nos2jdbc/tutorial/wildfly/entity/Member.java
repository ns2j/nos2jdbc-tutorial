package nos2jdbc.tutorial.wildfly.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Member extends EntityBase {
    @Column
    public String name;
    
    @OneToMany(mappedBy ="member")
    public List<ClubMemberRel> clubMemberRelList;
}
