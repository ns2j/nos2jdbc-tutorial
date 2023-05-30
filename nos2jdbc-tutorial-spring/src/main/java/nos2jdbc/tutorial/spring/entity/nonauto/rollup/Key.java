package nos2jdbc.tutorial.spring.entity.nonauto.rollup;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import nos2jdbc.annotation.NonAuto;

@Entity @NonAuto
public class Key {
    public Key() {};
    public Key(Integer y, Integer m, Long memberId) {
        this.y = y;
        this.m = m;
        this.memberId = memberId;
    }
    
    public Integer y;
    public Integer m;
    public Long memberId;

    @OneToOne(mappedBy = "key")
    public Item item;

    @Override
    public int hashCode() {
        int y0 = y == null ? 0 : y;
        int m0 = m ==  null ? 0 : m;
        long memberId0 = memberId == null ? 0 : memberId;
        long l0 = y0 + m0 + memberId0;
        return Long.valueOf(l0).hashCode();
    }

    boolean equalsInt(Integer i1, Integer i2) {
        if (i1 == null && i2 == null) return true;
        if (i1 == null && i2 != null) return false;
        if (i1 != null && i2 == null) return false;
        return i1.equals(i2);
    }

    boolean equalsLong(Long l1, Long l2) {
        if (l1 == null && l2 == null) return true;
        if (l1 == null && l2 != null) return false;
        if (l1 != null && l2 == null) return false;
        return l1.equals(l2);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        Key k = (Key)o;
        if (!equalsInt(y, k.y)) return false;
        if (!equalsInt(m, k.m)) return false;
        return equalsLong(memberId, k.memberId);
    }
    
    @Override
    public String toString() {
        return String.format("y: %d, m: %d, memberId: %d", y, m, memberId);
    }
}
