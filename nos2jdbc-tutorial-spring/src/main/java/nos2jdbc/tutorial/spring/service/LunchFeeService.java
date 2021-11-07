package nos2jdbc.tutorial.spring.service;

import java.util.List;

import org.seasar.extension.jdbc.JdbcManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nos2jdbc.tutorial.spring.entity.nonauto.MemberKey;
import nos2jdbc.tutorial.spring.entity.nonauto.Ym;
import nos2jdbc.tutorial.spring.entity.nonauto.rollup.Key;
import nos2jdbc.tutorial.spring.gen.service.LunchFeeServiceBase;

@Service
@Transactional
public class LunchFeeService extends LunchFeeServiceBase {
    @Autowired
    JdbcManager jdbcManager;
    
    public List<Ym> getYm() {
        sqlFilePathPrefix = "sql/";
        return selectBySqlFile(Ym.class, "sum.sql").getResultList();
    }
    public List<MemberKey> getMember() {
        sqlFilePathPrefix = "sql/";
        return selectBySqlFile(MemberKey.class, "sum.sql").getResultList();
    }

    public List<Key> getRollup() {
        sqlFilePathPrefix = "sql/";
        return selectBySqlFile(Key.class, "rollup.sql").getResultList();
    }
    public List<Key> getRollup2() {
        sqlFilePathPrefix = "sql/";
        return selectBySqlFile(Key.class, "rollup2.sql").getResultList();
    }
    public List<Key> getRollup3() {
        sqlFilePathPrefix = "sql/";
        return selectBySqlFile(Key.class, "rollup3.sql").getResultList();
    }
    public List<Key> getCube() {
        sqlFilePathPrefix = "sql/";
        return selectBySqlFile(Key.class, "cube.sql").getResultList();
    }
    public List<Key> getCubeWithJoin() {
        sqlFilePathPrefix = "sql/";
        return selectBySqlFile(Key.class, "cube-with-join.sql").getResultList();
    }
}
