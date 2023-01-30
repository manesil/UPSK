package br.com.upsk.calculo.salario.service;

import br.com.upsk.calculo.salario.entity.Funcionario;

import java.math.BigDecimal;
import java.util.Optional;

public interface FuncionarioService {

    Funcionario save(Funcionario funcionario);

    Optional<Funcionario> findById(Long idFuncionario);

    void delete(Long idFuncionario);


}
