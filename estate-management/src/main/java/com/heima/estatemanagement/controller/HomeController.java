package com.heima.estatemanagement.controller;

import com.github.pagehelper.Page;
import com.heima.estatemanagement.common.MessageConstant;
import com.heima.estatemanagement.common.PageResult;
import com.heima.estatemanagement.common.Result;
import com.heima.estatemanagement.common.StatusCode;
import com.heima.estatemanagement.entity.Home;
import com.heima.estatemanagement.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 朱明名
 * @Date: 2022/05/12/21:11
 * @Description:
 */
@RestController
@RequestMapping("/home")
public class HomeController {
    @Autowired
    HomeService homeService;

    @RequestMapping("/find")
    public Result find(){
        List<Home> all = homeService.findAll();
        return new Result(false,200,"请求成功",all);
    }
    @RequestMapping("/search")
    public PageResult search(@RequestBody Map searchMap){
        Page<Home> page = homeService.search(searchMap);
        return new PageResult(true, StatusCode.OK, MessageConstant.COMMUNITY_SEARCH_SUCCESS,page.getResult(),page.getTotal());
    }

    @RequestMapping("/add")
    public Result add(@RequestBody Home home){
        Boolean add = homeService.add(home);
        return new Result(true,StatusCode.OK,MessageConstant.COMMUNITY_ADD_SUCCESS);
    }
    @RequestMapping("/findById")
    public Result findById(Integer id){
        Home home = homeService.findById(id);
        return new Result(true,StatusCode.OK,MessageConstant.COMMUNITY_FIND_BY_ID_SUCCESS,home);
    }

    @RequestMapping("/update")
    public Result update(@RequestBody Home home){
        Boolean add = homeService.update(home);
        return new Result(true,StatusCode.OK,MessageConstant.COMMUNITY_UPDATE_SUCCESS);
    }

    @RequestMapping("/del")
    public Result del(@RequestBody List<Integer> ids){
        Boolean flag = homeService.del(ids);
        return new Result(true,StatusCode.OK,MessageConstant.COMMUNITY_DELETE_SUCCESS);
    }
}
