package nos2jdbc.tutorial.spring.entity;

import java.time.OffsetDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import nos2jdbc.annotation.CreateAt;
import nos2jdbc.annotation.UpdateAt;

@MappedSuperclass
public class EntityBase {
    @Id
    @GeneratedValue
    public Long id;
    
    @CreateAt
    OffsetDateTime createAt;
    @UpdateAt
    OffsetDateTime updateAt;


}
