package com.fis.spring.demoaccountspringjpa.service;

import com.fis.spring.demoaccountspringjpa.entity.Account;

import java.util.List;

public interface AccountService {
    Account save(Account account);
    Account update(Account account);
    void deleteById(Long accountId);
    Account getById(Long accountId);
    List<Account> getByFullName(String fullname);
}
