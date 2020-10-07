package com.petersen.CodeFellowship;

import com.petersen.CodeFellowship.controllers.ApplicationUserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CodeFellowshipApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ApplicationUserController applicationUserController;

	@Test
	void contextLoads() {
	}

//	@Test
//	public void homePageShouldRenderWithH1() {
//		this.mockMvc.perform(get("/")) // import the get ability
//				.andDo(print())
//				.andExpect(status().isOk())
//				.andExpect(content().string(containsString("<h1>Welcome to Code Fellowship</h1>")));
//	}
//
//	@Test
//	public void detailPageShouldHaveName() {
//		this.mockMvc.perform(get("/user/Matthew")) // import the get ability
//				.andDo(print())
//				.andExpect(redirectedUrl("/login"))
//				.andExpect(status().isOk());
//				.andExpect(content().string(containsString("<h1>Matthew</h1>")));
//	}
}
