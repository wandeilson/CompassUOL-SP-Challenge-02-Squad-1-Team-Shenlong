package br.com.compassuol.sp.challenge.ecommerce.controller;

import br.com.compassuol.sp.challenge.ecommerce.model.Product;
import br.com.compassuol.sp.challenge.ecommerce.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private ProductService productService;
    public ProductController (ProductService productService){
        this.productService = productService;
    }


    @PostMapping
    public ResponseEntity<Object> create (@RequestBody @Valid Product product){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.create(product));
    }
}
