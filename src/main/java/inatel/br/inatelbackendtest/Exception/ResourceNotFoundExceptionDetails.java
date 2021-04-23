package inatel.br.inatelbackendtest.Exception;

public class ResourceNotFoundExceptionDetails {

    protected String title;
    protected String details;


    public ResourceNotFoundExceptionDetails(String title, String details) {
        this.title = title;
        this.details = details;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
