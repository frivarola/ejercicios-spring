package com.spring.clase1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
class Clase1ApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() throws Exception {
		System.out.println("Whats");
	}

	@Test
	void shouldTraducirRomano() throws Exception{
		this.mockMvc.perform(get("/numeroRomano/10"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("X")));
	}

	@Test
	void shouldTraducirMorse() throws Exception{
		this.mockMvc.perform(get("/codigoMorse/-- . .-. -.-. .- -.. ---   .-.. .. -... .-. ."))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("MERCADO LIBRE")));
	}

}
