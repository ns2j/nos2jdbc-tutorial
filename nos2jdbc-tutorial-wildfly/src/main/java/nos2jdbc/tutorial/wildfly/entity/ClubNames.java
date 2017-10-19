package nos2jdbc.tutorial.wildfly.entity;

import javax.annotation.Generated;
import nos2jdbc.tutorial.wildfly.entity.ClubMemberRelNames._ClubMemberRelNames;
import org.seasar.extension.jdbc.name.PropertyName;

/**
 * {@link Club}のプロパティ名の集合です。
 * 
 */
@Generated(value = {"NOS2JDBC-Gen unknown", "org.seasar.extension.jdbc.gen.internal.model.NamesModelFactoryImpl"}, date = "2017/10/19 14:04:01")
public class ClubNames {

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
    public static class _ClubNames extends PropertyName<Club> {

        /**
         * インスタンスを構築します。
         */
        public _ClubNames() {
        }

        /**
         * インスタンスを構築します。
         * 
         * @param name
         *            名前
         */
        public _ClubNames(final String name) {
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
        public _ClubNames(final PropertyName<?> parent, final String name) {
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