package br.com.marcelomsilva.backendtestjava.dto;

public class ErrorDto {

    private String message;

    public ErrorDto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
