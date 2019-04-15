package com.syc.manager.controller;

import com.syc.commons.pojo.DataTableResult;
import com.syc.commons.pojo.ResponseResult;
import com.syc.commons.utils.ResultUtil;
import com.syc.commons.utils.ShopResult;
import com.syc.content.service.ContentService;
import com.syc.manager.pojo.TbContent;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 内容管理模块
 */
@Controller
@Api(description = "内容列表信息")
public class ContentController {

    @Autowired
    private ContentService contentService;

    @ResponseBody
    @RequestMapping(value = "/content/list/{cid}",method = RequestMethod.GET)
    @ApiOperation(value = "通过cid获得内容列表")
    public DataTableResult getContents(@PathVariable Long cid){
        System.out.println("catId="+cid);
        List<TbContent> contents = contentService.getContentList(cid);
        DataTableResult result=new DataTableResult();
        //String s = JsonUtils.objectToJson(contents);
        //System.out.println("json="+s);
        //设置商品总数量
        result.setData(contents);
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/content/add",method = RequestMethod.POST)
    @ApiOperation(value = "添加内容")
    public ResponseResult<Object> addContent(@ModelAttribute TbContent tbContent){
        contentService.addContent(tbContent);
        return new ResultUtil<>().setData(null);
    }

    @ResponseBody
    @RequestMapping(value = "/content/update",method = RequestMethod.POST)
    @ApiOperation(value = "编辑内容")
    public ResponseResult<Object> updateContent(@ModelAttribute TbContent tbContent){
        contentService.updateContent(tbContent);
        return new ResultUtil<>().setData(null);
    }

    @ResponseBody
    @RequestMapping(value = "/content/del/{id}",method = RequestMethod.DELETE)
    @ApiOperation(value = "删除内容")
    public ResponseResult<Object> deleteContent(@PathVariable Long id){
        contentService.deleteContent(id);
        return new ResultUtil<>().setData(null);
    }

}
