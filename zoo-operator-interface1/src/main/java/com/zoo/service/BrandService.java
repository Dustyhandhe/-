package com.zoo.service;

import com.zoo.entity.PageResult;
import com.zoo.pojo.TbBrand;

import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author:Dustyhandhe Date: 2019-02-26
 * Time: 17:22
 */
public interface BrandService {
    List<TbBrand> findAll();
    /*
     * 分页查找
     */
    PageResult findByPage(int currentPage,int pageSize);
}
