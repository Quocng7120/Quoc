package fis.training.order.repository;

import fis.training.order.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepo extends JpaRepository<Customer, Long> {
    boolean existsByUsername(String username);
    Optional<Customer> findById(Long customerId);
    Customer findByUsername(String username);
}
