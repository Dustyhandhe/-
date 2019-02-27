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
    PageResult findByPage(int currentPage, int pageSize);

    /**
     * 添加品牌
     */
    void addBrand(TbBrand tbBrand);

    /**
     * 根据品牌查询id
     */
    TbBrand findById(Long id);

    /**
     * 实现品牌的修改
     */
    void updateBrand(TbBrand tbBrand);

    /**
     * 删除品牌
     */
    void deleteBrand(Long[] ids);

    /**
     * 条件查询并分页
     */
    PageResult findByPage(TbBrand tbBrand, int currentPage, int pageSize);
}
