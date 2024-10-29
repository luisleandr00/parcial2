package co.edu.usco.parcial2.service;

import co.edu.usco.parcial2.entity.Vehiculos;

import java.util.List;
import java.util.Optional;

public interface IVehiculosService {
    List<Vehiculos> findByName(String name);

    Optional<Vehiculos> findById(Long id);

    List<Vehiculos> findAll();

    void save (Vehiculos vehiculos);

    void delete (Long id);

}
