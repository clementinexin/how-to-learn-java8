package java8inaction.chap02;

import java8inaction.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

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

        //method reference before
        inventory.sort((Apple a1,Apple a2)-> a1.getWeight().compareTo(a2.getWeight()));
        System.out.println(inventory);

        //method reference after
        inventory.sort(Comparator.comparing(Apple::getWeight));
        System.out.println(inventory);

        //constructor reference
        Supplier<Apple> c1 = Apple::new;
        Apple a1 = c1.get();

        Supplier<Apple> c2 = ()->new Apple();
        Apple a2 = c2.get();

        Function<Integer,Apple> c3 = Apple::new;
        Apple a3 = c3.apply(130);

        Function<Integer,Apple> c4 = (integer)->new Apple(integer);
        Apple a4 = c4.apply(130);

        BiFunction<String,Integer,Apple> c5 = Apple::new;
        Apple a5 = c5.apply("brown",130);

        BiFunction<String,Integer,Apple> c6 = (color,weight)->new Apple(color,weight);
        Apple a6 = c6.apply("brown",130);

        //composing comparator
        inventory.sort(Comparator.comparing(Apple::getWeight).reversed().thenComparing(Apple::getColor));
        System.out.println(inventory);

    }
}
