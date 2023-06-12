package br.com.compassuol.sp.challenge.ecommerce.controller;

import br.com.compassuol.sp.challenge.ecommerce.model.Payment;
import br.com.compassuol.sp.challenge.ecommerce.repository.PaymentRepository;
import br.com.compassuol.sp.challenge.ecommerce.service.PaymentService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.util.Assert;


import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class PaymentControllerTest {

    private PaymentService paymentService = Mockito.mock(PaymentService.class);
    private PaymentRepository paymentRepository = Mockito.mock(PaymentRepository.class);
    private PaymentController paymentController = new PaymentController(paymentService, paymentRepository);

    @Test
    public void testFindAllPayments() {

        List<Payment> payments = Arrays.asList(new Payment(), new Payment(), new Payment());
        Mockito.when(paymentRepository.findAll()).thenReturn(payments);
        List<Payment> result = paymentController.findAll();
        Assert.isTrue(payments.equals(result));
        Mockito.verify(paymentRepository, Mockito.times(1)).findAll();
    }

    @Test
    public void testFindAllIsNullList() {

        Mockito.when(paymentRepository.findAll()).thenReturn(null);
        List<Payment> result = paymentController.findAll();
        Assert.isNull(result);
        Mockito.verify(paymentRepository, Mockito.times(1)).findAll();
    }

    @Test
    public void testFindAllPayments_EmptyList() {

        Mockito.when(paymentRepository.findAll()).thenReturn(Collections.emptyList());
        List<Payment> result = paymentController.findAll();
        Assert.isTrue(result.isEmpty());
        Mockito.verify(paymentRepository, Mockito.times(1)).findAll();
    }
}







