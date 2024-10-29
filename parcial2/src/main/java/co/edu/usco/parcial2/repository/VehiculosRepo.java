package co.edu.usco.parcial2.repository;

import co.edu.usco.parcial2.entity.Vehiculos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VehiculosRepo extends JpaRepository<Vehiculos, Long> {
    @Query(value = "SELECT v FROM Vehiculos v WHERE v.name = :name", nativeQuery = false)
    List<Vehiculos> findByName(@Param("name") String name);
}
