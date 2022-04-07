package fis.training.filnal.controller;

import fis.training.filnal.entity.Account;
import fis.training.filnal.entity.Customer;
import fis.training.filnal.service.AccountService;
import fis.training.filnal.service.CustomerService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping()
    @ResponseBody
    public ResponseEntity<?> getAllAccount(@RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size){
        Pageable pageable = PageRequest.of(page.orElse(1) - 1, size.orElse(3));
        return ResponseEntity.ok(accountService.getAllAccount(pageable));
    }


    @GetMapping("/active-customer/{id}")
    public ResponseEntity<List<Account>> activeAccount(@PathVariable("id") Optional<Long> id){
        Integer status = 1;
        List<Account> accounts = accountService.findAccountByCustomerIdAndStatusOrderByAccountNumber(id.orElse(null), status);
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @GetMapping("/in-active-customer/{id}")
    public ResponseEntity<List<Account>>  inActiveAccount(@PathVariable("id") Optional<Long> id){
        Integer status = 2;
        List<Account> accounts = accountService.findAccountByCustomerIdAndStatusOrderByAccountNumber(id.orElse(null), status);
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<?> add(@RequestBody Account account){
        return  ResponseEntity.ok(accountService.addAccount(account));
    }

    @GetMapping("/findById/{accountId}")
    @ResponseBody
    public ResponseEntity<?> findById(@PathVariable Long accountId){
        return ResponseEntity.ok(accountService.findAccountById(accountId));
    }

    @GetMapping("/findAccountByAccountNumber/{accountNumber}")
    @ResponseBody
    public ResponseEntity<?> findAccountByAccountNumber(@PathVariable String accountNumber){
        return ResponseEntity.ok(accountService.findAccountByAccountNumber(accountNumber));
    }

    @GetMapping("/approve/{id}")
    public ResponseEntity<String> approveAccount(@PathVariable("id") Optional<Long> id){

        Long accountId = id.orElse(null);
        accountService.approveAccount(accountId);
        log.info("Account with id {} approved.", id);
        return new ResponseEntity<String>("Account approve successfully.", HttpStatus.OK);
    }

    @GetMapping("/{id}/status/{status}")
    public ResponseEntity<String> updateAccountStatus(@PathVariable("id") Optional<Long> id,@PathVariable("status")Optional<Integer> status){
        accountService.updateStatusAccount(id.orElse(null), status.orElse(null));
        log.info("Account with id {} update new status: {}", id, status);
        return new ResponseEntity<String>("Account status update successfully", HttpStatus.OK);
    }
}
