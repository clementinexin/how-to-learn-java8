package java8inaction.chap02;

/**
 * ClassName: Mother <br/>
 * Description: TODO <br/>
 * Date: 2016-04-18 11:01 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p>
 *         修改记录
 * @version v1.0.1 2016-04-18 jdai@ created. <br/>
 */
public interface Mother {

    default void teachHowtolive() {
        System.out.println("Mother teach us how to live");
    }
}
