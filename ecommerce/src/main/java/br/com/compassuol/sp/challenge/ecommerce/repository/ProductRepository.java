package br.com.compassuol.sp.challenge.ecommerce.repository;

import br.com.compassuol.sp.challenge.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Long, Product> {
}
