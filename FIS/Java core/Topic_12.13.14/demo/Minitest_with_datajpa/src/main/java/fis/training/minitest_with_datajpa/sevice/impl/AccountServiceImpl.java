package fis.training.minitest_with_datajpa.sevice.impl;

import fis.training.minitest_with_datajpa.entity.Account;
import fis.training.minitest_with_datajpa.repository.AccountRepo;
import fis.training.minitest_with_datajpa.sevice.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepo accountRepo;

    @Override
    public Account addAccount(Account account) {
        return accountRepo.save(account);
    }

    @Override
    public Account updateAccount(Account account) {
        return accountRepo.save(account);
    }

    @Override
    public void deleteAccount(Long accountId) {
        accountRepo.deleteById(accountId);
    }

    @Override
    public Account findById(Long accountId) {
        return  accountRepo.findById(accountId).orElse(null);
    }

    @Override
    public List<Account> findAllAccount() {
        return (List<Account>) accountRepo.findAll();
    }
}
