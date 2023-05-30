package nos2jdbc.tutorial.kotlinspring.entity.nonauto

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany

import nos2jdbc.annotation.NoFk
import nos2jdbc.annotation.NonAuto

@Entity @NonAuto
class MemberYm {
    @Id
    var y: Int? = null
    @Id
    var m: Int? = null
    
    @ManyToOne @NoFk
    var member: MemberKey? = null
    
    @OneToMany(mappedBy = "ym")
    var itemList: List<MemberItem> = mutableListOf()
    

}
