package java8inaction.chap14.curry;

import java.util.function.DoubleUnaryOperator;

/**
 * Created by daijiajia on 16/10/17.
 */
public class CurryDemo {

    static double converter(double x, double f, double b) {
        return x * f + b;
    }

    static DoubleUnaryOperator curriedConverter(double f, double b) {
        return (double x) -> x * f + b;
    }

    static DoubleUnaryOperator convertC2F = curriedConverter(9.0 / 5, 32);

    static DoubleUnaryOperator convertUSD2GBP = curriedConverter(0.6, 0);

    public static void main(String[] args) {
        System.out.println(convertC2F.applyAsDouble(10));
    }

}
