package java8inaction.chap09.case2;

/**
 * Created by daijiajia on 16/10/20.
 */
public interface B extends A {
    default void hello() {
        System.out.println("B hello");
    }
}
