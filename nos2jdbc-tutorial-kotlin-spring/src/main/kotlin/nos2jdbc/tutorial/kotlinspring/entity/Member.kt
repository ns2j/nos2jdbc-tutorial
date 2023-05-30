package nos2jdbc.tutorial.kotlinspring.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Column
import jakarta.persistence.OneToMany
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