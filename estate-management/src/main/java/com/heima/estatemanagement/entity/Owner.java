package com.heima.estatemanagement.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 朱明名
 * @Date: 2022/05/12/14:25
 * @Description:
 */
@Data
@Table(name = "tb_owner")
public class Owner {
    @Id
    Integer id;
    Integer communityId;
    Integer houseId;
    String name;
    String picture;
    String idcard;
    Integer telephone;
    String profession;
    String sex;
    String type;
    String remark;
    Timestamp createTime;
    Timestamp updateTime;
    Timestamp birthday;

}
