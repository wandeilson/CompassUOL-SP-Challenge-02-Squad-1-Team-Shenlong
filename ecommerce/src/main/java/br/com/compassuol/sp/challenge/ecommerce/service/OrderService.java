package br.com.compassuol.sp.challenge.ecommerce.service;

import br.com.compassuol.sp.challenge.ecommerce.model.Customer;
import br.com.compassuol.sp.challenge.ecommerce.model.Order;
import br.com.compassuol.sp.challenge.ecommerce.repository.CustomerRepository;
import br.com.compassuol.sp.challenge.ecommerce.repository.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;

import java.util.List;
import java.util.Optional;


@Service
public class OrderService {
    private OrderRepository  orderRepository;
    private CustomerRepository customerRepository;

    public OrderService(OrderRepository orderRepository, CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
    }

    public List<Order> getOrders(){
        return orderRepository.findAll();

    }
    @Transactional
    public Order createOrder(Order or, Long customerId){
        Order order = new Order();
        order.setCustomerId(order.getCustomerId());
        order.setDataHora(LocalDate.now());
        order.setOrderStatus(order.getOrderStatus());
        Optional<Customer> customerOptional =  customerRepository.findById(customerId);
        if (customerOptional.isEmpty())
            System.out.println("lança exception");
        Customer customer = customerOptional.get();
        order.setCustomerId(customer);
        return orderRepository.save(order);
    }

    public Order getOrderByCustomerId(Long customerId){
        return orderRepository.findById(customerId).orElseThrow(()-> new EntityNotFoundException());

    }



}
