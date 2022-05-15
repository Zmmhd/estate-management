package com.heima.estatemanagement.entity.Vo;

import lombok.Data;

import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 朱明名
 * @Date: 2022/05/15/11:44
 * @Description:
 */
@Data
public class CarVo {
    Integer id;
    String picture;
    String ownerName;
    String color;
    String carNumber;
    String remark;
    Timestamp createTime;
    Timestamp updateTime;
}
