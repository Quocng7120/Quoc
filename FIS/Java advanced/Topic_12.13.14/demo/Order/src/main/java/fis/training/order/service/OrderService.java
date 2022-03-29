package fis.training.order.service;

import fis.training.order.entity.Order;

public interface OrderService {
    Order addOrder(Order order);
    Order updateOrder(Order orderProduct);
    void deleteOrder(Long orderProductId);
}
