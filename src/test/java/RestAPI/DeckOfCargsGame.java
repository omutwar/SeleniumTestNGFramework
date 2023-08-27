package RestAPI;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class DeckOfCargsGame {
//	protected String baseURL = "https://deckofcardsapi.com/";
	protected String baseURI = "https://reqres.in/";
	
	public static void main(String[] args) {
		
	}
	
	@Test
	public void shuffleing() {
		
		// 1) Setup base URL
		RestAssured.baseURI = baseURI;
		
		// 2) Statically import the package
		given().header("Content-Type", "application/json")
			.when().get("/api/users?page=2")
				.then().assertThat().statusCode(200);
	}

}
