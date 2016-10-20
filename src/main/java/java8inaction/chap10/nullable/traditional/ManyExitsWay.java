package java8inaction.chap10.nullable.traditional;

/**
 * Created by daijiajia on 16/10/20.
 */
public class ManyExitsWay {

    public String getCarInsuranceName(Person person) {
        if (person == null) {
            return "UnKnown";
        }
        Car car = person.getCar();
        if (car == null) {
            return "UnKnown";
        }
        Insurance insurance = car.getInsurance();
        if (insurance == null) {
            return "UnKnown";
        }

        return insurance.getName();

    }
}
