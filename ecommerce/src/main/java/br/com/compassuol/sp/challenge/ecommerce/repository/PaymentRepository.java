package br.com.compassuol.sp.challenge.ecommerce.repository;

import br.com.compassuol.sp.challenge.ecommerce.repository.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
