package com.gupao.springbootdemo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author YCWB0571
 */
@Data
@ConfigurationProperties("update.file")
public class UploadFileConfig {

    /**
     * 上传文件路径
     */
    private String path;

}
