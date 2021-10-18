package nos2jdbc.tutorial.wildfly.entity;

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
    public OffsetDateTime createAt;
    @UpdateAt
    public OffsetDateTime updateAt;


}
