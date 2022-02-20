package nos2jdbc.tutorial.wildfly.entity;

import java.time.OffsetDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import nos2jdbc.annotation.CreatedAt;
import nos2jdbc.annotation.UpdatedAt;

@MappedSuperclass
public class EntityBase {
    @Id
    @GeneratedValue
    public Long id;
    
    @CreatedAt
    public OffsetDateTime createAt;
    @UpdatedAt
    public OffsetDateTime updateAt;


}
