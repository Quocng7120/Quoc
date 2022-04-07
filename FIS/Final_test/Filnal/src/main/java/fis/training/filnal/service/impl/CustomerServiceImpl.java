package fis.training.filnal.service.impl;

import fis.training.filnal.Exception.ValidateException;
import fis.training.filnal.entity.Customer;
import fis.training.filnal.repository.CustomerRepo;
import fis.training.filnal.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepo customerRepo;


    @Override
    public List<Customer> getAllCustomer(Pageable pageable) {
        Page<Customer> customerPage = customerRepo.findAll(pageable);
        return customerPage.getContent();
    }

    @Override
    public Customer findCustomerById(Long customerId) {
        if(!customerRepo.existsById(customerId)){
            throw new ValidateException("404", String.format("CustomerId %d is not exist.", customerId));
        }
        return customerRepo.findById(customerId).orElse(null);
    }

    @Override
    public Customer addCustomer(Customer customer) throws ValidateException {
        Customer ctm = customerRepo.findByIdentityNo(customer.getIdentityNo());
        if(ctm != null){
            throw new ValidateException("405", String.format("Identity No %s is exist.", customer.getIdentityNo()));
        }
        return customerRepo.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer, Long id) throws ValidateException{
        if(!customerRepo.existsById(id)){
            throw new ValidateException("404", String.format("CustomerId %d is not exist.", id));
        }
        customer.setCustomerId(id);
        return customerRepo.save(customer);
    }

    @Override
    public void deleteCustomer(Long customerId) {
        Optional<Customer> customer = customerRepo.findById(customerId);
        if(!customer.isPresent()){
            throw new ValidateException("404", String.format("CustomerId %d is not exist.", customerId));
        }
        Customer ctm = customer.get();
        ctm.setStatus(1);
        customerRepo.save(ctm);
    }
}
