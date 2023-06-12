package br.com.compassuol.sp.challenge.ecommerce.service;

import br.com.compassuol.sp.challenge.ecommerce.exception.CustomerNotFoundException;
import br.com.compassuol.sp.challenge.ecommerce.exception.ResourceNotFoundException;
import br.com.compassuol.sp.challenge.ecommerce.model.Customer;
import br.com.compassuol.sp.challenge.ecommerce.model.Order;
import br.com.compassuol.sp.challenge.ecommerce.repository.CustomerRepository;
import br.com.compassuol.sp.challenge.ecommerce.repository.OrderRepository;
import jakarta.persistence.Transient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private OrderRepository orderRepository;
    private CustomerRepository customerRepository;
    private ProductOrderService productOrderService;

    public OrderService(OrderRepository orderRepository,
                        CustomerRepository customerRepository,
                        ProductOrderService productOrderService) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.productOrderService = productOrderService;
    }

    public Order create (Order order, Long customerId){
        Optional<Customer> customerOptional =  customerRepository.findById(customerId);
        if (customerOptional.isEmpty())
            throw new CustomerNotFoundException("Customer not found");
        Customer customer = customerOptional.get();
        order.setCustomerId(customer);

        order.getProductsOrderList().forEach(
                productOrder -> {
                    Long idProduct = productOrder.getIdProduct();
                    productOrderService.setProduct(productOrder, idProduct);
                }
        );

        return orderRepository.save(order);
    }

    public Order getOrderByCustomerId(Long id){
        Optional<Order> orderOptional = orderRepository.findById(id);
        if (orderOptional.isEmpty())
            throw new ResourceNotFoundException(id);
        Order o = orderOptional.get();
        return o;
    }

    public List<Order> getOrders(){
        return orderRepository.findAll();
    }
}
