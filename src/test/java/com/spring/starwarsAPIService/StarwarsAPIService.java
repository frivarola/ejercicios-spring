package com.spring.starwarsAPIService;

import com.spring.clase3Starwars.StarWarsApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = StarWarsApplication.class)
@AutoConfigureMockMvc
public class StarwarsAPIService {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testService() throws Exception{
        this.mockMvc.perform(post("/star-wars/getNameCharactersLike")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"likeName\": \"Darth\"}"))
        .andDo(print())
        .andExpect(status().isOk());
    }
}
