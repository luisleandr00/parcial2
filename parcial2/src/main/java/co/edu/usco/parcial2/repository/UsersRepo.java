package co.edu.usco.parcial2.repository;

import co.edu.usco.parcial2.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepo extends JpaRepository<UsersEntity, Long> {
    @Query(value = "SELECT u FROM UsersEntity u WHERE u.username = :username", nativeQuery = false)
    Optional<UsersEntity> findUser(@Param("username") String username);
}
