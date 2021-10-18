package nos2jdbc.tutorial.wildfly.gen.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Club {
    @Id
    @GeneratedValue
    public Long id;
    
    @Column(nullable = false, unique = true)
    public String name;
    
    @OneToMany(mappedBy = "club")
    public List<ClubMemberRel> clubMemberRelList;

}
