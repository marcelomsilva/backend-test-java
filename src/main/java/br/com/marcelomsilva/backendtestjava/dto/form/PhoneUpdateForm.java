package br.com.marcelomsilva.backendtestjava.dto.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class PhoneUpdateForm {

    @NotNull @NotEmpty
    private String code;

    @NotNull @NotEmpty
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
