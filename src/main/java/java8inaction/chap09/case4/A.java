package java8inaction.chap09.case4;

/**
 * Created by daijiajia on 16/10/20.
 */
public interface A {

    default void hello() {
        System.out.println("A hello");
    }
}
