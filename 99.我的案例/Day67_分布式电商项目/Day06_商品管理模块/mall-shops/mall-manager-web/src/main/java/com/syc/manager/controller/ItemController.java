package com.syc.manager.controller;

import com.syc.commons.pojo.DataTableResult;
import com.syc.commons.pojo.ResponseResult;
import com.syc.commons.utils.ResultUtil;
import com.syc.manager.dto.ItemDTO;
import com.syc.manager.pojo.TbItem;
import com.syc.manager.service.ItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 商品管理--->商品列表的controller
 */
//@RestController
@Controller
@Api("商品管理--->商品列表")
public class ItemController {

    @Autowired
    private ItemService itemService;

    /**
     * 分页获取商品列表
     */
    @ResponseBody
    @RequestMapping(value = "/item/list", method = RequestMethod.GET)
    @ApiOperation(value = "分页搜索排序获取商品列表")
    public DataTableResult getItemList(int start, int length, int cid, @RequestParam("search[value]") String search,
                                       @RequestParam("order[0][column]") int orderCol, @RequestParam("order[0][dir]") String orderDir) {
        //获取客户端需要排序的列
        String[] cols = {"checkbox", "id", "image", "title", "sell_point", "price", "created", "updated", "status"};
        String orderColumn = cols[orderCol];

        //设置默认排序的列
        if (orderColumn == null) {
            orderColumn = "created";
        }

        //获取排序方式,默认为desc(asc)
        if (orderDir == null) {
            orderDir = "desc";
        }

        return itemService.getItemList(start, length, cid, search, orderColumn, orderDir);
    }

    /**
     * 查询商品总数量
     */
    @ResponseBody
    @RequestMapping(value = "/item/count", method = RequestMethod.GET)
    @ApiOperation(value = "获得商品总数目")
    public DataTableResult getAllItemCount() {
        return itemService.getAllItemCount();
    }

    /**
     * 添加商品
     */
    @ResponseBody
    @RequestMapping(value = "/item/add", method = RequestMethod.POST)
    @ApiOperation(value = "添加商品")
    public ResponseResult<TbItem> addItem(ItemDTO itemDto) {
        TbItem tbItem = itemService.addItem(itemDto);
        return new ResultUtil<TbItem>().setData(tbItem);
    }

    /**
     * 编辑商品之前,要先根据id查找要编辑的商品
     */
    @ResponseBody
    @RequestMapping(value = "/item/{itemId}", method = RequestMethod.GET)
    @ApiOperation(value = "通过ID获取商品")
    public ResponseResult<TbItem> getItemById(@PathVariable Long itemId) {
        TbItem item = itemService.getTbItemById(itemId);
        return new ResultUtil<TbItem>().setData(item);
    }

    /**
     * 编辑商品
     */
    @ResponseBody
    @RequestMapping(value = "/item/update/{id}", method = RequestMethod.POST)
    @ApiOperation(value = "编辑商品")
    public ResponseResult<TbItem> updateItem(@PathVariable Long id, ItemDTO itemDto) {
        TbItem tbItem = itemService.updateItem(id, itemDto);
        return new ResultUtil<TbItem>().setData(tbItem);
    }

    /**
     * 发布商品
     */
    @ResponseBody
    @RequestMapping(value = "/item/start/{id}", method = RequestMethod.PUT)
    @ApiOperation(value = "发布商品")
    public ResponseResult<TbItem> startItem(@PathVariable Long id) {
        TbItem tbItem = itemService.editItemState(id, 1);
        return new ResultUtil<TbItem>().setData(tbItem);
    }

    /**
     * 下架商品
     */
    @ResponseBody
    @RequestMapping(value = "/item/stop/{id}", method = RequestMethod.PUT)
    @ApiOperation(value = "下架商品")
    public ResponseResult<TbItem> stopItem(@PathVariable Long id) {
        TbItem tbItem = itemService.editItemState(id, 0);
        return new ResultUtil<TbItem>().setData(tbItem);
    }

    /**
     * 删除商品
     */
    @ResponseBody
    @RequestMapping(value = "/item/del/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "删除商品")
    public ResponseResult<TbItem> deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
        return new ResultUtil<TbItem>().setData(null);
    }

    //搜商品按钮功能---多条件搜索
    @ResponseBody
    @RequestMapping(value = "/item/listSearch",method = RequestMethod.GET)
    @ApiOperation(value = "多条件分页搜索排序获取商品列表")
    public DataTableResult getItemSearchList(int start, int length,int cid,String searchKey,String minDate,String maxDate,
                                              @RequestParam("search[value]") String search, @RequestParam("order[0][column]") int orderCol,
                                              @RequestParam("order[0][dir]") String orderDir){
        //获取客户端需要排序的列
        String[] cols = {"checkbox","id", "image", "title", "sell_point", "price", "created", "updated", "status"};
        //默认排序列
        String orderColumn = cols[orderCol];
        if(orderColumn == null) {
            orderColumn = "created";
        }

        //获取排序方式 默认为desc(asc)
        if(orderDir == null) {
            orderDir = "desc";
        }
        if(!search.isEmpty()){
            searchKey=search;
        }

        //SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //			// 1970-01-01 ~~ 2018-03-03 00:00:00
        //			Date start = format.parse(startDate + " 00:00:00");
        //			Date end = format.parse(endDate + " 24:00:00");
        //应该对日期范围进行格式化
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date startDate = format.parse(minDate+" 00:00:00");
            Date endDate = format.parse(maxDate+" 24:00:00");
            minDate=format.format(startDate);
            maxDate=format.format(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("minDate="+minDate+",maxDate="+maxDate);
        return itemService.getItemSearchList(start,length,cid,searchKey,minDate,maxDate+1,orderColumn,orderDir);
    }

}
