package nos2jdbc.tutorial.spring.gen.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ClubMemberRel {
    @Id
    public Long clubId;

    @Id
    public Long memberId;
    
    @ManyToOne
    public Club club;
    
    @ManyToOne
    public Member member;
    
    
    

}
