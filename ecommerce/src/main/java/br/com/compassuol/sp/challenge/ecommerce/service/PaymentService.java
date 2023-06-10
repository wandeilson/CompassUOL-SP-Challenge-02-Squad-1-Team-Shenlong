package br.com.compassuol.sp.challenge.ecommerce.service;

import br.com.compassuol.sp.challenge.ecommerce.repository.model.Payment;
import br.com.compassuol.sp.challenge.ecommerce.repository.PaymentRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private PaymentRepository paymentRepository;
    public PaymentService (PaymentRepository paymentRepository){

        this.paymentRepository = paymentRepository;
    }
    public Payment create(Payment payment) {

        return paymentRepository.save(payment);
    }
}
