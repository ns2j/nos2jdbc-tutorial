package nos2jdbc.tutorial.kotlinspring.entity.nonauto

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.OneToMany

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
