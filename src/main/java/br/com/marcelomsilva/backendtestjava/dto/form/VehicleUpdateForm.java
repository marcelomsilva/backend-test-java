package br.com.marcelomsilva.backendtestjava.dto.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class VehicleUpdateForm {

    @NotEmpty @NotNull
    private String plate;

    @Min(0)
    private Long modelId;

    public VehicleUpdateForm(String plate, Long modelId) {
        this.plate = plate;
        this.modelId = modelId;
    }

    public String getPlate() {
        return plate;
    }

    public Long getModelId() {
        return modelId;
    }
}
