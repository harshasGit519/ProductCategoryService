package com.ecommerce.produccategoryservice.services;

import com.ecommerce.produccategoryservice.clients.FakeStoreClientApi;
import com.ecommerce.produccategoryservice.dtos.FakeStoreProductDTO;
import com.ecommerce.produccategoryservice.models.Category;
import com.ecommerce.produccategoryservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements IProductService {

    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    @Autowired
    FakeStoreClientApi fakeStoreClientApi;

    @Override
    public Product getProductById(Long id) {
        FakeStoreProductDTO fakeStoreProductDTO = fakeStoreClientApi.getProductById(id);
        if (fakeStoreProductDTO != null) {
            return from(fakeStoreProductDTO);
        }
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDTO[] fakeStoreProductDTOArray = fakeStoreClientApi.getAllProducts();

        if (fakeStoreProductDTOArray != null) {
            List<Product> products = new ArrayList<>();
            for (FakeStoreProductDTO fakeStoreProductDTO : fakeStoreProductDTOArray) {
                Product product = from(fakeStoreProductDTO);
                products.add(product);
            }
            return products;
        }
        return List.of();
    }

    @Override
    public Product updateOrReplaceProduct(Long id, Product product) {
        FakeStoreProductDTO fakeStoreProductDTO = from(product);
        fakeStoreProductDTO = fakeStoreClientApi.updateOrReplaceProduct(id, fakeStoreProductDTO);
        if (fakeStoreProductDTO != null) {
            return from(fakeStoreProductDTO);
        }
        return null;
    }

    public <T> ResponseEntity<T> requestForEntity(HttpMethod httpMethod, String url, @Nullable Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables);
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    private Product from(FakeStoreProductDTO fakeStoreProductDTO) {
        Product product = new Product();
        product.setId(fakeStoreProductDTO.getId());
        product.setDescription(fakeStoreProductDTO.getDescription());
        product.setName(fakeStoreProductDTO.getTitle());
        product.setPrice(fakeStoreProductDTO.getPrice());
        product.setImageUrl(fakeStoreProductDTO.getImage());
        Category category = new Category();
        category.setCategoryName(fakeStoreProductDTO.getCategory());
        product.setCategory(category);
        return product;
    }

    private FakeStoreProductDTO from(Product product) {
        FakeStoreProductDTO fakeStoreProductDTO = new FakeStoreProductDTO();
        fakeStoreProductDTO.setId(product.getId());
        fakeStoreProductDTO.setDescription(product.getDescription());
        fakeStoreProductDTO.setTitle(product.getName());
        fakeStoreProductDTO.setPrice(product.getPrice());
        fakeStoreProductDTO.setImage(product.getImageUrl());
        if (product.getCategory() != null) {
            fakeStoreProductDTO.setCategory(product.getCategory().getCategoryName());
        }
        return fakeStoreProductDTO;
    }
}
