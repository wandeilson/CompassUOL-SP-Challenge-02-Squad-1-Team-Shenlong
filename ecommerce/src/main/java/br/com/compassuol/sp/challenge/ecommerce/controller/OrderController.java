package br.com.compassuol.sp.challenge.ecommerce.controller;

import br.com.compassuol.sp.challenge.ecommerce.model.Order;
import br.com.compassuol.sp.challenge.ecommerce.service.OrderService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<String> createOrder(@RequestBody Order or){
        Order order = orderService.createOrder(or);

       orderService.createOrder(order);

        return new ResponseEntity<>("Pedido criado com sucesso", HttpStatus.CREATED);
    };

    @GetMapping("customers/{customerId}")
    public Order getOrderByCustomerId(@PathVariable @NotNull Long customerId){
        return orderService.getOrderByCustomerId(customerId);
    };



};
