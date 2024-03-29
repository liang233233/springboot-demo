package com.gupao.springbootdemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gupao.springbootdemo.mapper.BrandMapper;
import com.gupao.springbootdemo.model.Brand;
import com.gupao.springbootdemo.service.BrandService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*****
 * @Author: 波波
 * @Description: 咕泡云商城
 ****/
@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements BrandService {


    @Autowired
    private BrandMapper brandMapper;

    /****
     * 条件查询
     * return List<Brand>
     */
    @Override
    public List<Brand> queryList(Brand brand) {
        //条件包装对象
        QueryWrapper<Brand> queryWrapper = new QueryWrapper<Brand>();
        //根据name查询品牌
        queryWrapper.like("name", brand.getName());

        //根据initial查询
        queryWrapper.eq("initial", brand.getInitial());
        return brandMapper.selectList(queryWrapper);
    }

    /****
     * 条件分页查询
     * return Page<Brand>
     */
    @Override
    public Page<Brand> queryPageList(Brand brand, Long currentPage, Long size) {
        //条件包装对象
        QueryWrapper<Brand> queryWrapper = new QueryWrapper();
        //根据name查询品牌
        queryWrapper.like(StringUtils.isNotBlank(brand.getName()), "name", brand.getName());
        return brandMapper.selectPage(new Page<Brand>(currentPage, size), queryWrapper);
    }
}
