package fis.training.minitest_with_datajpa.sevice.impl;

import fis.training.minitest_with_datajpa.entity.Account;
import fis.training.minitest_with_datajpa.entity.Transaction;
import fis.training.minitest_with_datajpa.repository.AccountRepo;
import fis.training.minitest_with_datajpa.repository.TransactionRepo;
import fis.training.minitest_with_datajpa.sevice.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    TransactionRepo transactionRepo;
    AccountRepo accountRepo;

    @Override
    public Transaction chuyenTien(Account fromAccount, Account toAccount, Double amount) {
        return null;
    }
}
