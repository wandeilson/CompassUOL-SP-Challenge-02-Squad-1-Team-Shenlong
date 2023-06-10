package br.com.compassuol.sp.challenge.ecommerce.controller;

import br.com.compassuol.sp.challenge.ecommerce.repository.model.Payment;
import br.com.compassuol.sp.challenge.ecommerce.service.PaymentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/payments")
public class PaymentController {

    private PaymentService paymentService;

    public PaymentController (PaymentService paymentService){

        this.paymentService = paymentService;
    }
    @PostMapping
    public ResponseEntity<Payment> create (@RequestBody @Valid Payment payment){
       return ResponseEntity.status(HttpStatus.CREATED).body(paymentService.create(payment));
    }
}
