package nos2jdbc.tutorial.spring.gen.entity.names;

import javax.annotation.Generated;
import nos2jdbc.tutorial.spring.gen.entity.Member;
import nos2jdbc.tutorial.spring.gen.entity.names.ClubMemberRelNames._ClubMemberRelNames;
import org.seasar.extension.jdbc.name.PropertyName;

/**
 * {@link Member}のプロパティ名の集合です。
 * 
 */
@Generated(value = {"NOS2JDBC-Gen unknown", "org.seasar.extension.jdbc.gen.internal.model.NamesModelFactoryImpl"}, date = "2018/03/07 14:37:07")
public class MemberNames {

    /**
     * idのプロパティ名を返します。
     * 
     * @return idのプロパティ名
     */
    public static PropertyName<Long> id() {
        return new PropertyName<Long>("id");
    }

    /**
     * nameのプロパティ名を返します。
     * 
     * @return nameのプロパティ名
     */
    public static PropertyName<String> name() {
        return new PropertyName<String>("name");
    }

    /**
     * clubMemberRelListのプロパティ名を返します。
     * 
     * @return clubMemberRelListのプロパティ名
     */
    public static _ClubMemberRelNames clubMemberRelList() {
        return new _ClubMemberRelNames("clubMemberRelList");
    }

    /**
     * @author S2JDBC-Gen
     */
    public static class _MemberNames extends PropertyName<Member> {

        /**
         * インスタンスを構築します。
         */
        public _MemberNames() {
        }

        /**
         * インスタンスを構築します。
         * 
         * @param name
         *            名前
         */
        public _MemberNames(final String name) {
            super(name);
        }

        /**
         * インスタンスを構築します。
         * 
         * @param parent
         *            親
         * @param name
         *            名前
         */
        public _MemberNames(final PropertyName<?> parent, final String name) {
            super(parent, name);
        }

        /**
         * idのプロパティ名を返します。
         *
         * @return idのプロパティ名
         */
        public PropertyName<Long> id() {
            return new PropertyName<Long>(this, "id");
        }

        /**
         * nameのプロパティ名を返します。
         *
         * @return nameのプロパティ名
         */
        public PropertyName<String> name() {
            return new PropertyName<String>(this, "name");
        }

        /**
         * clubMemberRelListのプロパティ名を返します。
         * 
         * @return clubMemberRelListのプロパティ名
         */
        public _ClubMemberRelNames clubMemberRelList() {
            return new _ClubMemberRelNames(this, "clubMemberRelList");
        }
    }
}