package com.zoo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zoo.entity.PageResult;
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

    //分页查找
    @Override
    public PageResult findByPage(int currentPage, int pageSize) {

        PageHelper.startPage(currentPage, pageSize);

        //需要查询所有记录
        TbBrandExample example = new TbBrandExample();
        //List<TbBrand> brands = brandMapper.selectByExample(example);// limit
        Page<TbBrand> brands = (Page<TbBrand>) tbBrandMapper.selectByExample(example);

        PageResult pageResult = new PageResult();

        pageResult.setTotal(brands.getTotal());//得到的总记录数
        pageResult.setRows(brands.getResult());//得到的是当前页的记录

        return pageResult;
    }

    //添加品牌
    @Override
    public void addBrand(TbBrand tbBrand) {
        tbBrandMapper.insert(tbBrand);
    }

    //根据id查询品牌
    @Override
    public TbBrand findById(Long id) {
        return tbBrandMapper.selectByPrimaryKey(id);
    }

    //品牌的修改
    @Override
    public void updateBrand(TbBrand tbBrand) {
        tbBrandMapper.updateByPrimaryKey(tbBrand);
    }

    //删除品牌
    @Override
    public void deleteBrand(Long[] ids) {
        for (Long id : ids
        ) {
            tbBrandMapper.deleteByPrimaryKey(id);
        }
    }

    //条件查询
    @Override
    public PageResult findByPage(TbBrand tbBrand, int currentPage, int pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        TbBrandExample example = new TbBrandExample();
        TbBrandExample.Criteria criteria = example.createCriteria();
        if (tbBrand != null) {
            if (tbBrand.getName() != null && tbBrand.getName().length() > 0) {
                criteria.andNameLike("%" + tbBrand.getName() + "%");
            }
            if (tbBrand.getFirstChar() != null && tbBrand.getFirstChar().length() > 0) {
                criteria.andFirstCharLike("%" + tbBrand.getFirstChar() + "%");
            }
        }
        Page<TbBrand> brands = (Page<TbBrand>) tbBrandMapper.selectByExample(example);
        return new PageResult(brands.getTotal(), brands.getResult());
    }
}
