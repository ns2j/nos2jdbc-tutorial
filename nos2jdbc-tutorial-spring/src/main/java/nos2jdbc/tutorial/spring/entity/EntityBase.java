package nos2jdbc.tutorial.spring.entity;

import java.time.OffsetDateTime;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
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
