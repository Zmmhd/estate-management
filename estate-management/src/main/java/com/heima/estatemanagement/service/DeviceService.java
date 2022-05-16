package com.heima.estatemanagement.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.heima.estatemanagement.entity.Device;
import com.heima.estatemanagement.entity.Device;
import com.heima.estatemanagement.mapper.DeviceMapper;
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
 * @Date: 2022/05/16/19:41
 * @Description:
 */
@Service
public class DeviceService implements BaseService<Device>{
    @Autowired
    DeviceMapper deviceMapper;


    @Override
    public List<Device> findAll() {
        return deviceMapper.selectAll();
    }

    @Override
    public Page<Device> search(Map searchMap) {
        //通用Mapper多条件搜索，标准写法
        Example example = new Example(Device.class);
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
        Page<Device> devices = (Page<Device>) deviceMapper.selectByExample(example);
        return devices;
    }

    @Override
    public Boolean add(Device device) {
        int row = deviceMapper.insert(device);
        if (row > 0) {
            return true;
        }
        return false;

    }

    @Override
    public Device findById(Integer id) {
        return deviceMapper.selectByPrimaryKey(id);
    }

    @Override
    public Boolean update(Device device) {
        int row = deviceMapper.updateByPrimaryKeySelective(device);
        if (row > 0) {
            return true;
        }
        return false;

    }

    @Override
    public Boolean del(List<Integer> ids) {
        for (Integer id : ids) {
            deviceMapper.deleteByPrimaryKey(id);
        }
        return true;
    }
}
