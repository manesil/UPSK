package br.com.upsk.calculo.salario.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class CargoSaveRequestDTO {

    private Long id;

    @NotNull @NotBlank
    private String descricao;

    @NotNull @DecimalMin(value = "0.1")
    private BigDecimal salarioBase;

}
