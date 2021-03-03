package apiEngine;

public enum  APIResources {

    POST("/rest/api/2/issue/"),
    GET("/rest/api/2/issue/"),
    DELETE("/rest/api/2/issue/10050");
    private String resources;

    APIResources(String resources) {

        this.resources=resources;
    }

    public String getResources(){

        return resources;
    }
}
