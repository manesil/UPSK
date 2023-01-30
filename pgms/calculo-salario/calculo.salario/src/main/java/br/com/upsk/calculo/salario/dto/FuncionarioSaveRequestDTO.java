package br.com.upsk.calculo.salario.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class FuncionarioSaveRequestDTO {

    private Long id;

    @NotNull @NotBlank private String nome;

    @NotNull
    @Pattern(regexp = "^\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$", message = "CPF invalido")
    private String cpf;

    @NotNull
    @Email
    private String email;

    @NotNull
    private String senha;

    private BigDecimal abonoSalarial;

    @NotNull
    private EnderecoDTO endereco;

    @NotNull
    private CargoSaveRequestDTO cargo;


}
