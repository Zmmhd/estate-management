package com.heima.estatemanagement.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 朱明名
 * @Date: 2022/05/12/14:33
 * @Description:
 */
@Data
@Table(name = "tb_parking_use")
public class ParkingUse {
    @Id
    Integer id;
    String communityName;
    Integer communityId;
    String code;
    String carNumber;
    String picture;
    String ownerName;
    Integer ownerId;
    Integer telephone;
    char useType;
    Integer totalFee;
    Timestamp createTime;
    Timestamp updateTime;
    Timestamp startTime;
    Timestamp endTime;
}
