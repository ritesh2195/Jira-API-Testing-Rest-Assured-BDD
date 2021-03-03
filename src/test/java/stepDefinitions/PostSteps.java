package stepDefinitions;

import apiEngine.APIResources;
import apiEngine.EndPoints;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
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

    @When("user hit {string} request")
    public void user_hit_request(String method) {

        APIResources resources = APIResources.valueOf(method);

        res = EndPoints.createIssue(resources.getResources());

    }

    @When("user hit {string} request with key {string}")
    public void user_hit_request_with_key(String method, String key) {

        APIResources resources = APIResources.valueOf(method);

        res =EndPoints.getIssue(resources.getResources()+key);

    }


    @Then("user should get {int} status code")
    public void user_should_get_status_code(Integer statusCode) {

        Assert.assertEquals((int)statusCode, res.statusCode());

        System.out.println(res.getBody().asString());

    }

    @Then("response body should contains {string} and {string}")
    public void response_body_should_contains_and(String id, String key) {

        String body = res.getBody().asString();

        Assert.assertTrue(body.contains(id));

        Assert.assertTrue(body.contains(key));
    }

    @Then("response body key should match with given key")
    public void response_body_key_should_match_with_given_key() {

        String resp = res.asString();

        JsonPath path = new JsonPath(resp);

        String key = path.getString("key");

        Assert.assertEquals("JA-10", key);
    }

}
