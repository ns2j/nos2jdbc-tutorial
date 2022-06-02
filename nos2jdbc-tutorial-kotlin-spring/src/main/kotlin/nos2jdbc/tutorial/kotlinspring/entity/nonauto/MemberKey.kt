package nos2jdbc.tutorial.kotlinspring.entity.nonauto

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToMany

import nos2jdbc.annotation.NonAuto

@Entity @NonAuto
class MemberKey {
    @Id
    var memberId: Long? = null
    
    var memberName: String? = null
    
    @OneToMany(mappedBy = "member")
    var ymList: List<MemberYm> = mutableListOf()
    

}
