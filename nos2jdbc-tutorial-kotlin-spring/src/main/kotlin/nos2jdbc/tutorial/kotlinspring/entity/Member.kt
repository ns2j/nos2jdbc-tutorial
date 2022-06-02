package nos2jdbc.tutorial.kotlinspring.entity

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.Column
import javax.persistence.OneToMany
@Entity
class Member : EntityBase() {
    @Column
    var name: String = ""
    
    @OneToMany(mappedBy ="member")
    var clubMemberRelList: List<ClubMemberRel> = mutableListOf()
}
/*
@Entity
data class Member(
    @Id
    @GeneratedValue
    var id: Long = 0,
    
    @Column
    var name: String = "",
    
    @OneToMany(mappedBy ="member")
    var clubMemberRelList: List<ClubMemberRel> = mutableListOf()

) {
	override fun hashCode(): Int {
		return id.hashCode();
	}
}
*/