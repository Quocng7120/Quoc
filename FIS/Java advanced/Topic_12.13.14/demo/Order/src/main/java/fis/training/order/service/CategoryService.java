package fis.training.order.service;

import fis.training.order.dto.DoanhThuDto;
import fis.training.order.entity.Category;

import java.util.Date;
import java.util.List;

public interface CategoryService {
    Category addCategory(Category category);
    Double checkOneCategory(Date date1, Date date2, Category category);
    List<DoanhThuDto> checkAllCategory(Date date1, Date date2);
}
