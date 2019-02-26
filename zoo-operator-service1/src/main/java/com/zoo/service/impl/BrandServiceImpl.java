package com.zoo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zoo.mapper.TbBrandMapper;
import com.zoo.pojo.TbBrand;
import com.zoo.pojo.TbBrandExample;
import com.zoo.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author:Dustyhandhe Date: 2019-02-26
 * Time: 17:27
 */
@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private TbBrandMapper tbBrandMapper;

    @Override
    public List<TbBrand> findAll() {
        TbBrandExample example = new TbBrandExample();
        //Criteria criteria = example.createCriteria();
        //criteria.andNameEqualTo(name);
        List<TbBrand> brands = tbBrandMapper.selectByExample(example);
        return brands;
    }
}
