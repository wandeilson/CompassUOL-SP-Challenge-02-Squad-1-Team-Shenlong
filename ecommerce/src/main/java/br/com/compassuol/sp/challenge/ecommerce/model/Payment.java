package br.com.compassuol.sp.challenge.ecommerce.model;

import br.com.compassuol.sp.challenge.ecommerce.enums.PaymentMethod;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Objects;

@Entity(name = "Payment")
public class Payment {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "payment_Id")
    private Long paymentId;

    @NotNull
    @Column
    private PaymentMethod paymentMethod;

    @NotNull

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd",timezone = "GMT")
    @DateTimeFormat
    @Column(name = "payment-date")
    private LocalDate paymentDate;
    @OneToOne
    @JoinColumn(name = "order_id")
    private Order orderId;

    @NotNull
   
    private Long idOrder;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(paymentId, payment.paymentId) && paymentMethod == payment.paymentMethod && Objects.equals(paymentDate, payment.paymentDate) && Objects.equals(orderId, payment.orderId) && Objects.equals(idOrder, payment.idOrder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentId, paymentMethod, paymentDate, orderId, idOrder);
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public Long getIdOrder() {
        return idOrder;
    }

    public void setOrderId(Order orderId) {
        this.orderId = orderId;
    }

    public Order getOrderId() {
        return orderId;
    }

    public void setProductId(Long paymentId) {
       this.paymentId = paymentId;
   }

   public Long getPaymentId(){
       return paymentId;
   }

   public  void setPaymentMethod(PaymentMethod paymentMethod){
       this.paymentMethod = paymentMethod;
   }
   public PaymentMethod getPaymentMethod(){
       return  paymentMethod;
   }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public LocalDate getPaymentDate() {

        return paymentDate;
    }
}
