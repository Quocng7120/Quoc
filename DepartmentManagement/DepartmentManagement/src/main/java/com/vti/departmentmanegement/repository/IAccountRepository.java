package com.vti.departmentmanegement.repository;

import com.vti.departmentmanegement.entity.Account;
import com.vti.departmentmanegement.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountRepository extends JpaRepository<Account, Short> {
    public Account findByUsername(String username);
}
