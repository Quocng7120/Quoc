package fis.training.order.dto;

import fis.training.order.entity.Customer;
import fis.training.order.entity.OrderDetail;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OrderDto {
    private Customer customer;
    private Date createDate;
    private Double totalPrice;
    private List<OrderDetail> lstOrderDetail;
}
