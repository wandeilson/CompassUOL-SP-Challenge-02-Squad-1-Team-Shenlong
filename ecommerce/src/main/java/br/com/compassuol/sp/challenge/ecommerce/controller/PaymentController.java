package br.com.compassuol.sp.challenge.ecommerce.controller;

import br.com.compassuol.sp.challenge.ecommerce.repository.PaymentRepository;
import br.com.compassuol.sp.challenge.ecommerce.repository.model.Payment;
import br.com.compassuol.sp.challenge.ecommerce.service.PaymentService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/payments")
public class PaymentController {

    private PaymentService paymentService;
    private final PaymentRepository paymentRepository;

    public PaymentController (PaymentService paymentService,
                              PaymentRepository paymentRepository){

        this.paymentService = paymentService;
        this.paymentRepository = paymentRepository;
    }
    @PostMapping
    public ResponseEntity<Payment> create (@RequestBody @Valid Payment payment){
       return ResponseEntity.status(HttpStatus.CREATED).body(paymentService.create(payment));
    }
    public List<Payment> findAll(){
        return paymentRepository.findAll();
    }

    public Payment findById(Long id){
        Optional<Payment> obj = paymentRepository.findById(id);
        return obj.orElseThrow(() -> new DataResourceNotFoundException(id));
    }


    public void delete(Long id) {
        Payment payment = findById(id);

        if(payment == null) {
            throw new IllegalStateException(String.format("Could not find a entity with id=%1", id));
        }
        paymentRepository.deleteById(id);
    }
    public Payment update(Long id, Payment payment ){
        try{
            Payment entity = paymentRepository.getReferenceById(id);
            updateDate(entity, payment);
            return paymentRepository.save(entity);
        }catch (EntityNotFoundException e){
            throw new ConfigDataResourceNotFoundException(id);
        }
    }
    private void updateDate(Payment entity, Payment payment ) {
        entity.setPaymentDate(payment.getPaymentDate());
        entity.setProductId(payment.getPaymentId());
        entity.setPaymentMethod(payment.getPaymentMethod());

    }
}
