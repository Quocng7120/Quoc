package fis.training.order.service;

import fis.training.order.entity.Product;

public interface ProductService {
    Product addProduct(Product product);
    Product updateProduct(Product product);
    String deleteProduct(Long productId);
    Product findById(Long productId);
}
