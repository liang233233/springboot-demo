package com.gupao.springbootdemo.listener.lead;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.Cell;
import com.alibaba.excel.metadata.CellExtra;
import com.alibaba.excel.read.metadata.holder.ReadSheetHolder;
import com.gupao.springbootdemo.model.Brand;
import com.gupao.springbootdemo.service.BrandService;
import com.gupao.springbootdemo.util.BeanCopyUtils;
import com.gupao.springbootdemo.vo.response.BrandExportRespones;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author YCWB0571
 */
@Slf4j
public class BrandImportListener extends AnalysisEventListener<BrandExportRespones> {

    private final BrandService brandService;

    public BrandImportListener(BrandService brandService) {
        this.brandService = brandService;
    }

    /**
     * 批处理阈值
     */
    private static final int BATCH_COUNT = 100;
    List<BrandExportRespones> list = new ArrayList<>(BATCH_COUNT);


    @Override
    public void invoke(BrandExportRespones brandExportRespones, AnalysisContext analysisContext) {
//        log.info("解析到一条数据:{}", JSON.toJSONString(excelItem));
        list.add(brandExportRespones);
        if (list.size() >= BATCH_COUNT) {
            importItemInfo(list);
            list.clear();
        }
        ReadSheetHolder readSheetHolder = analysisContext.readSheetHolder();
        Map<Integer, Cell> cellMap = readSheetHolder.getCellMap();
    }

    /**
     * 读取额外信息
     * @param extra
     * @param context
     */
    @Override
    public void extra(CellExtra extra, AnalysisContext context) {
        switch (extra.getType()) {
            case COMMENT:
                log.info("额外信息是批注,在rowIndex:{},columnIndex;{},内容是:{}", extra.getRowIndex(), extra.getColumnIndex(),
                        extra.getText());
                break;
            case HYPERLINK:
                if ("Sheet1!A1".equals(extra.getText())) {
                    log.info("额外信息是超链接,在rowIndex:{},columnIndex;{},内容是:{}", extra.getRowIndex(),
                            extra.getColumnIndex(), extra.getText());
                } else if ("Sheet2!A1".equals(extra.getText())) {
                    log.info(
                            "额外信息是超链接,而且覆盖了一个区间,在firstRowIndex:{},firstColumnIndex;{},lastRowIndex:{},lastColumnIndex:{},"
                                    + "内容是:{}",
                            extra.getFirstRowIndex(), extra.getFirstColumnIndex(), extra.getLastRowIndex(),
                            extra.getLastColumnIndex(), extra.getText());
                } else {
                    log.info("Unknown hyperlink!");
                }
                break;
            case MERGE:
                log.info(
                        "额外信息是超链接,而且覆盖了一个区间,在firstRowIndex:{},firstColumnIndex;{},lastRowIndex:{},lastColumnIndex:{}",
                        extra.getFirstRowIndex(), extra.getFirstColumnIndex(), extra.getLastRowIndex(),
                        extra.getLastColumnIndex());
                break;
            default:
        }
    }


    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        importItemInfo(list);
    }

    public void importItemInfo(List<BrandExportRespones> infoList) {
        //导入操作---新增公司和项目数据
        List<Brand> objects = new ArrayList<>();
        for (BrandExportRespones facilitiesInfoImportData : infoList) {
            Brand facilitiesInfoEntity = BeanCopyUtils.copyProperties(facilitiesInfoImportData, Brand.class);
            objects.add(facilitiesInfoEntity);
        }
//        brandService.saveBatch(objects);
    }
}