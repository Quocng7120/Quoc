package com.vti.departmentmanegement.service;

import com.vti.departmentmanegement.entity.Account;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IAccountService extends UserDetailsService {

    public Account getAccountByUsername(String username);
}
