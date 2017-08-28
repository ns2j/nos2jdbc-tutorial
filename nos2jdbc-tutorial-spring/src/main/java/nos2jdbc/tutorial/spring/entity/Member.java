package nos2jdbc.tutorial.spring.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Member {
    @Id
    @GeneratedValue
    public Long id;
    
    @Column
    public String name;
    
    @OneToMany(mappedBy ="member")
    public List<ClubMemberRel> clubMemberRelList;

}
