package java8inaction.chap02;

import java8inaction.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * ClassName: PredicateOperate <br/>
 * Description: TODO <br/>
 * Date: 2016-04-19 18:02 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p>
 *         修改记录
 * @version v1.0.1 2016-04-19 jdai@ created. <br/>
 */
public class PredicateOperate {

    public static List<Apple> filterApples(List<Apple> inventory,Predicate<Apple> predicate) {
        List<Apple> result = new ArrayList<Apple>();
        for (Apple apple : inventory) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple("green", 80),
                new Apple("green", 155),
                new Apple("red", 120));

        Predicate<Apple> redApple = (a) -> "red".equalsIgnoreCase(a.getColor());
        Predicate<Apple> notRedApple = redApple.negate();
        List<Apple> result = filterApples(inventory,notRedApple);
        System.out.println(result);

        result = filterApples(inventory, redApple.and((a) -> a.getWeight()>120));
        System.out.println(result);
    }
}
