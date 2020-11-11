package br.com.ms.ses.mail.model;

public class StatusErrorDTO extends StatusDTO {
    private String cause;
    private String details;

    public StatusErrorDTO() {

    }

    public StatusErrorDTO(String status, String cause, String details) {
        super(status);
        this.cause = cause;
        this.details = details;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
