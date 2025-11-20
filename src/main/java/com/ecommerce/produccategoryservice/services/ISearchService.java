package com.ecommerce.produccategoryservice.services;

import com.ecommerce.produccategoryservice.dtos.SortParam;
import com.ecommerce.produccategoryservice.models.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ISearchService {

    Page<Product> search(String query,
                         Integer pageSize,
                         Integer pageNo,
                         List<SortParam> sortParamList);

}
