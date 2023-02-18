package com.gupao.springbootdemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gupao.springbootdemo.mapper.UploadFileMapper;
import com.gupao.springbootdemo.model.UploadFile;
import com.gupao.springbootdemo.service.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 *  服务实现类
 *
 * @author huliang
 * @since 2023-01-13
 */
@Service
public class UploadFileServiceImpl extends ServiceImpl<UploadFileMapper, UploadFile> implements UploadFileService {
        
    @Autowired
    private UploadFileMapper uploadFileMapper;

    @Override
    public List<UploadFile> queryList(UploadFile uploadFile) {
        QueryWrapper<UploadFile> queryWrapper = new QueryWrapper<UploadFile>();
        return this.uploadFileMapper.selectList(queryWrapper);
    }

    @Override
    public Page<UploadFile> queryPageList( UploadFile uploadFile, Long currentPage, Long size) {
        QueryWrapper< UploadFile> wrapper = new QueryWrapper(uploadFile);
        return this.uploadFileMapper.selectPage(new Page<>(currentPage, size), wrapper);
    }

}