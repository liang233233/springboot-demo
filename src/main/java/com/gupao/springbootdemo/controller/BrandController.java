package com.gupao.springbootdemo.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.baomidou.mybatisplus.core.toolkit.SystemClock;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gupao.springbootdemo.config.UploadFileConfig;
import com.gupao.springbootdemo.handler.CustomRowWriteHandler;
import com.gupao.springbootdemo.listener.lead.BrandImportListener;
import com.gupao.springbootdemo.model.Brand;
import com.gupao.springbootdemo.service.BrandService;
import com.gupao.springbootdemo.util.BeanCopyUtils;
import com.gupao.springbootdemo.util.EasyExcelUtils;
import com.gupao.springbootdemo.util.RespResult;
import com.gupao.springbootdemo.vo.response.BrandExportRespones;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.StopWatch;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/*****
 * @Author: 波波
 * @Description: 咕泡云商城
 ****/
@Slf4j
@RestController
@RequestMapping(value = "/brand")
public class BrandController {

    private final BrandService brandService;

    private final UploadFileConfig uploadFileConfig;

    public BrandController(BrandService brandService, UploadFileConfig uploadFileConfig) {
        this.brandService = brandService;
        this.uploadFileConfig = uploadFileConfig;
    }

    /****
     * 增加方法
     */
    @PostMapping
    public RespResult add(@RequestBody Brand brand) {
        brandService.save(brand);
        return RespResult.ok();
    }

    /****
     * 修改方法
     */
    @PutMapping
    public RespResult update(@RequestBody Brand brand) {
        brandService.updateById(brand);
        return RespResult.ok();
    }

    /****
     * 删除方法
     */
    @DeleteMapping("/{id}")
    public RespResult delete(@PathVariable(value = "id") String id) {
        brandService.removeById(id);
        return RespResult.ok();
    }

    /****
     * 条件查询
     */
    @PostMapping(value = "/search")
    public RespResult<List<Brand>> queryList(@RequestBody Brand brand) {
        List<Brand> brands = brandService.queryList(brand);
        return RespResult.ok(brands);
    }

    /****
     * 条件查询
     */
    @PostMapping(value = "/search/{page}/{size}")
    public RespResult<Page<Brand>> queryPageList(
            @PathVariable(value = "page") Long page,
            @PathVariable(value = "size") Long size,
            @RequestBody Brand brand) {
        Page<Brand> pageInfo = brandService.queryPageList(brand, page, size);
        brandService.queryPageList(brand, page, size);
        brandService.queryPageList(brand, page, size);
        brandService.queryPageList(brand, page, size);
        brandService.queryPageList(brand, page, size);
        brandService.queryPageList(brand, page, size);
        brandService.queryPageList(brand, page, size);
        brandService.queryPageList(brand, page, size);
        brandService.queryPageList(brand, page, size);
        brandService.queryPageList(brand, page, size);
        brandService.queryPageList(brand, page, size);
        brandService.queryPageList(brand, page, size);
        brandService.queryPageList(brand, page, size);
        brandService.queryPageList(brand, page, size);
        brandService.queryPageList(brand, page, size);
        brandService.queryPageList(brand, page, size);
        brandService.queryPageList(brand, page, size);
        brandService.queryPageList(brand, page, size);
        brandService.queryPageList(brand, page, size);
        brandService.queryPageList(brand, page, size);
        brandService.queryPageList(brand, page, size);
        brandService.queryPageList(brand, page, size);
        log.info("--------test");
        return RespResult.ok(pageInfo);
    }


    /**
     * 条件查询+分页 + 导出
     *
     * @param brand
     * @return RespResult
     */
    @PostMapping(value = "/search/export/{page}/{size}")
    public void queryPageListExport(@RequestBody Brand brand,
                                    @PathVariable(value = "page") Long page,
                                    @PathVariable(value = "size") Long size,
                                    HttpServletResponse response) {
        Page<Brand> pageInfo = this.brandService.queryPageList(brand, page, size);
        List<Brand> records = pageInfo.getRecords();

        ArrayList<BrandExportRespones> result = new ArrayList<>();
        records.forEach(v -> {
            BrandExportRespones facilitiesInfoData = BeanCopyUtils.copyProperties(v, BrandExportRespones.class);
            result.add(facilitiesInfoData);
        });
        String excelName = "商铺";
        try {
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition",
                    "attachment; filename=" + URLEncoder.encode(excelName + ".xlsx", "UTF-8"));
            EasyExcel.write(response.getOutputStream(), BrandExportRespones.class)
                    .excelType(ExcelTypeEnum.XLSX)
//                    .registerWriteHandler(new CustomSheetWriteHandler())
                    .registerWriteHandler(new CustomRowWriteHandler())
                    .sheet(excelName).doWrite(result);
        } catch (Exception e) {
            log.info(excelName + "导出错误，错误原因：{}", e.getMessage());
        }
    }


    /**
     * 导入
     *
     * @param excelFile
     * @return RespResult
     */
    @PostMapping("/import")
    public RespResult importRoom(@RequestParam("excelFile") MultipartFile excelFile) throws Exception {
        StopWatch stopWatch = StopWatch.createStarted();
        // 拿到文件名
        String fileName = excelFile.getOriginalFilename();
        if (!fileName.endsWith(".xlsx")) {
            RespResult.error("格式不正确");
        }
        String localName = SystemClock.now() + fileName;
        // 上传
        EasyExcelUtils.uploadFile(excelFile.getBytes(), uploadFileConfig.getPath(), localName);
        // 全路径
        String wholeFilePath = uploadFileConfig.getPath() + File.separator + localName;
        EasyExcel.read(wholeFilePath, BrandExportRespones.class, new BrandImportListener(brandService))
                .sheet().doRead();
        return RespResult.ok();
    }
}
