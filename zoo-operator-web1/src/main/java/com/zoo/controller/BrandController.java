package com.zoo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zoo.entity.PageResult;
import com.zoo.pojo.TbBrand;
import com.zoo.service.BrandService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author:Dustyhandhe Date: 2019-02-26
 * Time: 17:32
 */
@RestController
@RequestMapping("/brand")
public class BrandController {
    @Reference
    private BrandService brandService;

    @RequestMapping("/findAll")
    public List<TbBrand> findAllBrands() {
        return brandService.findAll();
    }
    //分页查询品牌
    @RequestMapping("/findByPage")
    public PageResult findByPage(int page, int size){
        return brandService.findByPage(page, size);
    }
}
