package com.gupao.springbootdemo.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gupao.springbootdemo.model.UploadFile;

import java.util.List;

/**
 *
 *  服务类
 *
 * @author huliang
 * @since 2023-01-13
 */
public interface UploadFileService extends IService<UploadFile> {

    
    /****
     * 条件查询
     * @param uploadFile
     * return List<UploadFile>
     */
    List<UploadFile> queryList(UploadFile uploadFile);

    /****
     * 条件分页查询
     * @param uploadFile
     * @param currentPage  第几页
     * @param size 每页数量
     * return Page<UploadFile>
     */
    Page<UploadFile> queryPageList(UploadFile uploadFile, Long currentPage, Long size);

}
