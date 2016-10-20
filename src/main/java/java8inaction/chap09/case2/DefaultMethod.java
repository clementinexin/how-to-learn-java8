package java8inaction.chap09.case2;

/**
 * Created by daijiajia on 16/10/20.
 * the most specific interface wins
 */
public class DefaultMethod {

    public static void main(String[] args) {
        C c = new C();
        c.hello();
    }
}
