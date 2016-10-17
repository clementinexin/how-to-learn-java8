package java8inaction.chap14.lazy;

import java.util.stream.IntStream;

/**
 * Created by daijiajia on 16/10/17.
 */
public class RecursiveDemo {

    static IntStream numbers() {
        return IntStream.iterate(2, n -> n + 1);
    }

    static int head(IntStream numbers) {
        return numbers.findFirst().getAsInt();
    }

    static IntStream tail(IntStream numbers) {
        return numbers.skip(1);
    }

    static IntStream primes(IntStream numbers) {
        int head = head(numbers);
        return IntStream.concat(IntStream.of(head), primes(tail(numbers).filter(n -> n % head != 0)));
    }

    public static LazyList<Integer> primes(LazyList<Integer> numbers) {
        return new LazyList<>(numbers.head(), () -> primes(numbers.tail().filter(n -> n % numbers.head() != 0)));
    }

    public static void main(String[] args) {
        LazyList<Integer> numbers = LazyList.from(2);

        System.out.println(primes(numbers).head());
        System.out.println(primes(numbers).tail().head());
        System.out.println(primes(numbers).tail().tail().head());
    }
}
