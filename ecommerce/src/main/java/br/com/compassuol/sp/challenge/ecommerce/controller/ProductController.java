package br.com.compassuol.sp.challenge.ecommerce.controller;

import br.com.compassuol.sp.challenge.ecommerce.repository.model.Product;
import br.com.compassuol.sp.challenge.ecommerce.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        List<Product> list = productService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable long id){
        Product obj = productService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product obj){
        obj = productService.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
