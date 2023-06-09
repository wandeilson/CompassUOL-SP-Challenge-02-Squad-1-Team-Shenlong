package br.com.compassuol.sp.challenge.ecommerce.service;

import br.com.compassuol.sp.challenge.ecommerce.model.Order;
import br.com.compassuol.sp.challenge.ecommerce.model.Product;
import br.com.compassuol.sp.challenge.ecommerce.repository.OrderRepository;
import br.com.compassuol.sp.challenge.ecommerce.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;


@Service
public class OrderService {
    @Autowired
    private OrderRepository  orderRepository;

    @Autowired
    private ProductRepository productRepository;

    private List<Product> products = productRepository.findAll();


    for(Product product : products){

    }


    public List<Order> getOrders(){
        return orderRepository.findAll();

    }
    @Transactional
    public Order createOrder(Order or){
        Order order = new Order();
        order.setCustomerId(order.getCustomerId());
        order.setDataHora(LocalDateTime.now());
        order.setOrderStatus(order.getOrderStatus());
        order.addProduct(product);
        return orderRepository.save(order);
    }



    public Order getOrderByCustomerId(Long customerId){
        return orderRepository.findById(customerId).orElseThrow(()-> new EntityNotFoundException());

    }


    private Order getOrderById(long orderId) {
        return orderRepository.findById(orderId).orElseThrow(()-> new EntityNotFoundException());
    }


}
