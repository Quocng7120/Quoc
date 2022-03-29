package com.fis.spring.demoaccountspringjpa.dao;

import com.fis.spring.demoaccountspringjpa.entity.Account;

import java.util.List;

public interface AccountDao {
    List<Account> getByFullName(String fullName);
}
