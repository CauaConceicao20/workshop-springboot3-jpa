package com.educandoweb.course.resources;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderResource {

    @Autowired
    private OrderService orderService;

    @GetMapping("/returnAllOrder")
    public ResponseEntity<List<Order>> findAllOrder() {
        var list = orderService.findAll();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/returnOrder/{id}")
    public ResponseEntity<Order> finbByIdOrder(@PathVariable Long id) {
        Order order = orderService.findById(id);

        return ResponseEntity.ok().body(order);
    }

}
