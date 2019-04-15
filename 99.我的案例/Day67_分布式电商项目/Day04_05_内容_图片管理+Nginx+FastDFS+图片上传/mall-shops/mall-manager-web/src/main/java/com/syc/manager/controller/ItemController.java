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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public DataTableResult getItemList(int draw, int start, int length, int cid, @RequestParam("search[value]") String search,
                                       @RequestParam("order[0][column]") int orderCol, @RequestParam("order[0][dir]") String orderDir) {
        //获取客户端需要排序的列
        String[] cols = {"checkbox", "id", "image", "title", "sell_point", "price", "created", "updated", "status"};
        String orderColumn = cols[orderCol];

        if (orderColumn == null) {
            orderColumn = "created";
        }

        //获取排序方式 默认为desc(asc)
        if (orderDir == null) {
            orderDir = "desc";
        }

        return itemService.getItemList(draw, start, length, cid, search, orderColumn, orderDir);
    }

    /**
     * 查询商品总数量
     */
    @ResponseBody
    @RequestMapping(value = "/item/count",method = RequestMethod.GET)
    @ApiOperation(value = "获得商品总数目")
    public DataTableResult getAllItemCount(){
        return itemService.getAllItemCount();
    }

    /**
     * 添加商品
     */
    @ResponseBody
    @RequestMapping(value = "/item/add",method = RequestMethod.POST)
    @ApiOperation(value = "添加商品")
    public ResponseResult<TbItem> addItem(ItemDTO itemDto){
        TbItem tbItem=itemService.addItem(itemDto);
        return new ResultUtil<TbItem>().setData(tbItem);
    }
}
