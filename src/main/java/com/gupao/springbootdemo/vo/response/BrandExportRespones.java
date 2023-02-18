package com.gupao.springbootdemo.vo.response;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentFontStyle;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import com.gupao.springbootdemo.converter.CustomLocalDateTimeConverter;
import com.gupao.springbootdemo.converter.CustomStringImageConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author YCWB0571
 */
@Data
@HeadRowHeight(25)
@ContentRowHeight(120)
@AllArgsConstructor
@NoArgsConstructor
public class BrandExportRespones {


    // 品牌名字
    @ColumnWidth(35)
    @ContentFontStyle(fontName = "Calibri", fontHeightInPoints = 12)
    @ExcelProperty(value = "品牌名字")
    private String name;
    // 品牌图片
    @ExcelProperty(value = {"品牌图片"}, index = 1, converter = CustomStringImageConverter.class)
    private String image;
    // 品牌首字母
    @ExcelProperty(value = "品牌首字母")
    private String initial;
    // 排序
    @ExcelProperty(value = "排序")
    private Integer sort;

    @DateTimeFormat("yyyy-MM-dd HH:mm:ss")
    @ExcelProperty(value = "创建时间")
    private LocalDateTime createTime;

}
