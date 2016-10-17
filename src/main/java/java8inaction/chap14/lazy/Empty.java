package java8inaction.chap14.lazy;

/**
 * Created by daijiajia on 16/10/17.
 */
public class Empty<T> implements MyList<T> {
    @Override
    public T head() {
        throw new UnsupportedOperationException();
    }

    @Override
    public MyList<T> tail() {
        throw new UnsupportedOperationException();
    }
}
