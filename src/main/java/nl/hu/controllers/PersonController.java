package nl.hu.controllers;

import nl.hu.models.ActivityLevel;
import nl.hu.models.Gender;
import nl.hu.models.Person;
import nl.hu.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by rikde on 21/11/2017.
 */

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(method = RequestMethod.GET, value = "/bmi/{weight}/{length}")
    public Person getBmi(@PathVariable double weight, @PathVariable double length) {
        Person person = new Person(weight, length);
        double bmi = personService.calculateBmi(person);
        person.setBmi(bmi);
        return person;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/calorieIntake/{weight}/{length}/{age}/{gender}/{activityLevel}")
    public Person getCalorieIntake(@PathVariable double weight,
                                   @PathVariable double length,
                                   @PathVariable int age,
                                   @PathVariable String gender,
                                   @PathVariable String activityLevel) {

        Gender genderEnum = Gender.valueOf(gender.toUpperCase());
        ActivityLevel activityLevel1Enum = ActivityLevel.valueOf(activityLevel.toUpperCase());
        Person person = new Person(weight, length, age, genderEnum, activityLevel1Enum);

        int calorieIntake = personService.calculateCalorieIntake(person);
        person.setCalorieIntake(calorieIntake);

        return person;
    }
}
