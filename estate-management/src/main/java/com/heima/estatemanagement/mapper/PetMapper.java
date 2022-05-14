package com.heima.estatemanagement.mapper;

import com.heima.estatemanagement.entity.Pet;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * @Author: 朱明名
 * @Date: 2022/5/12
 * @Description:
 */
@Repository
public interface PetMapper extends Mapper<Pet> {
}
