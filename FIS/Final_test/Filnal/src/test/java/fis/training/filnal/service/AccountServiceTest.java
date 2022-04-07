package fis.training.filnal.service;

import fis.training.filnal.entity.Account;
import fis.training.filnal.entity.Customer;
import fis.training.filnal.repository.AccountRepo;
import fis.training.filnal.service.impl.AccountServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class AccountServiceTest {

    @Mock
    AccountRepo accountRepo;

    @InjectMocks
    @Autowired
    AccountServiceImpl accountService;

    Account account;

    List<Account> accounts;

    @BeforeEach
    public void setUp(){
        account = Account.builder()
                .accountId(4L)
                .accountNumber("1234567890123")
                .balance(8450000d)
                .create_datetime(LocalDateTime.now())
                .status(3)
                .update_datetime(LocalDateTime.now())
                .customer(new Customer())
                .build();

        accounts = new ArrayList<>();
        accounts.add(account);
    }

    @AfterEach
    public void tearDown(){
        account = null;
        accounts = null;
    }

    @Test
    void whenGetAllAccounts_thenReturnAccountList() {
        Page<Account> page = new PageImpl<>(accounts);

        when(accountRepo.findAll(page.getPageable())).thenReturn((Page<Account>) accounts);

        List<Account> list = accountService.getAllAccount(page.getPageable());

        assertThat(list.size()).isEqualTo(1);
    }

    @Test
    void givenCustomerIdAndStatus_whenFindAccountByCustomer_IdAndStatusOrderByAccountNumber_thenReturnAccountList() {
        Long id = 1L;
        Integer status = 1;
        when(accountRepo.findAccountByCustomerIdAndStatusOrderByAccountNumber(id, status)).thenReturn(accounts);

        List<Account> list = accountService.findAccountByCustomerIdAndStatusOrderByAccountNumber(id, status);

        assertThat(list.size()).isEqualTo(1);
    }

    @Test
    void givenAccountId_whenFindAccountById_thenReturnAccount() {
        Long id = 4L;

        when(accountRepo.findById(id)).thenReturn(Optional.of(account));

        Account acc = accountService.findAccountById(id);

        assertThat(acc.getAccountId()).isEqualTo(4L);
    }

    @Test
    void givenAccountNumber_whenFindAccountByAccountNumber_thenReturnAccount() {
        String accountNumber = "1234567890123";

        when(accountRepo.findByAccountNumber(accountNumber)).thenReturn(account);

        Account acc = accountService.findAccountByAccountNumber(accountNumber);

        assertThat(acc.getAccountNumber()).isEqualTo(accountNumber);
    }

    @Test
    void givenAccount_whenSaveAccount_thenReturnAccount() {
        when(accountRepo.save(account)).thenReturn(account);

        Account acc = accountService.addAccount(account);

        assertThat(acc).isNotNull();
    }

//    @Test
//    void givenAccountId_whenApproveAccount_thenReturnAccount() {
//        when(accountRepo.findById(account.getAccountId())).thenReturn(Optional.of(account));
//        when(accountRepo.save(account)).thenReturn(account);
//
//        accountService.approveAccount(account.getAccountId());
//
//        assertThat();
//    }


}
