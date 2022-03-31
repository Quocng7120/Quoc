package fis.training.order.controller;

import fis.training.order.entity.Category;
import fis.training.order.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<?> add(@RequestBody Category category){
        return  ResponseEntity.ok(categoryService.addCategory(category));
    }


}
