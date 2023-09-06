package nos2jdbc.tutorial.wildfly.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class ClubMemberRel extends EntityBase {
    public Long clubId;
    @ManyToOne
    public Club club;
    
    public Long memberId;
    @ManyToOne
    public Member member;
}
