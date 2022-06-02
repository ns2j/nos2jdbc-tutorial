package nos2jdbc.tutorial.kotlinspring.entity.nonauto

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToMany

import nos2jdbc.annotation.NonAuto

@Entity @NonAuto
class Ym {
    @Id
    var  y: Int? = null
    @Id
    var  m: Int? = null
    
    @OneToMany(mappedBy = "ym")
    var itemList: List<YmItem> = mutableListOf()
    

}
