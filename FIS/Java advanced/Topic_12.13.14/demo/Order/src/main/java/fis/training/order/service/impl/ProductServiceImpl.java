package fis.training.order.service.impl;

import fis.training.order.entity.Product;
import fis.training.order.repository.ProductRepo;
import fis.training.order.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepo productRepo;

    @Override
    public Product addProduct(Product product) {
        if(productRepo.existsByName(product.getName())) return null;
        return productRepo.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public String deleteProduct(Long productId) {
        if(!productRepo.existsById(productId)) return "Không tồn tại!";
        productRepo.deleteById(productId);
        return "Xóa thành công!";
    }

    @Override
    public Product findById(Long productId) {
        return productRepo.findById(productId).orElse(null);
    }
}
