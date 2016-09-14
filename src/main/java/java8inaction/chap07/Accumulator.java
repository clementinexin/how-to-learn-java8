package java8inaction.chap07;

import java.util.stream.LongStream;

/**
 * Created by daijiajia on 16/9/9.
 */
public class Accumulator {

    public long sum = 0;

    public void add(long value) {
        sum += value;
    }

    public static long sideEffectSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1L, n)
                .forEach(accumulator::add);
        return accumulator.sum;
    }

    public static long sideEffectParallelSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1L, n)
                .parallel()
                .forEach(accumulator::add);
        return accumulator.sum;
    }

    public static void main(String[] args) {
        System.out.println(SumExample.measureSumPerf(Accumulator::sideEffectSum, 10000000));
        System.out.println(SumExample.measureSumPerf(Accumulator::sideEffectParallelSum, 10000000));
    }
}
