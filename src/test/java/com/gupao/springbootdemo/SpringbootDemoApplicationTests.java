package com.gupao.springbootdemo;

import com.gupao.springbootdemo.model.Brand;
import com.gupao.springbootdemo.model.UploadFile;
import com.gupao.springbootdemo.service.BrandService;
import com.gupao.springbootdemo.service.UploadFileService;
import com.gupao.springbootdemo.util.FileUtil;
import lombok.SneakyThrows;
import net.anumbrella.seaweedfs.core.FileTemplate;
import net.anumbrella.seaweedfs.core.file.FileHandleStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class SpringbootDemoApplicationTests {


    @Autowired
    private BrandService brandService;


    @Autowired
    private FileTemplate fileTemplate;

    @Autowired
    private UploadFileService uploadFileService;

    @SneakyThrows
    @Test
    void testCRUD() {
        Brand brand = new Brand();
        brand.setName("test1");
//        brandService.save(brand);

//        Brand byId = brandService.getById(17);
//        new Thread(() -> {
//            byId.setName("test02");
//            brandService.updateById(byId);
//        }).start();
//
//        new Thread(() -> {
//            byId.setName("test03");
//            brandService.updateById(byId);
//        }).start();

//        brandService.removeById(17);

        List<Brand> brands = brandService.queryList(new Brand());

//        Thread.sleep(30000);
    }

    @SneakyThrows
    @Test
    void testUpdate() {
        byte[] bytes = FileUtil.getBytesByFile("C:\\Users\\YCWB0571\\Downloads\\66.jpg");

        List<UploadFile> objects = Collections.synchronizedList(new ArrayList<UploadFile>());

        for (int i = 0; i < 50; i++) {
            FileHandleStatus fileHandleStatus = FileUtil.uploadFile(fileTemplate, bytes);
            String fileId = fileHandleStatus.getFileId();

            UploadFile uploadFile = new UploadFile();
            uploadFile.setImgId(fileId);
            uploadFile.setCreateTime(LocalDateTime.now());
            objects.add(uploadFile);

            if (objects.size() == 50) {
                uploadFileService.saveBatch(objects);
                objects.clear();
            }
        }

    }

    @SneakyThrows
    @Test
    void testdelete() {
        List<UploadFile> uploadFiles = uploadFileService.queryList(new UploadFile());
        ArrayList<String> collect = uploadFiles.stream().map(UploadFile::getImgId).collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Long> collect1 = uploadFiles.stream().map(UploadFile::getId).collect(Collectors.toCollection(ArrayList::new));
        FileUtil.deleteFile(fileTemplate, collect);
        uploadFileService.removeByIds(collect1);
    }


    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread();
        ThreadLocal<Object> objectThreadLocal = new ThreadLocal<>();
//        objectThreadLocal.set();
        thread.join();

    }

}
