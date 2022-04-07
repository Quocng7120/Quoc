package fis.training.filnal.repository;

import fis.training.filnal.entity.Account;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {

    List<Account> findAccountByCustomerId(Long id);

    boolean existsByAccountNumber(String accountNumber);

    Account findByAccountNumber(String accountNumber);

    List<Account> findAccountByCustomerIdAndStatusOrderByAccountNumber(Long id, Integer status);

}
