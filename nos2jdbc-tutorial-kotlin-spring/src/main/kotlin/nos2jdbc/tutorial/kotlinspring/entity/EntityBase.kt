package nos2jdbc.tutorial.kotlinspring.entity

import java.time.OffsetDateTime

import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass

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
