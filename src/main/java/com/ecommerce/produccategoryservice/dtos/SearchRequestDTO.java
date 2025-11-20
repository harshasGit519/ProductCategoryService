package com.ecommerce.produccategoryservice.dtos;

import lombok.Data;

import java.util.List;

@Data
public class SearchRequestDTO {

    private String query;
    private Integer pageNo;
    private Integer pageSize;
    private List<SortParam> sortParamList;
}
