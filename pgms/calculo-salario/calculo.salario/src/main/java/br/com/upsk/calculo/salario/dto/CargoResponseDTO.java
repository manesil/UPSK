package br.com.upsk.calculo.salario.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class CargoResponseDTO {

    private Long id;
    private String descricao;
    private BigDecimal salarioBase;

}
