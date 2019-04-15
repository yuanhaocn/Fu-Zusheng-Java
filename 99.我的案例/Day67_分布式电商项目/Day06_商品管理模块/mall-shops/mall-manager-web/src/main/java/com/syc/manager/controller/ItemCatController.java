package com.syc.manager.controller;

import com.syc.commons.pojo.ResponseResult;
import com.syc.commons.pojo.ZTreeNode;
import com.syc.commons.utils.ResultUtil;
import com.syc.manager.pojo.TbItemCat;
import com.syc.manager.service.ItemCatService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品管理--->商品分类控制器
 */
@Controller
@Api("商品管理--->商品分类")
public class ItemCatController {

    @Autowired
    private ItemCatService itemCatService;

    //商品分类列表的查询
    @ResponseBody
    @RequestMapping(value = "/item/cat/list", method = RequestMethod.GET)
    @ApiOperation(value = "通过父ID获取商品分类列表")
    public List<ZTreeNode> getItemCatList(@RequestParam(name = "id", defaultValue = "0") Long parentId) {

        return itemCatService.getItemCatList(parentId);
    }

    @ResponseBody
    @RequestMapping(value = "/item/cat/add",method = RequestMethod.POST)
    @ApiOperation(value = "添加商品分类")
    public ResponseResult<Object> addItemCategory(@ModelAttribute TbItemCat tbItemCat){
        itemCatService.addItemCat(tbItemCat);
        return new ResultUtil<>().setData(null);
    }

    @ResponseBody
    @RequestMapping(value = "/item/cat/update",method = RequestMethod.POST)
    @ApiOperation(value = "编辑商品分类")
    public ResponseResult<Object> updateItemCategory(@ModelAttribute TbItemCat tbItemCat){
        itemCatService.updateItemCat(tbItemCat);
        return new ResultUtil<>().setData(null);
    }

    @ResponseBody
    @RequestMapping(value = "/item/cat/del/{id}",method = RequestMethod.DELETE)
    @ApiOperation(value = "删除商品分类")
    public ResponseResult<Object> deleteItemCategory(@PathVariable Long id){
        itemCatService.deleteItemCat(id);
        return new ResultUtil<>().setData(null);
    }
}
