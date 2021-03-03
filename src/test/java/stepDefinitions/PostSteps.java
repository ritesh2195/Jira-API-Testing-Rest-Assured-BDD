package stepDefinitions;

import apiEngine.EndPoints;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.cucumber.java.en.When;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

public class PostSteps {

    private Response res;

    @Given("user authenticate himself")
    public void user_authenticate_himself() {

        RequestSpecification request = EndPoints.authenticateUser();

    }

    @When("when user hit {string} request")
    public void when_user_hit_request(String string) {

        res = EndPoints.createIssue();

    }
    @Then("user should get {int} response code")
    public void user_should_get_response_code(Integer statusCode) {

        Assert.assertEquals((int)statusCode, res.statusCode());

        System.out.println(res.getBody().asString());

    }

    @Then("response body should contains {string} and {string}")
    public void response_body_should_contains_and(String id, String key) {

        String body = res.getBody().asString();

        Assert.assertTrue(body.contains(id));

        Assert.assertTrue(body.contains(key));
    }

}
