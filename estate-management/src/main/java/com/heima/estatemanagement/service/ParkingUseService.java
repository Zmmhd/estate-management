package com.heima.estatemanagement.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import com.heima.estatemanagement.entity.ParkingUse;

import com.heima.estatemanagement.mapper.ParkingUseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 朱明名
 * @Date: 2022/05/16/18:37
 * @Description:
 */
@Service
public class ParkingUseService implements BaseService<ParkingUse>{
    @Autowired
    ParkingUseMapper parkingUseMapper;

    @Override
    public List<ParkingUse> findAll() {
        return parkingUseMapper.selectAll();
    }

    @Override
    public Page<ParkingUse> search(Map searchMap) {
        //通用Mapper多条件搜索，标准写法
        Example example = new Example(ParkingUse.class);
        //1.初始化分页条件
        int pageNum = 1;
        int pageSize = 2;
        if (searchMap != null) {
            Example.Criteria criteria = example.createCriteria();//创建查询条件
            //时间区间
            if (StringUtil.isNotEmpty((String) searchMap.get("startTime"))) {
                criteria.andGreaterThanOrEqualTo("createTime", searchMap.get("startTime"));
            }
            if (StringUtil.isNotEmpty((String) searchMap.get("endTime"))) {
                criteria.andLessThanOrEqualTo("createTime", searchMap.get("endTime"));
                criteria.andLessThanOrEqualTo("createTime", searchMap.get("endTime"));
            }
            //名称模糊搜索
            if (StringUtil.isNotEmpty((String) searchMap.get("name"))) {
                criteria.andLike("name", "%" + (String) searchMap.get("name") + "%");
            }
            if ((Integer) searchMap.get("pageNum") != null) {
                pageNum = (Integer) searchMap.get("pageNum");
            }
            if ((Integer) searchMap.get("pageSize") != null) {
                pageSize = (Integer) searchMap.get("pageSize");
            }
        }
        PageHelper.startPage(pageNum, pageSize);
        //使用PageHelper插件完成分页
        Page<ParkingUse> parkingUses = (Page<ParkingUse>) parkingUseMapper.selectByExample(example);
        return parkingUses;
    }

    @Override
    public Boolean add(ParkingUse parkingUse) {
        int row = parkingUseMapper.insert(parkingUse);
        if (row > 0) {
            return true;
        }
        return false;

    }

    @Override
    public ParkingUse findById(Integer id) {
        return parkingUseMapper.selectByPrimaryKey(id);
    }

    @Override
    public Boolean update(ParkingUse parkingUse) {
        int row = parkingUseMapper.updateByPrimaryKeySelective(parkingUse);
        if (row > 0) {
            return true;
        }
        return false;

    }

    @Override
    public Boolean del(List<Integer> ids) {
        for (Integer id : ids) {
            parkingUseMapper.deleteByPrimaryKey(id);
        }
        return true;
    }
}
