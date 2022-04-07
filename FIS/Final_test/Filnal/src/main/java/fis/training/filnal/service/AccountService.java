package fis.training.filnal.service;

import fis.training.filnal.entity.Account;
import fis.training.filnal.entity.Customer;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AccountService {
    List<Account> getAllAccount(Pageable pageable);


    Account findAccountById(Long accountId);
    Account findAccountByAccountNumber(String accountNumber);
    Account addAccount(Account account);
    void approveAccount(Long id);
    void updateStatusAccount(Long id, int status);
    List<Account> findAccountByCustomerIdAndStatusOrderByAccountNumber(Long id, Integer status);

}
