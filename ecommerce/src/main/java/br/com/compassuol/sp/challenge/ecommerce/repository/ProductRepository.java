package br.com.compassuol.sp.challenge.ecommerce.repository;

import br.com.compassuol.sp.challenge.ecommerce.repository.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
