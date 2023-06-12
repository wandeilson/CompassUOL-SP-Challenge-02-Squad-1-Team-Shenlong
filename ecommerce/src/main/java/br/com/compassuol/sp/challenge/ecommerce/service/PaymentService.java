package br.com.compassuol.sp.challenge.ecommerce.service;

import br.com.compassuol.sp.challenge.ecommerce.exception.ResourceNotFoundException;
import br.com.compassuol.sp.challenge.ecommerce.model.Order;
import br.com.compassuol.sp.challenge.ecommerce.model.Payment;
import br.com.compassuol.sp.challenge.ecommerce.model.enums.Status;
import br.com.compassuol.sp.challenge.ecommerce.repository.OrderRepository;
import br.com.compassuol.sp.challenge.ecommerce.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class PaymentService {

    private OrderRepository orderRepository;
    private PaymentRepository paymentRepository;

    public PaymentService (PaymentRepository paymentRepository,OrderRepository orderRepository){

        this.paymentRepository = paymentRepository;
        this.orderRepository = orderRepository;
    }
    public Payment create(Payment payment) {
       Optional<Order> order = orderRepository.findById(payment.getIdOrder());
        if (order.isEmpty())
            System.out.println("execao");
            Order orderPayment = order.get();
            payment.setOrderId(orderPayment);
            orderPayment.setStatus(Status.CONFIRMED);
            orderRepository.save(orderPayment);

        return paymentRepository.save(payment);
    }

    public Payment update( Long id,Payment payment) {
        Payment payment1= findById(id);
        payment1.setPaymentDate(LocalDate.now());
        payment1.setPaymentMethod(payment.getPaymentMethod());
        payment1.setOrderId(payment.getOrderId());
        return  paymentRepository.save(payment);

	}

    private void updateDate(Payment entity, Payment payment ) {
        entity.setPaymentDate(payment.getPaymentDate());
        entity.setProductId(payment.getPaymentId());
        entity.setPaymentMethod(payment.getPaymentMethod());

    }

    public Payment findById(Long id) {

            Optional<Payment> payment = paymentRepository.findById(id);
            return payment.orElseThrow(() -> new ResourceNotFoundException(id));
        }
        
    }





