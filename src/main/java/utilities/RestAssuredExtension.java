package utilities;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;
import java.util.Map;

public class RestAssuredExtension {

	private RequestSpecBuilder builder = new RequestSpecBuilder();
	private String method;
	private String url;

	/**
	 * RestAssuredExtension constructor to pass initial settings for the following method
	 * @param uri
	 * @param method
	 * @param token
	 */
	public RestAssuredExtension(String uri, String method, String token){

		this.url = "https://reqres.in" + uri;
		this.method = method;

		if (token != null)
			builder.addHeader("Authorization", "Bearer" + token);
	}

	/**
	 * ExecuteAPI to execute the API for GET/POST/DELETE
	 * @return ResponseOptions<Response>
	 */
	private ResponseOptions<Response> ExecuteAPI(){
		RequestSpecification requestSpecification = builder.build();
		RequestSpecification request = RestAssured.given();
		request.contentType(ContentType.JSON);
		request.spec(requestSpecification);

		if (this.method.equalsIgnoreCase(APIConstant.ApiMethods.GET))
			return request.get(this.url);
		else if (this.method.equalsIgnoreCase(APIConstant.ApiMethods.POST))
			return request.post(this.url);
		else if (this.method.equalsIgnoreCase(APIConstant.ApiMethods.DELETE))
			return request.delete(this.url);
		return null;
	}

	/**
	 * Authenticate to get the token variable
	 * @param body
	 * @return string token
	 */
	public String Authenticate(Object body){

		builder.setBody(body);
		return  ExecuteAPI().getBody().jsonPath().get("access_token");
	}

	/**
	 * Execute API with query params being passed as the input of it
	 * @param queryParams
	 * @return Response
	 */
	public ResponseOptions<Response> ExecuteWithQueryParams(Map<String , Integer > queryParams){
		builder.addQueryParams(queryParams);
		return ExecuteAPI();
	}

	/**
	 * Execute API with path params being passed as the input of it
	 * @param pathParams
	 * @return Response as ResponseOptions
	 */
	public ResponseOptions<Response> ExecuteWithPathParams(Map<String , String > pathParams){
		builder.addPathParams(pathParams);
		return ExecuteAPI();
	}

	/**
	 * Execute API with body
	 * @param body
	 * @return Response as ResponseOptions
	 */
	public ResponseOptions<Response> ExecuteWithBody(Map<String , String > body){
		builder.setBody(body);
		return ExecuteAPI();
	}

	/**
	 * Execute API with path params and body
	 * @param pathParams
	 * @param body
	 * @return Response as ResponseOptions
	 */
	public ResponseOptions<Response> ExecuteWithPathParamsAndBody(Map<String , String > pathParams , Map<String , String > body){
		builder.addPathParams(pathParams);
		builder.setBody(body);
		return ExecuteAPI();
	}

	/**
	 * Execute API with query params and body
	 * @param queryParams
	 * @param body
	 * @return Response as ResponseOptions
	 */
	public ResponseOptions<Response> ExecuteWithQueryParamsAndBody(Map<String , String > queryParams , Map<String , String > body){
		builder.addQueryParams(queryParams);
		builder.setBody(body);
		return ExecuteAPI();
	}
}
