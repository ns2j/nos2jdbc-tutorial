package nos2jdbc.tutorial.kotlinspring.entity

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.GeneratedValue
import javax.persistence.Column
import javax.persistence.OneToMany
import java.util.ArrayList

@Entity
class Club : EntityBase() {
    @Column(nullable = false, unique = true)
    var name: String = ""

    @OneToMany(mappedBy = "club")
    var clubMemberRelList: List<ClubMemberRel> = mutableListOf() 
}

/*
@Entity
data class Club(
   @Id
    @GeneratedValue
    var id: Long = 0,
    
    @Column(nullable = false, unique = true)
    var name: String = "",
    
    @OneToMany(mappedBy = "club")
    var clubMemberRelList: List<ClubMemberRel> = mutableListOf() 
) {
	override fun hashCode(): Int {
		return id.hashCode();
	}
}
 	*/