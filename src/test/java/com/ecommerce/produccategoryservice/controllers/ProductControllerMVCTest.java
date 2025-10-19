package com.ecommerce.produccategoryservice.controllers;

import com.ecommerce.produccategoryservice.dtos.ProductDto;
import com.ecommerce.produccategoryservice.models.Product;
import com.ecommerce.produccategoryservice.services.IProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
public class ProductControllerMVCTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private IProductService iProductService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testgetAllProducts() throws Exception {

        Product product = new Product();
        product.setId(1L);
        product.setName("pro1");

        Product product2 = new Product();
        product2.setId(2L);
        product2.setName("pro2");

        List<Product> products = new ArrayList<>();
        products.add(product);
        products.add(product2);

        when(iProductService.getAllProducts()).thenReturn(products);

        ProductDto productDto = new ProductDto();
        productDto.setId(1L);
        productDto.setName("pro1");

        ProductDto productDto2 = new ProductDto();
        productDto2.setId(2L);
        productDto2.setName("pro2");
        List<ProductDto> productDtos = new ArrayList<>();
        productDtos.add(productDto);
        productDtos.add(productDto2);

        String body = objectMapper.writeValueAsString(productDtos);

        mockMvc.perform(get("/products"))
                .andExpect(status().isOk())
                .andExpect(content().string(body));
    }
}
