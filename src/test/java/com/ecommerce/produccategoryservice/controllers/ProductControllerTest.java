package com.ecommerce.produccategoryservice.controllers;

import com.ecommerce.produccategoryservice.dtos.ProductDto;
import com.ecommerce.produccategoryservice.models.Product;
import com.ecommerce.produccategoryservice.services.IProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductControllerTest {

    @Autowired
    ProductController productController;

    @MockitoBean
    IProductService iProductService;

    @Test
    public void testProductById() {
        // Arrange
        Long id = 2L;
        Product product = new Product();
        product.setId(id);
        product.setPrice(1000.0);
        product.setName("Pro1");
        when(iProductService.getProductById(id)).thenReturn(product);

        // Act
        ResponseEntity<ProductDto> responseEntity = productController.getProductById(id);

        // Assert
        assertNotNull(responseEntity);
        assertNotNull(responseEntity.getBody());
        assertEquals(id, responseEntity.getBody().getId());
        assertEquals(responseEntity.getBody().getPrice(), product.getPrice());
        assertEquals(responseEntity.getBody().getName(), product.getName());
    }

    @Test
    public void testProductIdLessThanZero() {
        Long id = -1L;
        Product product = new Product();
        product.setId(id);

        Exception exception = assertThrows(IllegalArgumentException.class,
                () -> productController.getProductById(id));
        assertEquals("Illegal id passed", exception.getMessage());
    }

    @Test
    public void testProductIdForRunTimeException()
    {
        Long productId = 20L;
        when(iProductService.getProductById(productId)).thenThrow(new RuntimeException("something wrong"));
        Exception ex = assertThrows(RuntimeException.class, () ->
                productController.getProductById(productId));
        assertEquals("something wrong",ex.getMessage());
    }

}