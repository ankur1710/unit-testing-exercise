package com.ankur.unittestingexercise;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.TestPropertySource;



@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) //this will look for the class with the annotation -@SpringBootApplication and launches the application context
@TestPropertySource(locations = {"classpath:test-app.properties"}) // this is used when we have a dedicated properties file // this takes the highest priority
class MainApplicationIntegrationTests {

	@Autowired
	TestRestTemplate testRestTemplate;

	@Test
	public void testGetItemService() throws JSONException {
		String result = this.testRestTemplate.getForObject("/get-item-service", String.class);
		JSONAssert.assertEquals("{id: 1,name:apple}", result, false);
	}

	@Test
	public void testGetAllService() throws JSONException {
		String resultAll = this.testRestTemplate.getForObject("/getAll",String.class);
		JSONAssert.assertEquals("[{id: 1,name:apple},{},{},{}]",resultAll,false);
	}

}
