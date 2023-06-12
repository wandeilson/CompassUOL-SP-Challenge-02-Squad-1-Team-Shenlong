package br.com.compassuol.sp.challenge.ecommerce.controller;

import br.com.compassuol.sp.challenge.ecommerce.model.Customer;
import br.com.compassuol.sp.challenge.ecommerce.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

class CustomerControllerTest {
    @InjectMocks
    CustomerController controller;
    @Mock
    CustomerService customerService;

    Customer customer1;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        customer1 = new Customer();
        customer1.setId(1L);
        customer1.setName("Cristiano Ronaldo");
        customer1.setCpf("09876543210");
        customer1.setEmail("cristiano@email.com");
        customer1.setActive(true);
    }

    @Test
    void findById() {
        when(customerService.findById(anyLong())).thenReturn(customer1);

        ResponseEntity<Object> result = controller.findById(1L);

        assertNotNull(result);
        assertNotNull(result.getBody());
        assertEquals(ResponseEntity.class, result.getClass());
        assertEquals(Customer.class, result.getBody().getClass());
    }

    @Test
    void create() {
        when(customerService.create(any())).thenReturn(customer1);

        ResponseEntity<Object> result = controller.create(customer1);

        assertNotNull(result);
        assertNotNull(result.getBody());
        assertEquals(HttpStatus.CREATED, result.getStatusCode());
        assertEquals(ResponseEntity.class, result.getClass());

    }

    @Test
    void update() {
        when(customerService.update(any(),anyLong())).thenReturn(customer1);

        ResponseEntity<Object> result = controller.update(customer1, 1L);

        assertNotNull(result);
        assertNotNull(result.getBody());
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(ResponseEntity.class, result.getClass());
    }
}