package fis.training.order.service.impl;

import fis.training.order.entity.Customer;
import fis.training.order.repository.CustomerRepo;
import fis.training.order.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    @Override
    public Customer addCustomer(Customer customer) {
        if(customerRepo.existsByUsername(customer.getUsername())) return null;
        return customerRepo.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        Customer c =customerRepo.findByUsername(customer.getUsername());
        if(c.equals(null)) return null;
        customer.setCustomerId(c.getCustomerId());
        return customerRepo.save(customer);
    }

    @Override
    public String deleteCustomer(Long customerId) {
        if(!customerRepo.existsById(customerId)) return "Không tồn tại!";
        customerRepo.deleteById(customerId);
        return "Xóa thành công!";

    }

    @Override
    public Customer findById(Long customerId) {
        if(!customerRepo.existsById(customerId)) return null;
        return customerRepo.findById(customerId).get();
    }
}
