package co.edu.usco.parcial2.service;

import co.edu.usco.parcial2.entity.Roles;
import co.edu.usco.parcial2.entity.UsersEntity;
import co.edu.usco.parcial2.repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsersRepo usersRepo;
    @Override
    public UserDetails loadUserByUsername(String username) {

        UsersEntity user = usersRepo.findUser(username)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario " + username + " no existe."));

        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();

        for (Roles role : user.getRoles()) {
            authorityList.add(new SimpleGrantedAuthority("ROLE_".concat(role.getName())));
        }

        return new User(user.getUsername(),
                user.getPassword(),
                authorityList);
    }
}
