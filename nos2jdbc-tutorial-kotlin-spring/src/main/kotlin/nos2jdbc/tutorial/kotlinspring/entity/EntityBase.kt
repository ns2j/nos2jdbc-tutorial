package nos2jdbc.tutorial.kotlinspring.entity

import java.time.OffsetDateTime

import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.MappedSuperclass

import nos2jdbc.annotation.CreatedAt
import nos2jdbc.annotation.UpdatedAt

@MappedSuperclass
open class EntityBase {
    @Id
    @GeneratedValue
    var id: Long? = null
    
    @CreatedAt
    var createAt: OffsetDateTime? = null 
    @UpdatedAt
    var updateAt: OffsetDateTime? = null


}
