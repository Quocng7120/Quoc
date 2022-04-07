package fis.training.filnal.service;

import fis.training.filnal.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService{
    User save(User employee);
}
