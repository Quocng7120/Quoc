package fis.training.filnal.controller;


import fis.training.filnal.Exception.ValidateException;
import fis.training.filnal.convert.CustomerConvert;
import fis.training.filnal.dto.CustomerDto;
import fis.training.filnal.entity.Customer;
import fis.training.filnal.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping()
    @ResponseBody
    public ResponseEntity<?> getAllCustomers(@RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size){
        Pageable pageable = PageRequest.of(page.orElse(1) - 1, size.orElse(3));
        return ResponseEntity.ok(customerService.getAllCustomer(pageable));
    }

//    @PostMapping("/add")
//    @ResponseBody
//    public ResponseEntity<?> add(@RequestBody CustomerDto dto) throws ValidateException {
//        Customer customer = CustomerConvert.convertDto(dto);
//        return ResponseEntity.ok(customerService.addCustomer(customer));
//    }

    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<?> add(@RequestBody CustomerDto dto) throws ValidateException {
        Customer customer = CustomerConvert.convertDto(dto);
        return ResponseEntity.ok(customerService.addCustomer(customer));
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Customer> findCustomerById(@PathVariable("id") Optional<Long> id) {
        Long customerId = id.orElse(null);
        return new ResponseEntity<Customer>(customerService.findCustomerById(customerId),HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") Optional<Long> id){
        Long criminalCaseId = id.orElse(null);
        customerService.deleteCustomer(criminalCaseId);
                return new ResponseEntity<String>("Criminal Case deleted successfully.",
                HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Customer> updateCriminalCase(@Validated @RequestBody CustomerDto dto, @PathVariable("id") Optional<Long> id){
        Long customerId = id.orElse(null);
        Customer customer = CustomerConvert.convertDto(dto);
        customer = customerService.updateCustomer(customer, customerId);
        return new ResponseEntity<Customer>(customer, HttpStatus.OK);
    }

}
