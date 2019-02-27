package com.zoo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zoo.entity.PageResult;
import com.zoo.entity.ReturnResult;
import com.zoo.pojo.TbBrand;
import com.zoo.service.BrandService;
import org.springframework.web.bind.annotation.RequestBody;
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
    public PageResult findByPage(int page, int size) {
        return brandService.findByPage(page, size);
    }

    //添加品牌
    @RequestMapping("/add")
    public ReturnResult addBrand(@RequestBody TbBrand tbBrand) {
        try {
            brandService.addBrand(tbBrand);
            return new ReturnResult(true, "添加品牌成功");
        } catch (Exception e) {
            return new ReturnResult(false, "添加品牌失败");

        }

    }

    //根据id查询品牌
    @RequestMapping("/findById")
    public TbBrand findBrandById(Long id) {
        return brandService.findById(id);
    }

    //修改品牌
    @RequestMapping("/update")
    public ReturnResult updateBrand(@RequestBody TbBrand tbBrand) {
        try {
            brandService.updateBrand(tbBrand);
            return new ReturnResult(true, "修改品牌成功");
        } catch (Exception e) {
            return new ReturnResult(false, "修改品牌失败");
        }
    }

    //删除品牌
    @RequestMapping("/del")
    public ReturnResult delBrands(Long[] ids) {
        try {
            brandService.deleteBrand(ids);
            return new ReturnResult(true, "删除品牌成功");
        } catch (Exception e) {
            return new ReturnResult(false, "删除品牌失败");
        }
    }

    //多条件查询
    @RequestMapping("/search")
    public PageResult findByCondition(@RequestBody TbBrand tbBrand, int page, int size) {
        return brandService.findByPage(tbBrand, page, size);
    }
}
