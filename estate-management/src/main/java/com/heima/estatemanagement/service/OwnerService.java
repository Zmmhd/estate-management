package com.heima.estatemanagement.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.heima.estatemanagement.entity.*;
import com.heima.estatemanagement.entity.Vo.CarVo;
import com.heima.estatemanagement.entity.Vo.OwnerVo;
import com.heima.estatemanagement.mapper.BuildingMapper;
import com.heima.estatemanagement.mapper.CommunityMapper;
import com.heima.estatemanagement.mapper.HouseMapper;
import com.heima.estatemanagement.mapper.OwnerMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 朱明名
 * @Date: 2022/05/15/14:02
 * @Description:
 */
@Service
public class OwnerService {
    @Autowired
    OwnerMapper ownerMapper;

    @Autowired
    CommunityMapper communityMapper;

    @Autowired
    HouseMapper houseMapper;

    public PageInfo<OwnerVo> search(Map searchMap) {
        //通用Mapper多条件搜索，标准写法
        Example example = new Example(Owner.class);
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

                System.out.println("----------------");
                System.out.println(searchMap.get("carNumber"));

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
        Page<Owner> ownerPage = (Page<Owner>) ownerMapper.selectByExample(example);
        List<Owner> owners = ownerPage.getResult();

        List<OwnerVo> ownerVos = new ArrayList<>();
        for (int i = 0; i < owners.size(); i++) {
            OwnerVo ownerVo = new OwnerVo();
            BeanUtils.copyProperties(owners.get(i),ownerVo);
            ownerVo.setCommunityName(communityMapper.selectByPrimaryKey(owners.get(i).getCommunityId()).getName());
            ownerVo.setHouseName(houseMapper.selectByPrimaryKey(owners.get(i).getHouseId()).getName());
            ownerVos.add(ownerVo);
        }
        PageInfo<OwnerVo> ownerVoPageInfo = new PageInfo<>(ownerVos);
        return ownerVoPageInfo;
    }


    public Boolean add(Owner owner) {
        int row = ownerMapper.insert(owner);
        if (row > 0) {
            return true;
        }
        return false;

    }


    public OwnerVo findById(Integer id) {
        Owner owner = ownerMapper.selectByPrimaryKey(id);
        OwnerVo ownerVo = new OwnerVo();
        BeanUtils.copyProperties(owner,ownerVo);
        ownerVo.setCommunityName(communityMapper.selectByPrimaryKey(owner.getCommunityId()).getName());
        ownerVo.setHouseName(houseMapper.selectByPrimaryKey(owner.getHouseId()).getName());
        return ownerVo;
    }


    public Boolean update(Owner owner) {
        int row = ownerMapper.updateByPrimaryKeySelective(owner);
        if (row > 0) {
            return true;
        }
        return false;

    }


    public Boolean del(List<Integer> ids) {
        for (Integer id : ids) {
            ownerMapper.deleteByPrimaryKey(id);
        }
        return true;
    }

}
