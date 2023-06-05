package br.com.compassuol.sp.challenge.ecommerce.service;
import br.com.compassuol.sp.challenge.ecommerce.model.Product;
import br.com.compassuol.sp.challenge.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private ProductRepository productRepository;
    public ProductService (ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    public Product create(Product product) {
        return productRepository.save(product);
    }
}
