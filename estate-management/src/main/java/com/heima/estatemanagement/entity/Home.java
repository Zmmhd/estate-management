package com.heima.estatemanagement.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 朱明名
 * @Date: 2022/05/12/20:06
 * @Description:
 */
@Data
@Table(name = "tb_home")
public class Home {
    @Id
    Integer id;
    String communityName;
    Integer number;
    String code;
    String buildingName;
    String ownerName;
    Integer ownerTel;
    Integer roomNum;
    Integer unit;
    Integer floor;
    String description;

}
