package com.heima.estatemanagement.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 朱明名
 * @Date: 2022/05/12/15:40
 * @Description:
 */
@Data
@Table(name = "tb_charge_item")
public class ChargeItem {
    @Id
    Integer id;
    Integer communityId;
    String communityName;
    String name;
    Timestamp createTime;
    Timestamp updateTime;
    Integer money;
}
