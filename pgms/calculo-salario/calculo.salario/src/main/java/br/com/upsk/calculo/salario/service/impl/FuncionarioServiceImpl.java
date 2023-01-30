package br.com.upsk.calculo.salario.service.impl;

import br.com.upsk.calculo.salario.entity.Funcionario;
import br.com.upsk.calculo.salario.repository.FuncionarioRepository;
import br.com.upsk.calculo.salario.service.FuncionarioService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    private FuncionarioRepository funcionarioRepository;

    public FuncionarioServiceImpl(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    @Override
    public Funcionario save(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    @Override
    public Optional<Funcionario> findById(Long idFuncionario) {
        return funcionarioRepository.findById(idFuncionario);
    }

    @Override
    public void delete(Long idFuncionario) {
        funcionarioRepository.deleteById(idFuncionario);
    }


}
