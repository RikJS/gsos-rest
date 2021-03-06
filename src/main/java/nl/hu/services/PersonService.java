package nl.hu.services;

import nl.hu.models.Gender;
import nl.hu.models.Person;
import org.springframework.stereotype.Service;

/**
 * Created by rikde on 21/11/2017.
 */
@Service
public class PersonService {

    public double calculateBmi(Person person) {
        double lengthInMeters = person.getLength()/100;
        lengthInMeters = person.getWeight() / (lengthInMeters*lengthInMeters);
        return round(lengthInMeters, 1);
    }

    public int calculateCalorieIntake(Person person) {
        double bmr = calculateBmr(person);
        double calorieIntake = calculateCalorieIntakeFromBmr(person, bmr);

        return (int) calorieIntake;
    }

    private double calculateBmr(Person person) {
        double bmr = 0;
        if(person.getGender() == Gender.MALE) {
            bmr = 66.5 + (13.75*person.getWeight()) + (5.003*person.getLength()) - (6.755*person.getAge());
        } else if(person.getGender() == Gender.FEMALE) {
            bmr = 655.1 + (9.563*person.getWeight()) + (1.850*person.getLength()) - (4.676*person.getAge());
        }
        return bmr;
    }

    private double calculateCalorieIntakeFromBmr(Person person, double bmr) {
        double activityFactor = determineActivityFactor(person);
        return bmr*activityFactor;
    }

    private double determineActivityFactor(Person person) {
        switch (person.getActivityLevel()) {
            case SEDENTARY:
                return 1.2;
            case MODERATLY_ACTIVE:
                return 1.3;
            case ACTIVE:
                return  1.4;
            default:
                return 1;
        }
    }

    private static double round (double value, int precision) {
        int scale = (int) Math.pow(10, precision);
        return (double) Math.round(value * scale) / scale;
    }

}
