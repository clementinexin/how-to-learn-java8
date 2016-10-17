package java8inaction.chap14.theroy;

import java.util.stream.IntStream;

/**
 * Created by daijiajia on 16/10/17.
 */
public class LambdaDemo {

    public static void main(String[] args) {
        System.out.println(IntStream.of(1, 2, 3).reduce((x, y) -> x + y));
    }
}
