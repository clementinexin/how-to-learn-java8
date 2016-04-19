package java8inaction.chap02;

import java.util.function.DoubleFunction;
import java.util.function.Function;

/**
 * ClassName: FunctionOperate <br/>
 * Description: TODO <br/>
 * Date: 2016-04-19 18:21 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p>
 *         修改记录
 * @version v1.0.1 2016-04-19 jdai@ created. <br/>
 */
public class FunctionOperate {

    public static void main(String[] args) {
        Function<Integer,Integer> f = x -> x+1;
        Function<Integer,Integer> g = x -> x*2;
        Function<Integer,Integer> h = f.andThen(g);
        System.out.println(h.apply(1));

        h = f.compose(g);
        System.out.println(h.apply(1));
        h = g.compose(f);
        System.out.println(h.apply(1));

        System.out.println(integrate((x)->x+10,10,14));
    }

    public static double integrate(DoubleFunction<Double> f,double a,double b) {
        return (f.apply(a) + f.apply(b))*(b-a)/2;
    }
}
