package fis.training.order.service;

import fis.training.order.entity.Customer;

public interface CustomerService {
    Customer addCustomer(Customer customer);
    Customer updateCustomer(Customer customer);
    String deleteCustomer(Long customerId);
    Customer findById(Long customerId);
}
