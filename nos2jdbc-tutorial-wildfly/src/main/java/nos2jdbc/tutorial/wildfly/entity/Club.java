package nos2jdbc.tutorial.wildfly.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Club extends EntityBase {
    @Column(nullable = false, unique = true)
    public String name;
    
    @OneToMany(mappedBy = "club")
    public List<ClubMemberRel> clubMemberRelList;

}
