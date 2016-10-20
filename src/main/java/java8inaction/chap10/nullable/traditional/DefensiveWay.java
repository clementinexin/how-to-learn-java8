package java8inaction.chap10.nullable.traditional;

/**
 * Created by daijiajia on 16/10/20.
 */
public class DefensiveWay {

    public String getCarInsuranceName(Person person) {
        if (person != null) {
            Car car = person.getCar();
            if (car != null) {
                Insurance insurance = car.getInsurance();
                if (insurance != null) {
                    return insurance.getName();
                }
            }
        }

        return "UnKnown";
    }
}
