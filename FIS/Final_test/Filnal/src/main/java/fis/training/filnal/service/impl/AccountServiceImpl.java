package fis.training.filnal.service.impl;

import fis.training.filnal.Exception.AppException;
import fis.training.filnal.Exception.ValidateException;
import fis.training.filnal.entity.Account;
import fis.training.filnal.entity.Customer;
import fis.training.filnal.repository.AccountRepo;
import fis.training.filnal.repository.CustomerRepo;
import fis.training.filnal.service.AccountService;
import fis.training.filnal.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepo accountRepo;

    @Autowired
    CustomerService customerService;

    @Override
    public List<Account> getAllAccount(Pageable pageable) {
        Page<Account> accountPage = accountRepo.findAll(pageable);
        return accountPage.getContent();
    }

    @Override
    public Account findAccountById(Long accountId) throws ValidateException {
        if(!accountRepo.existsById(accountId)){
            throw new ValidateException("404", String.format("AccountId %d is not exist.", accountId));
        }
        return accountRepo.findById(accountId).orElse(null);
    }

    @Override
    public Account findAccountByAccountNumber(String accountNumber) {
        if(!accountRepo.existsByAccountNumber(accountNumber)){
            throw new ValidateException("404", String.format("Account Number %d is not exist.", accountNumber));
        }
        return accountRepo.findByAccountNumber(accountNumber);
    }

    @Override
    public Account addAccount(Account account) {
        Account acc = accountRepo.findByAccountNumber(account.getAccountNumber());
        if(acc != null){
            throw new AppException("405", String.format("Account Number %s is exist.", account.getAccountNumber()));
        }
        return accountRepo.save(account);
    }

    @Override
    public void approveAccount(Long id) {
        Optional<Account> account = accountRepo.findById(id);
        if(!account.isPresent()){
            throw new AppException("404", String.format("AccountId %d is not exist.", id));
        }
        Account acc = account.get();
        acc.setStatus(1);
        accountRepo.save(acc);
    }

    @Override
    public void updateStatusAccount(Long id, int status) throws AppException{
        Optional<Account> account = accountRepo.findById(id);
        if(!account.isPresent()){
            throw new AppException("404", String.format("AccountId %d is not exist.", id));
        }
        if (status!=0 && status!=2){
            throw new AppException("400", "This status is not suitable!");
        }
        Account acc = account.get();
        acc.setStatus(status);
        accountRepo.save(acc);
    }

    @Override
    public List<Account> findAccountByCustomerIdAndStatusOrderByAccountNumber(Long id, Integer status) {
        Customer customer = customerService.findCustomerById(id);
        if(customer == null){
            throw new AppException("CUS404", String.format("CustomerId %d is not exist.", id));
        }
        if(status == null){
            List<Account> accounts = accountRepo.findAccountByCustomerId(id);
            Collections.sort(accounts, new Comparator<Account>() {
                @Override
                public int compare(Account o1, Account o2) {
                    if(o1.getStatus().equals(1) && !o2.getStatus().equals(1)){
                        return 1;
                    }else if(!o1.getStatus().equals(1) && o2.getStatus().equals(1)){
                        return -1;
                    } else {
                        return o1.getAccountNumber().compareTo(o2.getAccountNumber());
                    }
                }
            });
            return accounts;
        }
        return accountRepo.findAccountByCustomerIdAndStatusOrderByAccountNumber(id, status);
    }
}
