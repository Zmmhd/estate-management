package com.heima.estatemanagement.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.heima.estatemanagement.common.MessageConstant;
import com.heima.estatemanagement.common.PageResult;
import com.heima.estatemanagement.common.Result;
import com.heima.estatemanagement.common.StatusCode;
import com.heima.estatemanagement.entity.Car;
import com.heima.estatemanagement.entity.Vo.CarVo;
import com.heima.estatemanagement.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 朱明名
 * @Date: 2022/05/15/11:50
 * @Description:
 */
@RestController
@RequestMapping("/vehicle")
public class CarController {

    @Autowired
    CarService carService;


    @RequestMapping("/search")
    public PageResult search(@RequestBody Map searchMap){
        PageInfo<CarVo> page = carService.search(searchMap);
        return new PageResult(true, StatusCode.OK, MessageConstant.COMMUNITY_SEARCH_SUCCESS,page.getList(),page.getTotal());
    }

    @RequestMapping("/add")
    public Result add(@RequestBody Car car){
        Boolean add = carService.add(car);
        return new Result(true,StatusCode.OK,MessageConstant.COMMUNITY_ADD_SUCCESS);
    }
    @RequestMapping("/findById")
    public Result findById(Integer id){
        CarVo carVo = carService.findById(id);
        return new Result(true,StatusCode.OK,MessageConstant.COMMUNITY_FIND_BY_ID_SUCCESS,carVo);
    }

    @RequestMapping("/update")
    public Result update(@RequestBody Car car){
        Boolean add = carService.update(car);
        return new Result(true,StatusCode.OK,MessageConstant.COMMUNITY_UPDATE_SUCCESS);
    }

    @RequestMapping("/del")
    public Result del(@RequestBody List<Integer> ids){
        Boolean flag = carService.del(ids);
        return new Result(true,StatusCode.OK,MessageConstant.COMMUNITY_DELETE_SUCCESS);
    }



}
