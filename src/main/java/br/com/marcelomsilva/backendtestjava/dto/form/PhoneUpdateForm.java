package br.com.marcelomsilva.backendtestjava.dto.form;

public class PhoneUpdateForm {

    private String code;
    private String number;

    public PhoneUpdateForm(String code, String number) {
        this.code = code;
        this.number = number;
    }

    public String getCode() {
        return code;
    }

    public String getNumber() {
        return number;
    }
}
