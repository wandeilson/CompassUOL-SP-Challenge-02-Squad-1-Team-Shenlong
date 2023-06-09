package br.com.compassuol.sp.challenge.ecommerce.model;

import br.com.compassuol.sp.challenge.ecommerce.model.enums.OrderStatus;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class Order{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;


    @NotNull
    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customerId;


    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd",timezone = "GMT")
    @Column(name = "data_hora", nullable = false)
    @DateTimeFormat
    private LocalDateTime dateHour;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "order_status")
    private OrderStatus orderStatus;

   @OneToMany
   private List<Product> listProduct = new ArrayList<>();


    public Order(){

    }

    public Order(Long orderId, Customer customerId, LocalDateTime dateHour, OrderStatus orderStatus) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.dateHour = dateHour;
        this.orderStatus = orderStatus;
        listProduct = new ArrayList<>();
    }

    public void addProduct(Product product){
        this.listProduct.add(product);
    }

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

    public LocalDateTime getDateHour() {
        return dateHour;
    }

    public void setDataHora(LocalDateTime dateHour) {
        this.dateHour = dateHour;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<Product> getListProduct() {
        return listProduct;
    }

    public void setListProduct(List<Product> listProduct) {
        this.listProduct = listProduct;
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
