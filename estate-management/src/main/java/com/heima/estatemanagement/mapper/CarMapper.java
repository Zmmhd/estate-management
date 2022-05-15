package com.heima.estatemanagement.mapper;

import com.heima.estatemanagement.entity.Car;
import com.heima.estatemanagement.entity.Vo.CarVo;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface CarMapper extends Mapper<Car> {
}
