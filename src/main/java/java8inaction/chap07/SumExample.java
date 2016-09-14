package java8inaction.chap07;

import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Created by daijiajia on 16/9/9.
 */
public class SumExample {


    public static long iterativeSum(long n) {

        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += i;
        }
        return sum;
    }

    public static long sequentialSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .reduce(0L, Long::sum);
    }

    public static void main(String[] args) {
//        System.out.println(measureSumPerf(SumExample::iterativeSum, 10000000));

//        System.out.println(measureSumPerf(SumExample::sequentialSum, 10000000));

//        System.out.println(measureSumPerf(SumExample::parallelSum, 10000000));

        System.out.println(measureSumPerf(SumExample::rangeSum, 10000000));

        System.out.println(measureSumPerf(SumExample::parallelRangeSum, 10000000));
    }

    public static long parallelSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .parallel()
                .reduce(0L, Long::sum);
    }

    public static long measureSumPerf(Function<Long, Long> adder, long n) {
        long fastest = Long.MAX_VALUE;

        for (int i = 0; i < 10; i++) {
            long start = System.currentTimeMillis();
            long sum = adder.apply(n);
            long cost = System.currentTimeMillis() - start;
            if (cost < fastest) fastest = cost;
            System.out.println("sum :" + sum);
        }
        return fastest;
    }

    public static long rangeSum(long n) {
        return LongStream.rangeClosed(1, n)
                .reduce(0L, Long::sum);
    }

    public static long parallelRangeSum(long n) {
        return LongStream.rangeClosed(1, n)
                .parallel()
                .reduce(0L, Long::sum);
    }
}
