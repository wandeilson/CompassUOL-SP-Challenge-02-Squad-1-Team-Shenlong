package br.com.compassuol.sp.challenge.ecommerce.controller;

import br.com.compassuol.sp.challenge.ecommerce.model.Order;
import br.com.compassuol.sp.challenge.ecommerce.service.OrderService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(name="/v1/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> getOrders(){
        return orderService.getOrders();

    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order or, UriComponentsBuilder builder){
        Order order = orderService.createOrder(or);

        URI endereco = builder.path("/v1/orders/{id}").buildAndExpand(order.getOrderId()).toUri();

        return ResponseEntity.created(endereco).body(order);
    }

    @GetMapping("customers/{customerId}")
    public Order getOrderByCustomerId(@PathVariable @NotNull Long customerId){
        return orderService.getOrderByCustomerId(customerId);
    }



}
