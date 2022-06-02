package nos2jdbc.tutorial.kotlinspring.entity.nonauto

import javax.persistence.Entity
import javax.persistence.OneToOne

import nos2jdbc.annotation.NoFk
import nos2jdbc.annotation.NonAuto

@Entity @NonAuto
class YmItemMember {
    var memberId: Long? = null
    var memberName: String? = null
    @OneToOne @NoFk
    var ymItem: YmItem? = null
}
