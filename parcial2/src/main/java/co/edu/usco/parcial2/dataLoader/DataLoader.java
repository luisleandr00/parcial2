package co.edu.usco.parcial2.dataLoader;

import co.edu.usco.parcial2.entity.Roles;
import co.edu.usco.parcial2.entity.UsersEntity;
import co.edu.usco.parcial2.repository.RolesRepo;
import co.edu.usco.parcial2.repository.UsersRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
@AllArgsConstructor
public class DataLoader implements CommandLineRunner {
    private UsersRepo usersRepo;
    private RolesRepo rolesRepo;
    private PasswordEncoder passwordEncoder;
    public void run(String... args) throws Exception {
        /* Roles */
        Roles cliente = rolesRepo.findById(1L)
                .orElseThrow(() -> new EntityNotFoundException("role not found!"));

        Roles acomodador = rolesRepo.findById(2L)
                .orElseThrow(() -> new EntityNotFoundException("role not found!"));

        Roles admin = rolesRepo.findById(4L)
                .orElseThrow(() -> new EntityNotFoundException("role not found!"));


        UsersEntity luisUser = UsersEntity.builder()
                .username("luis")
                .password(passwordEncoder.encode("luis"))
                .roles(Set.of(admin))
                .build();
        UsersEntity angyUser = UsersEntity.builder()
                .username("angy")
                .password(passwordEncoder.encode("angy"))
                .roles(Set.of(acomodador))
                .build();

        UsersEntity julianUser = UsersEntity.builder()
                .username("julian")
                .password(passwordEncoder.encode("julian"))
                .roles(Set.of(cliente))
                .build();
        usersRepo.saveAll(List.of(luisUser,
                angyUser,
                julianUser ));
    }


}
