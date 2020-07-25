package com.quan.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Collections;
import java.util.List;

@Data
@AllArgsConstructor
public class PageInfo<T> implements java.io.Serializable {
    private Integer total;
    private Integer pageNum;
    private Integer pageSize;
    private List<T> records = Collections.emptyList();
}

