package com.ecommerce.produccategoryservice.services;

import com.ecommerce.produccategoryservice.dtos.SortParam;
import com.ecommerce.produccategoryservice.dtos.SortType;
import com.ecommerce.produccategoryservice.models.Product;
import com.ecommerce.produccategoryservice.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DBSearchServiceImpl implements ISearchService{

    @Autowired
    private ProductRepo productRepo;

    @Override
    public Page<Product> search(String query,
                                Integer pageSize,
                                Integer pageNo,
                                List<SortParam> sortParams) {
//        Sort sort = Sort.by("price").descending()
//                .and(Sort.by("id"));

        Sort sort = null;
        if(!sortParams.isEmpty()){
            if(sortParams.get(0).getSortType().equals(SortType.ASC)){
                sort = Sort.by(sortParams.get(0).getSortCriteria());
            }else{
                sort = Sort.by(sortParams.get(0).getSortCriteria()).descending();
            }
        }

        for(int i=1;i<sortParams.size();i++ ){
            if(sortParams.get(i).getSortType().equals(SortType.ASC)){
                sort = sort.and(Sort.by(sortParams.get(i).getSortCriteria()));
            }else{
                sort = sort.and(Sort.by(sortParams.get(i).getSortCriteria()).descending());
            }
        }

      return productRepo.findByName(query,
              PageRequest.of(pageNo,pageSize,sort));
    }
}
