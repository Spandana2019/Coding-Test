package com.generator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.generator.controller.GeneratorController;

/**
 * This class is used to test GeneratorController with the url
 * 
 */

@RunWith(SpringRunner.class)
@WebMvcTest(value = GeneratorController.class, secure = false)
public class GeneratorControllerTest {

	@Autowired
	private MockMvc mockMvc;

	int success_status = 200;

	@Test
	public void generateUUID() throws Exception {

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/generateUUID?x=2&y=7&z=5");

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println("Status : " + result.getResponse().getStatus());

		System.out.println("Content String : " + result.getResponse().getContentAsString());

		assertEquals(result.getResponse().getStatus(), success_status);

	}
}
