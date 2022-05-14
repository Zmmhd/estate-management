package com.heima.estatemanagement.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 朱明名
 * @Date: 2022/05/12/14:36
 * @Description:
 */
@Data
@Table(name = "tb_pet")
public class Pet {
    @Id
    Integer id;
    String picture;
    String ownerName;
    Integer ownerId;
    String name;
    String color;
    String remark;
    Timestamp createTime;
    Timestamp updateTime;
    Timestamp adoptTime;
}
