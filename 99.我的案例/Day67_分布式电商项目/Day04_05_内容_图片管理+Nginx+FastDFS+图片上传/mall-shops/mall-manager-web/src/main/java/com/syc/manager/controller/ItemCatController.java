package com.syc.manager.controller;

import com.syc.commons.pojo.ZTreeNode;
import com.syc.manager.service.ItemCatService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 商品管理--->商品分类控制器
 */
@Controller
@Api("商品管理--->商品分类")
public class ItemCatController {

    @Autowired
    private ItemCatService itemCatService;

    @ResponseBody
    @RequestMapping(value = "/item/cat/list", method = RequestMethod.GET)
    @ApiOperation(value = "通过父ID获取商品分类列表")
    public List<ZTreeNode> getItemCatList(@RequestParam(name = "id", defaultValue = "0") Long parentId) {

        return itemCatService.getItemCatList(parentId);
    }
}
