package fis.training.minitest_with_datajpa.repository;

import fis.training.minitest_with_datajpa.entity.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountRepo extends CrudRepository<Account, Long> {
    List<Account> findByAccountNumber(String accountNumber);
}
