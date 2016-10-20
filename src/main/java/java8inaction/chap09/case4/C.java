package java8inaction.chap09.case4;

/**
 * Created by daijiajia on 16/10/20.
 */
public class C implements A, B {
    public void hello() {
        A.super.hello();
    }
}
