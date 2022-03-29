package fis.training.order.controller;

import fis.training.order.entity.Order;
import fis.training.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;
    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<?> add(@RequestBody Order order){
        return  ResponseEntity.ok(orderService.addOrder(order));
    }
    @PostMapping("/update")
    @ResponseBody
    public ResponseEntity<?> update(@RequestBody Order order){
        return  ResponseEntity.ok(orderService.updateOrder(order));
    }
    @GetMapping("/delete/{orderId}")
    @ResponseBody
    public ResponseEntity<?> delete(@PathVariable Long orderId){
        orderService.deleteOrder(orderId);
        return ResponseEntity.ok("Thanh Cong");
    }
}
