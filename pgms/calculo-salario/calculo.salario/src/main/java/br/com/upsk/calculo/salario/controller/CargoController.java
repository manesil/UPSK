package br.com.upsk.calculo.salario.controller;

import br.com.upsk.calculo.salario.dto.CargoResponseDTO;
import br.com.upsk.calculo.salario.dto.CargoSaveRequestDTO;
import br.com.upsk.calculo.salario.dto.CargoSaveResponseDTO;
import br.com.upsk.calculo.salario.entity.Cargo;
import br.com.upsk.calculo.salario.service.CargoService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/cargos")
public class CargoController {

    //classe de acesso, vincula a controller com o serviço
    private CargoService cargoService;

    public CargoController(CargoService cargoService) {
        this.cargoService = cargoService;
    }

    //trata a resposta da entidade
    @PostMapping
    public ResponseEntity<CargoSaveResponseDTO> save(@RequestBody @Valid CargoSaveRequestDTO cargoRequest) {

        //Registra LOG
        log.info(cargoRequest.toString());

        //Captura
        Cargo cargo = new Cargo();
        cargo.setId(cargoRequest.getId());
        cargo.setDescricao(cargoRequest.getDescricao());
        cargo.setSalarioBase(cargoRequest.getSalarioBase());

        //save
        cargoService.save(cargo);

        //devolve resposta
        CargoSaveResponseDTO cargoResponse = new CargoSaveResponseDTO();
        cargoResponse.setId(cargo.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(cargoResponse);
    }

    //Busca um cargo pelo indice
    @GetMapping(value = "/{idCargo}")
    public ResponseEntity<CargoResponseDTO> getById(@PathVariable(value = "idCargo") Long id) {

        Optional<Cargo> cargo = cargoService.findById(id);

        if (cargo.isPresent()) {
            CargoResponseDTO cargoResponseDTO = new CargoResponseDTO();
            cargoResponseDTO.setId(cargo.get().getId());
            cargoResponseDTO.setDescricao(cargo.get().getDescricao());
            cargoResponseDTO.setSalarioBase(cargo.get().getSalarioBase());
            return ResponseEntity.ok(cargoResponseDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    //atualiza utilizando o ID
    @PutMapping("/{idCargo}")
    public ResponseEntity update(@PathVariable Long idCargo, @RequestBody @Valid CargoSaveRequestDTO cargoRequest) {

        Optional<Cargo> cargo = cargoService.findById(idCargo);

        if (cargo.isPresent()) {
            //cargo.get().setId(cargoRequest.getId());
            cargo.get().setDescricao(cargoRequest.getDescricao());
            cargo.get().setSalarioBase(cargoRequest.getSalarioBase());
            cargoService.save(cargo.get());
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

    //apaga um cargo
    @DeleteMapping("/{idCargo}")
    public ResponseEntity<String> delete(@PathVariable Long idCargo) {

        Optional<Cargo> cargo = cargoService.findById(idCargo);
        if (cargo.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        // delete
        cargoService.delete(idCargo);
        return ResponseEntity.ok().build();
    }

    //lista os cargos
    @GetMapping
    public ResponseEntity<List<CargoResponseDTO>> findAll() {
        //select
        return ResponseEntity.ok(new ArrayList<>());
    }

}
