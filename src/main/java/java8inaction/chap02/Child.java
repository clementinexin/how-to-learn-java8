package java8inaction.chap02;

/**
 * ClassName: Child <br/>
 * Description: multiple inheritance implements by default methods of multiple interfaces <br/>
 * Date: 2016-04-18 11:02 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p>
 *         修改记录
 * @version v1.0.1 2016-04-18 jdai@ created. <br/>
 */

public class Child implements Father,Mother {

    public static void main(String[] args) {
        Child child = new Child();
        child.teachHowtowork();
        child.teachHowtolive();
    }
}
