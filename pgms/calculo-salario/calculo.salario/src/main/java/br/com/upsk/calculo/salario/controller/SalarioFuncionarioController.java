package br.com.upsk.calculo.salario.controller;

import br.com.upsk.calculo.salario.dto.*;

import br.com.upsk.calculo.salario.service.FuncionarioService;
import br.com.upsk.calculo.salario.service.SalarioFuncionarioService;
import br.com.upsk.calculo.salario.entity.Funcionario;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/salariofuncionario")
public class SalarioFuncionarioController {

    //classe de acesso, vincula a controller com o serviço
    private SalarioFuncionarioService salarioFuncionarioService;
    private FuncionarioService funcionarioService;

    public SalarioFuncionarioController(SalarioFuncionarioService salarioFuncionarioService, FuncionarioService funcionarioService) {
        this.salarioFuncionarioService = salarioFuncionarioService;
        this.funcionarioService = funcionarioService;
    }

    //calcula salario pelo funcionário id
    @GetMapping(value = "/{id}")
    public ResponseEntity<SalarioFuncionarioResponseDTO> getById(@PathVariable(value = "id") Long funcionarioId) {

        Optional<Funcionario> funcionario = funcionarioService.findById(funcionarioId);

        if (funcionario.isPresent()) {
            SalarioFuncionarioResponseDTO salarioFuncionarioResponseDTO = new SalarioFuncionarioResponseDTO();

            salarioFuncionarioResponseDTO.setFuncionario(new FuncionarioResponseDTO());
            salarioFuncionarioResponseDTO.setCargo(new CargoResponseDTO());

            salarioFuncionarioResponseDTO.getFuncionario().setId(funcionario.get().getId());
            salarioFuncionarioResponseDTO.getFuncionario().setNome(funcionario.get().getNome());
            salarioFuncionarioResponseDTO.getFuncionario().setAbonoSalarial(funcionario.get().getAbonoSalarial());

            salarioFuncionarioResponseDTO.getCargo().setId(funcionario.get().getCargo().getId());
            salarioFuncionarioResponseDTO.getCargo().setDescricao(funcionario.get().getCargo().getDescricao() );
            salarioFuncionarioResponseDTO.getCargo().setSalarioBase(funcionario.get().getCargo().getSalarioBase());

            salarioFuncionarioResponseDTO.setSalarioAtual(salarioFuncionarioService.calculoSalario(funcionarioId));

            return ResponseEntity.ok(salarioFuncionarioResponseDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

}
