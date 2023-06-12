package br.com.compassuol.sp.challenge.ecommerce.controller;

import br.com.compassuol.sp.challenge.ecommerce.model.Order;
import br.com.compassuol.sp.challenge.ecommerce.service.OrderService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
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
    @PostMapping("/{customerId}")
    public ResponseEntity<Object> create (@Valid @RequestBody Order order,
                                          @PathVariable (value = "customerId") Long customerId){
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.create(order, customerId));
    }

    @GetMapping("customers/{customerId}")
    public Order getOrderByCustomerId(@PathVariable @NotNull Long customerId){
        return orderService.getOrderByCustomerId(customerId);
    }

    @GetMapping
    public ResponseEntity<List<Order>> getOrders(){
        return ResponseEntity.ok().body(orderService.getOrders());

    }


}
