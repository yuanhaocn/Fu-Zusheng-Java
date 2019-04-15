package com.syc.manager.controller;

import com.syc.commons.pojo.DataTableResult;
import com.syc.commons.pojo.ResponseResult;
import com.syc.commons.utils.FastDFSClient;
import com.syc.commons.utils.JsonUtils;
import com.syc.commons.utils.ResultUtil;
import com.syc.content.service.ContentImageService;
import com.syc.manager.pojo.TbImage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 图片管理模块控制器.
 * 图片上传+图片管理
 */
@Controller
@Api(description = "图片上传统一接口")
public class ImageController {

    @Value("${IMAGE_SERVER_URL}")
    private String IMAGE_SERVER_URL;

    @Autowired
    private ContentImageService contentImageService;

    @ResponseBody
    @RequestMapping(value = "/image/imageUpload", method = RequestMethod.POST)
    @ApiOperation(value = "WebUploader图片上传")
    public String uploadFile(@RequestParam("file") MultipartFile files) {
        try {
            //上传图片
            FastDFSClient client = new FastDFSClient("classpath:conf/fdfs_client.conf");
            String fileName = files.getOriginalFilename();//得到文件的原始名字
            String ext = fileName.substring(fileName.lastIndexOf(".") + 1);//截取扩展名
            String path = client.uploadPic(files.getBytes(), ext, files.getSize());

            path = IMAGE_SERVER_URL + path;
            System.out.println("path====>" + path);
            Map<String, Object> map = new HashMap<>();
            map.put("success", true);
            map.put("error", 0);
            map.put("result", path);
            //把map转成json字符串
            return JsonUtils.objectToJson(map);
        } catch (Exception e) {
            e.printStackTrace();
            Map<String, Object> map = new HashMap<>();
            map.put("error", 1);
            map.put("message", "文件上传失败");
            return JsonUtils.objectToJson(map);
        }
    }

    //图片管理--->查询
    @ResponseBody
    @RequestMapping(value = "/image/list", method = RequestMethod.GET)
    @ApiOperation(value = "通过获得图片列表")
    public DataTableResult getContentImage() {
        List<TbImage> images = contentImageService.getContentImages();
        DataTableResult result=new DataTableResult();
        result.setData(images);
        return result;
    }

    //图片管理--->修改
    @ResponseBody
    @RequestMapping(value = "/image/update",method = RequestMethod.POST)
    @ApiOperation(value = "编辑图片")
    public ResponseResult<Object> updateContentImage(@ModelAttribute TbImage tbImage){
        contentImageService.updateContentImage(tbImage);
        return new ResultUtil<>().setData(null);
    }

}
