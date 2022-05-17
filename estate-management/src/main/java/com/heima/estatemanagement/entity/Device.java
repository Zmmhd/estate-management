package com.heima.estatemanagement.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 朱明名
 * @Date: 2022/05/12/11:07
 * @Description:
 */
@Data
@Table(name = "tb_device")
public class Device {
    @Id
    Integer id;
    String communityName;
    Integer communityId;
    String code;
    String name;
    String brand;
    Integer unitPrice;
    Integer num;
    Integer expectedUsefulLife;
    Timestamp createTime;
    Timestamp updateTime;
    Timestamp purchaseDate;
}
