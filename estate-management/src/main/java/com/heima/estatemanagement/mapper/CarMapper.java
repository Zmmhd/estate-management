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
    @Select("select a.id,a.picture,b.name as ownerName,a.color,a.car_number as carNumber," +
            "a.remark,a.create_time as createTime,a.update_time as updateTime " +
            "from tb_car as a join tb_owner as b on a.owner_id = b.id ")
    public List<CarVo> find();
}
