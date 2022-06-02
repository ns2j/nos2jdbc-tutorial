package nos2jdbc.tutorial.kotlinspring.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import nos2jdbc.tutorial.kotlinspring.gen.service.LunchFeeServiceBase
import nos2jdbc.tutorial.kotlinspring.entity.nonauto.Ym
import nos2jdbc.tutorial.kotlinspring.entity.nonauto.MemberKey
import nos2jdbc.tutorial.kotlinspring.entity.nonauto.rollup.Key

@Service
@Transactional
class LunchFeeService: LunchFeeServiceBase() {
    fun getYm() : List<Ym> {
        sqlFilePathPrefix = "sql/";
        return selectBySqlFile(Ym::class.java, "sum.sql").getResultList();
    }
    fun getMember() : List<MemberKey> {
        sqlFilePathPrefix = "sql/";
        return selectBySqlFile(MemberKey::class.java, "sum.sql").getResultList();
    }

    fun getRollup() : List<Key> {
        sqlFilePathPrefix = "sql/";
        return selectBySqlFile(Key::class.java, "rollup.sql").getResultList();
    }
    fun getRollup2() : List<Key> {
        sqlFilePathPrefix = "sql/";
        return selectBySqlFile(Key::class.java, "rollup2.sql").getResultList();
    }
    fun getRollup3() : List<Key> {
        sqlFilePathPrefix = "sql/";
        return selectBySqlFile(Key::class.java, "rollup3.sql").getResultList();
    }
    fun getCube() : List<Key> {
        sqlFilePathPrefix = "sql/";
        return selectBySqlFile(Key::class.java, "cube.sql").getResultList();
    }
    fun getCubeWithJoin() : List<Key> {
        sqlFilePathPrefix = "sql/";
        return selectBySqlFile(Key::class.java, "cube_with_join.sql").getResultList();
    }
}