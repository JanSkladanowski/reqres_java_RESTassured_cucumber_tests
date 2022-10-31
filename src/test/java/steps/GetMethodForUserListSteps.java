package steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import pojo.Data;
import pojo.Page;
import utilities.APIConstant;
import utilities.RestAssuredExtension;

public class GetMethodForUserListSteps {

	public static ResponseOptions<Response> response;
	public static String token;

	@Given("For endpoint {string} and {int} page")
	public void forEndpointAndPage(String uri, int pageNumber) {

		Map<String , Integer> queryParams = new HashMap<>();
		queryParams.put("page", pageNumber);

		RestAssuredExtension restAssuredExtension = new RestAssuredExtension(uri, APIConstant.ApiMethods.GET,null);
		response = restAssuredExtension.ExecuteWithQueryParams(queryParams);
	}

	@Then("For {int} user I should see the the email as {string}")
	public void forUserNumberUserIShouldSeeTheTheEmailAsEmail(int userNumber, String email) {

		Data[] users = response.getBody().as(Page.class).getData();
		Data user = users[userNumber];
		Assert.assertEquals(user.getEmail(), (email));
		assertThat(response.getStatusCode(),equalTo(200));
	}
}


