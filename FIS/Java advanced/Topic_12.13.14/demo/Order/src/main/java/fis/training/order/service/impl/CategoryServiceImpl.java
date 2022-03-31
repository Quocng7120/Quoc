package fis.training.order.service.impl;

import fis.training.order.dto.DoanhThuDto;
import fis.training.order.entity.Category;
import fis.training.order.entity.OrderDetail;
import fis.training.order.entity.Product;
import fis.training.order.repository.CategoryRepo;
import fis.training.order.repository.OrderDetailRepo;
import fis.training.order.repository.ProductRepo;
import fis.training.order.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    ProductRepo productRepo;

    @Autowired
    OrderDetailRepo orderDetailRepo;

    @Autowired
    CategoryRepo categoryRepo;

    @Override
    public Double checkOneCategory(Date date1, Date date2, Category category) {
        Double sum=0.0;
        List<Product> lstProducts=productRepo.findByCategory(category) ;
        for(Product product:lstProducts) {
            List<OrderDetail> lstOrderRows=orderDetailRepo.findByCreateDateBetweenAndProduct(date1, date2, product);
            for(OrderDetail orderRow:lstOrderRows) {
                sum+=orderRow.getAmount()*product.getPrice();
            }
        }
        return sum;
    }

    @Override
    public Category addCategory(Category category) {
        return categoryRepo.save(category);
    }

    @Override
    public List<DoanhThuDto> checkAllCategory(Date date1, Date date2) {
        List<Category> lstCategories =categoryRepo.findAll();
        List<DoanhThuDto> lst=new ArrayList<>();
        for(Category category:lstCategories) {
            Double money=checkOneCategory(date1, date2, category);
            lst.add(new DoanhThuDto(category.getName(),money));
        }
        return lst;
    }
}
