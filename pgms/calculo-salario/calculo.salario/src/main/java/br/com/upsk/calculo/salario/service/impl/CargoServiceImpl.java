package br.com.upsk.calculo.salario.service.impl;

import br.com.upsk.calculo.salario.entity.Cargo;
import br.com.upsk.calculo.salario.repository.CargoRepository;
import br.com.upsk.calculo.salario.service.CargoService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CargoServiceImpl implements CargoService {

    private CargoRepository cargoRepository;

    public CargoServiceImpl(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    @Override
    public Cargo save(Cargo cargo) {
        return cargoRepository.save(cargo);
    }

    //TODO - caomo fazer o update e não deveria ser optional tb igual ao findbyid?
    @Override
    public Cargo update(Cargo cargo) {
        return null;
    }
    /*
    public Cargo update(Long idCargo, Cargo cargo) {
        return cargoRepository.update(cargo);
    }
    */

    @Override
    public Optional<Cargo> findById(Long idCargo) {
        return cargoRepository.findById(idCargo);
    }

    @Override
    public void delete(Long idCargo) {
        cargoRepository.deleteById(idCargo);
    }

}
