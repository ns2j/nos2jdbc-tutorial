package nos2jdbc.tutorial.spring.entity.nonauto;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
