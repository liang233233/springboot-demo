package com.gupao.springbootdemo.util;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import net.anumbrella.seaweedfs.core.FileTemplate;
import net.anumbrella.seaweedfs.core.file.FileHandleStatus;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author YCWB0571
 */
@Slf4j
public class FileUtil {


    public static byte[] getBytesByFile(String filePath) {
        try {
            File file = new File(filePath);
            //获取输入流
            FileInputStream fis = new FileInputStream(file);

            //新的 byte 数组输出流，缓冲区容量1024byte
            ByteArrayOutputStream bos = new ByteArrayOutputStream(1024);
            //缓存
            byte[] b = new byte[1024];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            fis.close();
            //改变为byte[]
            byte[] data = bos.toByteArray();
            //
            bos.close();
            return data;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static FileHandleStatus uploadFile(FileTemplate template, byte[] bytes) {
        try (InputStream inputStream = new ByteArrayInputStream(bytes)) {
            // 上传图片
            FileHandleStatus fileHandleStatus = template.saveFileByStream(UUID.randomUUID().toString().replaceAll("-", ""), inputStream);
            return fileHandleStatus;
        } catch (Exception e) {
            log.error("上传文件失败， error:{}", e);
        }
        return null;
    }

    @SneakyThrows
    public static void deleteFile(FileTemplate template, ArrayList<String> lists) {
        template.deleteFiles(lists);
    }

}
