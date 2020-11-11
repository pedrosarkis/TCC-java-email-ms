package br.com.ms.ses.mail.model;

public class StatusDTO {
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public StatusDTO() {
    }

    public StatusDTO(String status) {
        this.status = status;
    }
}
