package fis.training.filnal.service;

import fis.training.filnal.Exception.ValidateException;
import fis.training.filnal.entity.Customer;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomer(Pageable pageable);
    Customer findCustomerById(Long customerId) throws ValidateException;;
    Customer addCustomer(Customer customer) throws ValidateException;
    Customer updateCustomer(Customer customer, Long id) throws ValidateException;
    void deleteCustomer(Long customerId) throws ValidateException;
}
