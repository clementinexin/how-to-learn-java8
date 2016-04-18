package java8inaction.chap02;

/**
 * ClassName: Father <br/>
 * Description: TODO <br/>
 * Date: 2016-04-18 11:00 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p>
 *         修改记录
 * @version v1.0.1 2016-04-18 jdai@ created. <br/>
 */
public interface Father {

    default void teachHowtowork() {
        System.out.println("Father teach us how to work");
    }
}
