package br.com.compassuol.sp.challenge.ecommerce.service;

import br.com.compassuol.sp.challenge.ecommerce.controller.ProductController;
import br.com.compassuol.sp.challenge.ecommerce.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;

public class ProductService {

    private ProductService productService;
    @BeforeEach
    void setUp(){
        productService = new ProductService();
    }

}
