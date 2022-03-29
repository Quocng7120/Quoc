package fis.training.order.service.impl;

import fis.training.order.entity.Order;
import fis.training.order.repository.OrderRepo;
import fis.training.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepo orderRepo;

    @Override
    public Order addOrder(Order order) {
        return orderRepo.save(order);
    }

    @Override
    public Order updateOrder(Order order) {
        return orderRepo.save(order);
    }

    @Override
    public void deleteOrder(Long orderId) {
        orderRepo.deleteById(orderId);
    }
}
