package com.ecommerce.produccategoryservice.repos;

import com.ecommerce.produccategoryservice.models.Category;
import com.ecommerce.produccategoryservice.models.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
class CategoryRepoTest {

    @Autowired
    private CategoryRepo categoryRepo;

//    @Test
//    @Transactional
    public void testLoadingForFetchTypes(){
        Category category = categoryRepo.findById(123L).get();
        category.getCategoryName();
        for(Product product : category.getProducts()){
            System.out.println(product.getId());
        }
    }

    @Test
    @Transactional
    public void testFetcAll(){
        List<Category> categoryList =  categoryRepo.findAll();
        for(Category category : categoryList){
            System.out.println("CateId:"+category.getId());
            for(Product product : category.getProducts()){
                System.out.println("PrdId:"+product.getId());
            }
        }
    }

}