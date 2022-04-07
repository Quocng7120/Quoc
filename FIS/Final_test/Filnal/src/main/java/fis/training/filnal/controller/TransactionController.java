package fis.training.filnal.controller;

import fis.training.filnal.Exception.AppException;
import fis.training.filnal.Exception.ValidateException;
import fis.training.filnal.convert.CustomerConvert;
import fis.training.filnal.dto.CustomerDto;
import fis.training.filnal.dto.TransferDto;
import fis.training.filnal.entity.Customer;
import fis.training.filnal.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/newTransfer")
    @ResponseBody
    public ResponseEntity<?> newTransfer(@RequestBody TransferDto dto) {
        return ResponseEntity.ok(transactionService.transfer(dto));
    }
}
