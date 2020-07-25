package com.quan.service;

import com.quan.pojo.Ad;
import com.quan.pojo.PageInfo;

public interface AdService {

    PageInfo<Ad> queryAdList(Ad ad, Integer page, Integer pageSize);
}
