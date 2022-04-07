package fis.training.filnal.service.impl;

import fis.training.filnal.entity.Role;
import fis.training.filnal.entity.User;
import fis.training.filnal.repository.UserRepo;
import fis.training.filnal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    BCryptPasswordEncoder passwordEncoder;

    @Override
    public User save(User employee) {
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        return userRepo.save(employee);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User employee = userRepo.findById(username).orElse(null);
        if(employee == null){
            throw new UsernameNotFoundException(username + " not found.");
        }
        return org.springframework.security.core.userdetails.User.withUsername(username).password(employee.getPassword()).roles().build();
    }

    private Collection<? extends GrantedAuthority> mapRolesAuthorities(Collection<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getId())).collect(Collectors.toList());
    }
}
