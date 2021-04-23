package inatel.br.inatelbackendtest.Exception;

public class NotUniqueException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    private String fieldName;

    public NotUniqueException(String fieldName, String message) {
        super(message);
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }
}
