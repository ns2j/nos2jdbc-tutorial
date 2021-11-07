package nos2jdbc.tutorial.spring.entity.nonauto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import nos2jdbc.annotation.NonAuto;

@Entity @NonAuto
public class Ym {
    @Id
    public Integer y;
    @Id
    public Integer m;
    
    @OneToMany(mappedBy = "ym")
    public List<YmItem> itemList;
    

}
