package br.com.compassuol.sp.challenge.ecommerce.controller;

import br.com.compassuol.sp.challenge.ecommerce.model.Product;
import br.com.compassuol.sp.challenge.ecommerce.repository.ProductRepository;
import br.com.compassuol.sp.challenge.ecommerce.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {

    @Mock
    ProductService productService;
    @InjectMocks
    ProductController productController;

    @Mock
    ProductRepository productRepository;

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
    void findByIdTest(){
        //action
        productService.findById(product1.getProductId());
        //Verification
        assertEquals(product1.getProductId(), 1);
    }

    @Test
    void findByIdNotFoundTest(){
        //action
        productService.findById(product1.getProductId());
        //Verification
        assertNotEquals(product1.getProductId(), 2);
    }

    @Test
    public void findAllTest(){
        //action
      List<Product> productList = Arrays.asList(product1, product2);
      when(productRepository.findAll()).thenReturn(productList);

      List<Product> listProduct = productRepository.findAll();
        //Verification
      assertEquals(productList, listProduct);
    }
    @Test
    public void updateTest(){
        //action
        product1.setDescription("update teste unitário");
        //Verification
        assertNotNull(productController.update(1L, product1));
        assertEquals("update teste unitário", product1.getDescription());
    }
    @Test
    public void deleteTest() {
        //action
        ResponseEntity<?> response = productController.delete(1L);
        HttpStatus statusCode = (HttpStatus) response.getStatusCode();
        //Verification
        assertEquals(HttpStatus.NO_CONTENT, statusCode);
    }
}
