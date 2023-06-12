package br.com.compassuol.sp.challenge.ecommerce.controller;

import br.com.compassuol.sp.challenge.ecommerce.model.Order;
import br.com.compassuol.sp.challenge.ecommerce.service.OrderService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<Order>> getOrders(){
        return ResponseEntity.ok().body(orderService.getOrders());

    }
    @PostMapping("/{customerId}")
    public ResponseEntity<Order> createOrder(@Valid @RequestBody Order order,
                                             @PathVariable (name = "customerId") Long customerId ){
        return ResponseEntity.ok().body(orderService.createOrder(order, customerId));
    }

    @GetMapping("customers/{customerId}")
    public Order getOrderByCustomerId(@PathVariable @NotNull Long customerId){
        return orderService.getOrderByCustomerId(customerId);
    }

}
