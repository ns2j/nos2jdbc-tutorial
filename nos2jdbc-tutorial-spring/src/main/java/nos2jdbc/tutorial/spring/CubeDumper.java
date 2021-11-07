package nos2jdbc.tutorial.spring;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import nos2jdbc.tutorial.spring.entity.Member;
import nos2jdbc.tutorial.spring.entity.nonauto.rollup.Item;
import nos2jdbc.tutorial.spring.entity.nonauto.rollup.Key;
import nos2jdbc.tutorial.spring.service.LunchFeeService;
import nos2jdbc.tutorial.spring.service.MemberService;

@Component
public class CubeDumper {
    @Autowired
    MemberService memberService;
    @Autowired
    LunchFeeService lfService;

    List<Key> keys;

    public CubeDumper() {
    }

    public void loadKeys() {
        keys = lfService.getCubeWithJoin(); 
    }

    public void dumCube() {
        System.out.println("");
        System.out.println("cube example");
        for (Key k: keys)
            printWithFormat("(%s): (amount: %s, count: %d)",
                    "" + k, k.item.amount, k.item.count);
    }

    public void dumpCubeWithJoin() { 
        System.out.println("");
        System.out.println("year");
        for (int y = 2020; y < 2022; y++)
            printWithFormat("year sum: %d: %s", y, getItemStr(y, null, null));

        System.out.println("");
        System.out.println("year month");
        for (int y = 2020; y < 2022; y++)
            for (int m = 1; m < 13; m++) {
                Key key = new Key(y, m, null);
                if (findItem(key) != null)
                    printWithFormat("year month sum: %d %d: %s",
                            y, m, getItemStr(key));
            }

        List<Member> mems = memberService.findAll(); 
        System.out.println("");
        System.out.println("member year month");
        for (Member mem: mems)
            for (int y = 2020; y < 2022; y++)
                for (int m = 1; m < 13; m++) {
                    Key key = new Key(y, m, mem.id);
                    if (findItem(key) != null)
                        printWithFormat("member year month sum: %d-%s %d %d: %s",
                                mem.id, mem.name, y, m, getItemStr(key));
                }
        System.out.println("");
        System.out.println("member year");
        for (Member mem: mems)
            for (int y = 2020; y < 2022; y++)
                printWithFormat("member year sum: %d-%s %d: %s",
                        mem.id, mem.name, y, getItemStr(y, null, mem.id));

        System.out.println("");
        System.out.println("member");
        for (Member mem: mems)
            printWithFormat("member sum: %d-%s: %s",
                    mem.id, mem.name, getItemStr(null, null, mem.id));

        System.out.println("");
        printWithFormat("grand sum: %s", getItemStr(null, null, null));
    }

    void printWithFormat(String format, Object...objs) {
        System.out.println(String.format(format, objs));
    }

    Item findItem(Key key) {
        for (Key k: keys)
            if (k.equals(key))
                return k.item;
        return null;
    }
    String getItemStr(Integer y, Integer m, Long memberId) {
        return getItemStr(new Key(y, m, memberId));
    }
    String getItemStr(Key key) {
        Item item = findItem(key);
        return item == null ? "null" : String.format("(amount: %s, count: %d)", item.amount, item.count);
    }

}
