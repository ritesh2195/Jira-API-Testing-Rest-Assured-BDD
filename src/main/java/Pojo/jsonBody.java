package Pojo;

public class jsonBody {

    public static body getData(){

        body b = new body();

        Fields fields = new Fields();

        Project project = new Project();

        project.setKey("JA");

        fields.setProject(project);

        fields.setSummary("Raising Bug");

        fields.setDescription("Creating of an issue using project keys and issue type names using the REST API");

        Bug bug = new Bug();

        bug.setName("Bug");

        fields.setIssuetype(bug);

        b.setFields(fields);

        return b;
    }
}
