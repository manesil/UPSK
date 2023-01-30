package br.com.upsk.calculo.salario.controller;

import br.com.upsk.calculo.salario.dto.*;
import br.com.upsk.calculo.salario.service.FuncionarioService;
import br.com.upsk.calculo.salario.entity.Cargo;
import br.com.upsk.calculo.salario.entity.Endereco;
import br.com.upsk.calculo.salario.entity.Funcionario;


import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    //classe de acesso, vincula a controller com o serviço
    private FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    ///trata a resposta da entidade
    @PostMapping
    public ResponseEntity<FuncionarioSaveResponseDTO> save(@RequestBody @Valid FuncionarioSaveRequestDTO funcionarioRequest) {
        log.info(funcionarioRequest.toString());

        Funcionario funcionario = new Funcionario();
        funcionario.setId(funcionarioRequest.getId());
        funcionario.setCpf(funcionarioRequest.getCpf());
        funcionario.setNome(funcionarioRequest.getNome());
        funcionario.setEmail(funcionarioRequest.getEmail());
        funcionario.setAbonoSalarial(funcionarioRequest.getAbonoSalarial());
        funcionario.setSenha(funcionarioRequest.getSenha());

        Endereco endereco = new Endereco();
        endereco.setId(funcionarioRequest.getEndereco().getId());
        endereco.setLogradouro(funcionarioRequest.getEndereco().getLogradouro());
        endereco.setBairro(funcionarioRequest.getEndereco().getBairro());
        endereco.setCidade(funcionarioRequest.getEndereco().getCidade());
        endereco.setUf(funcionarioRequest.getEndereco().getUf());
        endereco.setCep(funcionarioRequest.getEndereco().getCep());

        Cargo cargo = new Cargo();
        cargo.setId(funcionarioRequest.getCargo().getId());
        cargo.setDescricao(funcionarioRequest.getCargo().getDescricao());
        cargo.setSalarioBase(funcionarioRequest.getCargo().getSalarioBase());

        funcionario.setEndereco(endereco);
        funcionario.setCargo(cargo);

        funcionario = funcionarioService.save(funcionario);

        FuncionarioSaveResponseDTO funcionarioSaveResponseDTO = new FuncionarioSaveResponseDTO();
        funcionarioSaveResponseDTO.setId(funcionario.getId());

        return ResponseEntity.ok(funcionarioSaveResponseDTO);
    }

    //busca funcionário pelo id
    @GetMapping(value = "/{id}")
    public ResponseEntity<FuncionarioResponseDTO> getById(@PathVariable(value = "id") Long funcionarioId) {

        Optional<Funcionario> funcionario = funcionarioService.findById(funcionarioId);

        if (funcionario.isPresent()) {
            FuncionarioResponseDTO funcionarioResponseDTO = new FuncionarioResponseDTO();

            funcionarioResponseDTO.setId(funcionario.get().getId());
            funcionarioResponseDTO.setNome(funcionario.get().getNome());
            funcionarioResponseDTO.setCpf(funcionario.get().getCpf());
            funcionarioResponseDTO.setEmail(funcionario.get().getEmail());
            funcionarioResponseDTO.setAbonoSalarial(funcionario.get().getAbonoSalarial());
            funcionarioResponseDTO.setEndereco(new EnderecoDTO());
            funcionarioResponseDTO.setCargo(new CargoResponseDTO());

            funcionarioResponseDTO.getCargo().setId(funcionario.get().getCargo().getId());
            funcionarioResponseDTO.getCargo().setDescricao(funcionario.get().getCargo().getDescricao() );
            funcionarioResponseDTO.getCargo().setSalarioBase(funcionario.get().getCargo().getSalarioBase());

            funcionarioResponseDTO.getEndereco().setId(funcionario.get().getEndereco().getId());
            funcionarioResponseDTO.getEndereco().setLogradouro(funcionario.get().getEndereco().getLogradouro());
            funcionarioResponseDTO.getEndereco().setBairro(funcionario.get().getEndereco().getBairro());
            funcionarioResponseDTO.getEndereco().setCidade(funcionario.get().getEndereco().getCidade());
            funcionarioResponseDTO.getEndereco().setUf(funcionario.get().getEndereco().getUf());
            funcionarioResponseDTO.getEndereco().setCep(funcionario.get().getEndereco().getCep());

            return ResponseEntity.ok(funcionarioResponseDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

}
