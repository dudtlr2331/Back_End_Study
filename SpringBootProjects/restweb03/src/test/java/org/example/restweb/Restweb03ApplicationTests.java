package org.example.restweb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class Restweb03ApplicationTests {

	// web 요청에 대한 테스트
	// MockMvc

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() throws Exception {
//		mockMvc.perform(get("/ename.do?ename=scott"))
//		mockMvc.perform(get("/ename/scott"))
//				.andExpect(status().isOk())
//				.andExpect(content().string("scott"))
//				.andDo(print());
	}

}
