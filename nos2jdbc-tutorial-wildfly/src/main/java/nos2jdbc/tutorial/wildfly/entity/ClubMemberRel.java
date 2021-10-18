package nos2jdbc.tutorial.wildfly.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class ClubMemberRel extends EntityBase {
    public Long clubId;
    @ManyToOne
    public Club club;
    
    public Long memberId;
    @ManyToOne
    public Member member;
}
