package restapi;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static constants.constants.BASE_URI;

public class RestApi {
    RestAssured restAssured;
    RequestSpecBuilder builder;
    RequestSpecification httpRequest;
    Response response;
     String getPage;

    @Given("set up API environment")
    public String set_up_API_environment() {
        return restAssured.baseURI= BASE_URI+"api/users?";
    }

    @When("search page {string}")
    public RequestSpecification search_page(String page) {
    this.getPage = page;
    builder = new RequestSpecBuilder();
    RequestSpecification requestSpec = builder.build();

    httpRequest = RestAssured.given();
    httpRequest.spec(requestSpec);
    httpRequest.param("page",page);
    return httpRequest;
    }

    @Then("result displayed")
    public void result_displayed() {
    response= httpRequest.get();
    response.prettyPrint();
    }


}
