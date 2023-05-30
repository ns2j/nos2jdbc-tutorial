package nos2jdbc.tutorial.kotlinspring.entity.nonauto

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.OneToMany

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
