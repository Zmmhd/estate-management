package com.heima.estatemanagement.mapper;

import com.heima.estatemanagement.entity.Owner;
import com.heima.estatemanagement.service.BaseService;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.Mapper;

/**
 * Created with IntelliJ IDEA.
 * @Author: 朱明名
 * @Date: 2022/5/15
 * @Description:
 */
@Repository
public interface OwnerMapper extends Mapper<Owner> {
}
