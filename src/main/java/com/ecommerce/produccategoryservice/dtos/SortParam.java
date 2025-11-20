package com.ecommerce.produccategoryservice.dtos;

import lombok.Data;

@Data
public class SortParam {
    private String sortCriteria;
    private SortType sortType;
}
