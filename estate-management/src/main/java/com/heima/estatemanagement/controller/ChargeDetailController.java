package com.heima.estatemanagement.controller;

import com.github.pagehelper.Page;
import com.heima.estatemanagement.common.MessageConstant;
import com.heima.estatemanagement.common.PageResult;
import com.heima.estatemanagement.common.Result;
import com.heima.estatemanagement.common.StatusCode;
import com.heima.estatemanagement.entity.ChargeDetail;
import com.heima.estatemanagement.mapper.ChargeDetailMapper;
import com.heima.estatemanagement.service.ChargeDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
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
 * @Date: 2022/05/17/19:40
 * @Description:
 */
@RestController
@RequestMapping("/promx")
public class ChargeDetailController {
    @Autowired
    ChargeDetailService chargeDetailService;

    @RequestMapping("/find")
    public Result find(){
        List<ChargeDetail> all = chargeDetailService.findAll();
        return new Result(false,200,"请求成功",all);
    }
    @RequestMapping("/search")
    public PageResult search(@RequestBody Map searchMap){
        Page<ChargeDetail> page = chargeDetailService.search(searchMap);
        return new PageResult(true, StatusCode.OK, MessageConstant.COMMUNITY_SEARCH_SUCCESS,page.getResult(),page.getTotal());
    }

    @RequestMapping("/add")
    public Result add(@RequestBody ChargeDetail chargeDetail){
        Date date = new Date();
        chargeDetail.setCreateTime(new Timestamp(date.getTime()));
        chargeDetail.setUpdateTime(new Timestamp(date.getTime()));
        Boolean add = chargeDetailService.add(chargeDetail);
        return new Result(true,StatusCode.OK,MessageConstant.COMMUNITY_ADD_SUCCESS);
    }
    @RequestMapping("/findById")
    public Result findById(Integer id){
        ChargeDetail chargeDetail = chargeDetailService.findById(id);
        return new Result(true,StatusCode.OK,MessageConstant.COMMUNITY_FIND_BY_ID_SUCCESS,chargeDetail);
    }

    @RequestMapping("/update")
    public Result update(@RequestBody ChargeDetail chargeDetail){
        Boolean add = chargeDetailService.update(chargeDetail);
        return new Result(true,StatusCode.OK,MessageConstant.COMMUNITY_UPDATE_SUCCESS);
    }

    @RequestMapping("/del")
    public Result del(@RequestBody List<Integer> ids){
        Boolean flag = chargeDetailService.del(ids);
        return new Result(true,StatusCode.OK,MessageConstant.COMMUNITY_DELETE_SUCCESS);
    }


}
