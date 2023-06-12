package br.com.compassuol.sp.challenge.ecommerce.service;

import br.com.compassuol.sp.challenge.ecommerce.exception.CustomerNotFoundException;
import br.com.compassuol.sp.challenge.ecommerce.model.Customer;
import br.com.compassuol.sp.challenge.ecommerce.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @InjectMocks
    private CustomerService customerService;
    @Mock
    private CustomerRepository customerRepository;

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
    @DisplayName("findByIdTest")
    void findByIdTest() {
        when(customerRepository.findById(anyLong())).thenReturn(Optional.of(customer1));

        Customer result = customerService.findById(1L);

        assertNotNull(result);
        assertEquals(Customer.class, result.getClass());
        assertEquals(1L, result.getId());
        assertEquals("Cristiano Ronaldo", result.getName());
        assertEquals("09876543210", result.getCpf());
        assertEquals("cristiano@email.com", result.getEmail());
        assertEquals(true, result.isActive());

    }

    @Test
    void notFoundByIdTest() {
        Long id = null;
        when(customerRepository.findById(anyLong())).thenThrow(new CustomerNotFoundException("Id: " + id + " does not exist"));

        try {
            customerService.findById(1L);
        } catch (Exception ex) {
            assertEquals(CustomerNotFoundException.class, ex.getClass());
            assertEquals("Id: " + id + " does not exist", ex.getMessage());
        }

//        assertThat(customerService.findById(1L)).isEqualTo(null);
    }

    @Test
    @DisplayName("createTest")
    void createTest() {
        when(customerRepository.save(customer1)).thenReturn(customer1);

        CustomerService customerService = new CustomerService(customerRepository);

        assertThat(customerService.create(customer1)).isEqualTo(customer1);

    }

    @Test
    @DisplayName("updateTest")
    void updateTest() {
        when(customerRepository.findById(1L)).thenReturn(Optional.of(customer1));

        customer1.setEmail("rnaldo@gmail.com");
        when(customerRepository.save(customer1)).thenReturn(customer1);

        CustomerService customerService = new CustomerService(customerRepository);


        assertThat(customerService.update(customer1,1L)).isEqualTo(customer1);


    }
}