package br.com.upsk.calculo.salario.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class FuncionarioResponseDTO {

    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private BigDecimal abonoSalarial;
    private EnderecoDTO endereco;
    private CargoResponseDTO cargo;

}
