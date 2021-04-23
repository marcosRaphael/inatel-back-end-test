package inatel.br.inatelbackendtest.Exception;

public class ArgumentsNotValidExceptionDetails {

    protected String title;
    protected String details;
    private String fields;
    private String fieldsMessage;

    public ArgumentsNotValidExceptionDetails(String title, String details, String fields, String fieldsMessage) {
        this.title = title;
        this.details = details;
        this.fields = fields;
        this.fieldsMessage = fieldsMessage;
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

    public String getFields() {
        return fields;
    }

    public void setFields(String fields) {
        this.fields = fields;
    }

    public String getFieldsMessage() {
        return fieldsMessage;
    }

    public void setFieldsMessage(String fieldsMessage) {
        this.fieldsMessage = fieldsMessage;
    }
}
