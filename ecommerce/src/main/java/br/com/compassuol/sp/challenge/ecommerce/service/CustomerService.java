package br.com.compassuol.sp.challenge.ecommerce.service;

import br.com.compassuol.sp.challenge.ecommerce.exception.CustomerNotFoundException;
import br.com.compassuol.sp.challenge.ecommerce.model.Customer;
import br.com.compassuol.sp.challenge.ecommerce.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;
    public CustomerService (CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer findCustomer(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);

        return customer.orElse(null);
    }

    public Customer createCustomer(Customer customer) {
        if (customer.getCpf().length() != 11 || customer.getCpf() == null) {
            throw new RuntimeException("Invalid CPF");
        }
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Customer customer, Long id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isEmpty())
            throw new CustomerNotFoundException("Customer does not exist");

        customer.setId(id);
        return customerRepository.save(customer);
    }



}
