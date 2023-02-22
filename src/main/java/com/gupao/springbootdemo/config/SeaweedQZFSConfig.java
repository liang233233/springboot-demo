package com.gupao.springbootdemo.config;

import lombok.extern.slf4j.Slf4j;
import net.anumbrella.seaweedfs.core.FileSource;
import net.anumbrella.seaweedfs.core.FileTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Slf4j
@Configuration
@ConditionalOnProperty(prefix = "seaweedfs.qz", name = "enabled", havingValue = "false")
public class SeaweedQZFSConfig {

    @Value("${seaweedfs.qz.host}")
    private String host;
    @Value("${seaweedfs.qz.port}")
    private int port;

    private static String frontPicUrl;//回送数据给前端时需要加上的前缀

    @Bean("fileQZTemplate")
    public FileTemplate fileQZTemplate() {
        FileSource fileSource = new FileSource();
        // SeaweedFS master服务ip地址
        fileSource.setHost(host);
        // SeaweedFS master服务端口
        fileSource.setPort(port);
        try {
            // 启动服务
            fileSource.startup();
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return new FileTemplate(fileSource.getConnection());
    }

    public static String getFrontPicUrl() {
        return frontPicUrl;
    }

    @Value("${seaweedfs.qz.fullpath}")
    public void setFrontPicUrl(String frontPicUrl) {
        SeaweedQZFSConfig.frontPicUrl = frontPicUrl;
    }
}