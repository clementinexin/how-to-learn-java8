package java8inaction.chap10.nullable.optional;

import java.util.Optional;

/**
 * Created by daijiajia on 16/10/20.
 */
public class Car {

    private Optional<Insurance> insurance;

    public Optional<Insurance> getInsurance() {
        return insurance;
    }
}
