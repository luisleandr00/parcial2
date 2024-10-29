package co.edu.usco.parcial2.repository;

import co.edu.usco.parcial2.entity.Tipos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TiposRepo extends JpaRepository<Tipos, Long> {
    @Query(value = "SELECT t FROM Tipos t WHERE t.name = :name", nativeQuery = false)
    Tipos findByName(@Param("name") String name);
}
