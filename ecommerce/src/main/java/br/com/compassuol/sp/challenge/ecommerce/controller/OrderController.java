package br.com.compassuol.sp.challenge.ecommerce.controller;

import br.com.compassuol.sp.challenge.ecommerce.model.Order;
import br.com.compassuol.sp.challenge.ecommerce.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private OrderService orderService;
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @PostMapping("/{customerId}")
    public ResponseEntity<Object> create (@Valid @RequestBody Order order,
                                          @PathVariable (value = "customerId") Long customerId){
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.create(order, customerId));
    }
}
