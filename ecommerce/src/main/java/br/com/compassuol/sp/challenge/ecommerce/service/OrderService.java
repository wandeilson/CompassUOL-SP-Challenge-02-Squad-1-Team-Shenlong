package br.com.compassuol.sp.challenge.ecommerce.service;

import br.com.compassuol.sp.challenge.ecommerce.model.Order;
import br.com.compassuol.sp.challenge.ecommerce.repository.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;

import java.util.List;


@Service
public class OrderService {
    @Autowired
    private OrderRepository  orderRepository;

    public List<Order> getOrders(){
        return orderRepository.findAll();

    }
    @Transactional
    public Order createOrder(Order or){
        Order order = new Order();
       order.setCustomerId(order.getCustomerId());
        order.setDataHora(LocalDate.now());
        order.setOrderStatus(order.getOrderStatus());
        return orderRepository.save(order);
    }

    public Order getOrderByCustomerId(Long customerId){
        return orderRepository.findById(customerId).orElseThrow(()-> new EntityNotFoundException());

    }



}
