package br.com.compassuol.sp.challenge.ecommerce.model;

import br.com.compassuol.sp.challenge.ecommerce.model.enums.OrderStatus;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;


import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customerId;

//    private Set<Product> productOrder;


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd",timezone = "GMT")
    @Column(nullable = false)
    @DateTimeFormat
    private LocalDate dateHour;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status")
    @NotNull(message = "Order status must be included")
    private OrderStatus orderStatus;


    //private List<ProductOrder> productOrderList;


    public Order() {
        //productOrderList = new ArrayList<>();
    }

    public Order(Long orderId, Customer customerId, OrderStatus orderStatus) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.dateHour = LocalDate.now();
        this.orderStatus = orderStatus;
        //productOrderList = new ArrayList<>();
    }

//    public Set<Product> getProductOrder() {
//        return productOrder;
//    }
//
//    public void setProductOrder(Set<Product> productOrder) {
//        this.productOrder = productOrder;
//    }
//    public List<ProductOrder> getProductOrderList(){
//        return productOrderList;
//    }
//
//
//    public void addProduct(Product product , int quantity){
//        ProductOrder productOrder = new ProductOrder(product, quantity);
//        this.productOrderList.add(productOrder);
//    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }


    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public LocalDate getDateHour() {
        return dateHour;
    }

    public void setDataHora(LocalDate dateHour) {
        this.dateHour = dateHour;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderId == order.orderId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId);
    }
}
