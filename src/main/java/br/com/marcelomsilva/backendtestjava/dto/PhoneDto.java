package br.com.marcelomsilva.backendtestjava.dto;

import br.com.marcelomsilva.backendtestjava.entity.Phone;

public class PhoneDto {

    private String code;
    private String number;

    public PhoneDto(Phone phone) {
        this.code = phone.getCode();
        this.number = phone.getNumber();
    }

    public String getCode() {
        return code;
    }

    public String getNumber() {
        return number;
    }
}
