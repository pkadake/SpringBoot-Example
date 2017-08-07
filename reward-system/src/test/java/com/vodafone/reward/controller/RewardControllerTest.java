package com.vodafone.reward.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.vodafone.reward.service.RewardService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(value = RewardController.class, secure = false)
@ContextConfiguration(classes = com.vodafone.reward.starter.RewardSystemApplication.class)
public class RewardControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private RewardService rewardService;

	String exampleJson = "{\r\n   \"vouchers\":[\r\n      {\r\n         \"voucher-number\":\"V2378578346\",\r\n         \"voucher-value\":1200,\r\n         \"currency\":\"INR\",\r\n         \"firstname\":\"Drew\",\r\n         \"lastname\":\"Barrymore\"\r\n      },\r\n      {\r\n         \"voucher-number\":\"V183240062\",\r\n         \"voucher-value\":5,\r\n         \"currency\":\"USD\",\r\n         \"firstname\":\"Johnny\",\r\n         \"lastname\":\"Depp\"\r\n      },\r\n      {\r\n         \"voucher-number\":\"V45708293\",\r\n         \"voucher-value\":500,\r\n         \"currency\":\"INR\",\r\n         \"firstname\":\"Drew\",\r\n         \"lastname\":\"Barrymore\"\r\n      },\r\n      {\r\n         \"voucher-number\":\"V1106\",\r\n         \"voucher-value\":60,\r\n         \"currency\":\"INR\",\r\n         \"firstname\":\"Brad\",\r\n         \"lastname\":\"Pitt\"\r\n      }\r\n   ],\r\n   \"credits\":[\r\n      {\r\n         \"credit-id\":\"C072341\",\r\n         \"points\":100,\r\n         \"firstname\":\"Drew\",\r\n         \"lastname\":\"Barrymore\"\r\n      },\r\n      {\r\n         \"credit-id\":\"C3475634\",\r\n         \"points\":50,\r\n         \"firstname\":\"Johnny\",\r\n         \"lastname\":\"Depp\"\r\n      },\r\n      {\r\n         \"credit-id\":\"C34857\",\r\n         \"points\":10,\r\n         \"firstname\":\"Drew\",\r\n         \"lastname\":\"Barrymore\"\r\n      }\r\n   ]\r\n}";

	@Test
	public void getRewardsByPerson() throws Exception {

		// Send exampleJson as body to /rewards
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/rewards").accept(MediaType.APPLICATION_JSON)
				.content(exampleJson).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.OK.value(), response.getStatus());

	}

}
