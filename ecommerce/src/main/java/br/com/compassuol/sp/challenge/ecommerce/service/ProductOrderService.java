package br.com.compassuol.sp.challenge.ecommerce.service;

import br.com.compassuol.sp.challenge.ecommerce.model.Product;
import br.com.compassuol.sp.challenge.ecommerce.model.ProductOrder;
import br.com.compassuol.sp.challenge.ecommerce.repository.ProductOrderRepository;
import br.com.compassuol.sp.challenge.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductOrderService {

    private ProductOrderRepository productOrderRepository;
    private ProductRepository productRepository;

    public ProductOrderService(ProductOrderRepository productOrderRepository,
                               ProductRepository productRepository) {
        this.productOrderRepository = productOrderRepository;
        this.productRepository = productRepository;
    }

    public void setProduct(ProductOrder productOrder, Long id){
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isEmpty())
            System.out.println("execao");
        Product p = productOptional.get();
        productOrder.setProduct(p);
        productOrderRepository.save(productOrder);

    }

}
