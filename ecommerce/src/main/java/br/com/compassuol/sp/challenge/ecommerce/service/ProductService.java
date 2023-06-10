package br.com.compassuol.sp.challenge.ecommerce.service;
import br.com.compassuol.sp.challenge.ecommerce.exception.DatabaseException;
import br.com.compassuol.sp.challenge.ecommerce.exception.ResourceNotFoundException;
import br.com.compassuol.sp.challenge.ecommerce.model.Product;
import br.com.compassuol.sp.challenge.ecommerce.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;
    public ProductService (ProductRepository productRepository)
    {
        this.productRepository = productRepository;

    }
    public Product create(Product product) {

        return productRepository.save(product);
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product findById(Long id){
        Optional<Product> obj = productRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public void delete(Long id){
        try{
            productRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        }catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }
    public Product update(Long id, Product obj){
        try{
            Product entity = productRepository.getReferenceById(id);
            updateDate(entity, obj);
            return productRepository.save(entity);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateDate(Product entity, Product obj) {
        entity.setName(obj.getName());
        entity.setPrice(obj.getPrice());
        entity.setDescription(obj.getDescription());
    }
}
