package com.heima.estatemanagement.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 朱明名
 * @Date: 2022/05/12/11:55
 * @Description:
 */
@Data
@Table(name = "tb_house")
public class House {
    @Id
    Integer id;
    String communityName;
    Integer communityId;
    String buildingName;
    Integer buildingId;
    String code;
    String name;
    Integer ownerId;
    String ownerName;
    Integer telephone;
    Integer roomNum;
    Integer unit;
    Integer floor;
    String description;
    Timestamp liveTime;
    
}
