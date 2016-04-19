package java8inaction.chap01;

import java8inaction.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * ClassName: AppleFilter <br/>
 * Description: TODO <br/>
 * Date: 2016-04-15 13:51 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p/>
 *         修改记录
 * @version v1.0.1 2016-04-15 jdai@ created. <br/>
 */
public class AppleFilter {

    public static void main(String[] args) {

        List<Apple> inventory = Arrays.asList(new Apple( "green",80),
                new Apple( "green",155),
                new Apple( "red",120));

        List<Apple> result = filterApple(inventory,AppleFilter::isGreenApple);
        System.out.println(result);

        result = filterApple(inventory,(Apple apple) -> "green".equalsIgnoreCase(apple.getColor()));
        System.out.println(result);

        result = filterApple(inventory,AppleFilter::isGreenAndHeavyApple);
        System.out.println(result);

        result = filterApple(inventory,(Apple apple) -> "green".equalsIgnoreCase(apple.getColor()) && apple.getWeight() > 150);
        System.out.println(result);

    }

    public static boolean isGreenAndHeavyApple(Apple apple) {
        return "green".equalsIgnoreCase(apple.getColor()) && apple.getWeight() > 150;
    }

    public static List<Apple> filterApple(List<Apple> inventory,Predicate<Apple> p) {
        List<Apple> result = new ArrayList<Apple>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static boolean isGreenApple(Apple apple) {
        return "green".equalsIgnoreCase(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }

    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<Apple>();
        for(Apple apple : inventory) {
            if("green".equalsIgnoreCase(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterHeavyApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<Apple>();
        for(Apple apple : inventory) {
            if(apple.getWeight() > 150) {
                result.add(apple);
            }
        }
        return result;
    }


}
