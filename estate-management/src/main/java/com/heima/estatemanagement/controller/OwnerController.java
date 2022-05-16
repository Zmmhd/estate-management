package com.heima.estatemanagement.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.heima.estatemanagement.common.MessageConstant;
import com.heima.estatemanagement.common.PageResult;
import com.heima.estatemanagement.common.Result;
import com.heima.estatemanagement.common.StatusCode;
import com.heima.estatemanagement.entity.Owner;
import com.heima.estatemanagement.entity.Pet;
import com.heima.estatemanagement.entity.Vo.OwnerVo;
import com.heima.estatemanagement.service.OwnerService;
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
 * @Date: 2022/05/15/20:51
 * @Description:
 */
@RestController
@RequestMapping("/personnel")
public class OwnerController {
    @Autowired
    OwnerService ownerService;


    @RequestMapping("/search")
    public PageResult search(@RequestBody Map searchMap){
        PageInfo<OwnerVo> page = ownerService.search(searchMap);
        return new PageResult(true, StatusCode.OK, MessageConstant.COMMUNITY_SEARCH_SUCCESS,page.getList(),page.getTotal());
    }

    @RequestMapping("/add")
    public Result add(@RequestBody Owner owner){
        Boolean add = ownerService.add(owner);
        return new Result(true,StatusCode.OK,MessageConstant.COMMUNITY_ADD_SUCCESS);
    }
    @RequestMapping("/findById")
    public Result findById(Integer id){
        OwnerVo owner = ownerService.findById(id);
        return new Result(true,StatusCode.OK,MessageConstant.COMMUNITY_FIND_BY_ID_SUCCESS,owner);
    }

    @RequestMapping("/update")
    public Result update(@RequestBody Owner owner){
        Boolean add = ownerService.update(owner);
        return new Result(true,StatusCode.OK,MessageConstant.COMMUNITY_UPDATE_SUCCESS);
    }

    @RequestMapping("/del")
    public Result del(@RequestBody List<Integer> ids){
        Boolean flag = ownerService.del(ids);
        return new Result(true,StatusCode.OK,MessageConstant.COMMUNITY_DELETE_SUCCESS);
    }

}
