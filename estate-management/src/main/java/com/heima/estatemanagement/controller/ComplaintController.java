package com.heima.estatemanagement.controller;

import com.github.pagehelper.Page;
import com.heima.estatemanagement.common.MessageConstant;
import com.heima.estatemanagement.common.PageResult;
import com.heima.estatemanagement.common.Result;
import com.heima.estatemanagement.common.StatusCode;
import com.heima.estatemanagement.entity.Complaint;
import com.heima.estatemanagement.service.ComplaintService;
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
 * @Date: 2022/05/16/19:19
 * @Description:
 */
@RestController
@RequestMapping("/complain")
public class ComplaintController {
    @Autowired
    ComplaintService complaintService;

    @RequestMapping("/find")
    public Result find(){
        List<Complaint> all = complaintService.findAll();
        return new Result(false,200,"请求成功",all);
    }
    @RequestMapping("/search")
    public PageResult search(@RequestBody Map searchMap){
        Page<Complaint> page = complaintService.search(searchMap);
        return new PageResult(true, StatusCode.OK, MessageConstant.COMMUNITY_SEARCH_SUCCESS,page.getResult(),page.getTotal());
    }

    @RequestMapping("/add")
    public Result add(@RequestBody Complaint complaint){
        Boolean add = complaintService.add(complaint);
        return new Result(true,StatusCode.OK,MessageConstant.COMMUNITY_ADD_SUCCESS);
    }
    @RequestMapping("/findById")
    public Result findById(Integer id){
        Complaint complaint = complaintService.findById(id);
        return new Result(true,StatusCode.OK,MessageConstant.COMMUNITY_FIND_BY_ID_SUCCESS,complaint);
    }

    @RequestMapping("/update")
    public Result update(@RequestBody Complaint complaint){
        Boolean add = complaintService.update(complaint);
        return new Result(true,StatusCode.OK,MessageConstant.COMMUNITY_UPDATE_SUCCESS);
    }

    @RequestMapping("/del")
    public Result del(@RequestBody List<Integer> ids){
        Boolean flag = complaintService.del(ids);
        return new Result(true,StatusCode.OK,MessageConstant.COMMUNITY_DELETE_SUCCESS);
    }
}
