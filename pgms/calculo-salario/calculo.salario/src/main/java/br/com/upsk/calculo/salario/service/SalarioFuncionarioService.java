package br.com.upsk.calculo.salario.service;

import br.com.upsk.calculo.salario.entity.Funcionario;

import java.math.BigDecimal;
import java.util.Optional;

public interface SalarioFuncionarioService {

    Optional<Funcionario> findById(Long idFuncionario);

    BigDecimal calculoSalario(Long idFuncionario);
}
