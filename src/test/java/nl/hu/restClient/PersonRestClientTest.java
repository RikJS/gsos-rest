package nl.hu.restClient;

import nl.hu.GsosRestApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.Charset;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Created by rikde on 24/11/2017.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GsosRestApplication.class)
@WebAppConfiguration
public class PersonRestClientTest {

    private int weight;
    private int length;
    private int age;
    private String gender;
    private String activityLevel;

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() {
        weight = 67;
        length = 170;
        age = 20;
        gender = "male";
        activityLevel = "active";

        this.mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void getBmiTest()
            throws Exception {
        MvcResult result = this.mockMvc.perform(get("/bmi/"+weight+"/"+length))
                .andExpect(status().isOk())
                .andReturn();

        String responseExpected = "{\"response\":23.2}";
        String responseResult = result.getResponse().getContentAsString();
        assertEquals(responseExpected, responseResult);
    }

    @Test
    public void getCalorieIntakeTest()
            throws Exception {
        MvcResult result = this.mockMvc.perform(get("/calorieIntake/"+weight+"/"+length+"/"+age+"/"+gender+"/"+activityLevel))
                .andExpect(status().isOk())
                .andReturn();

        String responseExpected = "{\"response\":2384}";
        String responseResult = result.getResponse().getContentAsString();
        assertEquals(responseExpected, responseResult);
    }

}
