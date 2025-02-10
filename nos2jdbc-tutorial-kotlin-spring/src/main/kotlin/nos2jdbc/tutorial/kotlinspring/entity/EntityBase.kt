package nos2jdbc.tutorial.kotlinspring.entity

import java.time.OffsetDateTime

import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass
import jakarta.persistence.Version

import nos2jdbc.annotation.CreatedAt
import nos2jdbc.annotation.UpdatedAt

@MappedSuperclass
open class EntityBase {
    @Id
    @GeneratedValue
    var id: Long? = null
    
    @Version
    var version: Long? = 1

    @CreatedAt
    var createdAt: OffsetDateTime? = null 
    @UpdatedAt
    var updatedAt: OffsetDateTime? = null


}
