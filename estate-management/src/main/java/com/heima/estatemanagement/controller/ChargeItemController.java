package com.heima.estatemanagement.controller;

import com.github.pagehelper.Page;
import com.heima.estatemanagement.common.MessageConstant;
import com.heima.estatemanagement.common.PageResult;
import com.heima.estatemanagement.common.Result;
import com.heima.estatemanagement.common.StatusCode;
import com.heima.estatemanagement.entity.ChargeItem;
import com.heima.estatemanagement.service.ChargeItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 朱明名
 * @Date: 2022/05/17/19:42
 * @Description:
 */
@RestController
@RequestMapping("/pro")
public class ChargeItemController {
    @Autowired
    ChargeItemService chargeItemService;

    @RequestMapping("/find")
    public Result find(){
        List<ChargeItem> all = chargeItemService.findAll();
        return new Result(false,200,"请求成功",all);
    }
    @RequestMapping("/search")
    public PageResult search(@RequestBody Map searchMap){
        Page<ChargeItem> page = chargeItemService.search(searchMap);
        return new PageResult(true, StatusCode.OK, MessageConstant.COMMUNITY_SEARCH_SUCCESS,page.getResult(),page.getTotal());
    }

    @RequestMapping("/add")
    public Result add(@RequestBody ChargeItem chargeItem){
        Date date = new Date();
        chargeItem.setCreateTime(new Timestamp(date.getTime()));
        chargeItem.setUpdateTime(new Timestamp(date.getTime()));
        Boolean add = chargeItemService.add(chargeItem);
        return new Result(true,StatusCode.OK,MessageConstant.COMMUNITY_ADD_SUCCESS);
    }
    @RequestMapping("/findById")
    public Result findById(Integer id){
        ChargeItem chargeItem = chargeItemService.findById(id);
        return new Result(true,StatusCode.OK,MessageConstant.COMMUNITY_FIND_BY_ID_SUCCESS,chargeItem);
    }

    @RequestMapping("/update")
    public Result update(@RequestBody ChargeItem chargeItem){
        Boolean add = chargeItemService.update(chargeItem);
        return new Result(true,StatusCode.OK,MessageConstant.COMMUNITY_UPDATE_SUCCESS);
    }

    @RequestMapping("/del")
    public Result del(@RequestBody List<Integer> ids){
        Boolean flag = chargeItemService.del(ids);
        return new Result(true,StatusCode.OK,MessageConstant.COMMUNITY_DELETE_SUCCESS);
    }



}
