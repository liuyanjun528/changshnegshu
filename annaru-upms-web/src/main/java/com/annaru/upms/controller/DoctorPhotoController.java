package com.annaru.upms.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import com.annaru.common.base.BaseController;
import com.annaru.common.result.PageUtils;
import com.annaru.upms.shiro.ShiroKit;
import com.annaru.common.result.ResultMap;

import com.annaru.upms.entity.DoctorPhoto;
import com.annaru.upms.service.IDoctorPhotoService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;



/**
 * 医生照片
 *
 * @author xck
 * @date 2019-04-08 16:20:08
 */
@Api(tags = {"医生照片管理"}, description = "医生照片管理")
@RestController
@RequestMapping("upms/doctorPhoto")
public class DoctorPhotoController extends BaseController {
    @Reference
    private IDoctorPhotoService doctorPhotoService;

    /**
     * 列表
     */
    @ApiOperation(value = "列表")
    @GetMapping("/list")
    @RequiresPermissions("upms/doctorPhoto/list")
    public ResultMap list(@ApiParam(value = "当前页", defaultValue="1")@RequestParam(required = false) long page,
                       @ApiParam(value = "每页数量", defaultValue = "10")@RequestParam(required = false) long limit,
                       @ApiParam(value = "关键字")@RequestParam(required = false)String key){

        Map<String, Object> params = new HashMap<>();
        params.put("page",page);
        params.put("limit", limit);
        params.put("key", key);
        PageUtils<Map<String, Object>> pageList = doctorPhotoService.getDataPage(params);
        return ResultMap.ok().put("page",pageList);
    }


    /**
     * 信息
     */
    @ApiOperation(value = "查看详情", notes = "查看upms详情")
    @GetMapping("/info/{id}")
    @RequiresPermissions("upms/doctorPhoto/info")
    public ResultMap info(@PathVariable("id") Integer id){
        DoctorPhoto doctorPhoto = doctorPhotoService.getById(id);
        return ResultMap.ok().put("doctorPhoto",doctorPhoto);
    }

    /**
     * 保存
     */
    @ApiOperation(value = "保存")
    @PostMapping("/save")
    @RequiresPermissions("upms/doctorPhoto/save")
    public ResultMap save(@Valid @RequestBody DoctorPhoto doctorPhoto) {
        try {
            doctorPhotoService.save(doctorPhoto);
            return ResultMap.ok("添加成功");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }
    }

    /**
     * 修改
     */
    @ApiOperation(value = "修改")
    @PostMapping("/update")
    @RequiresPermissions("upms/doctorPhoto/update")
    public ResultMap update(@Valid @RequestBody DoctorPhoto doctorPhoto) {
        try {

            doctorPhotoService.updateById(doctorPhoto);
            return ResultMap.ok("修改成功");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除")
    @PostMapping("/delete")
    @RequiresPermissions("upms/doctorPhoto/delete")
    public ResultMap delete(@RequestBody Integer[]ids) {
        try {
            doctorPhotoService.removeByIds(Arrays.asList(ids));
            return ResultMap.ok("删除成功！");
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResultMap.error("运行异常，请联系管理员");
        }

    }

//图片上传
@ResponseBody
@RequestMapping("/upload")
public Map<String, String> uploadaaa(MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, IOException {
    //String path = request.getSession().getServletContext().getRealPath("upload");
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式  HH:mm:ss
    String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
    String path = "C:/var/uploaded_files/"+date+"/";
    UUID uuid=UUID.randomUUID();
    String originalFilename = file.getOriginalFilename();
    // String fileName = uuid.toString() + originalFilename;
    String extendName = originalFilename.substring(originalFilename.lastIndexOf("."), originalFilename.length());
    String fileName = uuid.toString() + extendName;
    File dir = new File(path, fileName);
    File filepath = new File(path);
    if(!filepath.exists()){
        filepath.mkdirs();
    }
    file.transferTo(dir);

    Map<String, String> map = new HashMap<>();
    map.put("filePath", path);
    map.put("fileName", fileName);

    return map;

}




}
