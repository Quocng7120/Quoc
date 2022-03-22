package vn.fis.training.repository.inmemory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import vn.fis.training.domain.Account;
import vn.fis.training.repository.AccountRepository;

import static org.junit.jupiter.api.Assertions.*;

public class AccountRepositoryInMemoryTest {

    Logger LOG = LogManager.getLogger(AccountRepositoryInMemoryTest.class);
    AccountRepository accountRepository;

    @BeforeEach
    void setUp(){
        LOG.info("Init...");
        accountRepository = new AccountRepositoryInMemory();
    }

    @Test void given_anValid_Account_Call_AddAccount_Shoud_Success(){
        Account account = new Account(1L, "03424324252", "Nguyen Duy Quoc", 1221.0, 1);
        Account addedAccount = accountRepository.addAccount(account);
        assertTrue(addedAccount.equals(account));
    }

    @Test void given_anValib_AccountId_Call_Delete_Should_Success(){
        Account account = new Account(1L, "03424324252", "Nguyen Duy Quoc", 1221.0, 1);
        accountRepository.addAccount(account);
        accountRepository.deleteAccount(1L);
        assertTrue(accountRepository.findAllAccountOrderDyIdAsc().size()==0);
    }

//    @Test void ...(){
//        Account account1 = new Account(1L, "03424324252", "Nguyen Duy Quoc", 1221.0, 1);
//        Account account2 = new Account(2L, "03424324252", "Nguyen Duy Quoc", 1221.0, 1);
//        Account account3 = new Account(3L, "03424324252", "Nguyen Duy Quoc", 1221.0, 1);
//        Account account4 = new Account(4L, "03424324252", "Nguyen Duy Quoc", 1221.0, 1);
//        accountRepository.addAccount(account1);
//        accountRepository.addAccount(account2);
//        accountRepository.addAccount(account3);
//        accountRepository.addAccount(account4);
//        assertTrue(accountRepository.findById(2L).getId() == 2L);
//        assertTrue(accountRepository.findById(3L).getId() == 3L);
//    }
}