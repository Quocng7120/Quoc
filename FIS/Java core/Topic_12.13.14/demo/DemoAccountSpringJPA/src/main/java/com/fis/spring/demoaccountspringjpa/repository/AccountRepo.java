package com.fis.spring.demoaccountspringjpa.repository;

import com.fis.spring.demoaccountspringjpa.dao.AccountDao;
import com.fis.spring.demoaccountspringjpa.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long>, AccountDao {
}
