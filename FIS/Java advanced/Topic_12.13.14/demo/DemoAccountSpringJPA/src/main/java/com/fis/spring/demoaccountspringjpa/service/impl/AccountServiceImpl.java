package com.fis.spring.demoaccountspringjpa.service.impl;

import com.fis.spring.demoaccountspringjpa.entity.Account;
import com.fis.spring.demoaccountspringjpa.repository.AccountRepo;
import com.fis.spring.demoaccountspringjpa.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepo accountRepo;


    @Override
    public Account save(Account account) {
        //Validate
        account.setIssuedDate(new Date());
        return accountRepo.save(account);
    }

    @Override
    public Account update(Account account) {
        //validate
        account.setUpdateDate(new Date());
        Account account1 =accountRepo.save(account);
        //Lưu lịch sử vào đâu đó
        return account1;
    }

    @Override
    public void deleteById(Long accountId) {
        //get account theo accountId
        //Cập nhật trạng thái sang INACTIVE
        accountRepo.deleteById(accountId);
    }

    @Override
    public Account getById(Long accountId) {
        return accountRepo.getById(accountId);
    }

    @Override
    public List<Account> getByFullName(String fullname) {
        return null;
    }
}
