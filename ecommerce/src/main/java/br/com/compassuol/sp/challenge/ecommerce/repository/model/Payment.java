package br.com.compassuol.sp.challenge.ecommerce.repository.model;

import br.com.compassuol.sp.challenge.ecommerce.enums.PaymentMethod;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @NotNull(message = "payment")
    @Column (name = "payment_id")
    private Long paymentId;

    @NotNull
    @Column(name = "payment Method")
    private PaymentMethod paymentMethod;
    @Column
    @NotNull
    @DateTimeFormat
    private LocalDate paymentDate;

   // private Order orderId ;




    public String toString() {
        return "Payment{" +
                "PaymentId=" + paymentId +
                ", paymentMethod=" + paymentMethod +
                ", paymentDate=" +paymentDate +
                ", paymentDate='" + paymentDate + '\'' +
                '}';
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
