package java8inaction.chap10.nullable.optional;

import java.util.Optional;

/**
 * Created by daijiajia on 16/10/20.
 */
public class Person {

    private Optional<Car> car;

    public Optional<Car> getCar() {
        return car;
    }
}
