package nos2jdbc.tutorial.spring.gen.entity.names;

import javax.annotation.Generated;
import nos2jdbc.tutorial.spring.gen.entity.ClubMemberRel;
import nos2jdbc.tutorial.spring.gen.entity.names.ClubNames._ClubNames;
import nos2jdbc.tutorial.spring.gen.entity.names.MemberNames._MemberNames;
import org.seasar.extension.jdbc.name.PropertyName;

/**
 * {@link ClubMemberRel}のプロパティ名の集合です。
 * 
 */
@Generated(value = {"NOS2JDBC-Gen unknown", "org.seasar.extension.jdbc.gen.internal.model.NamesModelFactoryImpl"}, date = "2018/03/07 14:37:07")
public class ClubMemberRelNames {

    /**
     * clubIdのプロパティ名を返します。
     * 
     * @return clubIdのプロパティ名
     */
    public static PropertyName<Long> clubId() {
        return new PropertyName<Long>("clubId");
    }

    /**
     * memberIdのプロパティ名を返します。
     * 
     * @return memberIdのプロパティ名
     */
    public static PropertyName<Long> memberId() {
        return new PropertyName<Long>("memberId");
    }

    /**
     * clubのプロパティ名を返します。
     * 
     * @return clubのプロパティ名
     */
    public static _ClubNames club() {
        return new _ClubNames("club");
    }

    /**
     * memberのプロパティ名を返します。
     * 
     * @return memberのプロパティ名
     */
    public static _MemberNames member() {
        return new _MemberNames("member");
    }

    /**
     * @author S2JDBC-Gen
     */
    public static class _ClubMemberRelNames extends PropertyName<ClubMemberRel> {

        /**
         * インスタンスを構築します。
         */
        public _ClubMemberRelNames() {
        }

        /**
         * インスタンスを構築します。
         * 
         * @param name
         *            名前
         */
        public _ClubMemberRelNames(final String name) {
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
        public _ClubMemberRelNames(final PropertyName<?> parent, final String name) {
            super(parent, name);
        }

        /**
         * clubIdのプロパティ名を返します。
         *
         * @return clubIdのプロパティ名
         */
        public PropertyName<Long> clubId() {
            return new PropertyName<Long>(this, "clubId");
        }

        /**
         * memberIdのプロパティ名を返します。
         *
         * @return memberIdのプロパティ名
         */
        public PropertyName<Long> memberId() {
            return new PropertyName<Long>(this, "memberId");
        }

        /**
         * clubのプロパティ名を返します。
         * 
         * @return clubのプロパティ名
         */
        public _ClubNames club() {
            return new _ClubNames(this, "club");
        }

        /**
         * memberのプロパティ名を返します。
         * 
         * @return memberのプロパティ名
         */
        public _MemberNames member() {
            return new _MemberNames(this, "member");
        }
    }
}