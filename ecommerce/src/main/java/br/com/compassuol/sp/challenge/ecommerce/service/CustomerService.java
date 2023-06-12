package br.com.compassuol.sp.challenge.ecommerce.service;

import br.com.compassuol.sp.challenge.ecommerce.exception.CPFAlreadyExistsException;
import br.com.compassuol.sp.challenge.ecommerce.exception.CustomerNotFoundException;
import br.com.compassuol.sp.challenge.ecommerce.exception.EmailAlreadyExistsException;
import br.com.compassuol.sp.challenge.ecommerce.model.Customer;
import br.com.compassuol.sp.challenge.ecommerce.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;
    public CustomerService (CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer findById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isEmpty())
            throw new CustomerNotFoundException("Id: " + id + " does not exist");
        return customer.orElse(null);
    }

    public Customer create(Customer customer) {
        if (customer.getCpf().length() != 11 || customer.getCpf() == null) {
            throw new RuntimeException("Invalid CPF");
        }

        List<Customer> allCustomers = customerRepository.findAll();
        for (Customer c: allCustomers){
            if(c.getEmail().equals(customer.getEmail())){
                throw new EmailAlreadyExistsException("This email is already registered.");
            }
            if(c.getCpf().equals(customer.getCpf())){
                throw new CPFAlreadyExistsException("This CPF is already registered.");
            }
        }
        return customerRepository.save(customer);
    }

    public Customer update(Customer customer, Long id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isEmpty())
            throw new CustomerNotFoundException("Customer does not exist");

        customer.setId(id);
        return customerRepository.save(customer);
    }
}
