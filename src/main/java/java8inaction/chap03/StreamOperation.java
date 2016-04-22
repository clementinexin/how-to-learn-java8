package java8inaction.chap03;

import java.util.Comparator;
import java.util.List;
import static java8inaction.chap03.Dish.menu;
import static java.util.stream.Collectors.toList;
/**
 * ClassName: StreamOperation <br/>
 * Description: TODO <br/>
 * Date: 2016-04-21 17:49 <br/>
 * <br/>
 *
 * @author jdai@
 *         <p>
 *         修改记录
 * @version v1.0.1 2016-04-21 jdai@ created. <br/>
 */
public class StreamOperation {

    public static void main(String[] args) {
        List<String> lowCaloriDishNames = menu.stream().filter(d -> d.getCalories() < 400)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(toList());
        System.out.println(lowCaloriDishNames);
    }
}
