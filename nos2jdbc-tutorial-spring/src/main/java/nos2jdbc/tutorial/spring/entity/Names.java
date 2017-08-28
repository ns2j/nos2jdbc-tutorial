package nos2jdbc.tutorial.spring.entity;

import javax.annotation.Generated;
import nos2jdbc.tutorial.spring.entity.ClubMemberRelNames._ClubMemberRelNames;
import nos2jdbc.tutorial.spring.entity.ClubNames._ClubNames;
import nos2jdbc.tutorial.spring.entity.MemberNames._MemberNames;

/**
 * 名前クラスの集約です。
 * 
 */
@Generated(value = {"NOS2JDBC-Gen unknown", "org.seasar.extension.jdbc.gen.internal.model.NamesAggregateModelFactoryImpl"}, date = "2017/08/25 15:32:20")
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