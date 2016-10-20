package java8inaction.chap09.case4;

/**
 * Created by daijiajia on 16/10/20.
 * should specific which default method inherit when implements two interface has the same name default method with equals routing
 */
public class DefaultMethod {

    public static void main(String[] args) {
        C c = new C();
        c.hello();
    }
}
