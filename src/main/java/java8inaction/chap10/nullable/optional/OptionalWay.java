package java8inaction.chap10.nullable.optional;


import java.util.Optional;

/**
 * Created by daijiajia on 16/10/20.
 */
public class OptionalWay {

    public static String getCarInsuranceName(Optional<Person> person) {
        return person.flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("UnKnown");
    }

    public static void main(String[] args) {
        Person person = new Person();

        Optional<Person> personOptional = Optional.ofNullable(person);

        System.out.println(getCarInsuranceName(personOptional));
    }
}
