package java8inaction.chap02;

import java8inaction.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: AppleFilter <br/>
 * Description: TODO <br/>
 * Date: 2016-04-18 11:20 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p>
 *         修改记录
 * @version v1.0.1 2016-04-18 jdai@ created. <br/>
 */
public class AppleFilter {

    public static List<Apple> filterApples(List<Apple> inventory,ApplePredicate predicate) {
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

        List<Apple> result = filterApples(inventory,new AppleGreenColorPredicate());
        System.out.println(result);

        result = filterApples(inventory,new AppleHeavyWeightPredicate());
        System.out.println(result);

        //anonymous class
        result = filterApples(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return "red".equalsIgnoreCase(apple.getColor());
            }
        });
        System.out.println(result);

        //lambda
        result = filterApples(inventory,(Apple apple)-> "red".equalsIgnoreCase(apple.getColor()));
        System.out.println(result);

        //type inference
        result = filterApples(inventory,apple -> "red".equalsIgnoreCase(apple.getColor()));
        System.out.println(result);

        //method reference

    }
}
