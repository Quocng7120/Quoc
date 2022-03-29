package fis.training.minitest_with_datajpa.sevice;

import fis.training.minitest_with_datajpa.entity.Account;

import java.util.List;

public interface AccountService {
    Account addAccount(Account account);
    Account updateAccount(Account account);
    void deleteAccount(Long accountId);
    Account findById(Long accountId);
    List<Account> findAllAccount();
}
