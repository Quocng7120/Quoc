package fis.training.filnal.service;

import fis.training.filnal.entity.Account;
import fis.training.filnal.entity.Transaction;
import fis.training.filnal.repository.AccountRepo;
import fis.training.filnal.repository.TransactionRepo;
import fis.training.filnal.service.impl.AccountServiceImpl;
import fis.training.filnal.service.impl.TransactionServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class TransactionServiceTest {

    @Mock
    TransactionRepo transactionRepo;

    @Mock
    AccountRepo accountRepo;

    @InjectMocks
    @Autowired
    TransactionServiceImpl transactionService;

    @Autowired
    @InjectMocks
    AccountServiceImpl accountService;

    Transaction transaction;

    List<Transaction> transactions;

    @BeforeEach
    public void setUp(){
        transaction = Transaction.builder()
                .transactionId(9L)
                .amount(50000d)
                .content("Happy Birthday")
                .errorReason("")
                .status(0)
                .transactionDate(LocalDateTime.now())
                .fromAccount(new Account())
                .toAccount(new Account())
                .build();

        transactions = new ArrayList<>();
        transactions.add(transaction);
    }

    @AfterEach
    public void tearDown(){
        transactions = null;
        transaction = null;
    }

//    @Test
//    void givenTransaction_whenTransfer_thenReturnTransaction() {
//        when(accountRepo.findById(transaction.getFromAccount().getAccountId())).thenReturn(Optional.of(transaction.getFromAccount()));
//        when(accountService.findAccountById(transaction.getFromAccount().getAccountId())).thenReturn(transaction.getFromAccount());
//        when(transactionRepo.save(transaction)).thenReturn(transaction);
//
//        Transaction trans = transactionService.transfer();
//
//        assertThat(trans).isNotNull();
//    }

}
