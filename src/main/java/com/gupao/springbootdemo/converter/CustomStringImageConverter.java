package com.gupao.springbootdemo.converter;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.converters.ReadConverterContext;
import com.alibaba.excel.converters.WriteConverterContext;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.data.ReadCellData;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.util.IoUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author YCWB0571
 */
@Slf4j
public class CustomStringImageConverter implements Converter<String> {
    @Override
    public Class supportJavaTypeKey() {
        return String.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.EMPTY;
    }

    @Override
    public String convertToJavaData(ReadConverterContext<?> context) throws Exception {
        // 导入数据 类型转换
        ReadCellData<?> readCellData = context.getReadCellData();
        return readCellData.getData().toString();
    }


    @Override
    public WriteCellData<?> convertToExcelData(WriteConverterContext<String> context) throws Exception {
        String str = context.getValue();
        InputStream inputStream = null;

        if (StringUtils.isBlank(str)) {
            return new WriteCellData("");
        }
        try {
            //开启连接
            URL value = new URL(str);
            URLConnection uc = value.openConnection();
            URL url = null;
            //获取响应状态
            int statusCode = ((HttpURLConnection) uc).getResponseCode();

            switch (statusCode) {
                case 200:
                    inputStream = value.openStream();
                    break;
                default:
                    break;
            }
            byte[] bytes = IoUtils.toByteArray(inputStream);
            return new WriteCellData(bytes);
        } catch (Exception e) {
            //捕获下链接异常
            log.error("图片转换异常!! {}", e.getMessage());
            return new WriteCellData("");
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }
}
