package com.gupao.springbootdemo.handler;

import com.alibaba.excel.write.handler.RowWriteHandler;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteTableHolder;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * 自定义EasyExcel Row
 */
public class CustomRowWriteHandler implements RowWriteHandler {

    private CellStyle headerStyle;

    private CellStyle contentStyle;

    @Override
    public void beforeRowCreate(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Integer rowIndex, Integer relativeRowIndex, Boolean isHead) {
    }

    /**
     * 行创建后执行此方法
     */
    @Override
    public void afterRowCreate(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Row row, Integer relativeRowIndex, Boolean isHead) {
        //创建一个单元格
        Cell cell = row.createCell(0);
        //给表格头样式赋值
        if (headerStyle == null) {
            Workbook workbook = writeSheetHolder.getSheet().getWorkbook();
            writeSheetHolder.getUseDefaultStyle();

        }
        //给表格内容样式赋值
        if (contentStyle == null) {
            Workbook workbook = writeSheetHolder.getSheet().getWorkbook();
            writeSheetHolder.getUseDefaultStyle();
        }
        //设置列宽0列8个字符宽度(poi的列宽是通过字符个数来确定的，一个列宽为一个字符的1/256)
//        writeSheetHolder.getSheet().setColumnWidth(1, 8 * 256);
        if (row.getRowNum() == 0) {
            cell.setCellValue("序号");
//            cell.setCellStyle();
        } else {
            cell.setCellValue(relativeRowIndex + 1);
//            cell.setCellStyle(contentStyle);
        }
    }

    @Override
    public void afterRowDispose(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, Row row, Integer relativeRowIndex, Boolean isHead) {
    }

}
