package br.com.compassuol.sp.challenge.ecommerce.service;

import br.com.compassuol.sp.challenge.ecommerce.exception.ResourceNotFoundException;
import br.com.compassuol.sp.challenge.ecommerce.model.Payment;
import br.com.compassuol.sp.challenge.ecommerce.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class PaymentService {

    private PaymentRepository paymentRepository;
    @Autowired
    public PaymentService (PaymentRepository paymentRepository){

        this.paymentRepository = paymentRepository;
    }
    public Payment create(Payment payment) {

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





