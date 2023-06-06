package br.com.compassuol.sp.challenge.ecommerce.controller;

import br.com.compassuol.sp.challenge.ecommerce.model.Customer;
import br.com.compassuol.sp.challenge.ecommerce.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1/customers")
public class CustomerController {

    private CustomerService customerService;
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}")
    public Customer getCustomer(@PathVariable Long customerId) {
        return customerService.findCustomer(customerId);
    }

    @PostMapping
    public ResponseEntity<Object> createCustomer(@RequestBody @Valid Customer customer) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.createCustomer(customer));
    }

    @PutMapping("{customerId}")
    public ResponseEntity<Object> updateCustomer(@RequestBody @Valid Customer customer, @PathVariable Long customerId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.updateCustomer(customer, customerId));
    }

}
