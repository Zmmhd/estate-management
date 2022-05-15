package com.heima.estatemanagement.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.heima.estatemanagement.entity.Car;
import com.heima.estatemanagement.entity.Vo.CarVo;
import com.heima.estatemanagement.mapper.CarMapper;
import com.heima.estatemanagement.mapper.OwnerMapper;
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
 * @Date: 2022/05/15/11:52
 * @Description:
 */
@Service
public class CarService {
    @Autowired
    CarMapper carMapper;

    @Autowired
    OwnerMapper ownerMapper;


    public PageInfo<CarVo> search(Map searchMap) {
        //通用Mapper多条件搜索，标准写法
        Example example = new Example(Car.class);
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
        Page<Car> carPage = (Page<Car>) carMapper.selectByExample(example);
        List<Car> cars = carPage.getResult();

        List<CarVo> carVos = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++) {
            CarVo carVo = new CarVo();
            BeanUtils.copyProperties(cars.get(i),carVo);
            carVo.setOwnerName(ownerMapper.selectByPrimaryKey(cars.get(i).getOwnerId()).getName());
            carVos.add(carVo);
        }
        PageInfo<CarVo> carVoPageInfo = new PageInfo<>(carVos);
        return carVoPageInfo;
    }


    public Boolean add(Car car) {
        int row = carMapper.insert(car);
        if (row > 0) {
            return true;
        }
        return false;

    }


    public CarVo findById(Integer id) {
        Car car = carMapper.selectByPrimaryKey(id);
        CarVo carVo = new CarVo();
        BeanUtils.copyProperties(car,carVo);
        carVo.setOwnerName(ownerMapper.selectByPrimaryKey(car.getOwnerId()).getName());
        return carVo;
    }


    public Boolean update(Car car) {
        int row = carMapper.updateByPrimaryKeySelective(car);
        if (row > 0) {
            return true;
        }
        return false;

    }


    public Boolean del(List<Integer> ids) {
        for (Integer id : ids) {
            carMapper.deleteByPrimaryKey(id);
        }
        return true;
    }
}
