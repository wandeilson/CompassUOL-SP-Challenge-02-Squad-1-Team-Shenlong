package br.com.compassuol.sp.challenge.ecommerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long customerId;

    @NotNull(message = "Name is mandatory")
    @Size(min = 3, message = "Name should be at least 3 characters long")
    @NotBlank
    private String name;

    @NotNull(message = "CPF is mandatory")
    @Size(min = 11, max = 11)
    @NotBlank
    private String cpf;

    @NotNull(message = "Email is mandatory")
    @Email
    @NotBlank
    private String email;

    private boolean active;

    public Customer() {
    }

    public Long getId() {
        return customerId;
    }

    public void setId(Long id) {
        this.customerId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + customerId +
                ", name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", active=" + active +
                '}';
    }
}
