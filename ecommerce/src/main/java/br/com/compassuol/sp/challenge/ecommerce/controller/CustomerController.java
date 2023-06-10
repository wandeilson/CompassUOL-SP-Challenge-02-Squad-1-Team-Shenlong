package br.com.compassuol.sp.challenge.ecommerce.controller;

import br.com.compassuol.sp.challenge.ecommerce.exception.CustomerNotFoundException;
import br.com.compassuol.sp.challenge.ecommerce.model.Customer;
import br.com.compassuol.sp.challenge.ecommerce.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private CustomerService customerService;
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Object> findById(@PathVariable Long customerId) {
        Customer customer = customerService.findById(customerId);

        if (customer == null) {
            throw new CustomerNotFoundException("Id: " + customerId + " does not exist");
        }

        return ResponseEntity.ok(customer);
    }

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody @Valid Customer customer) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.create(customer));
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<Object> update(@RequestBody @Valid Customer customer, @PathVariable Long customerId) {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.update(customer, customerId));
    }

}
