package fis.training.order.repository;

import fis.training.order.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  ProductRepo extends JpaRepository<Product, Long> {
    boolean existsByName(String name);
    Product findByName(String name);
}
