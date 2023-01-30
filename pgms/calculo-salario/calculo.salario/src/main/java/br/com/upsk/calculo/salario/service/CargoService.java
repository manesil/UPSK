package br.com.upsk.calculo.salario.service;

import br.com.upsk.calculo.salario.entity.Cargo;

import java.util.Optional;

public interface CargoService {

    Cargo save(Cargo cargo);

    Cargo update(Cargo cargo);

    Optional<Cargo> findById(Long idCargo);

    void delete(Long idCargo);

}
