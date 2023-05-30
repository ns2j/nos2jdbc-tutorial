package nos2jdbc.tutorial.kotlinspring.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne

@Entity
class ClubMemberRel : EntityBase() {
    @Id
    var clubId: Long? = null

    @Id
    var memberId: Long? = null

	    @ManyToOne
    var club: Club? = null

    @ManyToOne
    var member: Member? = null
}

/*
@Entity
data class ClubMemberRel(
        @Id
        var clubId: Long? = null,

        @Id
        var memberId: Long? = null,

        @ManyToOne
        var club: Club? = null,

        @ManyToOne
        var member: Member? = null
        ) {
	override fun toString(): String {
		
	} 

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as ClubMemberRel
        if (clubId != other.clubId) return false
        if (memberId != other.memberId) return false
        return true
    }

    override fun hashCode() : Int {
        if (clubId == null || memberId == null) return 0;
        return clubId.hashCode() + memberId.hashCode();
    }
}
 */
