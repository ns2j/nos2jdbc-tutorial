package nos2jdbc.tutorial.spring.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Club extends EntityBase {
    @Column(nullable = false, unique = true)
    public String name;
    
    @OneToMany(mappedBy = "club")
    public List<ClubMemberRel> clubMemberRelList;

}
