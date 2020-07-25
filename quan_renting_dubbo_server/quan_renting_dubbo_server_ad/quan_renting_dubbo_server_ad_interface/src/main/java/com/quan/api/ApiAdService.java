package com.quan.api;

import com.quan.pojo.Ad;
import com.quan.pojo.PageInfo;

public interface ApiAdService {

    PageInfo<Ad> queryAdList(Integer type, Integer page, Integer pageSize);
}
