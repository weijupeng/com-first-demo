package com.wjp.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


/**
 * @author weijupeng
 */
@RestController
public class UploadController {
    private final static Logger log = LoggerFactory.getLogger(UploadController.class);

    @GetMapping("/upload")
    private String upload() {
        log.info("上传测试");
        return "upload";
    }

    @PostMapping("upload")
    public String upload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "上传失败，请选择文件";
        }
        String filename = file.getOriginalFilename();
        String filePath = "C:/Users/weijupeng/Desktop/user/";
        File dest = new File(filePath + filename);
        try {
            file.transferTo(dest);
            log.info("上传成功");
            return "上传成功";
        } catch (IOException e) {
            log.error(e.toString() + e);
        }
        return "上传失败";
    }
}
