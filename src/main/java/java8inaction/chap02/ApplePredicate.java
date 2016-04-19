package java8inaction.chap02;


import java8inaction.Apple;

/**
 * ClassName: ApplePredicate <br/>
 * Description: TODO <br/>
 * Date: 2016-04-18 11:15 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p>
 *         修改记录
 * @version v1.0.1 2016-04-18 jdai@ created. <br/>
 */
public interface ApplePredicate {

    boolean test(Apple apple);
}
