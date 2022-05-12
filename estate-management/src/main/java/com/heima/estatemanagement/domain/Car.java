package com.heima.estatemanagement.domain;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 朱明名
 * @Date: 2022/05/12/11:00
 * @Description:
 */
@Data
@Table(name = "tb_car")
public class Car {
    @Id
    Integer id;
    String picture;
    Integer ownerId;
    String color;
    String carNumber;
    String remark;
    Timestamp creatTime;
    Timestamp updateTime;
}
