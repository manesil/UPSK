package br.com.upsk.calculo.salario.service.impl;

import br.com.upsk.calculo.salario.entity.Funcionario;
import br.com.upsk.calculo.salario.repository.CargoRepository;
import br.com.upsk.calculo.salario.repository.FuncionarioRepository;
import br.com.upsk.calculo.salario.service.FuncionarioService;
import br.com.upsk.calculo.salario.service.SalarioFuncionarioService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class SalarioFuncionarioServiceImpl implements SalarioFuncionarioService {

    private FuncionarioRepository funcionarioRepository;

    public SalarioFuncionarioServiceImpl(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    @Override
    public Optional<Funcionario> findById(Long idFuncionario) {

        return funcionarioRepository.findById(idFuncionario);
    }

    @Override
    public BigDecimal calculoSalario(Long idFuncionario) {

        Funcionario funcionario = findById(idFuncionario).get();
        BigDecimal calculo_salario = funcionario.getAbonoSalarial().add(funcionario.getCargo().getSalarioBase());
        return calculo_salario;

    }


}
