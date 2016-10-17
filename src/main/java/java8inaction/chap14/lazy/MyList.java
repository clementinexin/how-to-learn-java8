package java8inaction.chap14.lazy;

/**
 * Created by daijiajia on 16/10/17.
 */
public interface MyList<T> {

    abstract T head();

    abstract MyList<T> tail();

    default boolean isEmpty() {
        return true;
    }

}
