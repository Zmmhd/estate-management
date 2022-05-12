package com.heima.estatemanagement.domain;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 朱明名
 * @Date: 2022/05/12/14:42
 * @Description:
 */
@Data
@Table(name = "tb_charge_detail")
public class ChargeDetail {
    @Id
    Integer id;
    Integer communityId;
    String communityName;
    Integer chargeItemId;
    String chargeItemName;
    String contractor;
    Integer telephone;
    Integer payMoney;
    Integer actualMoney;
    Timestamp createTime;
    Timestamp updateTime;
    Timestamp payTime;
    char status;
}
