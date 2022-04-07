package fis.training.filnal.service;

import fis.training.filnal.entity.Customer;
import fis.training.filnal.entity.CustomerType;
import fis.training.filnal.repository.CustomerRepo;
import fis.training.filnal.service.impl.CustomerServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @Mock
    CustomerRepo customerRepo;

    @InjectMocks
    @Autowired
    CustomerServiceImpl customerService;

    Customer customer;

    List<Customer> customers;

    @BeforeEach
    public void setUp(){
        customer = Customer.builder()
                .customerId(1L)
                .address("HHT")
                .birthday(LocalDateTime.now().minusDays(365 * 30))
                .createDatetime(LocalDateTime.now())
                .customerType(CustomerType.INDIVIDUAL)
                .identityNo("1234567890")
                .mobile("0342082940")
                .name("Quocng")
                .status(1)
                .updateDatetime(LocalDateTime.now())
                .build();

        customers = new ArrayList<>();
        customers.add(customer);
    }

    @AfterEach
    public void tearDown(){
        customers = null;
        customer = null;
    }

    @Test
    void whenFindAllCustomer_thenReturnCustomerList() {
        Page<Customer> page = new PageImpl<>(customers);

        when(customerRepo.findAll(page.getPageable())).thenReturn(page);

        List<Customer> list = customerService.getAllCustomer(page.getPageable());

        assertThat(list.size()).isEqualTo(1);
    }

    @Test
    void givenCustomer_whenCreateCustomer_thenReturnCustomer() {
        when(customerRepo.save(customer)).thenReturn(customer);

        Customer cus = customerService.addCustomer(customer);

        assertThat(cus.getCustomerId()).isEqualTo(customer.getCustomerId());
    }

    @Test
    void givenCustomerAndId_whenUpdateCustomer_thenReturnCustomer() {
        when(customerRepo.existsById(customer.getCustomerId())).thenReturn(true);
        when(customerRepo.save(customer)).thenReturn(customer);

        Customer cus = customerService.updateCustomer(customer, customer.getCustomerId());

        assertThat(cus.getCustomerId()).isEqualTo(customer.getCustomerId());
    }

    @Test
    void givenCustomerId_whenFindCustomerById_thenReturnCustomer() {
        when(customerRepo.findById(customer.getCustomerId())).thenReturn(Optional.of(customer));

        Customer cus = customerService.findCustomerById(customer.getCustomerId());

        assertThat(cus.getCustomerId()).isEqualTo(customer.getCustomerId());
    }
}
