package nl.hu.services;

import nl.hu.models.ActivityLevel;
import nl.hu.models.Gender;
import nl.hu.models.Person;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by rikde on 24/11/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonServiceTest {
    private Person personBmi;
    private Person personCalorieIntake;

    @Autowired
    private PersonService personService;

    @Before
    public void setup() {
        personBmi = new Person(67, 170);
        personCalorieIntake = new Person(67, 170, 20, Gender.MALE, ActivityLevel.ACTIVE);
    }

    @Test
    public void calculateBmiTest() {
        double bmiExpected = 23.2;
        double bmiResult = personService.calculateBmi(personBmi);

        assertEquals(bmiExpected, bmiResult, 1e-8);
    }

    @Test
    public void calculateCalorieIntakeTest() {
        int calorieIntakeExpected = 2384;
        int calorieIntakeResult = personService.calculateCalorieIntake(personCalorieIntake);

        assertEquals(calorieIntakeExpected, calorieIntakeResult);
    }
}
