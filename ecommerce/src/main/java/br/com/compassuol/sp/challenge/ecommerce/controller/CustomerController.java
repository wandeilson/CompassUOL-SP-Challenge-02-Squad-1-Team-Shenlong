package br.com.compassuol.sp.challenge.ecommerce.controller;

import br.com.compassuol.sp.challenge.ecommerce.exception.CustomerNotFoundException;
import br.com.compassuol.sp.challenge.ecommerce.model.Customer;
import br.com.compassuol.sp.challenge.ecommerce.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/customers")
public class CustomerController {

    private CustomerService customerService;
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}")
    public Customer getCustomer(@PathVariable Long customerId) {
        Customer customer = customerService.findCustomer(customerId);

        if (customer == null) {
            throw new CustomerNotFoundException("Id: " + customerId + " does not exist");
        }

        return customer;
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
