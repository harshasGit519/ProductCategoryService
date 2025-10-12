package com.ecommerce.produccategoryservice.clients;

import com.ecommerce.produccategoryservice.dtos.FakeStoreProductDTO;
import com.ecommerce.produccategoryservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class FakeStoreClientApi {

    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    public FakeStoreProductDTO getProductById(Long id) {
        ResponseEntity<FakeStoreProductDTO> fakeStoreProductDTOResponseEntity =
                requestForEntity(HttpMethod.GET, "https://fakestoreapi.com/products/{id}", null, FakeStoreProductDTO.class, id);
        if (validateSingleReponseEntity(fakeStoreProductDTOResponseEntity)) {
            return fakeStoreProductDTOResponseEntity.getBody();
        }
        return null;
    }

    public FakeStoreProductDTO[] getAllProducts() {
        ResponseEntity<FakeStoreProductDTO[]> fakeStoreProductDTOResponseEntityList =
                requestForEntity(HttpMethod.GET, "https://fakestoreapi.com/products", null, FakeStoreProductDTO[].class);
        if (validateReponseEntity(fakeStoreProductDTOResponseEntityList)) {
            return fakeStoreProductDTOResponseEntityList.getBody();
        }
        return null;
    }

    public FakeStoreProductDTO updateOrReplaceProduct(Long id, FakeStoreProductDTO fakeStoreProductDTO) {
        ResponseEntity<FakeStoreProductDTO> fakeStoreProductDTOResponseEntity =
                requestForEntity(HttpMethod.PUT, "https://fakestoreapi.com/products/{id}", fakeStoreProductDTO, FakeStoreProductDTO.class, id);
        if (validateSingleReponseEntity(fakeStoreProductDTOResponseEntity)) {
            return fakeStoreProductDTOResponseEntity.getBody();
        }
        return null;
    }

    private Boolean validateSingleReponseEntity(ResponseEntity<FakeStoreProductDTO> fakeStoreProductDTOResponseEntity) {
        if (fakeStoreProductDTOResponseEntity != null &&
                fakeStoreProductDTOResponseEntity.getStatusCode().equals(HttpStatusCode.valueOf(200)) &&
                fakeStoreProductDTOResponseEntity.hasBody()) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    private Boolean validateReponseEntity(ResponseEntity<FakeStoreProductDTO[]> fakeStoreProductDTOResponseEntity) {
        if (fakeStoreProductDTOResponseEntity != null &&
                fakeStoreProductDTOResponseEntity.getStatusCode().equals(HttpStatusCode.valueOf(200)) &&
                fakeStoreProductDTOResponseEntity.hasBody()) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public <T> ResponseEntity<T> requestForEntity(HttpMethod httpMethod, String url, @Nullable Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        ResponseExtractor<ResponseEntity<T>> responseExtractor = restTemplate.responseEntityExtractor(responseType);
        return restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, uriVariables);
    }
}
