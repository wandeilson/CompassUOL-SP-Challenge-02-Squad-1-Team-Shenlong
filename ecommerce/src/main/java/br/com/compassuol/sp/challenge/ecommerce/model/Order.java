package br.com.compassuol.sp.challenge.ecommerce.model;

import br.com.compassuol.sp.challenge.ecommerce.model.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderID;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customerId;

    @NotNull
    private Status status;

    @Transient
    private List<ProductOrder> productsOrderList;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd",timezone = "GMT")
    @Column(name = "date", nullable = false)
    @DateTimeFormat
    @NotNull
    private LocalDate date;

    public Order() {
        this.productsOrderList = new ArrayList<>();
    }

    public Long getOrderID() {
        return orderID;
    }

    public void setOrderID(Long orderID) {
        this.orderID = orderID;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<ProductOrder> getProductsOrderList() {
        return productsOrderList;
    }

    public void setProductsOrderList(List<ProductOrder> productsOrderList) {
        this.productsOrderList = productsOrderList;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", customerId=" + customerId +
                ", status=" + status +
                ", productsOrderList=" + productsOrderList +
                ", dateHour=" + date +
                '}';
    }
}
