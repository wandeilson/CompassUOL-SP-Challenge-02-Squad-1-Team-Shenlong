package br.com.compassuol.sp.challenge.ecommerce.service;

import br.com.compassuol.sp.challenge.ecommerce.exceptions.ResourceNotFoundException;
import br.com.compassuol.sp.challenge.ecommerce.model.Product;
import br.com.compassuol.sp.challenge.ecommerce.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    Product product1;

    Product product2;

    @BeforeEach
    void setUp(){
        //Scenario
        product1 = new Product();
        product1.setProductId(1l);
        product1.setName("Shirt");
        product1.setPrice(new BigDecimal("150.00"));
        product1.setDescription("Test");

        product2 = new Product();
        product2.setProductId(2l);
        product2.setName("Dress");
        product2.setPrice(new BigDecimal("50.00"));
        product2.setDescription("Test");
    }

    @Test
    void findAllTest(){
        List<Product> productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);

        when(productRepository.findAll()).thenReturn(productList);

        ProductService productService = new ProductService(productRepository);

        List<Product> result = productService.findAll();

        assertEquals(productList, result);
    }

    @Test
    public void findByIdTest() {
        when(productRepository.findById(1L)).thenReturn(Optional.of(product1));

        ProductService productService = new ProductService(productRepository);

        Product result = productService.findById(1L);

        assertEquals(product1, result);
    }

    @Test
    public void findByIdNotFoundTest() {
        when(productRepository.findById(1L)).thenReturn(Optional.empty());

        ProductService productService = new ProductService(productRepository);

        assertThrows(ResourceNotFoundException.class, () -> productService.findById(1L));
    }

    @Test
    public void testDelete() {
        ProductService productService = new ProductService(productRepository);

        assertDoesNotThrow(() -> productService.delete(1L));

        verify(productRepository).deleteById(1L);
    }

    @Test
    public void testUpdate() {
        ProductService productService = new ProductService(productRepository);

        product1.setName("shoes");
        product1.setPrice(BigDecimal.valueOf(19.99));
        product1.setDescription("Test");

        Product entity = new Product();
        when(productRepository.getReferenceById(1L)).thenReturn(entity);

        productService.update(1L, product1);

        verify(productRepository).getReferenceById(1L);

        assertEquals("shoes", entity.getName());
        assertEquals(BigDecimal.valueOf(19.99), entity.getPrice());
        assertEquals("Test", entity.getDescription());
    }
}
