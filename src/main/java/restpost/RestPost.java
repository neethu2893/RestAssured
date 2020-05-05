package restpost;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import static constants.constants.BASE_URI;

public class RestPost {
    RestAssured restAssured;
    RequestSpecification requestSpecification;
    Response response;
//    String name = "abc";
//    String job = "def";
    @Given("setup base URI of API")
    public String setup_base_URI_of_API() {
        return restAssured.baseURI= BASE_URI+"api/users/";
    }

    @When("create request body with name {string} and job {string}")
    public RequestSpecification create_request_body_with_name_and_job(String name,String job) {
        requestSpecification = RestAssured.given();
        String requestBody = "{\n"+
                "\t\"name\": \""+name+"\",\n" +
                "\t\"job\" : \""+job+"\"\n"+
                "}\n";

        requestSpecification.body(requestBody);
        return requestSpecification;

    }

    @Then("assert response with status code {int}")
    public void assert_response_with_status_code(int exp) {
        response = requestSpecification.post();
        response.prettyPrint();
        int status = response.getStatusCode();
        Assert.assertEquals(status,exp);


    }
}
