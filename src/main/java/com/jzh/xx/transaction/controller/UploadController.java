package com.jzh.xx.transaction.controller;

import cn.hutool.core.lang.UUID;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UploadController {
    private static final String ENDPOINT = "oss-cn-shenzhen.aliyuncs.com";
    private static final String ACCESS_KEY_ID = "LTAI4FpbVyixp5LA5jrDsPGq";
    private static final String ACCESS_KEY_SECRET = "dcNVI0I82ucLb4TK8oAHRFJHvjvrCl";
    private static final String BUCKET_NAME = "jzh971018";

    @PostMapping("upload")
    @ResponseBody
    public Map<String,Object> upload(MultipartFile dropzFile, HttpServletRequest request) {
        Map<String,Object> result = new HashMap<>();

        //文件名
        String fileName = dropzFile.getOriginalFilename();
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
        String newName = UUID.randomUUID() + "." + suffix;
        OSS client = new OSSClientBuilder().build(ENDPOINT, ACCESS_KEY_ID, ACCESS_KEY_SECRET);
        try {
            client.putObject(new PutObjectRequest(BUCKET_NAME, newName, new ByteArrayInputStream(dropzFile.getBytes())));
            // 上传文件路径 = http://BUCKET_NAME.ENDPOINT/自定义路径/fileName
            String filePath = "http://" + BUCKET_NAME + "." + ENDPOINT + "/"+ newName;
            result.put("filePath", filePath);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            client.shutdown();
        }
        return result;
    }
}
