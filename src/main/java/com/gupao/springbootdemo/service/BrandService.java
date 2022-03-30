package com.gupao.springbootdemo.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gupao.springbootdemo.model.Brand;

import java.util.List;

/*****
 * @Author: 波波
 * @Description: 咕泡云商城
 ****/
public interface BrandService extends IService<Brand> {

    /****
     * 条件查询
     * return List<Brand>
     */
    List<Brand> queryList(Brand brand);

    /****
     * 条件分页查询
     * return Page<Brand>
     */
    Page<Brand> queryPageList(Brand brand,Long currentPage,Long size);

}
