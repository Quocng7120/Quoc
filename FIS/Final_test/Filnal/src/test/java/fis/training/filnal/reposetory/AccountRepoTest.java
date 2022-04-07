package fis.training.filnal.reposetory;

import fis.training.filnal.entity.Account;
import fis.training.filnal.repository.AccountRepo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AccountRepoTest {

    @Autowired
    AccountRepo accountRepo;

    @Test
    void givenCustomerId_whenFindAccountByCustomerId_thenReturnAccountList() {
        Long id = 1L;
        List<Account> accounts = accountRepo.findAccountByCustomerId(id);

        assertThat(accounts).isNotNull();
    }

    @Test
    void givenAccountNumber_whenFindAccountByAccountNumber_thenReturnAccount() {
        String accountNumber = "1234567890123";
        Account account = accountRepo.findByAccountNumber(accountNumber);

        assertThat(account).isNotNull();
    }

    @Test
    void givenCustomerIdAndStatus_whenFindAccountByCustomerIdAndStatusOrderByAccountNumber_thenReturnAccountList() {
        Long id = 1L;
        Integer status = 1;
        List<Account> accounts = accountRepo.findAccountByCustomerIdAndStatusOrderByAccountNumber(id ,status);

        assertThat(accounts).isNotNull();
    }
}
