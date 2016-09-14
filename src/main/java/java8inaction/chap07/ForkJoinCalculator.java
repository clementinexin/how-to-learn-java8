package java8inaction.chap07;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * Created by daijiajia on 16/9/9.
 */
public class ForkJoinCalculator extends RecursiveTask<Long> {

    long[] numbers;
    int start;
    int end;


    public static final long THRESHOLD = 1000000L;

    public ForkJoinCalculator(long[] numbers) {
        this(numbers, 0, numbers.length);
    }

    public ForkJoinCalculator(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.end = end;
        this.start = start;
    }

    @Override
    protected Long compute() {
        long length = end - start;
        if (length <= THRESHOLD) {
            return computeSequentially();
        }
        ForkJoinCalculator left = new ForkJoinCalculator(numbers, start, (int) (start + length / 2));
        long leftResult = left.compute();
        ForkJoinCalculator right = new ForkJoinCalculator(numbers, (int) (start + length / 2), end);
        long rightResult = right.compute();

        return leftResult + rightResult;
    }

    private long computeSequentially() {
        long sum = 0;
        for (int i = start; i < end; i++) {
            sum += numbers[i];
        }
        return sum;
    }


    public static void main(String[] args) {

        System.out.println(SumExample.measureSumPerf(ForkJoinCalculator::forkJoinSum, 10000000));

    }

    public static long forkJoinSum(long n) {
        long[] numbers = LongStream.rangeClosed(1, n).toArray();
        ForkJoinTask<Long> task = new ForkJoinCalculator(numbers);
        return new ForkJoinPool().invoke(task);
    }


}
