package java8inaction.chap14.lazy;

import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created by daijiajia on 16/10/17.
 */
public class LazyList<T> implements MyList<T> {

    private final T head;

    private final Supplier<LazyList<T>> tail;

    public LazyList(T head, Supplier<LazyList<T>> tail) {
        this.head = head;
        this.tail = tail;
    }

    @Override
    public T head() {
        return head;
    }

    @Override
    public LazyList<T> tail() {
        return tail.get();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    public static LazyList<Integer> from(int n) {
        return new LazyList<>(n, () -> from(n + 1));
    }

    public static void main(String[] args) {
        LazyList<Integer> numbers = from(2);
        System.out.println(numbers.head());
        System.out.println(numbers.tail().head());
        System.out.println(numbers.tail().tail().head());
    }

    public LazyList<T> filter(Predicate<T> p) {
        return isEmpty() ?
                this :
                p.test(head()) ?
                        new LazyList<>(head(), () -> tail().filter(p)) :
                        tail().filter(p);
    }
}
