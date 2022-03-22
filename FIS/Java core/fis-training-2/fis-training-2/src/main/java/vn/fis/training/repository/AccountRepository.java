package vn.fis.training.repository;

import vn.fis.training.domain.Account;

import java.util.List;

public interface AccountRepository {
    Account addAccount(Account account);
    Account updateAccount(Account account);
    void deleteAccount(Long id);
    List<Account> findAllAccountOrderDyIdAsc();
    Account findById(Long id);
}
