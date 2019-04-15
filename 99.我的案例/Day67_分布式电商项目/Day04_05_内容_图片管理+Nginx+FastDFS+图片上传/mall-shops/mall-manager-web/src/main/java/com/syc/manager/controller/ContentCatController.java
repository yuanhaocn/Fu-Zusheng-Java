package com.syc.manager.controller;

import com.syc.commons.pojo.ResponseResult;
import com.syc.commons.pojo.ZTreeNode;
import com.syc.commons.utils.ResultUtil;
import com.syc.content.service.ContentCatService;
import com.syc.manager.pojo.TbContentCategory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 内容分类管理模块
 */
@Controller
@Api("内容分类管理")
public class ContentCatController {

    @Autowired
    private ContentCatService contentCatService;

    @ResponseBody
    @RequestMapping(value = "/content/cat/list",method = RequestMethod.GET)
    @ApiOperation(value = "获得分类列表")
    public List<ZTreeNode> getContentByCid(@RequestParam(name="id", defaultValue="0") Long parentId){
        System.out.println("parentID="+parentId);
        return contentCatService.getContentCatList(parentId);
    }

    //添加内容分类
    @ResponseBody
    @RequestMapping(value = "/content/cat/add",method = RequestMethod.POST)
    @ApiOperation(value = "添加内容分类")
    public ResponseResult<TbContentCategory> addContentCategory(@ModelAttribute TbContentCategory contentCategory){
        contentCatService.addContentCat(contentCategory);
        return new ResultUtil<TbContentCategory>().setData(null);
    }

    //修改内容分类
    @ResponseBody
    @RequestMapping(value = "/content/cat/update",method = RequestMethod.POST)
    @ApiOperation(value = "编辑内容分类")
    public ResponseResult<TbContentCategory> updateContentCategory(@ModelAttribute TbContentCategory contentCategory){
        contentCatService.updateContentCat(contentCategory);
        return new ResultUtil<TbContentCategory>().setData(null);
    }

    //删除内容分类
    @ResponseBody
    @RequestMapping(value = "/content/cat/del/{id}",method = RequestMethod.DELETE)
    @ApiOperation(value = "删除内容分类")
    public ResponseResult<TbContentCategory> deleteContentCategory(@PathVariable Long id){
        contentCatService.deleteContentCat(id);
        return new ResultUtil<TbContentCategory>().setData(null);
    }
}
