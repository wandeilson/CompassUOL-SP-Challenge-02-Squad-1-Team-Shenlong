package br.com.compassuol.sp.challenge.ecommerce.service;

import br.com.compassuol.sp.challenge.ecommerce.exception.CustomerNotFoundException;
import br.com.compassuol.sp.challenge.ecommerce.model.Customer;
import br.com.compassuol.sp.challenge.ecommerce.model.Order;
import br.com.compassuol.sp.challenge.ecommerce.model.Product;

import br.com.compassuol.sp.challenge.ecommerce.repository.CustomerRepository;
import br.com.compassuol.sp.challenge.ecommerce.repository.OrderRepository;
import br.com.compassuol.sp.challenge.ecommerce.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDate;


import java.util.List;
import java.util.Optional;


@Service
public class OrderService {
    private OrderRepository  orderRepository;
    private CustomerRepository customerRepository;
    //private ProductRepository productRepository;

    public OrderService(OrderRepository orderRepository, CustomerRepository customerRepository,ProductRepository productRepository){
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        //this.productRepository = productRepository;
    }

    public List<Order> getOrders(){
        return orderRepository.findAll();

    }


    //private List<Product> products = productRepository.findAll();

    @Transactional
    public Order createOrder(Order or, Long customerId){

        Order order = new Order();

//        for( ProductOrder productOrder : order.getProductOrderList()){
//           Product product = products.stream().filter(x -> x.getProductId() == productOrder.getProduct().getProductId()).findFirst().orElse(null);
//            order.addProduct(product, productOrder.getQuantity());
//        }

        order.setCustomerId(or.getCustomerId());
        order.setDataHora(LocalDate.now());
        order.setOrderStatus(or.getOrderStatus());
        Optional<Customer> customerOptional =  customerRepository.findById(customerId);
        if (customerOptional.isEmpty())
            throw new CustomerNotFoundException("Customer not found");
        Customer customer = customerOptional.get();
        order.setCustomerId(customer);
        return orderRepository.save(order);

    }


    public Order getOrderByCustomerId(Long customerId){
        return orderRepository.findById(customerId).orElseThrow(()-> new EntityNotFoundException());

    }



}
