package Pojo;

public class Fields {

    private Project project;
    private String summary;
    private String description;
    private Bug issuetype;

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Bug getIssuetype() {
        return issuetype;
    }

    public void setIssuetype(Bug issuetype) {
        this.issuetype = issuetype;
    }

}
