package com.gupao.springbootdemo.util;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.handler.WriteHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

/**
 * @author YCKJ3465
 * @since 2021/6/23 上午11:18
 */
@Slf4j
public class EasyExcelUtils {

    public static final String SUFFIX_XLS = ".xls";

    /**
     * 导出文件时间格式
     */
    private final static DateTimeFormatter FORMATTER_DT19_CN = DateTimeFormatter.ofPattern("yyyy年M月d日 HH:mm:ss");

    /**
     * 导出excel
     *
     * @param list         导出数据 List<A>
     * @param clazz        A.class
     * @param writeHandler 导出handler处理类
     * @param fileDir      文件地址
     * @param sheetName    sheet名称
     * @param excelName    excel名称
     * @return 导出excel文件地址
     */
    public static String exportExcel(List<?> list, Class<?> clazz, WriteHandler writeHandler, String fileDir,
                                     String sheetName, String excelName) {
        //实现excel写的操作
        //1 设置写入文件夹地址和excel文件名称
        File tempFile = null;
        try {
            tempFile = new File(fileDir + File.separator + getExcelName(excelName) + SUFFIX_XLS);
            if (!tempFile.exists()) {
                tempFile.createNewFile();
            }

            // 2 调用easy excel 里面的方法实现写操作
            // write方法两个参数：第一个参数文件路径名称，第二个参数实体类class
            if (!CollectionUtils.isEmpty(list)) {
                if (Objects.nonNull(writeHandler)) {
                    EasyExcel.write(tempFile.getPath(), clazz)
                            .registerWriteHandler(writeHandler)
                            .sheet(sheetName)
                            .doWrite(list);
                } else {
                    EasyExcel.write(tempFile.getPath(), clazz)
                            .sheet(sheetName)
                            .doWrite(list);
                }
            }
            log.debug("========excel export success!!! ===========");
        } catch (Exception exception) {
            log.error("excel export failed !!!!! ", exception);
        }

        return tempFile != null ? tempFile.getAbsolutePath() : null;
    }

    /**
     * 导出excel到流中
     *
     * @param list         导出数据 List<A>
     * @param clazz        A.class
     * @param writeHandler 导出handler处理类
     * @param sheetName    sheet名称
     * @return 导出excel文件地址
     */
    public static void exportExcel(List<?> list, Class<?> clazz, WriteHandler writeHandler,
                                   String sheetName, OutputStream outputStream) {
        //实现excel写的操作
        try {
            if (Objects.nonNull(writeHandler)) {
                EasyExcel.write(outputStream, clazz)
                        .registerWriteHandler(writeHandler)
                        .sheet(sheetName)
                        .doWrite(list);
            } else {
                EasyExcel.write(outputStream, clazz)
                        .sheet(sheetName)
                        .doWrite(list);
            }
            log.debug("========excel export success!!! ===========");
        } catch (Exception exception) {
            log.error("excel export failed !!!!! ", exception);
        }
    }

    /**
     * 生成最终文件名称
     *
     * @param excelName 文件名称
     * @return 文件名称+时间
     */
    public static String getExcelName(String excelName) {
        return excelName + LocalDateTime.now().format(FORMATTER_DT19_CN);
    }

    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        //如果文件存在就先删除了
        File ifFile = new File(filePath + File.separator + fileName);
        if (ifFile.exists()) {
            log.debug("File is exists!");
            ifFile.delete();
        }
        //然后再写文件
        FileOutputStream out = null;
        try {

            out = new FileOutputStream(filePath + File.separator + fileName);
            out.write(file);
        } catch (Exception e) {
            log.error("Error:", e);
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

}
