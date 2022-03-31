package fis.training.order.repository;

import fis.training.order.entity.Category;
import fis.training.order.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface  ProductRepo extends JpaRepository<Product, Long> {
    boolean existsByName(String name);
    Product findByName(String name);
    List<Product> findByCategory(Category category);
}
