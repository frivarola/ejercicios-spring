package com.spring.calculateCaloriesService;

import com.spring.clase3Calorias.CaloriesApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest(classes= CaloriesApplication.class)
@AutoConfigureMockMvc
class CalculateCaloriesServiceTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() throws Exception {
        System.out.println("Whats");
    }

    @Test
    void getCaloriesTotales() throws Exception{
        this.mockMvc.perform(post("/calories/getDishCalories")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "   \"name\":\"a la fede\",\n" +
                        "   \"ingredients\":[\n" +
                        "      {\n" +
                        "         \"name\":\"Apio\",\n" +
                        "         \"peso\":20\n" +
                        "      },\n" +
                        "      {\n" +
                        "         \"name\":\"Alcachofas\",\n" +
                        "         \"peso\":30\n" +
                        "      }\n" +
                        "   ]\n" +
                        "}"))
                .andDo(print())
                .andExpect(status().isOk());
    }


    @Test
    void getCaloriesByIngredient() throws Exception{
        this.mockMvc.perform(post("/calories/getCaloriesByIngredient")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "   \"name\":\"a la fede\",\n" +
                        "   \"ingredients\":[\n" +
                        "      {\n" +
                        "         \"name\":\"Apio\",\n" +
                        "         \"peso\":20\n" +
                        "      },\n" +
                        "      {\n" +
                        "         \"name\":\"Alcachofas\",\n" +
                        "         \"peso\":30\n" +
                        "      }\n" +
                        "   ]\n" +
                        "}"))
                .andDo(print())
                .andExpect(status().isOk());
    }


    @Test
    void getMaxCalories() throws Exception{
        this.mockMvc.perform(post("/calories/getMaxCalories")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "   \"name\":\"a la fede\",\n" +
                        "   \"ingredients\":[\n" +
                        "      {\n" +
                        "         \"name\":\"Apio\",\n" +
                        "         \"peso\":20\n" +
                        "      },\n" +
                        "      {\n" +
                        "         \"name\":\"Alcachofas\",\n" +
                        "         \"peso\":30\n" +
                        "      }\n" +
                        "   ]\n" +
                        "}"))
                .andDo(print())
                .andExpect(status().isOk());
    }

}