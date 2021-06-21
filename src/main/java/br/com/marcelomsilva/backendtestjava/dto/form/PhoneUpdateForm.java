package br.com.marcelomsilva.backendtestjava.dto.form;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class PhoneUpdateForm {

    @NotNull @NotEmpty
    @Length(min = 2, max = 2)
    private String code;

    @NotNull @NotEmpty
    @Length(min = 8, max = 9)
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
