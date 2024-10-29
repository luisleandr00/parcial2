package co.edu.usco.parcial2.service;

import co.edu.usco.parcial2.entity.Vehiculos;
import co.edu.usco.parcial2.repository.TiposRepo;
import co.edu.usco.parcial2.repository.VehiculosRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehiculosService implements IVehiculosService{
    @Autowired
    private VehiculosRepo vehiculosRepo;

    @Autowired
    private TiposRepo tiposRepo;

    @Override
    public List<Vehiculos> findByName(String name) {
        return vehiculosRepo.findByName(name);
    }

    @Override
    public Optional<Vehiculos> findById(Long id) {
        return vehiculosRepo.findById(id);
    }

    @Override
    public List<Vehiculos> findAll() {
        return vehiculosRepo.findAll();
    }

    @Override
    public void save(Vehiculos vehiculos) {

        vehiculos.setTipos(tiposRepo.findByName(vehiculos.getTipos().getName()));
        vehiculosRepo.save(vehiculos);
    }

    @Override
    public void delete(Long id) {
        vehiculosRepo.deleteById(id);
    }



}
