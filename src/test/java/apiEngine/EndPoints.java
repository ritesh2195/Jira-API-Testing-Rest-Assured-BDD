package apiEngine;
import static io.restassured.RestAssured.*;

import Pojo.jsonBody;
import Utilities.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class EndPoints {

    static RequestSpecification req;

    public static RequestSpecification authenticateUser(){

        RestAssured.baseURI = ConfigReader.getConfigReader().getURI();

        req = given().auth().preemptive().basic(ConfigReader.getConfigReader().getUserName(), ConfigReader.getConfigReader().getPassword());

        return req;
    }

    public static Response createIssue(String endPoint){

        Response response = req.header("Content-Type", "application/json").body(jsonBody.getData())

        .post(endPoint);

        return response;
    }

    public static Response getIssue(String endPoint){

        return req.get(endPoint);
    }
}
