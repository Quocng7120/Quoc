package fis.training.order.service.impl;

import fis.training.order.repository.OrderDetailRepo;
import fis.training.order.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    OrderDetailRepo orderDetailRepo;


}
