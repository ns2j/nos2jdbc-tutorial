package nos2jdbc.tutorial.kotlinspring.entity.nonauto

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.OneToMany

import nos2jdbc.annotation.NonAuto

@Entity @NonAuto
class MemberKey {
    @Id
    var memberId: Long? = null
    
    var memberName: String? = null
    
    @OneToMany(mappedBy = "member")
    var ymList: List<MemberYm> = mutableListOf()
    

}
