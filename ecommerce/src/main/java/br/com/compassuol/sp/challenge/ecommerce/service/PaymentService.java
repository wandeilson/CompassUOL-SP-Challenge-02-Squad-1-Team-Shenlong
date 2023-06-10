package br.com.compassuol.sp.challenge.ecommerce.service;

import br.com.compassuol.sp.challenge.ecommerce.exception.PaymentNotFoundException;
import br.com.compassuol.sp.challenge.ecommerce.repository.model.Payment;
import br.com.compassuol.sp.challenge.ecommerce.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentService {

    private PaymentRepository paymentRepository;
    public PaymentService (PaymentRepository paymentRepository){

        this.paymentRepository = paymentRepository;
    }
    public Payment create(Payment payment) {

        return paymentRepository.save(payment);
    }

   /* public Payment update(Payment payment , Long id) {
        Optional<Payment> optional = paymentRepository.findById(id);
        if (optional.isEmpty())
            throw new PaymentNotFoundException("Pyament does not exist");

        payment.setPaymentId(id);
        return paymentRepository.save(payment);
    }*/
}
