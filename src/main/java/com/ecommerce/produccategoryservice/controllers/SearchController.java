package com.ecommerce.produccategoryservice.controllers;

import com.ecommerce.produccategoryservice.dtos.SearchRequestDTO;
import com.ecommerce.produccategoryservice.models.Product;
import com.ecommerce.produccategoryservice.services.ISearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private ISearchService searchService;

    @PostMapping
    public Page<Product> search
            (@RequestBody SearchRequestDTO searchRequestDTO) {

       return searchService.search(searchRequestDTO.getQuery(),
                searchRequestDTO.getPageSize(),
                searchRequestDTO.getPageNo(),
               searchRequestDTO.getSortParamList());


    }
}
