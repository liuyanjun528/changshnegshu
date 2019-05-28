package com.annaru.upms.controller;

import com.annaru.common.result.ResultMap;
import com.annaru.common.util.UUIDGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Author:wh
 * Description:文件上传下载
 */
@Api(tags = "文件上传管理", description = "文件上传下载")
@RestController
@RequestMapping("api")
public class UploadController {

    @Value("${upload.virtualRoute}")
    private String virtualRoute;

    @Value("${upload.absoluteRoute}")
    private String absolutePath;

    @ApiOperation(value = "文件上传")
    @PostMapping(value = "/fileUpload")
    public ResultMap fileUpload(@RequestParam(value = "file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResultMap.error("上传文件为空");
        }
        String fileName = file.getOriginalFilename();  // 文件名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
        fileName = UUIDGenerator.getUUID() + suffixName; // 新文件名
        File dest = new File(absolutePath + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String filename = virtualRoute + fileName;
        return ResultMap.ok().put("data", filename);
    }
}
