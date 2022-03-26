package fis.training.minitest_with_datajpa.controller;

import fis.training.minitest_with_datajpa.entity.Account;
import fis.training.minitest_with_datajpa.sevice.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<?> add(@RequestBody Account account){
        return  ResponseEntity.ok(accountService.addAccount(account));
    }

    @PostMapping("/update")
    @ResponseBody
    public ResponseEntity<?> save(@RequestBody Account account){
        return  ResponseEntity.ok(accountService.updateAccount(account));
    }

    @GetMapping("/delete/{accountId}")
    @ResponseBody
    public ResponseEntity<?> delete(@PathVariable Long accountId){
        accountService.deleteAccount(accountId);
        return ResponseEntity.ok("Done!");
    }
    @GetMapping("/findById/{accountId}")
    @ResponseBody
    public ResponseEntity<?> findById(@PathVariable Long accountId){
        return ResponseEntity.ok(accountService.findById(accountId));
    }
    @GetMapping("/findAll")
    @ResponseBody
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(accountService.findAllAccount());
    }
}
