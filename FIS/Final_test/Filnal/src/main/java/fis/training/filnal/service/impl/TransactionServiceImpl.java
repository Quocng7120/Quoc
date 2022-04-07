package fis.training.filnal.service.impl;

import fis.training.filnal.convert.TransactionConvert;
import fis.training.filnal.dto.TransferDto;
import fis.training.filnal.entity.Account;
import fis.training.filnal.entity.Report;
import fis.training.filnal.entity.Transaction;
import fis.training.filnal.repository.AccountRepo;
import fis.training.filnal.repository.TransactionRepo;
import fis.training.filnal.service.TransactionService;
import org.hibernate.TransactionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRepo transactionRepo;

    @Autowired
    AccountRepo accountRepo;

    @Override
    @Transactional(rollbackOn = {TransactionException.class})
    public Transaction transfer(TransferDto dto) {

        Account fromAccount = accountRepo.findById(dto.getFromAccountId()).orElse(null);
        Account toAccount = accountRepo.findById(dto.getToAccountId()).orElse(null);

        Transaction transaction = TransactionConvert.convertDto(dto, fromAccount, toAccount);

        return transactionRepo.save(transaction);
    }

    @Override
    public List<Transaction> findTransactionOfAnAccount(Long accountId) {
        return null;
    }

    @Override
    public Transaction saveTransaction(Transaction transaction) {
        return null;
    }

    @Override
    public List<Transaction> findTransactionsByAccountNumberAndTime(String accountNumber, String from, String to) {
        return null;
    }

    @Override
    public List<Transaction> findAllByTransactionDateBetween(String from, String to) {
        return null;
    }

    @Override
    public List<Report> findAllByTransactionDateBetweenAndStatus(String from, String to, Integer status) {
        return null;
    }

    @Override
    public List<Object[]> reportByDay(String dateTime) {
        return null;
    }
}
