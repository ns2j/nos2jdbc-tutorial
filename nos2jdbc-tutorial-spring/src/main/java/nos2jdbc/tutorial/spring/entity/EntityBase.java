package nos2jdbc.tutorial.spring.entity;

import java.time.OffsetDateTime;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import nos2jdbc.annotation.CreatedAt;
import nos2jdbc.annotation.NonAuto;
import nos2jdbc.annotation.UpdatedAt;

@MappedSuperclass
@NonAuto
public class EntityBase {
    @Id
    @GeneratedValue
    public Long id;
    
    @CreatedAt
    public OffsetDateTime createdAt;
    @UpdatedAt
    public OffsetDateTime updatedAt;


}
