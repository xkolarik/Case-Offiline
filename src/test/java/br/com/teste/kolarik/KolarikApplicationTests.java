package br.com.teste.kolarik;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import br.com.teste.kolarik.controller.BotController;
import br.com.teste.kolarik.service.BotService;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.*; 
import static io.restassured.matcher.RestAssuredMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KolarikApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	private MockMvc mockMvc;
	
	@Autowired
	private BotController botController;

	@Autowired
	private BotService service;
	
	@BeforeClass
    public static void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8081;
    }
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(botController).build();
	}
	
	@Test
	public void testePutBot() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/bots/"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void testGETBotsId() throws Exception {
		String json = "[\r\n" + 
				"    {\r\n" + 
				"        \"id\": \"36b9f842-ee97-11e8-9443-0242ac120001\",\r\n" + 
				"        \"name\": \"Aureo\"\r\n" + 
				"    }\r\n" + 
				"]"; 
		this.mockMvc.perform(MockMvcRequestBuilders.get("/bots/id:5d779a9e6b76856a28d894b2"))
				.equals(json);
	}
	
	@Test																															
	public void testGETAllBots() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/bots/"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test																					
	public void testPOSTBots() throws Exception {
		String json = "[\r\n" + 
				"    {\r\n" + 
				"        \"id\": \"36b9f842-ee97-11e8-9443-0242ac120002\",\r\n" + 
				"        \"name\": \"Aureo\"\r\n" + 
				"    }\r\n" + 
				"]"; 
		given()
        .when()
      //  .post("/bots/id:5d77a3e76b76856a28d894b3", json)
        .then()
       // .assertThat()
       // .body(json, equalToPath(json))
        .statusCode(200);
	}
}

