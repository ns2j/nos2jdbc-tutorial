package nos2jdbc.tutorial.spring.gen.entity.names;

import javax.annotation.Generated;
import nos2jdbc.tutorial.spring.gen.entity.Club;
import nos2jdbc.tutorial.spring.gen.entity.ClubMemberRel;
import nos2jdbc.tutorial.spring.gen.entity.Member;
import nos2jdbc.tutorial.spring.gen.entity.names.ClubMemberRelNames._ClubMemberRelNames;
import nos2jdbc.tutorial.spring.gen.entity.names.ClubNames._ClubNames;
import nos2jdbc.tutorial.spring.gen.entity.names.MemberNames._MemberNames;

/**
 * 名前クラスの集約です。
 * 
 */
@Generated(value = {"NOS2JDBC-Gen unknown", "org.seasar.extension.jdbc.gen.internal.model.NamesAggregateModelFactoryImpl"}, date = "2018/03/07 14:37:07")
public class Names {

    /**
     * {@link ClubMemberRel}の名前クラスを返します。
     * 
     * @return ClubMemberRelの名前クラス
     */
    public static _ClubMemberRelNames clubMemberRel() {
        return new _ClubMemberRelNames();
    }

    /**
     * {@link Member}の名前クラスを返します。
     * 
     * @return Memberの名前クラス
     */
    public static _MemberNames member() {
        return new _MemberNames();
    }

    /**
     * {@link Club}の名前クラスを返します。
     * 
     * @return Clubの名前クラス
     */
    public static _ClubNames club() {
        return new _ClubNames();
    }
}