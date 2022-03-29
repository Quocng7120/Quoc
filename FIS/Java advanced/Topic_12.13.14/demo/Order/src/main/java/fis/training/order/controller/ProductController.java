package fis.training.order.controller;

import fis.training.order.entity.Product;
import fis.training.order.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<?> add(@RequestBody Product product){
        return ResponseEntity.ok(productService.addProduct(product));
    }
    @PostMapping("/update")
    @ResponseBody
    public ResponseEntity<?> update(@RequestBody Product product){
        return ResponseEntity.ok(productService.updateProduct(product));
    }

    @GetMapping("/delete/{productId}")
    @ResponseBody
    public ResponseEntity<?> delete(@PathVariable Long productId){
        return ResponseEntity.ok(productService.deleteProduct(productId));
    }
    @GetMapping("/findById/{productId}")
    @ResponseBody
    public ResponseEntity<?> findById(@PathVariable Long productId){
        return ResponseEntity.ok(productService.findById(productId));
    }
}
