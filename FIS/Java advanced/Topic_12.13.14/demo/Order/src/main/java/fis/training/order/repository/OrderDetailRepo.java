package fis.training.order.repository;

import fis.training.order.entity.OrderDetail;
import fis.training.order.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface OrderDetailRepo extends JpaRepository<OrderDetail, Long> {
    List<OrderDetail> findByCreateDateBetween(Date start, Date end);
    List<OrderDetail> findByCreateDateBetweenAndProduct(Date start, Date end, Product product);
}
