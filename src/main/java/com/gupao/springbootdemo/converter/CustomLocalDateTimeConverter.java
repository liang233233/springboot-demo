package com.gupao.springbootdemo.converter;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.converters.WriteConverterContext;
import com.alibaba.excel.metadata.data.WriteCellData;

import java.time.LocalDateTime;

public class CustomLocalDateTimeConverter implements Converter<LocalDateTime> {

    @Override
    public WriteCellData<?> convertToExcelData(WriteConverterContext<LocalDateTime> context) throws Exception {
//        context.




        return Converter.super.convertToExcelData(context);
    }
}
