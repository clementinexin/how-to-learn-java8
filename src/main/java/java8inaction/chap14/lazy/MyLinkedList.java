package java8inaction.chap14.lazy;

/**
 * Created by daijiajia on 16/10/17.
 */
public class MyLinkedList<T> implements MyList<T> {

    private final T head;

    private final MyList<T> tail;

    public MyLinkedList(T head, MyList<T> tail) {
        this.head = head;
        this.tail = tail;
    }

    @Override
    public T head() {
        return head;
    }

    @Override
    public MyList<T> tail() {
        return tail;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }


    public static void main(String[] args) {
        MyList<Integer> l = new MyLinkedList<>(10, new MyLinkedList<>(1, new Empty<>()));
        System.out.println(l.head());
        System.out.println(l.tail().head());
        System.out.println(l.tail().tail().head());
    }
}
