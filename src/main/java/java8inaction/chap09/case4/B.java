package java8inaction.chap09.case4;

/**
 * Created by daijiajia on 16/10/20.
 */
public interface B {

    default void hello() {
        System.out.println("B hello");
    }
}
