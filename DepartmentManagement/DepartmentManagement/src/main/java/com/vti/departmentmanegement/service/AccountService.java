package com.vti.departmentmanegement.service;

import com.vti.departmentmanegement.entity.Account;
import com.vti.departmentmanegement.repository.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AccountService implements IAccountService {

	@Autowired
	private IAccountRepository repository;


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = repository.findByUsername(username);

		if(account == null){
			throw new UsernameNotFoundException(username);
		}
		new BCryptPasswordEncoder().encode("123456");
		return new User(account.getUsername(), account.getPassword(), AuthorityUtils.createAuthorityList("user"));
	}

	@Override
	public Account getAccountByUsername(String username){
		return repository.findByUsername(username);
	}
}
